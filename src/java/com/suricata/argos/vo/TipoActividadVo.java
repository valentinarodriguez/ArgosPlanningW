/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.suricata.argos.vo;

/**
 *
 * @author Valentina
 */
public class TipoActividadVo {
    private Integer id;
     private String nombre;
     private String descripcion;


    public TipoActividadVo() {
    }


    public TipoActividadVo(String nombre, String descripcion) {
       this.nombre = nombre;
       this.descripcion = descripcion;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
