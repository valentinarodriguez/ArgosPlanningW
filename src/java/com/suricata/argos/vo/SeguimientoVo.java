/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.suricata.argos.vo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Valentina
 */
public class SeguimientoVo {


     private Integer id;
     private UsuarioVo usuario;
     private Set<SeguimientoTipoSeguimientoVo> seguimientotiposeguimientos = new HashSet(0);
     private ActividadVo actividad;
     private Date fechaVencimiento;
     private Date fechaAnuncio;
     private Integer enviado;

    public SeguimientoVo() {
    }


    public SeguimientoVo(UsuarioVo usuario, Set<SeguimientoTipoSeguimientoVo> seguimientotiposeguimientos, ActividadVo actividad, Date fechaVencimiento, Date fechaAnuncio, Integer enviado) {
       this.usuario = usuario;
       this.seguimientotiposeguimientos = seguimientotiposeguimientos;
       this.actividad = actividad;
       this.fechaVencimiento = fechaVencimiento;
       this.fechaAnuncio = fechaAnuncio;
       this.enviado = enviado;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public UsuarioVo getUsuario() {
        return this.usuario;
    }

    public void setUsuario(UsuarioVo usuario) {
        this.usuario = usuario;
    }
    public Set<SeguimientoTipoSeguimientoVo> getSeguimientotiposeguimientos() {
        return seguimientotiposeguimientos;
    }

    public void setSeguimientotiposeguimientos(Set<SeguimientoTipoSeguimientoVo> seguimientotiposeguimientos) {
        this.seguimientotiposeguimientos = seguimientotiposeguimientos;
    }
    public ActividadVo getActividad() {
        return this.actividad;
    }

    public void setActividad(ActividadVo actividad) {
        this.actividad = actividad;
    }
    public Date getFechaVencimiento() {
        return this.fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }
    public Date getFechaAnuncio() {
        return this.fechaAnuncio;
    }

    public void setFechaAnuncio(Date fechaAnuncio) {
        this.fechaAnuncio = fechaAnuncio;
    }

    public Integer getEnviado() {
        return enviado;
    }

    public void setEnviado(Integer enviado) {
        this.enviado = enviado;
    }

 



}
