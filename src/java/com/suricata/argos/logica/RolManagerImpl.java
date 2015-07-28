/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.suricata.argos.logica;

import com.suricata.argos.constantes.Constantes;
import com.suricata.argos.exception.ArgosWebServiceException;
import com.suricata.argos.exception.FaltanDatosException;
import com.suricata.argos.logica.utiles.ConvertidorUtiles;
import com.suricata.argos.vo.RolVo;
import com.suricata.argos.ws.client.ArgosWS;
import com.suricata.argos.ws.client.ArgosWSService;
import com.suricata.argos.ws.client.DatosNoEncontradosException_Exception;
import com.suricata.argos.ws.client.ErrorSQLException_Exception;
import com.suricata.argos.ws.client.FaltaParametroException_Exception;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.log4j.Logger;

/**
 *
 * @author Valentina
 */
public class RolManagerImpl implements RolManager{
  private static final Logger LOGGER = Logger.getLogger(RolManagerImpl.class);
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
    public void crearRol(RolVo rol) throws ArgosWebServiceException, FaltanDatosException {
          try {
              if (validarDatosObligatorios(rol) == true){
                this.getWS().crearRol(ConvertidorUtiles.convertVoToVoWS(rol));
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
        }

    }

    public List<RolVo> listarRoles() throws ArgosWebServiceException {
        try {
            List<RolVo> listaVos = null;
            listaVos = new ArrayList<RolVo>();
            List<com.suricata.argos.ws.client.RolVo> listaEntity = this.getWS().listarRoles();
            Iterator it = listaEntity.iterator();
            while (it.hasNext()) {
                RolVo rolVo = ConvertidorUtiles.convertVoWSToVo((com.suricata.argos.ws.client.RolVo) it.next());
                listaVos.add(rolVo);
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

    public RolVo buscarRol(Integer id) throws ArgosWebServiceException {
         try {
            RolVo rol = null;
            rol = ConvertidorUtiles.convertVoWSToVo(this.getWS().buscarRol(id));
            return rol;
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

    public void modificarRol(RolVo rol) throws ArgosWebServiceException, FaltanDatosException {
         try {
          if (validarDatosObligatorios(rol) == true && rol.getId() != 0){
                this.getWS().modificarRol(ConvertidorUtiles.convertVoToVoWS(rol));
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
        }
    }

    public List<RolVo> listarRolesPorUsuario(Integer idUsuario) throws ArgosWebServiceException, FaltanDatosException {
       try {
            if (idUsuario == null){
                LOGGER.error("Faltan datos");
                throw new FaltanDatosException("Faltan datos");
            }
            List<RolVo> listaVos = null;
            listaVos = new ArrayList<RolVo>();
            List<com.suricata.argos.ws.client.RolVo> listaEntity = this.getWS().listarRolesPorUsuario( idUsuario);
            Iterator it = listaEntity.iterator();
            while (it.hasNext()) {
                RolVo rolVo = ConvertidorUtiles.convertVoWSToVo((com.suricata.argos.ws.client.RolVo) it.next());
                listaVos.add(rolVo);
            }
            return listaVos;
        } catch (ErrorSQLException_Exception ex) {
            LOGGER.error(ex.getMessage(), ex);
            throw new ArgosWebServiceException(Constantes.ERROR_WS_GENERICO, ex);
        } catch (MalformedURLException ex) {
            LOGGER.error(ex.getMessage(), ex);
            throw new ArgosWebServiceException(Constantes.ERROR_WS_GENERICO, ex);
        } catch (FaltaParametroException_Exception ex) {
              LOGGER.error(ex.getMessage(), ex);
            throw new FaltanDatosException(Constantes.ERROR_WS_GENERICO, ex);
        }
    }

      private boolean validarDatosObligatorios (RolVo rol) {
        boolean resultado = false;
        if (rol != null && rol.getNombre() != null) {
            resultado = true;
        }
        return resultado;
    }


}
