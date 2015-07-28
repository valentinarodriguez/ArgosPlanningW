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
public class OportunidadVo {

     private Integer id;
     private ContactoVo contacto;
     private TipoProyectoVo tipoproyecto;
     private TecnologiaVo tecnologia;
     private UsuarioVo usuario;
     private EstadoVo estado;
     private EmpresaVo empresa;
     private String codigoInterno;
     private String titulo;
     private String descripcionCierre;
     private Date fecha;
     private DocumentoVo documento;
     private Date fechaCierre;

    public DocumentoVo getDocumento() {
        return documento;
    }

    public void setDocumento(DocumentoVo documento) {
        this.documento = documento;
    }

    public OportunidadVo() {
         
     }

      public OportunidadVo(ContactoVo contacto, TipoProyectoVo tipoproyecto, TecnologiaVo tecnologia, UsuarioVo usuario, EstadoVo estado, EmpresaVo empresa, String codigoInterno, String titulo, String descripcionCierre, Date fecha) {
       this.setCodigoInterno(codigoInterno);
       this.setContacto(contacto);
       this.setDescripcionCierre(descripcionCierre);
       this.setEmpresa(empresa);
       this.setEstado(estado);
       this.setFecha(fecha);
       this.setId(id);
       this.setTecnologia(tecnologia);
       this.setTipoproyecto(tipoproyecto);
       this.setTitulo(titulo);
       this.setUsuario(usuario);
      }

    public String getCodigoInterno() {
        return codigoInterno;
    }

    public void setCodigoInterno(String codigoInterno) {
        this.codigoInterno = codigoInterno;
    }

    public ContactoVo getContacto() {
        return contacto;
    }

    public void setContacto(ContactoVo contacto) {
        this.contacto = contacto;
    }

    public String getDescripcionCierre() {
        return descripcionCierre;
    }

    public void setDescripcionCierre(String descripcionCierre) {
        this.descripcionCierre = descripcionCierre;
    }

    public EmpresaVo getEmpresa() {
        return empresa;
    }

    public void setEmpresa(EmpresaVo empresa) {
        this.empresa = empresa;
    }

    public EstadoVo getEstado() {
        return estado;
    }

    public void setEstado(EstadoVo estado) {
        this.estado = estado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TecnologiaVo getTecnologia() {
        return tecnologia;
    }

    public void setTecnologia(TecnologiaVo tecnologia) {
        this.tecnologia = tecnologia;
    }

    public TipoProyectoVo getTipoproyecto() {
        return tipoproyecto;
    }

    public void setTipoproyecto(TipoProyectoVo tipoproyecto) {
        this.tipoproyecto = tipoproyecto;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public UsuarioVo getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioVo usuario) {
        this.usuario = usuario;
    }

    public Date getFechaCierre() {
        return fechaCierre;
    }

    public void setFechaCierre(Date fechaCierre) {
        this.fechaCierre = fechaCierre;
    }

}
