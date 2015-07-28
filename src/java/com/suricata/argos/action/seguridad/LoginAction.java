/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.suricata.argos.action.seguridad;

import com.opensymphony.xwork2.ActionSupport;

/**
 *Responsable de solicitarle a la capa de servicios que verifique la autenticación
 * y autorización para el usuario que fue ingresado en el formulario de login.
 * @author Valentina
 */
public class LoginAction extends ActionSupport {

    /**
	 * Es la contraseña por la que se validará al usuario.
	 */
	private String contrasena;
	/**
	 * Es el usuario correspondiente a los datos ingresados en el formulario de login.
	 */
	private String usuario;

	public LoginAction(){

	}


	/**
	 * Carga la página de login y carga los datos de la cookie en caso de que exista a
	 * través del método obtenerCookie.
	 */
	public String execute(){
            return SUCCESS;
	}

	/**
	 * Es la contraseña por la que se validará al usuario.
	 */
	public String getContrasena(){
		return contrasena;
	}

	/**
	 * Es el usuario por el que se logueará el usuario.
	 */
	public String getUsuario(){
		return usuario;

	}

	/**
	 * Es el encargado de obtener la autenticación y autorización del usuario. 
	 */
	public void login(){
       
	}

	/**
	 * Cierra la sesión del usuario del sistema.
	 *
	 */
	public void logout(){

	}

	/**
	 * Es la contraseña por la que se validará al usuario.
	 *
	 * @param newVal
	 */
	public void setContrasena(String newVal){
		contrasena = newVal;
	}

	/**
	 * Es el usuario por el que se logueará el usuario.
	 *
	 * @param newVal
	 */
	public void setUsuario(String newVal){
		usuario = newVal;
	}
}
