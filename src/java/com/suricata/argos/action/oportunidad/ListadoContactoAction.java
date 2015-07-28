/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.suricata.argos.action.oportunidad;

import com.suricata.argos.action.ArgosAction;
import com.suricata.argos.exception.ArgosWebServiceException;
import com.suricata.argos.logica.ContactoManager;
import com.suricata.argos.logica.ContactoManagerImpl;
import com.suricata.argos.vo.ContactoVo;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Valentina
 */
public class ListadoContactoAction extends ArgosAction {

 private List<ContactoVo> listadoContactos;
 private ContactoManager contactoManager = new ContactoManagerImpl();
 private Integer id;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<ContactoVo> getListadoContactos() {
        return listadoContactos;
    }

    public void setListadoContactos(List<ContactoVo> listadoContactos) {
        this.listadoContactos = listadoContactos;
    }

   

    public String execute() throws Exception {
        try {
           this.setListadoContactos(contactoManager.listarContactos());
           if (this.getListadoContactos() == null)
            listadoContactos = new ArrayList();
        } catch (ArgosWebServiceException e) {
            addActionError(e.getMessage());
        }
        return SUCCESS;
    }

}
