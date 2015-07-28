/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.suricata.argos.action.oportunidad;

import com.suricata.argos.action.ArgosAction;
import com.suricata.argos.exception.ArgosWebServiceException;
import com.suricata.argos.logica.EmpresaManager;
import com.suricata.argos.logica.EmpresaManagerImpl;
import com.suricata.argos.vo.EmpresaVo;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Valentina
 */
public class ListadoEmpresaAction extends ArgosAction {

 private List<EmpresaVo> listadoEmpresas;
 private EmpresaManager empresaManager = new EmpresaManagerImpl();
 private Integer id;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<EmpresaVo> getListadoEmpresas() {
        return listadoEmpresas;
    }

    public void setListadoEmpresas(List<EmpresaVo> listadoEmpresas) {
        this.listadoEmpresas = listadoEmpresas;
    }

   

    public String execute() throws Exception {
        try {
           this.setListadoEmpresas(empresaManager.listarEmpresas());
           if (this.getListadoEmpresas() == null)
            listadoEmpresas = new ArrayList();
        } catch (ArgosWebServiceException e) {
            addActionError(e.getMessage());
        }
        return SUCCESS;
    }

}
