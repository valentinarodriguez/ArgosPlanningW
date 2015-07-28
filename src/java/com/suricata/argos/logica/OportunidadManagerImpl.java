/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.suricata.argos.logica;

import com.suricata.argos.exception.ArgosWebServiceException;
import com.suricata.argos.vo.OportunidadVo;
import com.suricata.argos.ws.client.ArgosWS;
import com.suricata.argos.ws.client.ArgosWSService;
import com.suricata.argos.ws.client.DatosDuplicadosException_Exception;
import com.suricata.argos.ws.client.DatosNoEncontradosException_Exception;
import com.suricata.argos.ws.client.DocumentoException_Exception;
import com.suricata.argos.ws.client.ErrorSQLException_Exception;
import com.suricata.argos.ws.client.FaltaParametroException_Exception;
import com.suricata.argos.ws.client.TipoDatosException_Exception;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.log4j.Logger;
import com.suricata.argos.constantes.Constantes;
import com.suricata.argos.exception.FaltanDatosException;
import com.suricata.argos.logica.utiles.ConvertidorUtiles;
import java.util.Date;
import javax.xml.datatype.DatatypeConfigurationException;

/**
 *
 * @author Valentina
 */
public class OportunidadManagerImpl implements OportunidadManager {
    private static final Logger LOGGER = Logger.getLogger(OportunidadManagerImpl.class);

    /**
     *
     * @return
     * @throws Exception
     */
    public ArgosWS getWS() throws MalformedURLException {
        ArgosWS proxy = null;
        ArgosWSService webService = WSGeneralUtil.getInstance().getWebService();
        proxy = webService.getArgosWSPort();
        return proxy;
    }
    

   public OportunidadVo buscarOportunidad(Integer idOportunidad) throws ArgosWebServiceException {
        try {
            OportunidadVo oportunidad = null;
            oportunidad = ConvertidorUtiles.convertVoWSToVo(this.getWS().buscarOportunidad(idOportunidad));
            return oportunidad;
        } catch (TipoDatosException_Exception ex) {
            LOGGER.error(ex.getMessage(), ex);
            throw new ArgosWebServiceException(Constantes.ERROR_WS_TIPO_DATO, ex);
        } catch (DocumentoException_Exception ex) {
            LOGGER.error(ex.getMessage(), ex);
            throw new ArgosWebServiceException(Constantes.ERROR_WS_ARCHIVO_UPLOAD, ex);
        } catch (DatosNoEncontradosException_Exception ex) {
            LOGGER.error(ex.getMessage(), ex);
            throw new ArgosWebServiceException(Constantes.ERROR_WS_NO_EXISTE_DATO, ex);
        } catch (ErrorSQLException_Exception ex) {
            LOGGER.error(ex.getMessage(), ex);
            throw new ArgosWebServiceException(Constantes.ERROR_WS_GENERICO, ex);
        } catch (MalformedURLException ex) {
            LOGGER.error(ex.getMessage(), ex);
            throw new ArgosWebServiceException(Constantes.ERROR_WS_GENERICO, ex);
        }
    }


    public List<OportunidadVo> listarOportunidades(String estado, Date fechaDesde, Date fechaHasta) throws ArgosWebServiceException {
       try {
            List<OportunidadVo> listaVos = null;
            listaVos = new ArrayList<OportunidadVo>();
            List<com.suricata.argos.ws.client.OportunidadVo> listaEntity = this.getWS().listarOportunidades( estado,  ConvertidorUtiles.convertDate(fechaDesde),  ConvertidorUtiles.convertDate(fechaHasta));
            Iterator it = listaEntity.iterator();
            while (it.hasNext()) {
                OportunidadVo oportunidadVo = ConvertidorUtiles.convertVoWSToVo((com.suricata.argos.ws.client.OportunidadVo) it.next());
                listaVos.add(oportunidadVo);
            }
            return listaVos;
       } catch (DatatypeConfigurationException ex) {
            LOGGER.error(ex.getMessage(), ex);
           throw new ArgosWebServiceException(Constantes.ERROR_WS_TIPO_DATO, ex);
        } catch (TipoDatosException_Exception ex) {
            LOGGER.error(ex.getMessage(), ex);
           throw new ArgosWebServiceException(Constantes.ERROR_WS_TIPO_DATO, ex);
        } catch (ErrorSQLException_Exception ex) {
            LOGGER.error(ex.getMessage(), ex);
            throw new ArgosWebServiceException(Constantes.ERROR_WS_GENERICO, ex);
        } catch (MalformedURLException ex) {
            LOGGER.error(ex.getMessage(), ex);
            throw new ArgosWebServiceException(Constantes.ERROR_WS_GENERICO, ex);
        }
    }

    public void modificarOportunidad(OportunidadVo oportunidad) throws ArgosWebServiceException, FaltanDatosException {
         try {
              if (validarDatosObligatorios(oportunidad) == true && oportunidad.getId() != 0){
                this.getWS().modificarOportunidad(ConvertidorUtiles.convertVoToVoWS(oportunidad));
              } else {
                 LOGGER.error(Constantes.ERROR_WS_FALTAN_DATOS);
                 throw new FaltanDatosException(Constantes.ERROR_WS_FALTAN_DATOS);
              }
        } catch (DatosDuplicadosException_Exception ex) {
             LOGGER.error(ex.getMessage(), ex);
             throw new ArgosWebServiceException(Constantes.ERROR_WS_DATOS_DUPLICADOS, ex);
        } catch (ErrorSQLException_Exception ex) {
             LOGGER.error(ex.getMessage(), ex);
             throw new ArgosWebServiceException(Constantes.ERROR_WS_GENERICO, ex);
        } catch (FaltaParametroException_Exception ex) {
             LOGGER.error(ex.getMessage(), ex);
             throw new ArgosWebServiceException(Constantes.ERROR_WS_FALTAN_DATOS, ex);
        } catch (MalformedURLException ex) {
            LOGGER.error(ex.getMessage(), ex);
            throw new ArgosWebServiceException(Constantes.ERROR_WS_GENERICO, ex);
        } catch (DatatypeConfigurationException ex) {
              LOGGER.error(ex.getMessage(), ex);
            throw new ArgosWebServiceException(Constantes.ERROR_WS_GENERICO, ex);
       } catch (TipoDatosException_Exception ex) {
            LOGGER.error(ex.getMessage(), ex);
           throw new ArgosWebServiceException(Constantes.ERROR_WS_TIPO_DATO, ex);
        }

    }

    public void crearOportunidad(OportunidadVo oportunidad) throws ArgosWebServiceException, FaltanDatosException {
         try {
              if (validarDatosObligatorios(oportunidad) == true){
                this.getWS().crearOportunidad(ConvertidorUtiles.convertVoToVoWS(oportunidad));
              } else {
                 LOGGER.error(Constantes.ERROR_WS_FALTAN_DATOS);
                 throw new FaltanDatosException(Constantes.ERROR_WS_FALTAN_DATOS);
              }
        } catch (DocumentoException_Exception ex) {
            LOGGER.error(ex.getMessage(), ex);
            throw new ArgosWebServiceException(Constantes.ERROR_WS_ARCHIVO_UPLOAD, ex);
        } catch (DatosDuplicadosException_Exception ex) {
             LOGGER.error(ex.getMessage(), ex);
             throw new ArgosWebServiceException(Constantes.ERROR_WS_DATOS_DUPLICADOS, ex);
        } catch (ErrorSQLException_Exception ex) {
             LOGGER.error(ex.getMessage(), ex);
             throw new ArgosWebServiceException(Constantes.ERROR_WS_GENERICO, ex);
        } catch (FaltaParametroException_Exception ex) {
             LOGGER.error(ex.getMessage(), ex);
             throw new ArgosWebServiceException(Constantes.ERROR_WS_FALTAN_DATOS, ex);
        } catch (MalformedURLException ex) {
            LOGGER.error(ex.getMessage(), ex);
            throw new ArgosWebServiceException(Constantes.ERROR_WS_GENERICO, ex);
         } catch (DatatypeConfigurationException ex) {
              LOGGER.error(ex.getMessage(), ex);
            throw new ArgosWebServiceException(Constantes.ERROR_WS_GENERICO, ex);
         } catch (TipoDatosException_Exception ex) {
            LOGGER.error(ex.getMessage(), ex);
           throw new ArgosWebServiceException(Constantes.ERROR_WS_TIPO_DATO, ex);
        }

    }


    /**
     *
     * @param oportunidad
     * @return
     */
    private boolean validarDatosObligatorios (OportunidadVo oportunidad) {
        boolean resultado = false;
        if (oportunidad != null && oportunidad.getContacto() != null && oportunidad.getEmpresa() != null
               && oportunidad.getEstado() != null && oportunidad.getTecnologia()  != null &&
                oportunidad.getTipoproyecto() != null && oportunidad.getTitulo() != null) {
            resultado = true;
        }
        return resultado;
    }

    public void borrarOportunidad(OportunidadVo oportunidad) throws ArgosWebServiceException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<OportunidadVo> listarUltimasOportunidades(Long idUsuario) throws ArgosWebServiceException {
        try {
            List<OportunidadVo> listaVos = null;
            listaVos = new ArrayList<OportunidadVo>();
            List<com.suricata.argos.ws.client.OportunidadVo> listaEntity = this.getWS().listarUltimasOportunidadesPorUsuario(idUsuario);
            Iterator it = listaEntity.iterator();
            while (it.hasNext()) {
                OportunidadVo oportunidadVo = ConvertidorUtiles.convertVoWSToVo((com.suricata.argos.ws.client.OportunidadVo) it.next());
                listaVos.add(oportunidadVo);
            }
            return listaVos;
        } catch (ErrorSQLException_Exception ex) {
            LOGGER.error(ex.getMessage(), ex);
            throw new ArgosWebServiceException(Constantes.ERROR_WS_GENERICO, ex);
        } catch (MalformedURLException ex) {
            LOGGER.error(ex.getMessage(), ex);
            throw new ArgosWebServiceException(Constantes.ERROR_WS_GENERICO, ex);
        } catch (TipoDatosException_Exception ex) {
            LOGGER.error(ex.getMessage(), ex);
           throw new ArgosWebServiceException(Constantes.ERROR_WS_TIPO_DATO, ex);
        }
    }


     public List<OportunidadVo> listarUltimasOportunidades() throws ArgosWebServiceException {
        try {
            List<OportunidadVo> listaVos = null;
            listaVos = new ArrayList<OportunidadVo>();
            List<com.suricata.argos.ws.client.OportunidadVo> listaEntity = this.getWS().listarUltimasOportunidades();
            Iterator it = listaEntity.iterator();
            while (it.hasNext()) {
                OportunidadVo oportunidadVo = ConvertidorUtiles.convertVoWSToVo((com.suricata.argos.ws.client.OportunidadVo) it.next());
                listaVos.add(oportunidadVo);
            }
            return listaVos;
        } catch (ErrorSQLException_Exception ex) {
            LOGGER.error(ex.getMessage(), ex);
            throw new ArgosWebServiceException(Constantes.ERROR_WS_GENERICO, ex);
        } catch (MalformedURLException ex) {
            LOGGER.error(ex.getMessage(), ex);
            throw new ArgosWebServiceException(Constantes.ERROR_WS_GENERICO, ex);
         } catch (TipoDatosException_Exception ex) {
            LOGGER.error(ex.getMessage(), ex);
           throw new ArgosWebServiceException(Constantes.ERROR_WS_TIPO_DATO, ex);
        }
    }
}
