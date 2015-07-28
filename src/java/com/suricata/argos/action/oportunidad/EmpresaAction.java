package com.suricata.argos.action.oportunidad;


import com.opensymphony.xwork2.validator.annotations.*;
import com.suricata.argos.action.ArgosAction;
import com.suricata.argos.exception.ArgosWebServiceException;
import com.suricata.argos.exception.FaltanDatosException;
import com.suricata.argos.logica.EmpresaManager;
import com.suricata.argos.logica.EmpresaManagerImpl;
import com.suricata.argos.vo.EmpresaVo;
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
public class EmpresaAction extends ArgosAction {
    private EmpresaManager empresaManager = new EmpresaManagerImpl();

     private int id;
     private String nombre;
     private String descripcion;
     private Long rut;
     private String rubro;
     private String direccion;
     private String telefono;

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

   @RequiredStringValidator(type = ValidatorType.FIELD, message = "Campo requerido")
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

  
    @SkipValidation
    public String editar() throws Exception {
         EmpresaVo empresa = this.empresaManager.buscarEmpresa(id);
         this.setDescripcion(empresa.getDescripcion());
         this.setDireccion(empresa.getDireccion());
         this.setId(empresa.getId());
         this.setNombre(empresa.getNombre());
         this.setRubro(empresa.getRubro());
         this.setRut(empresa.getRut());
         this.setTelefono(empresa.getTelefono());
        return SUCCESS;
    }

    @SkipValidation
    public String crear() throws Exception {
        return SUCCESS;
    }

    @SkipValidation
     public String salvar() throws Exception {
        try {
            EmpresaVo empresa = new EmpresaVo( nombre,  descripcion,  rut,  rubro,  direccion,  telefono);
            if (this.getId()!= 0){
                empresa.setId(id);
                this.empresaManager.modificarEmpresa(empresa);
            } else {
                this.empresaManager.crearEmpresa(empresa);
            }

         
        } catch (ArgosWebServiceException e) {
            addActionError(e.getMessage());
        } catch (FaltanDatosException e)  {
            addActionError(e.getMessage());
        } 
        return "salvar";
    }




}
