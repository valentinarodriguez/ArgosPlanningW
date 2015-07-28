/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.suricata.argos.action;

import com.opensymphony.xwork2.ActionSupport;
import com.suricata.argos.constantes.Constantes;
import com.suricata.argos.exception.ArgosWebServiceException;
import com.suricata.argos.exception.FaltanDatosException;
import com.suricata.argos.logica.RolManager;
import com.suricata.argos.logica.RolManagerImpl;
import com.suricata.argos.logica.UsuarioManager;
import com.suricata.argos.logica.UsuarioManagerImpl;
import com.suricata.argos.vo.RolVo;
import com.suricata.argos.vo.UsuarioVo;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author Valentina
 */
public class LoginAction extends ArgosAction {
    private String usuario;
    private String contrasena;
    private RolManager rolManager = new RolManagerImpl();
    private UsuarioManager usuarioManager = new UsuarioManagerImpl();

    public static final String REDIR_INICIO = "redirInicio";

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }



    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String execute () {
        return INPUT;
    }

      public String validarUsuario(){
       UsuarioVo usuarioVo = null;
        try {
           
            usuarioVo = usuarioManager.buscarUsuario(usuario, contrasena);
            if (usuarioVo == null) {
                addActionError("Datos incorrectos");
                return INPUT;
            } else {
                List<RolVo> rolesUsuario = rolManager.listarRolesPorUsuario(usuarioVo.getId());
                if (rolesUsuario == null || rolesUsuario.size() == 0) {
                    addActionError("No hay roles");
                    return INPUT;
                }
                this.getSession().put(Constantes.SESSION_USUARIO, usuarioVo);
            }


        } catch (FaltanDatosException ex) {
           addActionError(ex.getMessage());
           return INPUT;
        } catch (ArgosWebServiceException ex) {
           addActionError(ex.getMessage());
           return INPUT;
        }
        return REDIR_INICIO;

    }

     
}
