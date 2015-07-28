/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.suricata.argos.logica;

import com.suricata.argos.exception.ArgosWebServiceException;
import com.suricata.argos.vo.ActividadVo;
import com.suricata.argos.vo.DocumentoVo;
import com.suricata.argos.ws.client.ArgosWS;
import com.suricata.argos.ws.client.ArgosWSService;
import com.suricata.argos.ws.client.DatosNoEncontradosException_Exception;
import com.suricata.argos.ws.client.DocumentoException_Exception;
import com.suricata.argos.ws.client.ErrorSQLException_Exception;
import com.suricata.argos.ws.client.FaltaParametroException_Exception;
import com.suricata.argos.ws.client.TipoDatosException_Exception;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import javax.xml.datatype.DatatypeConfigurationException;
import org.apache.log4j.Logger;
import com.suricata.argos.constantes.Constantes;
import com.suricata.argos.exception.FaltanDatosException;
import com.suricata.argos.logica.utiles.ConvertidorUtiles;
import java.util.Date;

/**
 *
 * @author Valentina
 */
public class ActividadManagerImpl implements ActividadManager {
    private static final Logger LOGGER = Logger.getLogger(ActividadManagerImpl.class);
    /**
     *
     * @return
     * @throws Exception
     */
    public ArgosWS getWS() throws MalformedURLException {
        ArgosWS proxy = null;
        ArgosWSService webService = WSGeneralUtil.getInstance().getWebService();
        proxy = webService.getArgosWSPort();
        LOGGER.debug("Se conecto al WS");
        return proxy;
    }


public ActividadVo buscarActividad(Integer idActividad) throws ArgosWebServiceException {
        try {
            ActividadVo actividad = null;
            actividad = ConvertidorUtiles.convertVoWSToVo(this.getWS().buscarActividad(idActividad));
            LOGGER.debug("Se busco la actividad");
            return actividad;
        } catch (TipoDatosException_Exception ex) {
             LOGGER.error(ex.getMessage(), ex);
             throw new ArgosWebServiceException(Constantes.ERROR_WS_TIPO_DATO, ex);
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


    public List<ActividadVo> listarActividads(String estado, Date fechaDesde, Date fechaHasta) throws ArgosWebServiceException {
       try {
            List<ActividadVo> listaVos = null;
            listaVos = new ArrayList<ActividadVo>();
            List<com.suricata.argos.ws.client.ActividadVo> listaEntity = this.getWS().listarActividades( estado,  ConvertidorUtiles.convertDate(fechaDesde),  ConvertidorUtiles.convertDate(fechaHasta));
            LOGGER.debug("Se obtuvieron las actividades");
            Iterator it = listaEntity.iterator();
            while (it.hasNext()) {
                ActividadVo actividadVo = ConvertidorUtiles.convertVoWSToVo((com.suricata.argos.ws.client.ActividadVo) it.next());
                listaVos.add(actividadVo);
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

    public void modificarActividad(ActividadVo actividad) throws ArgosWebServiceException,FaltanDatosException {
         try {
              LOGGER.debug("modificar actividad");
              if (validarDatosObligatorios(actividad) == true && actividad.getId() != 0){
                    LOGGER.debug("los datos son validos");
                    this.getWS().modificarActividad(ConvertidorUtiles.convertVoToVoWS(actividad));
                    LOGGER.debug("Se modificó la actividad");
              } else {
                 LOGGER.error(Constantes.ERROR_WS_FALTAN_DATOS);
                 throw new FaltanDatosException(Constantes.ERROR_WS_FALTAN_DATOS);
              }
   
        } catch (TipoDatosException_Exception ex) {
            LOGGER.error(ex.getMessage(), ex);
            throw new ArgosWebServiceException(Constantes.ERROR_WS_TIPO_DATO, ex);
        } catch (ErrorSQLException_Exception ex) {
             LOGGER.error(ex.getMessage(), ex);
             throw new ArgosWebServiceException(Constantes.ERROR_WS_GENERICO, ex);
        } catch (FaltaParametroException_Exception ex) {
             LOGGER.error(ex.getMessage(), ex);
             throw new ArgosWebServiceException(Constantes.ERROR_WS_FALTAN_DATOS, ex);
        } catch (MalformedURLException ex) {
            LOGGER.error(ex.getMessage(), ex);
            throw new ArgosWebServiceException(Constantes.ERROR_WS_GENERICO, ex);
        }  catch (DatatypeConfigurationException ex){
            LOGGER.error(ex.getMessage(), ex);
             throw new FaltanDatosException(Constantes.ERROR_WS_FALTAN_DATOS);
        }
    }

    public void crearActividad(ActividadVo actividad) throws ArgosWebServiceException, FaltanDatosException {
         try {
              LOGGER.debug("Crear actividad");
              if (validarDatosObligatorios(actividad) == true){
                LOGGER.debug("hay datos validos");
                this.getWS().crearActividad(ConvertidorUtiles.convertVoToVoWS(actividad));
                LOGGER.debug("Se creó la actividad");
              } else {
                 LOGGER.error(Constantes.ERROR_WS_FALTAN_DATOS);
                 throw new FaltanDatosException(Constantes.ERROR_WS_FALTAN_DATOS);
              }
  
        } catch (TipoDatosException_Exception ex) {
           LOGGER.error(ex.getMessage(), ex);
           throw new ArgosWebServiceException(Constantes.ERROR_WS_TIPO_DATO, ex);
        } catch (ErrorSQLException_Exception ex) {
             LOGGER.error(ex.getMessage(), ex);
             throw new ArgosWebServiceException(Constantes.ERROR_WS_GENERICO, ex);
        } catch (FaltaParametroException_Exception ex) {
             LOGGER.error(ex.getMessage(), ex);
             throw new ArgosWebServiceException(Constantes.ERROR_WS_FALTAN_DATOS, ex);
        } catch (MalformedURLException ex) {
            LOGGER.error(ex.getMessage(), ex);
            throw new ArgosWebServiceException(Constantes.ERROR_WS_GENERICO, ex);
        }  catch (DatatypeConfigurationException ex){
            LOGGER.error(ex.getMessage(), ex);
             throw new FaltanDatosException(Constantes.ERROR_WS_FALTAN_DATOS);
        } catch (DocumentoException_Exception ex) {
            LOGGER.error(ex.getMessage(), ex);
            throw new ArgosWebServiceException(Constantes.ERROR_WS_ARCHIVO_UPLOAD, ex);
        }

    }

    
   private boolean validarDatosObligatorios (ActividadVo actividad) {
       LOGGER.debug("validarDatos");
        boolean resultado = true;
        if (actividad != null && actividad.getEstado() != null 
                && actividad.getOportunidad() != null && actividad.getTipoactividad() != null
                && actividad.getTitulo() != null && actividad.getUsuario() != null) {
            resultado = true;
        LOGGER.debug("Datos validos");
        }
        return resultado;
    }

    public void borrarActividad(ActividadVo actividad) throws ArgosWebServiceException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<ActividadVo> listarUltimasActividades(Long idUsuario) throws ArgosWebServiceException {
         try {
            List<ActividadVo> listaVos = null;
            listaVos = new ArrayList<ActividadVo>();
            List<com.suricata.argos.ws.client.ActividadVo> listaEntity = this.getWS().listarUltimasActividadesPorUsuario(idUsuario);
            LOGGER.debug("Se obtuvieron las actividades");
            Iterator it = listaEntity.iterator();
            while (it.hasNext()) {
                ActividadVo actividadVo = ConvertidorUtiles.convertVoWSToVo((com.suricata.argos.ws.client.ActividadVo) it.next());
                listaVos.add(actividadVo);
            }
            return listaVos;
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

    public List<ActividadVo> listarUltimasActividades() throws ArgosWebServiceException {
         try {
            List<ActividadVo> listaVos = null;
            listaVos = new ArrayList<ActividadVo>();
            List<com.suricata.argos.ws.client.ActividadVo> listaEntity = this.getWS().listarUltimasActividades();
            LOGGER.debug("Se obtuvieron las actividades");
            Iterator it = listaEntity.iterator();
            while (it.hasNext()) {
                ActividadVo actividadVo = ConvertidorUtiles.convertVoWSToVo((com.suricata.argos.ws.client.ActividadVo) it.next());
                listaVos.add(actividadVo);
            }
            return listaVos;
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

    public byte[] descargarPlantilla(String ruta) throws ArgosWebServiceException, FaltanDatosException {
        try {
            return this.getWS().descargarPlantilla(ruta);
        } catch (DocumentoException_Exception ex) {
             LOGGER.error(ex.getMessage(), ex);
             throw new ArgosWebServiceException(Constantes.ERROR_WS_ARCHIVO_DOWNLOAD, ex);
        } catch (ErrorSQLException_Exception ex) {
            LOGGER.error(ex.getMessage(), ex);
            throw new ArgosWebServiceException(Constantes.ERROR_WS_GENERICO, ex);
        } catch (FaltaParametroException_Exception ex) {
           LOGGER.error(ex.getMessage(), ex);
           throw new ArgosWebServiceException(Constantes.ERROR_WS_FALTAN_DATOS, ex);
        } catch (MalformedURLException ex) {
           LOGGER.error(ex.getMessage(), ex);
           throw new ArgosWebServiceException(Constantes.ERROR_WS_GENERICO, ex);
        }
    }

    public DocumentoVo buscarDocumento(String nombrePlantilla) throws ArgosWebServiceException, FaltanDatosException {
        try {
            return ConvertidorUtiles.convertVoWSToVo(this.getWS().buscarDocumento(nombrePlantilla));
        } catch (ErrorSQLException_Exception ex) {
            LOGGER.error(ex.getMessage(), ex);
            throw new ArgosWebServiceException(Constantes.ERROR_WS_GENERICO, ex);
        } catch (FaltaParametroException_Exception ex) {
           LOGGER.error(ex.getMessage(), ex);
           throw new ArgosWebServiceException(Constantes.ERROR_WS_FALTAN_DATOS, ex);
        } catch (MalformedURLException ex) {
           LOGGER.error(ex.getMessage(), ex);
           throw new ArgosWebServiceException(Constantes.ERROR_WS_GENERICO, ex);
        }
    }
}
