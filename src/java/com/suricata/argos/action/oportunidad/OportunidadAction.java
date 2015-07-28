package com.suricata.argos.action.oportunidad;


import com.opensymphony.xwork2.validator.annotations.*;
import com.suricata.argos.action.ArgosAction;
import com.suricata.argos.exception.ArgosWebServiceException;
import com.suricata.argos.exception.FaltanDatosException;
import com.suricata.argos.logica.CodigueraManager;
import com.suricata.argos.logica.CodigueraManagerImpl;
import com.suricata.argos.constantes.Constantes;
import com.suricata.argos.logica.ContactoManager;
import com.suricata.argos.logica.ContactoManagerImpl;
import com.suricata.argos.logica.EmpresaManager;
import com.suricata.argos.logica.EmpresaManagerImpl;
import com.suricata.argos.logica.OportunidadManager;
import com.suricata.argos.logica.OportunidadManagerImpl;
import com.suricata.argos.logica.UsuarioManager;
import com.suricata.argos.logica.UsuarioManagerImpl;
import com.suricata.argos.vo.ContactoVo;
import com.suricata.argos.vo.DocumentoVo;
import com.suricata.argos.vo.EmpresaVo;
import com.suricata.argos.vo.EstadoVo;
import com.suricata.argos.vo.OportunidadVo;
import com.suricata.argos.vo.TecnologiaVo;
import com.suricata.argos.vo.TipoProyectoVo;
import com.suricata.argos.vo.UsuarioVo;
import java.util.Date;
import java.util.List;
import java.io.File;
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
public class OportunidadAction extends ArgosAction {
    private OportunidadManager oportunidadManager = new OportunidadManagerImpl();
    private EmpresaManager empresaManager = new EmpresaManagerImpl();
    private ContactoManager contactoManager = new ContactoManagerImpl();
    private CodigueraManager codigueraManager = new CodigueraManagerImpl();
    private UsuarioManager usuarioManager = new UsuarioManagerImpl();
    //El archivo a subir.
    private File archivo;
    

     private Integer id;
     private ContactoVo contacto;
     private TipoProyectoVo tipoproyecto;
     private TecnologiaVo tecnologia;
     private UsuarioVo usuario;
     private EstadoVo estado;
     private EmpresaVo empresa;
     private String codigoInterno;
     private String titulo;
     private String descripcionCierre;
     private Date fecha;
     private List<ContactoVo> listaContactos;
     private List<TecnologiaVo> listaTecnologias;
     private List<TipoProyectoVo> listaTipoProyectos;
     private List<EmpresaVo> listaEmpresas;
     private List<EstadoVo> listaEstados;
     private String nombreDocumento;
     	/**
	 * El nombre del archivo a subir.
	 */
    private String archivoFileName;

    public String getNombreDocumento() {
        return nombreDocumento;
    }

    public void setNombreDocumento(String nombreDocumento) {
        this.nombreDocumento = nombreDocumento;
    }


    public String getCodigoInterno() {
        return codigoInterno;
    }

    public void setCodigoInterno(String codigoInterno) {
        this.codigoInterno = codigoInterno;
    }

    public ContactoVo getContacto() {
        return contacto;
    }

    @RequiredStringValidator(type = ValidatorType.FIELD, message = "Campo requerido")
    public void setContacto(ContactoVo contacto) {
        this.contacto = contacto;
    }

    public String getDescripcionCierre() {
        return descripcionCierre;
    }

    public void setDescripcionCierre(String descripcionCierre) {
        this.descripcionCierre = descripcionCierre;
    }

    public EmpresaVo getEmpresa() {
        return empresa;
    }

   @RequiredStringValidator(type = ValidatorType.FIELD, message = "Campo requerido")
    public void setEmpresa(EmpresaVo empresa) {
        this.empresa = empresa;
    }

    public EstadoVo getEstado() {
        return estado;
    }

    public void setEstado(EstadoVo estado) {
        this.estado = estado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public TecnologiaVo getTecnologia() {
        return tecnologia;
    }

   @RequiredStringValidator(type = ValidatorType.FIELD, message = "Campo requerido")
    public void setTecnologia(TecnologiaVo tecnologia) {
        this.tecnologia = tecnologia;
    }

    public TipoProyectoVo getTipoproyecto() {
        return tipoproyecto;
    }

   @RequiredStringValidator(type = ValidatorType.FIELD, message = "Campo requerido")
    public void setTipoproyecto(TipoProyectoVo tipoproyecto) {
        this.tipoproyecto = tipoproyecto;
    }

    public String getTitulo() {
        return titulo;
    }

   @RequiredStringValidator(type = ValidatorType.FIELD, message = "Campo requerido")
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public UsuarioVo getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioVo usuario) {
        this.usuario = usuario;
    }

    public List<ContactoVo> getListaContactos() {
        return listaContactos;
    }

    public void setListaContactos(List<ContactoVo> listaContactos) {
        this.listaContactos = listaContactos;
    }

    public List<EmpresaVo> getListaEmpresas() {
        return listaEmpresas;
    }

    public void setListaEmpresas(List<EmpresaVo> listaEmpresas) {
        this.listaEmpresas = listaEmpresas;
    }

    public List<EstadoVo> getListaEstados() {
        return listaEstados;
    }

    public void setListaEstados(List<EstadoVo> listaEstados) {
        this.listaEstados = listaEstados;
    }

    public List<TecnologiaVo> getListaTecnologias() {
        return listaTecnologias;
    }

    public void setListaTecnologias(List<TecnologiaVo> listaTecnologias) {
        this.listaTecnologias = listaTecnologias;
    }

    public List<TipoProyectoVo> getListaTipoProyectos() {
        return listaTipoProyectos;
    }

    public void setListaTipoProyectos(List<TipoProyectoVo> listaTipoProyectos) {
        this.listaTipoProyectos = listaTipoProyectos;
    }

    public File getArchivo() {
        return archivo;
    }

    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }

    public String getArchivoFileName() {
        return archivoFileName;
    }

    public void setArchivoFileName(String archivoFileName) {
        this.archivoFileName = archivoFileName;
    }

   

    @SkipValidation
    public String editar() throws Exception {
         OportunidadVo oportunidad = this.oportunidadManager.buscarOportunidad(id);
         this.setCodigoInterno(oportunidad.getCodigoInterno());
         this.setContacto(oportunidad.getContacto());
         this.setDescripcionCierre(oportunidad.getDescripcionCierre());
         this.setEmpresa(oportunidad.getEmpresa());
         this.setEstado(oportunidad.getEstado());
         this.setFecha(oportunidad.getFecha());
         this.setId(oportunidad.getId());
         this.setTecnologia(oportunidad.getTecnologia());
         this.setTipoproyecto(oportunidad.getTipoproyecto());
         this.setTitulo(oportunidad.getTitulo());
         this.setUsuario(oportunidad.getUsuario());
         try {
            this.cargarListas();
         } catch (ArgosWebServiceException e) {
            addActionError(e.getMessage());
        }
     
        return SUCCESS;
    }


    public void cargarListas() throws ArgosWebServiceException {
        this.setListaEmpresas(empresaManager.listarEmpresas());
        this.setListaContactos(contactoManager.listarContactos());
        this.setListaTecnologias(codigueraManager.listarTecnologias());
        this.setListaTipoProyectos(codigueraManager.listarTipoProyectos());
        this.setListaEstados(codigueraManager.listarEstados());
    }

    @SkipValidation
    public String crear() throws Exception {
         try {
            this.cargarListas();
         } catch (ArgosWebServiceException e) {
            addActionError(e.getMessage());
        }
            return SUCCESS;
    }

    @SkipValidation
     public String salvar() throws Exception {
        try {
            OportunidadVo oportunidad = new OportunidadVo( contacto,  tipoproyecto,  tecnologia,  usuario,  estado,  empresa,  codigoInterno,  titulo,  descripcionCierre,  fecha);
            if (this.getId()!= null && this.getId()!= 0){
                oportunidad.setId(id);
                this.oportunidadManager.modificarOportunidad(oportunidad);
            } else {
                oportunidad.setFecha(new Date());
                EstadoVo estadoNuevo = new EstadoVo();
                estadoNuevo.setId(Constantes.ESTADO_ABIERTO_ID);
                oportunidad.setEstado(estadoNuevo);
                UsuarioVo usuarioVo = (UsuarioVo) this.getSession().get(Constantes.SESSION_USUARIO);
                oportunidad.setUsuario(usuarioVo);
                if (this.nombreDocumento!= null && archivo != null){
                    oportunidad.setDocumento(this.crearDocumento(oportunidad));
                }
                this.oportunidadManager.crearOportunidad(oportunidad);
            }

        } catch (ArgosWebServiceException e) {
            addActionError(e.getMessage());
        } catch (FaltanDatosException e)  {
            addActionError(e.getMessage());
        } 
        return "salvar";
    }

    @SkipValidation
    private DocumentoVo crearDocumento (OportunidadVo oportunidad) {
        DocumentoVo documento = new DocumentoVo();
        int indice = archivoFileName.lastIndexOf('.');

        String tipo = null;

        // Obtiene el tipo como el substring después del último '.'
       tipo = archivoFileName.substring(indice + 1);
       documento.setTamano("" + archivo.length());
 
        documento.setNombre(this.nombreDocumento);
        documento.setTipo(tipo);
       // documento.setOportunidad(oportunidad);
        documento.setRuta(archivo.getAbsolutePath());
        return documento;
    }



}
