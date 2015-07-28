/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.suricata.argos.logica;

import com.suricata.argos.exception.ArgosWebServiceException;
import com.suricata.argos.logica.utiles.ConvertidorUtiles;
import com.suricata.argos.vo.EstadoVo;
import com.suricata.argos.vo.TecnologiaVo;
import com.suricata.argos.vo.TipoProyectoVo;
import com.suricata.argos.ws.client.ArgosWS;
import com.suricata.argos.ws.client.ArgosWSService;
import com.suricata.argos.ws.client.ErrorSQLException_Exception;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.log4j.Logger;
import com.suricata.argos.constantes.Constantes;
import com.suricata.argos.vo.TipoActividadVo;
import com.suricata.argos.vo.TipoSeguimientoVo;

/**
 *
 * @author Valentina
 */
public class CodigueraManagerImpl implements CodigueraManager{
      private static final Logger LOGGER = Logger.getLogger(CodigueraManagerImpl.class);
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
    public List<TipoProyectoVo> listarTipoProyectos() throws ArgosWebServiceException {
        try {
            List<TipoProyectoVo> listaVos = null;
            listaVos = new ArrayList<TipoProyectoVo>();
            List<com.suricata.argos.ws.client.TipoProyectoVo> listaEntity = this.getWS().listarTipoProyectos();
            Iterator it = listaEntity.iterator();
            while (it.hasNext()) {
                TipoProyectoVo codigueraVo = ConvertidorUtiles.convertVoWSToVo((com.suricata.argos.ws.client.TipoProyectoVo) it.next());
                listaVos.add(codigueraVo);
            }
            return listaVos;
        } catch (ErrorSQLException_Exception ex) {
            LOGGER.error(ex.getMessage(), ex);
            throw new ArgosWebServiceException(Constantes.ERROR_WS_GENERICO, ex);
        } catch (MalformedURLException ex) {
            LOGGER.error(ex.getMessage(), ex);
            throw new ArgosWebServiceException(Constantes.ERROR_WS_GENERICO, ex);
        }
    }

    public List<TecnologiaVo> listarTecnologias() throws ArgosWebServiceException {
         try {
            List<TecnologiaVo> listaVos = null;
            listaVos = new ArrayList<TecnologiaVo>();
            List<com.suricata.argos.ws.client.TecnologiaVo> listaEntity = this.getWS().listarTecnologias();
            Iterator it = listaEntity.iterator();
            while (it.hasNext()) {
                TecnologiaVo codigueraVo = ConvertidorUtiles.convertVoWSToVo((com.suricata.argos.ws.client.TecnologiaVo) it.next());
                listaVos.add(codigueraVo);
            }
            return listaVos;
        } catch (ErrorSQLException_Exception ex) {
            LOGGER.error(ex.getMessage(), ex);
            throw new ArgosWebServiceException(Constantes.ERROR_WS_GENERICO, ex);
        } catch (MalformedURLException ex) {
            LOGGER.error(ex.getMessage(), ex);
            throw new ArgosWebServiceException(Constantes.ERROR_WS_GENERICO, ex);
        }
    }

    public List<EstadoVo> listarEstados() throws ArgosWebServiceException {
         try {
            List<EstadoVo> listaVos = null;
            listaVos = new ArrayList<EstadoVo>();
            List<com.suricata.argos.ws.client.EstadoVo> listaEntity = this.getWS().listarEstados();
            Iterator it = listaEntity.iterator();
            while (it.hasNext()) {
                EstadoVo codigueraVo = ConvertidorUtiles.convertVoWSToVo((com.suricata.argos.ws.client.EstadoVo) it.next());
                listaVos.add(codigueraVo);
            }
            return listaVos;
        } catch (ErrorSQLException_Exception ex) {
            LOGGER.error(ex.getMessage(), ex);
            throw new ArgosWebServiceException(Constantes.ERROR_WS_GENERICO, ex);
        } catch (MalformedURLException ex) {
            LOGGER.error(ex.getMessage(), ex);
            throw new ArgosWebServiceException(Constantes.ERROR_WS_GENERICO, ex);
        }
    }

      public List<TipoActividadVo> listarTipoActividades() throws ArgosWebServiceException {
         try {
            List<TipoActividadVo> listaVos = null;
            listaVos = new ArrayList<TipoActividadVo>();
            List<com.suricata.argos.ws.client.TipoActividadVo> listaEntity = this.getWS().listarTipoActividades();
            Iterator it = listaEntity.iterator();
            while (it.hasNext()) {
                TipoActividadVo codigueraVo = ConvertidorUtiles.convertVoWSToVo((com.suricata.argos.ws.client.TipoActividadVo) it.next());
                listaVos.add(codigueraVo);
            }
            return listaVos;
        } catch (ErrorSQLException_Exception ex) {
            LOGGER.error(ex.getMessage(), ex);
            throw new ArgosWebServiceException(Constantes.ERROR_WS_GENERICO, ex);
        } catch (MalformedURLException ex) {
            LOGGER.error(ex.getMessage(), ex);
            throw new ArgosWebServiceException(Constantes.ERROR_WS_GENERICO, ex);
        }
    }

   

    public List<TipoSeguimientoVo> listarTipoSeguimientos() throws ArgosWebServiceException {
        try {
            List<TipoSeguimientoVo> listaVos = null;
            listaVos = new ArrayList<TipoSeguimientoVo>();
            List<com.suricata.argos.ws.client.TipoSeguimientoVo> listaEntity = this.getWS().listarTipoSeguimientos();
            Iterator it = listaEntity.iterator();
            while (it.hasNext()) {
                TipoSeguimientoVo codigueraVo = ConvertidorUtiles.convertVoWSToVo((com.suricata.argos.ws.client.TipoSeguimientoVo) it.next());
                listaVos.add(codigueraVo);
            }
            return listaVos;
        } catch (ErrorSQLException_Exception ex) {
            LOGGER.error(ex.getMessage(), ex);
            throw new ArgosWebServiceException(Constantes.ERROR_WS_GENERICO, ex);
        } catch (MalformedURLException ex) {
            LOGGER.error(ex.getMessage(), ex);
            throw new ArgosWebServiceException(Constantes.ERROR_WS_GENERICO, ex);
        }
    }
}
