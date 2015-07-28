/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.suricata.argos.vo;

/**
 *
 * @author Valentina
 */
public class ContactoVo {
     private Integer id;
     private EmpresaVo empresaVo;
     private String nombre;
     private String apellido;
     private String cargo;
     private String email;
     private String telefono;
     private String celular;
     private String chat;
     private String comentarios;


   public ContactoVo(){

   }

   public ContactoVo(EmpresaVo empresaVo, String nombre, String apellido,String cargo,String email,String telefono,String celular,String chat,String  comentarios){
       this.setApellido(apellido);
       this.setCargo(cargo);
       this.setCelular(celular);
       this.setChat(chat);
       this.setComentarios(comentarios);
       this.setEmail(email);
       this.setTelefono(telefono);
       this.setEmpresaVo(empresaVo);
       this.setNombre(nombre);
   }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getChat() {
        return chat;
    }

    public void setChat(String chat) {
        this.chat = chat;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public EmpresaVo getEmpresaVo() {
        return empresaVo;
    }

    public void setEmpresaVo(EmpresaVo empresaVo) {
        this.empresaVo = empresaVo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

     


}
