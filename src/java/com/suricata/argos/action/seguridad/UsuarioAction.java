package com.suricata.argos.action.seguridad;


import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.*;
import com.suricata.argos.exception.ArgosWebServiceException;
import com.suricata.argos.exception.FaltanDatosException;
import com.suricata.argos.logica.UsuarioManager;
import com.suricata.argos.logica.UsuarioManagerImpl;
import com.suricata.argos.vo.UsuarioVo;
import org.apache.struts2.interceptor.validation.SkipValidation;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Valentina
 */
@Validations()
public class UsuarioAction extends ActionSupport {
    private UsuarioManager usuarioManager = new UsuarioManagerImpl();

     private String apellido;
      private String nombre;
     private String nick;
     private String telefono;
     private String email;
     private Long celular;
     private String cargo;
     private Integer id;
     private String contrasena;


   

    public UsuarioManager getUsuarioManager() {
        return usuarioManager;
    }

    public void setUsuarioManager(UsuarioManager usuarioManager) {
        this.usuarioManager = usuarioManager;
    }

    public String getApellido() {
        return apellido;
    }
    
    @RequiredStringValidator(type = ValidatorType.FIELD, message = "Campo requerido")
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCargo() {
        return cargo;
    }

    @RequiredStringValidator(type = ValidatorType.FIELD, message = "Campo requerido")
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Long getCelular() {
        return celular;
    }

    public void setCelular(Long celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public String getContrasena() {
        return contrasena;
    }

    @RequiredStringValidator(type = ValidatorType.FIELD, message = "Campo requerido")
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }


    @RequiredStringValidator(type = ValidatorType.FIELD, message = "Campo requerido")
    @EmailValidator(message = "Formato no válido", shortCircuit = true)
    public void setEmail(String email) {
        this.email = email;
    }

    public String getNick() {
        return nick;
    }

    @RequiredStringValidator(type = ValidatorType.FIELD, message = "Campo requerido")
    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getNombre() {
        return nombre;
    }

    @RequiredStringValidator(type = ValidatorType.FIELD, message = "Campo requerido")
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }



    @SkipValidation
    public String editar() throws Exception {
     UsuarioVo usuario = this.usuarioManager.buscarUsuario(id);
     this.setApellido(usuario.getApellido());
     this.setCargo(usuario.getCargo());
     this.setCelular(usuario.getCelular());
     this.setEmail(usuario.getEmail());
     this.setNick(usuario.getNick());
     this.setNombre(usuario.getNombre());
     this.setTelefono(usuario.getTelefono());
     this.setId(usuario.getId());
     this.setContrasena(usuario.getContrasena());
        return SUCCESS;
    }

    @SkipValidation
    public String crear() throws Exception {
        return SUCCESS;
    }

    @SkipValidation
     public String salvar() throws Exception {
        try {
            UsuarioVo usuario = new UsuarioVo( nombre, apellido, nick, telefono,  email, celular, cargo, contrasena);
            if (this.getId()!= null && this.getId()!= 0){
                usuario.setId(id);
                this.usuarioManager.modificarUsuario(usuario);
            } else {
                this.usuarioManager.crearUsuario(usuario);
            }

         
        } catch (ArgosWebServiceException e) {
            addActionError(e.getMessage());
        } catch (FaltanDatosException e)  {
            addActionError(e.getMessage());
        } 
        return SUCCESS;
    }




}
