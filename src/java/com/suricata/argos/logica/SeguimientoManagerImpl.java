/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.suricata.argos.logica;

import com.suricata.argos.constantes.Constantes;
import com.suricata.argos.exception.ArgosWebServiceException;
import com.suricata.argos.exception.FaltanDatosException;
import com.suricata.argos.logica.utiles.ConvertidorUtiles;
import com.suricata.argos.vo.SeguimientoVo;
import com.suricata.argos.ws.client.ArgosWS;
import com.suricata.argos.ws.client.ArgosWSService;
import com.suricata.argos.ws.client.DatosNoEncontradosException_Exception;
import com.suricata.argos.ws.client.ErrorSQLException_Exception;
import com.suricata.argos.ws.client.FaltaParametroException_Exception;
import com.suricata.argos.ws.client.TipoDatosException_Exception;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.apache.log4j.Logger;
import javax.xml.datatype.DatatypeConfigurationException;

/**
 *
 * @author Valentina
 */
public class SeguimientoManagerImpl implements SeguimientoManager {

    private static final Logger LOGGER = Logger.getLogger(SeguimientoManagerImpl.class);
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


public SeguimientoVo buscarSeguimiento(Integer idSeguimiento) throws ArgosWebServiceException {
        try {
            SeguimientoVo seguimiento = null;
            seguimiento = ConvertidorUtiles.convertVoWSToVo(this.getWS().buscarSeguimiento(idSeguimiento));
            return seguimiento;
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


    public List<SeguimientoVo> listarSeguimientos(String enviado, Date fechaDesde, Date fechaHasta) throws ArgosWebServiceException {
       try {
            List<SeguimientoVo> listaVos = null;
            listaVos = new ArrayList<SeguimientoVo>();
            List<com.suricata.argos.ws.client.SeguimientoVo> listaEntity = this.getWS().listarSeguimientos(enviado,  ConvertidorUtiles.convertDate(fechaDesde),  ConvertidorUtiles.convertDate(fechaHasta));
            Iterator it = listaEntity.iterator();
            while (it.hasNext()) {
                SeguimientoVo seguimientoVo = ConvertidorUtiles.convertVoWSToVo((com.suricata.argos.ws.client.SeguimientoVo) it.next());
                listaVos.add(seguimientoVo);
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

    public void modificarSeguimiento(SeguimientoVo seguimiento) throws ArgosWebServiceException,FaltanDatosException {
         try {
              if (validarDatosObligatorios(seguimiento) == true && seguimiento.getId() != 0){
                    this.getWS().modificarSeguimiento(ConvertidorUtiles.convertVoToVoWS(seguimiento));
              } else {
                 LOGGER.error(Constantes.ERROR_WS_FALTAN_DATOS);
                 throw new FaltanDatosException(Constantes.ERROR_WS_FALTAN_DATOS);
              }

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
        } catch (TipoDatosException_Exception ex) {
            LOGGER.error(ex.getMessage(), ex);
            throw new ArgosWebServiceException(Constantes.ERROR_WS_TIPO_DATO, ex);
        }
    }

    public void crearSeguimiento(SeguimientoVo seguimiento) throws ArgosWebServiceException, FaltanDatosException {
         try {
              if (validarDatosObligatorios(seguimiento) == true){
                this.getWS().crearSeguimiento(ConvertidorUtiles.convertVoToVoWS(seguimiento));
              } else {
                 LOGGER.error(Constantes.ERROR_WS_FALTAN_DATOS);
                 throw new FaltanDatosException(Constantes.ERROR_WS_FALTAN_DATOS);
              }

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
        } catch (TipoDatosException_Exception ex) {
            LOGGER.error(ex.getMessage(), ex);
            throw new ArgosWebServiceException(Constantes.ERROR_WS_TIPO_DATO, ex);
        }

    }


   private boolean validarDatosObligatorios (SeguimientoVo seguimiento) {
        boolean resultado = false;
        if (seguimiento != null) {
            resultado = true;
        }
        return resultado;
    }

    public void borrarSeguimiento(SeguimientoVo seguimiento) throws ArgosWebServiceException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<SeguimientoVo> listarUltimosSeguimientos(Long idUsuario) throws ArgosWebServiceException {
         try {
            List<SeguimientoVo> listaVos = null;
            listaVos = new ArrayList<SeguimientoVo>();
            List<com.suricata.argos.ws.client.SeguimientoVo> listaEntity = this.getWS().listarUltimosSeguimientosPorUsuario(idUsuario);
            Iterator it = listaEntity.iterator();
            while (it.hasNext()) {
                SeguimientoVo seguimientoVo = ConvertidorUtiles.convertVoWSToVo((com.suricata.argos.ws.client.SeguimientoVo) it.next());
                listaVos.add(seguimientoVo);
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

      public List<SeguimientoVo> listarUltimosSeguimientos() throws ArgosWebServiceException {
         try {
            List<SeguimientoVo> listaVos = null;
            listaVos = new ArrayList<SeguimientoVo>();
            List<com.suricata.argos.ws.client.SeguimientoVo> listaEntity = this.getWS().listarUltimosSeguimientos();
            Iterator it = listaEntity.iterator();
            while (it.hasNext()) {
                SeguimientoVo seguimientoVo = ConvertidorUtiles.convertVoWSToVo((com.suricata.argos.ws.client.SeguimientoVo) it.next());
                listaVos.add(seguimientoVo);
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
