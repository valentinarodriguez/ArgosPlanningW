/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.suricata.argos.vo;

import java.util.Date;

/**
 *
 * @author Valentina
 */
public class ActividadVo {
    private Integer id;
     private OportunidadVo oportunidad;
     private UsuarioVo usuario;
     private TipoActividadVo tipoactividad;
     private String titulo;
     private String descripcion;
     private ContactoVo responsableCliente;
     private UsuarioVo responsableUsuario;
     private Date fechaVencimiento;
     private Date fechaCreacion;
     private String descripcionCierre;
     private EstadoVo estado;
     private DocumentoVo documento;

    public ActividadVo() {
    }


    public ActividadVo(OportunidadVo oportunidad, UsuarioVo usuario, TipoActividadVo tipoactividad, String titulo, ContactoVo responsableCliente, UsuarioVo responsableUsuario, Date fechaVencimiento, Date fechaCreacion, DocumentoVo documento) {
        this.oportunidad = oportunidad;
        this.usuario = usuario;
        this.tipoactividad = tipoactividad;
        this.titulo = titulo;
        this.responsableCliente = responsableCliente;
        this.responsableUsuario = responsableUsuario;
        this.fechaVencimiento = fechaVencimiento;
        this.fechaCreacion = fechaCreacion;
        this.documento = documento;
    }
    public ActividadVo(OportunidadVo oportunidad, UsuarioVo usuario, TipoActividadVo tipoactividad, String titulo, String descripcion,ContactoVo responsableCliente, UsuarioVo responsableUsuario, Date fechaVencimiento, Date fechaCreacion, String descripcionCierre, EstadoVo estado, DocumentoVo documento) {
       this.oportunidad = oportunidad;
       this.usuario = usuario;
       this.tipoactividad = tipoactividad;
       this.titulo = titulo;
       this.descripcion = descripcion;
       this.responsableCliente = responsableCliente;
       this.responsableUsuario = responsableUsuario;
       this.fechaVencimiento = fechaVencimiento;
       this.fechaCreacion = fechaCreacion;
       this.descripcionCierre = descripcionCierre;
       this.estado = estado;
       this.documento = documento;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public OportunidadVo getOportunidad() {
        return this.oportunidad;
    }

    public void setOportunidad(OportunidadVo oportunidad) {
        this.oportunidad = oportunidad;
    }
    public UsuarioVo getUsuario() {
        return this.usuario;
    }

    public void setUsuario(UsuarioVo usuario) {
        this.usuario = usuario;
    }
    public TipoActividadVo getTipoactividad() {
        return this.tipoactividad;
    }

    public void setTipoactividad(TipoActividadVo tipoactividad) {
        this.tipoactividad = tipoactividad;
    }
    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaVencimiento() {
        return this.fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }
    public Date getFechaCreacion() {
        return this.fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
    public String getDescripcionCierre() {
        return this.descripcionCierre;
    }

    public void setDescripcionCierre(String descripcionCierre) {
        this.descripcionCierre = descripcionCierre;
    }

    public EstadoVo getEstado() {
        return estado;
    }

    public void setEstado(EstadoVo estado) {
        this.estado = estado;
    }

    public ContactoVo getResponsableCliente() {
        return responsableCliente;
    }

    public void setResponsableCliente(ContactoVo responsableCliente) {
        this.responsableCliente = responsableCliente;
    }

    public UsuarioVo getResponsableUsuario() {
        return responsableUsuario;
    }

    public void setResponsableUsuario(UsuarioVo responsableUsuario) {
        this.responsableUsuario = responsableUsuario;
    }

    public DocumentoVo getDocumento() {
        return documento;
    }

    public void setDocumento(DocumentoVo documento) {
        this.documento = documento;
    }



}
