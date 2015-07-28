package com.suricata.argos.action.oportunidad;


import com.opensymphony.xwork2.validator.annotations.*;
import com.suricata.argos.action.ArgosAction;
import com.suricata.argos.constantes.Constantes;
import com.suricata.argos.exception.ArgosWebServiceException;
import com.suricata.argos.logica.CodigueraManager;
import com.suricata.argos.logica.CodigueraManagerImpl;
import com.suricata.argos.logica.ActividadManager;
import com.suricata.argos.logica.ActividadManagerImpl;
import com.suricata.argos.logica.SeguimientoManager;
import com.suricata.argos.logica.SeguimientoManagerImpl;
import com.suricata.argos.logica.UsuarioManager;
import com.suricata.argos.logica.UsuarioManagerImpl;
import com.suricata.argos.vo.ActividadVo;
import com.suricata.argos.vo.SeguimientoTipoSeguimientoVo;
import com.suricata.argos.vo.SeguimientoVo;
import com.suricata.argos.vo.TipoSeguimientoVo;
import com.suricata.argos.vo.UsuarioVo;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.apache.struts2.interceptor.validation.SkipValidation;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Valentina
 */
@Validations
public class SeguimientoAction extends ArgosAction {
    private CodigueraManager codigueraManager = new CodigueraManagerImpl();
    private UsuarioManager usuarioManager = new UsuarioManagerImpl();
    private ActividadManager actividadManager = new ActividadManagerImpl();
    private SeguimientoManager seguimientoManager = new SeguimientoManagerImpl();

     private Integer id;
     private UsuarioVo usuario;
     private TipoSeguimientoVo tiposeguimiento;
     private ActividadVo actividad;
     private Date fechaVencimiento;
     private Date fechaAnuncio;
     private Integer enviado;
     private String horaVencimiento;
     private String horaAnuncio;
     private Integer usuarioId;
  
     private Boolean email;
     private Boolean sms;

    public Boolean getEmail() {
        return email;
    }

    public void setEmail(Boolean email) {
        this.email = email;
    }

    public Boolean getSms() {
        return sms;
    }

    public void setSms(Boolean sms) {
        this.sms = sms;
    }

    public String getHoraVencimiento() {
        return horaVencimiento;
    }

    @RequiredFieldValidator(type = ValidatorType.FIELD, message = "Campo requerido")
    public void setHoraVencimiento(String horaVencimiento) {
        this.horaVencimiento = horaVencimiento;
    }

     private List<ActividadVo> listaActividades;
     private List<UsuarioVo> listaUsuarios;
     private List<TipoSeguimientoVo> listaTipoSeguimientos;

    public ActividadVo getActividad() {
        return actividad;
    }

     @RequiredFieldValidator(type = ValidatorType.FIELD, message = "Campo requerido")
    public void setActividad(ActividadVo actividad) {
        this.actividad = actividad;
    }

    public Date getFechaAnuncio() {
        return fechaAnuncio;
    }

     @RequiredFieldValidator(type = ValidatorType.FIELD, message = "Campo requerido")
    public void setFechaAnuncio(Date fechaAnuncio) {
        this.fechaAnuncio = fechaAnuncio;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

     @RequiredFieldValidator(type = ValidatorType.FIELD, message = "Campo requerido")
    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<ActividadVo> getListaActividades() {
        return listaActividades;
    }

    public void setListaActividades(List<ActividadVo> listaActividades) {
        this.listaActividades = listaActividades;
    }

    public List<TipoSeguimientoVo> getListaTipoSeguimientos() {
        return listaTipoSeguimientos;
    }

    public void setListaTipoSeguimientos(List<TipoSeguimientoVo> listaTipoSeguimientos) {
        this.listaTipoSeguimientos = listaTipoSeguimientos;
    }

 

    public List<UsuarioVo> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(List<UsuarioVo> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public TipoSeguimientoVo getTiposeguimiento() {
        return tiposeguimiento;
    }

    public void setTiposeguimiento(TipoSeguimientoVo tiposeguimiento) {
        this.tiposeguimiento = tiposeguimiento;
    }

    public UsuarioVo getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioVo usuario) {
        this.usuario = usuario;
    }

    public Integer getEnviado() {
        return enviado;
    }

    public void setEnviado(Integer enviado) {
        this.enviado = enviado;
    }



    public Integer getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getHoraAnuncio() {
        return horaAnuncio;
    }

     @RequiredFieldValidator(type = ValidatorType.FIELD, message = "Campo requerido")
    public void setHoraAnuncio(String horaAnuncio) {
        this.horaAnuncio = horaAnuncio;
    }


    @SkipValidation
    public String editar() throws Exception {
         try {
            SeguimientoVo seguimiento = this.seguimientoManager.buscarSeguimiento(id);
            Iterator<SeguimientoTipoSeguimientoVo>  it = seguimiento.getSeguimientotiposeguimientos().iterator();
            while (it.hasNext()){
                SeguimientoTipoSeguimientoVo seguimientoTipoSeguimiento = it.next();
                if (seguimientoTipoSeguimiento.getTiposeguimiento().getId() == 1) {
                    this.setEmail(true);
                }  else {
                    this.setSms(true);
                }
            }
            this.setEnviado(seguimiento.getEnviado());
            this.setFechaAnuncio(seguimiento.getFechaAnuncio());
            this.setFechaVencimiento(seguimiento.getFechaVencimiento());
            this.setHoraVencimiento(this.getFechaVencimiento().getHours() + ":" + this.getFechaVencimiento().getMinutes());
            this.setHoraAnuncio(this.getFechaAnuncio().getHours() + ":" + this.getFechaAnuncio().getMinutes());
            this.setId(seguimiento.getId());
            this.setUsuario(seguimiento.getUsuario());
            this.setUsuarioId(usuario.getId());
            actividad =  new ActividadVo();
            actividad.setId(seguimiento.getActividad().getId());
            this.setActividad(actividad);
            
            this.cargarListas();
         } catch (ArgosWebServiceException e) {
            addActionError(e.getMessage());
        }
     
        return SUCCESS;
    }


    public void cargarListas() throws ArgosWebServiceException {
        this.setListaActividades(this.actividadManager.listarActividads(Constantes.ESTADO_ABIERTO_NOMBRE, null, null));
        this.setListaTipoSeguimientos(this.codigueraManager.listarTipoSeguimientos());
        this.setListaUsuarios(this.usuarioManager.listarUsuarios());
    }

    @SkipValidation
    public String crear() throws Exception {
         try {
            Date d = new Date();
            this.setHoraVencimiento(String.valueOf(d.getHours()) + ":" + String.valueOf(d.getMinutes()));
            this.setHoraAnuncio(String.valueOf(d.getHours()) + ":" + String.valueOf(d.getMinutes()));
            this.cargarListas();
         } catch (ArgosWebServiceException e) {
            addActionError(e.getMessage());
        }
            return SUCCESS;
    }

    private Date convertirHora(String hora, Date fecha){
        if (hora.contains(":") && hora.length() == 5) {
            String split [] = hora.split(":");
            fecha.setHours(Integer.parseInt(split[0]));
            fecha.setMinutes(Integer.parseInt(split[1]));    
        } else {
           fecha = null;
        }
        
        return fecha;
    }


   
     public String salvar() throws Exception {
            Set seguimientotiposeguimientos = new HashSet(0);
            
            if (this.getEmail()){ //email
                TipoSeguimientoVo tiposeguimientoEMAIL = new TipoSeguimientoVo();
                tiposeguimientoEMAIL.setId(1);
                SeguimientoTipoSeguimientoVo seguimientoTipoSeguimientoEMAILVo = new SeguimientoTipoSeguimientoVo();
                seguimientoTipoSeguimientoEMAILVo.setTiposeguimiento(tiposeguimientoEMAIL);
                seguimientotiposeguimientos.add(seguimientoTipoSeguimientoEMAILVo);
            } 
            if (this.getSms()) { //sms
                TipoSeguimientoVo tiposeguimientoSMS = new TipoSeguimientoVo();
                tiposeguimientoSMS.setId(2);
                SeguimientoTipoSeguimientoVo seguimientoTipoSeguimientoSMSVo = new SeguimientoTipoSeguimientoVo();
                seguimientoTipoSeguimientoSMSVo.setTiposeguimiento(tiposeguimientoSMS);
                seguimientotiposeguimientos.add(seguimientoTipoSeguimientoSMSVo);
            }
            if (!this.getEmail() && !this.getSms()){
                addActionError(getText("Debe elegir un tipo de seguimiento: Email o SMS"));
                return "inputCrear";
            }

            fechaAnuncio = this.convertirHora(horaAnuncio, fechaAnuncio);
            fechaVencimiento = this.convertirHora(horaVencimiento, fechaVencimiento);

            if (fechaAnuncio == null || fechaVencimiento == null){
                addFieldError(horaAnuncio, "El formato de la hora debe ser 00:00");
                return "inputCrear";
            }


            SeguimientoVo seguimiento = new SeguimientoVo(usuario, seguimientotiposeguimientos, actividad, fechaVencimiento, fechaAnuncio, enviado);
           if (this.getId()!= null && this.getId()!= 0){
                seguimiento.setId(id);
                usuario = new UsuarioVo();
                usuario.setId(usuarioId);
                seguimiento.setUsuario(usuario);
                this.seguimientoManager.modificarSeguimiento(seguimiento);
            } else {
                UsuarioVo usuarioVo = (UsuarioVo) this.getSession().get(Constantes.SESSION_USUARIO);
                seguimiento.setUsuario(usuarioVo);
                this.seguimientoManager.crearSeguimiento(seguimiento);
            }

        return "salvar";
    }

  



}
