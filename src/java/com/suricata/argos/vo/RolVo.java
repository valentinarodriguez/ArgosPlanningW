package com.suricata.argos.vo;

import java.util.HashSet;
import java.util.Set;

/**
 * Son los roles que forman parte del modelo de seguridad de IWC.
 * @version 1.0
 * @created 16-Jun-2010 01:49:54
 */
public class RolVo {
  private Integer id;
     private String nombre;
     private Set usuariorols = new HashSet(0);

    public RolVo() {
    }


    public RolVo(String nombre) {
        this.nombre = nombre;
    }
    public RolVo(String nombre, Set usuariorols) {
       this.nombre = nombre;
       this.usuariorols = usuariorols;
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
    public Set getUsuariorols() {
        return this.usuariorols;
    }

    public void setUsuariorols(Set usuariorols) {
        this.usuariorols = usuariorols;
    }




}