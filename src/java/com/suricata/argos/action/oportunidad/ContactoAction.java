package com.suricata.argos.action.oportunidad;


import com.opensymphony.xwork2.validator.annotations.*;
import com.suricata.argos.action.ArgosAction;
import com.suricata.argos.exception.ArgosWebServiceException;
import com.suricata.argos.exception.FaltanDatosException;
import com.suricata.argos.logica.ContactoManager;
import com.suricata.argos.logica.ContactoManagerImpl;
import com.suricata.argos.logica.EmpresaManager;
import com.suricata.argos.logica.EmpresaManagerImpl;
import com.suricata.argos.vo.ContactoVo;
import com.suricata.argos.vo.EmpresaVo;
import java.util.List;
import org.apache.struts2.interceptor.validation.SkipValidation;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Valentina
 */
@Validation()
public class ContactoAction extends ArgosAction {
    private ContactoManager contactoManager = new ContactoManagerImpl();
    private EmpresaManager empresaManager = new EmpresaManagerImpl();

     private String apellido;
     private String nombre;
     private String telefono;
     private String email;
     private String celular;
     private String cargo;
     private Integer id;
     private String chat;
     private String comentarios;
     private EmpresaVo empresa;
     private List<EmpresaVo> listaEmpresas;

    public List<EmpresaVo> getListaEmpresas() {
        return listaEmpresas;
    }

    public void setListaEmpresas(List<EmpresaVo> listaEmpresas) {
        this.listaEmpresas = listaEmpresas;
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

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }


    @EmailValidator(message = "Formato no válido", shortCircuit = true)
    public void setEmail(String email) {
        this.email = email;
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

    public String getChat() {
        return chat;
    }

    @EmailValidator(message = "Formato no válido", shortCircuit = true)
    public void setChat(String chat) {
        this.chat = chat;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public EmpresaVo getEmpresa() {
        return empresa;
    }

     @RequiredFieldValidator(type = ValidatorType.FIELD, message = "Campo requerido")
    public void setEmpresa(EmpresaVo empresa) {
        this.empresa = empresa;
    }

    @SkipValidation
    public String editar() throws Exception {
     ContactoVo contacto = this.contactoManager.buscarContacto(id);
     this.setApellido(contacto.getApellido());
     this.setCargo(contacto.getCargo());
     this.setCelular(contacto.getCelular());
     this.setChat(contacto.getChat());
     this.setComentarios(contacto.getComentarios());
     this.setEmail(contacto.getEmail());
     this.setEmpresa(contacto.getEmpresaVo());
     this.setId(contacto.getId());
     this.setNombre(contacto.getNombre());
     this.setTelefono(contacto.getTelefono());
     this.setListaEmpresas(this.empresaManager.listarEmpresas());
     this.setEmpresa(contacto.getEmpresaVo());
     return SUCCESS;
    }

    @SkipValidation
    public String crear() throws Exception {
        this.setListaEmpresas(this.empresaManager.listarEmpresas());
        return SUCCESS;
    }

    @SkipValidation
     public String salvar() throws Exception {
        try {
            ContactoVo contacto = new ContactoVo(empresa, nombre, apellido, cargo, email, telefono, celular, chat, comentarios);
            if (this.getId()!= null && this.getId()!= 0){
                contacto.setId(id);
                this.contactoManager.modificarContacto(contacto);
            } else {
                this.contactoManager.crearContacto(contacto);
            }

         
        } catch (ArgosWebServiceException e) {
            addActionError(e.getMessage());
        } catch (FaltanDatosException e)  {
            addActionError(e.getMessage());
        } 
        return "salvar";
    }




}
