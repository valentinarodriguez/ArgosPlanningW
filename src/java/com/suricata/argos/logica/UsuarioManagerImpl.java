/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.suricata.argos.logica;


import com.suricata.argos.exception.ArgosWebServiceException;
import com.suricata.argos.vo.UsuarioVo;
import com.suricata.argos.ws.client.ArgosWS;
import com.suricata.argos.ws.client.ArgosWSService;
import com.suricata.argos.ws.client.DatosDuplicadosException_Exception;
import com.suricata.argos.ws.client.DatosNoEncontradosException_Exception;
import com.suricata.argos.ws.client.ErrorSQLException_Exception;
import com.suricata.argos.ws.client.FaltaParametroException_Exception;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.log4j.Logger;
import com.suricata.argos.constantes.Constantes;
import com.suricata.argos.exception.FaltanDatosException;



/**
 *
 * @author Valentina
 */
public class UsuarioManagerImpl implements UsuarioManager {

    private static final Logger LOGGER = Logger.getLogger(UsuarioManagerImpl.class);

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


    
    public UsuarioVo buscarUsuario(Integer idUsuario) throws ArgosWebServiceException {
        try {
            UsuarioVo usuario = null;
            usuario = this.convertVoWSToVo(this.getWS().buscarUsuario(idUsuario));
            return usuario;
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


    public List<UsuarioVo> listarUsuarios() throws ArgosWebServiceException {
       try {
            List<UsuarioVo> listaVos = null;
            listaVos = new ArrayList<UsuarioVo>();
            List<com.suricata.argos.ws.client.UsuarioVo> listaEntity = this.getWS().listarUsuarios();
            Iterator it = listaEntity.iterator();
            while (it.hasNext()) {
                UsuarioVo usaurioVo = this.convertVoWSToVo((com.suricata.argos.ws.client.UsuarioVo) it.next());
                listaVos.add(usaurioVo);
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

    public void modificarUsuario(UsuarioVo usuario) throws ArgosWebServiceException,FaltanDatosException {
         try {
              if (validarDatosObligatorios(usuario) == true && usuario.getId() != 0){
                this.getWS().modificarUsuario(this.convertVoToVoWS(usuario));
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
        }

    }

    public void crearUsuario(UsuarioVo usuario) throws ArgosWebServiceException, FaltanDatosException {
         try {
              if (validarDatosObligatorios(usuario) == true){
                this.getWS().crearUsuario(this.convertVoToVoWS(usuario));
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
        }
       
    }


   
    private boolean validarDatosObligatorios (UsuarioVo usuario) throws ArgosWebServiceException {
        boolean resultado = false;
    if (usuario != null && usuario.getApellido()!= null && usuario.getNombre() != null &&
                usuario.getCargo() != null && usuario.getEmail() != null && usuario.getNick()  != null) {
            resultado = true;
        }
       
        return resultado;
    }

    private com.suricata.argos.ws.client.UsuarioVo convertVoToVoWS(UsuarioVo usuarioVo){
        com.suricata.argos.ws.client.UsuarioVo usuario = new com.suricata.argos.ws.client.UsuarioVo();
        if (usuario != null) {
            usuario.setApellido(usuarioVo.getApellido());
            usuario.setCargo(usuarioVo.getCargo());
            usuario.setEmail(usuarioVo.getEmail());
            usuario.setCelular(usuarioVo.getCelular());
            usuario.setId(usuarioVo.getId());
            usuario.setNick(usuarioVo.getNick());
            usuario.setNombre(usuarioVo.getNombre());
            usuario.setTelefono(usuarioVo.getTelefono());
            usuario.setContrasena(usuarioVo.getContrasena());
        }
         return usuario;
    }
    
     private UsuarioVo convertVoWSToVo(com.suricata.argos.ws.client.UsuarioVo usuarioVo){
        UsuarioVo usuario = new UsuarioVo();
        if (usuario != null) {
            usuario.setApellido(usuarioVo.getApellido());
            usuario.setCargo(usuarioVo.getCargo());
            usuario.setEmail(usuarioVo.getEmail());
            usuario.setCelular(usuarioVo.getCelular());
            usuario.setId(usuarioVo.getId());
            usuario.setNick(usuarioVo.getNick());
            usuario.setNombre(usuarioVo.getNombre());
            usuario.setTelefono(usuarioVo.getTelefono());
        }
         return usuario;
    }

    public UsuarioVo buscarUsuario(String nombre, String contrasena) throws ArgosWebServiceException, FaltanDatosException {
        try {
            UsuarioVo usuario = null;
            usuario = this.convertVoWSToVo(this.getWS().validarUsuario(nombre, contrasena));
            return usuario;
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

}
