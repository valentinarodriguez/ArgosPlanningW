/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.suricata.argos.vo;

/**
 *
 * @author Valentina
 */
public class EmpresaVo {

     private int id;
     private String nombre;
     private String descripcion;
     private Long rut;
     private String rubro;
     private String direccion;
     private String telefono;

     public EmpresaVo() {

     }

     public EmpresaVo(String nombre, String descripcion, Long rut, String rubro, String direccion, String telefono) {
         this.setDescripcion(descripcion);
         this.setDireccion(direccion);
         this.setNombre(nombre);
         this.setRubro(rubro);
         this.setRut(rut);
         this.setTelefono(telefono);
     }


    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRubro() {
        return rubro;
    }

    public void setRubro(String rubro) {
        this.rubro = rubro;
    }

    public Long getRut() {
        return rut;
    }

    public void setRut(Long rut) {
        this.rut = rut;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

     

}
