package com.suricata.argos.vo;

/**
 * Representa al usuario que utiliza el sistema IWC. Puede ser interno o externo.
 * @version 1.0
 * @created 16-Jun-2010 01:50:10
 */
public class UsuarioVo {
     
     private Integer id;
     private String nombre;
     private String nick;
     private String apellido;
     private String telefono;
     private String email;
     private Long celular;
     private String cargo;
     private String contrasena;

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

    public Long getCelular() {
        return celular;
    }

    public void setCelular(Long celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
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

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

   
     
	public UsuarioVo(){

	}

	public UsuarioVo(String nombre, String apellido, String nick, String telefono, String email, Long celular, String cargo, String contrasena){
            this.setApellido(apellido);
            this.setCargo(cargo);
            this.setCelular(celular);
            this.setEmail(email);
            this.setNick(nick);
            this.setNombre(nombre);
            this.setTelefono(telefono);
            this.setContrasena(contrasena);
	}


	public void finalize() throws Throwable {

	}

}