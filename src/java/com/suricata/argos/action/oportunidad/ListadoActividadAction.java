/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.suricata.argos.action.oportunidad;

import com.suricata.argos.action.ArgosAction;
import com.suricata.argos.constantes.Constantes;
import com.suricata.argos.exception.ArgosWebServiceException;
import com.suricata.argos.logica.ActividadManager;
import com.suricata.argos.logica.ActividadManagerImpl;
import com.suricata.argos.logica.CodigueraManager;
import com.suricata.argos.logica.CodigueraManagerImpl;
import com.suricata.argos.vo.ActividadVo;
import com.suricata.argos.vo.EstadoVo;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Valentina
 */
public class ListadoActividadAction extends ArgosAction {

 private List<ActividadVo> listadoActividades;
 private ActividadManager actividadManager = new ActividadManagerImpl();
  private CodigueraManager codigueraManager = new CodigueraManagerImpl();
 private Integer id;
 private Date fechaDesde;
 private Date fechaHasta;
 private List<EstadoVo> listaEstados;
 private EstadoVo estado;

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

    public EstadoVo getEstado() {
        return estado;
    }

    public void setEstado(EstadoVo estado) {
        this.estado = estado;
    }

  

    public List<EstadoVo> getListaEstados() {
        return listaEstados;
    }

    public void setListaEstados(List<EstadoVo> listaEstados) {
        this.listaEstados = listaEstados;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<ActividadVo> getListadoActividades() {
        return listadoActividades;
    }

    public void setListadoActividades(List<ActividadVo> listadoActividades) {
        this.listadoActividades = listadoActividades;
    }

   

    public String execute() throws Exception {
        try {
            this.setListaEstados(this.codigueraManager.listarEstados());
           String nombreEstado = "";
           if (estado == null){
                  nombreEstado = Constantes.ESTADO_ABIERTO_NOMBRE;
           } else {
               nombreEstado =  estado.getNombre();
           }

           this.setListadoActividades(actividadManager.listarActividads(nombreEstado, fechaDesde, fechaHasta));
           if (this.getListadoActividades() == null)
            listadoActividades = new ArrayList();
        } catch (ArgosWebServiceException e) {
            addActionError(e.getMessage());
        }
        return SUCCESS;
    }

}
