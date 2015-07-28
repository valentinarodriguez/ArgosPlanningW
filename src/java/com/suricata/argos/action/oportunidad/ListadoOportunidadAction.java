/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.suricata.argos.action.oportunidad;

import com.suricata.argos.action.ArgosAction;
import com.suricata.argos.constantes.Constantes;
import com.suricata.argos.exception.ArgosWebServiceException;
import com.suricata.argos.logica.CodigueraManager;
import com.suricata.argos.logica.CodigueraManagerImpl;
import com.suricata.argos.logica.OportunidadManager;
import com.suricata.argos.logica.OportunidadManagerImpl;
import com.suricata.argos.vo.EstadoVo;
import com.suricata.argos.vo.OportunidadVo;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Valentina
 */
public class ListadoOportunidadAction extends ArgosAction {

 private List<OportunidadVo> listadoOportunidades;
 private OportunidadManager oportunidadManager = new OportunidadManagerImpl();
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

    public List<OportunidadVo> getListadoOportunidades() {
        return listadoOportunidades;
    }

    public void setListadoOportunidades(List<OportunidadVo> listadoOportunidades) {
        this.listadoOportunidades = listadoOportunidades;
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

           this.setListadoOportunidades(oportunidadManager.listarOportunidades(nombreEstado, fechaDesde, fechaHasta));
           if (this.getListadoOportunidades() == null)
            listadoOportunidades = new ArrayList();
        } catch (ArgosWebServiceException e) {
            addActionError(e.getMessage());
        }
        return SUCCESS;
    }

}
