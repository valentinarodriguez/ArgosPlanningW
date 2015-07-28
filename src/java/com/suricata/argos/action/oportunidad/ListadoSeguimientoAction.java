/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.suricata.argos.action.oportunidad;

import com.suricata.argos.action.ArgosAction;
import com.suricata.argos.exception.ArgosWebServiceException;
import com.suricata.argos.logica.SeguimientoManager;
import com.suricata.argos.logica.SeguimientoManagerImpl;
import com.suricata.argos.vo.SeguimientoVo;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Valentina
 */
public class ListadoSeguimientoAction  extends ArgosAction {
private List<SeguimientoVo> listadoSeguimientos;
 private SeguimientoManager seguimientoManager = new SeguimientoManagerImpl();
 private Integer id;
 private Date fechaDesde;
 private Date fechaHasta;
 private Boolean enviado;

    public Date getFechaDesde() {
        return fechaDesde;
    }

    public void setFechaDesde(Date fechaDesde) {
        this.fechaDesde = fechaDesde;
    }

    public Date getFechaHasta() {
        return fechaHasta;
    }

    public void setFechaHasta(Date fechaHasta) {
        this.fechaHasta = fechaHasta;
    }

    public Boolean getEnviado() {
        return enviado;
    }

    public void setEnviado(Boolean enviado) {
        this.enviado = enviado;
    }



    public List<SeguimientoVo> getListadoSeguimientos() {
        return listadoSeguimientos;
    }

    public void setListadoSeguimientos(List<SeguimientoVo> listadoSeguimientos) {
        this.listadoSeguimientos = listadoSeguimientos;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

  


    public String execute() throws Exception {
        try {
            String envio;
            if (enviado == null){
               enviado = true;
            }

           this.setListadoSeguimientos(this.seguimientoManager.listarSeguimientos(enviado.toString(), fechaDesde, fechaHasta));
           if (this.getListadoSeguimientos() == null)
            listadoSeguimientos = new ArrayList();
        } catch (ArgosWebServiceException e) {
            addActionError(e.getMessage());
        }
        return SUCCESS;
    }

}
