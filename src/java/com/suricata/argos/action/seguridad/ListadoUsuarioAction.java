/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.suricata.argos.action.seguridad;

import com.opensymphony.xwork2.ActionSupport;
import com.suricata.argos.exception.ArgosWebServiceException;
import com.suricata.argos.logica.UsuarioManager;
import com.suricata.argos.logica.UsuarioManagerImpl;
import com.suricata.argos.vo.UsuarioVo;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Valentina
 */
public class ListadoUsuarioAction extends ActionSupport {

 private List<UsuarioVo> listadoUsuarios;
 private UsuarioManager usuarioManager = new UsuarioManagerImpl();
 private Integer id;


    public UsuarioManager getUsuarioManager() {
        return usuarioManager;
    }

    public void setUsuarioManager(UsuarioManager usuarioManager) {
        this.usuarioManager = usuarioManager;
    }

    public List<UsuarioVo> getListadoUsuarios() {
        return listadoUsuarios;
    }

    public void setListadoUsuarios(List<UsuarioVo> listadoUsuarios) {
        this.listadoUsuarios = listadoUsuarios;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String execute() throws Exception {
        try {
           this.setListadoUsuarios(this.getUsuarioManager().listarUsuarios());
           if (this.getListadoUsuarios() == null)
            listadoUsuarios = new ArrayList();
        } catch (ArgosWebServiceException e) {
            addActionError(e.getMessage());
        }
        return SUCCESS;
    }

}
