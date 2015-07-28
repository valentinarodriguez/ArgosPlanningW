package com.suricata.argos.action.oportunidad;


import com.opensymphony.xwork2.validator.annotations.*;
import com.suricata.argos.action.ArgosAction;
import com.suricata.argos.exception.ArgosWebServiceException;
import com.suricata.argos.exception.FaltanDatosException;
import com.suricata.argos.logica.CodigueraManager;
import com.suricata.argos.logica.CodigueraManagerImpl;
import com.suricata.argos.constantes.Constantes;
import com.suricata.argos.logica.ActividadManager;
import com.suricata.argos.logica.ActividadManagerImpl;
import com.suricata.argos.logica.ContactoManager;
import com.suricata.argos.logica.ContactoManagerImpl;
import com.suricata.argos.logica.EmpresaManager;
import com.suricata.argos.logica.EmpresaManagerImpl;
import com.suricata.argos.logica.OportunidadManager;
import com.suricata.argos.logica.OportunidadManagerImpl;
import com.suricata.argos.logica.UsuarioManager;
import com.suricata.argos.logica.UsuarioManagerImpl;
import com.suricata.argos.vo.EmpresaVo;
import com.suricata.argos.vo.EstadoVo;
import com.suricata.argos.vo.ActividadVo;
import com.suricata.argos.vo.ContactoVo;
import com.suricata.argos.vo.DocumentoVo;
import com.suricata.argos.vo.OportunidadVo;
import com.suricata.argos.vo.TipoActividadVo;
import com.suricata.argos.vo.UsuarioVo;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class ActividadAction extends ArgosAction {
    private static final String DOWNLOAD_DOC = "downloadDoc";
    private EmpresaManager empresaManager = new EmpresaManagerImpl();
    private ContactoManager contactoManager = new ContactoManagerImpl();
    private CodigueraManager codigueraManager = new CodigueraManagerImpl();
    private UsuarioManager usuarioManager = new UsuarioManagerImpl();
    private OportunidadManager oportunidadManager = new OportunidadManagerImpl();
    private ActividadManager actividadManager = new ActividadManagerImpl();
    

     private Integer id;
     private OportunidadVo oportunidad;
     private UsuarioVo usuario;
     private TipoActividadVo tipoactividad;
     private String titulo;
     private String descripcion;
     private ContactoVo contactoResponsable;
     private UsuarioVo usuarioResponsable;
     private Date fechaVencimiento;
     private Date fechaCreacion;
     private String descripcionCierre;
     private EstadoVo estado;
     private EmpresaVo empresa;
     
     private List<OportunidadVo> listaOportunidades;
     private List<TipoActividadVo> listaTipoActividad;
     private List<EstadoVo> listaEstados;
     private List<EmpresaVo> listaEmpresas;
     private List<UsuarioVo> listaUsuarios;
     private List<ContactoVo> listaContactos;
     private List<UsuarioVo> listaResponsablesUsuarios;

     private TipoActividadVo idObjeto;

         //El archivo a subir.
     private File archivo;
     private String nombreDocumento;
     	/**
	 * El nombre del archivo a subir.
	 */
    private String archivoFileName;

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

    public String getNombreDocumento() {
        return nombreDocumento;
    }

    public void setNombreDocumento(String nombreDocumento) {
        this.nombreDocumento = nombreDocumento;
    }


    public TipoActividadVo getIdObjeto() {
        return idObjeto;
    }

    public void setIdObjeto(TipoActividadVo idObjeto) {
        this.idObjeto = idObjeto;
    }

     
/**
	 * Auxiliar para realizar la descarga de documentos.
	 */
	private InputStream documentStream;
	/**
	 * Auxiliar para realizar la descarga de documentos.
	 */
	private String downloadFilename;
	/**
	 * Auxiliar para realizar la descarga de documentos.
	 */
	private String downloadFilesize;
	/**
	 * Auxiliar para realizar la descarga de documentos.
	 */
	private String downloadFiletype;

    public EmpresaVo getEmpresa() {
        return empresa;
    }

    public void setEmpresa(EmpresaVo empresa) {
        this.empresa = empresa;
    }


    public List<UsuarioVo> getListaResponsablesUsuarios() {
        return listaResponsablesUsuarios;
    }

    public void setListaResponsablesUsuarios(List<UsuarioVo> listaResponsablesUsuarios) {
        this.listaResponsablesUsuarios = listaResponsablesUsuarios;
    }
    

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcionCierre() {
        return descripcionCierre;
    }

    public void setDescripcionCierre(String descripcionCierre) {
        this.descripcionCierre = descripcionCierre;
    }

    public EmpresaManager getEmpresaManager() {
        return empresaManager;
    }

    public void setEmpresaManager(EmpresaManager empresaManager) {
        this.empresaManager = empresaManager;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
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

    public List<OportunidadVo> getListaOportunidades() {
        return listaOportunidades;
    }

    public void setListaOportunidades(List<OportunidadVo> listaOportunidades) {
        this.listaOportunidades = listaOportunidades;
    }

    public List<TipoActividadVo> getListaTipoActividad() {
        return listaTipoActividad;
    }

    public void setListaTipoActividad(List<TipoActividadVo> listaTipoActividad) {
        this.listaTipoActividad = listaTipoActividad;
    }


    public OportunidadVo getOportunidad() {
        return oportunidad;
    }

      @RequiredFieldValidator(type = ValidatorType.FIELD, message = "Campo requerido")
    public void setOportunidad(OportunidadVo oportunidad) {
        this.oportunidad = oportunidad;
    }

 
    public TipoActividadVo getTipoactividad() {
        return tipoactividad;
    }

      @RequiredFieldValidator(type = ValidatorType.FIELD, message = "Campo requerido")
    public void setTipoactividad(TipoActividadVo tipoactividad) {
        this.tipoactividad = tipoactividad;
    }

    public String getTitulo() {
        return titulo;
    }

      @RequiredFieldValidator(type = ValidatorType.FIELD, message = "Campo requerido")
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public UsuarioVo getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioVo usuario) {
        this.usuario = usuario;
    }

    public List<UsuarioVo> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(List<UsuarioVo> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public EstadoVo getEstado() {
        return estado;
    }

    public void setEstado(EstadoVo estado) {
        this.estado = estado;
    }

    public ContactoVo getContactoResponsable() {
        return contactoResponsable;
    }

    public void setContactoResponsable(ContactoVo contactoResponsable) {
        this.contactoResponsable = contactoResponsable;
    }

    public List<ContactoVo> getListaContactos() {
        return listaContactos;
    }

    public void setListaContactos(List<ContactoVo> listaContactos) {
        this.listaContactos = listaContactos;
    }

    public UsuarioVo getUsuarioResponsable() {
        return usuarioResponsable;
    }

    public void setUsuarioResponsable(UsuarioVo usuarioResponsable) {
        this.usuarioResponsable = usuarioResponsable;
    }


    @SkipValidation
    public String editar() throws Exception {
         ActividadVo actividad = this.actividadManager.buscarActividad(id);
         this.setDescripcionCierre(actividad.getDescripcionCierre());
         this.setId(actividad.getId());
         this.setTitulo(actividad.getTitulo());
         this.setUsuario(actividad.getUsuario());
         this.setDescripcion(actividad.getDescripcion());
         this.setFechaCreacion(actividad.getFechaCreacion());
         this.setFechaVencimiento(actividad.getFechaVencimiento());
         this.setOportunidad(actividad.getOportunidad());
         this.setContactoResponsable(actividad.getResponsableCliente());
         this.setUsuarioResponsable(actividad.getResponsableUsuario());
         this.setTipoactividad(actividad.getTipoactividad());
         this.setTitulo(actividad.getTitulo());
       //  this.cargarURLArchivo();
         try {
            this.cargarListas();
         } catch (ArgosWebServiceException e) {
            addActionError(e.getMessage());
        }
     
        return SUCCESS;
    }


    public void cargarListas() throws ArgosWebServiceException {
        this.setListaEmpresas(empresaManager.listarEmpresas());
        this.setListaEstados(codigueraManager.listarEstados());
        this.setListaOportunidades(oportunidadManager.listarOportunidades(Constantes.ESTADO_ABIERTO_NOMBRE, null, null));
        this.setListaTipoActividad(codigueraManager.listarTipoActividades());
        this.setListaUsuarios(usuarioManager.listarUsuarios());
        this.setListaContactos(contactoManager.listarContactos());
        this.setListaResponsablesUsuarios(usuarioManager.listarUsuarios());
    }

    @SkipValidation
    public String crear() throws Exception {
         try {
            this.cargarListas();
            this.setFechaVencimiento(new Date());
      //      this.cargarURLArchivo();
         } catch (ArgosWebServiceException e) {
            addActionError(e.getMessage());
        }
            return SUCCESS;
    }

    @SkipValidation
     public String salvar() throws Exception {
        try {
            DocumentoVo documento = this.crearDocumento();
            ActividadVo actividad = new ActividadVo( oportunidad,  usuario,  tipoactividad,  titulo,  descripcion, contactoResponsable,usuarioResponsable, fechaVencimiento,  fechaCreacion,  descripcionCierre, estado, documento);
            if (this.getId()!= null && this.getId()!= 0){
                actividad.setId(id);
                this.actividadManager.modificarActividad(actividad);
            } else {
                actividad.setFechaCreacion(new Date());
                EstadoVo estadoNuevo = new EstadoVo();
                estadoNuevo.setId(Constantes.ESTADO_ABIERTO_ID);
                actividad.setEstado(estadoNuevo);
                UsuarioVo usuarioVo = (UsuarioVo) this.getSession().get(Constantes.SESSION_USUARIO);
                actividad.setUsuario(usuarioVo);
                actividad.setFechaCreacion(new Date());
                 if (this.nombreDocumento!= null && archivo != null){
                    actividad.setDocumento(documento);
                }
                this.actividadManager.crearActividad(actividad);
            }

        } catch (ArgosWebServiceException e) {
            addActionError(e.getMessage());
        } catch (FaltanDatosException e)  {
            addActionError(e.getMessage());
        } 
        return "salvar";
    }

   

    public String descargarDocumento() {
        String nombrePlantilla = null;
        DocumentoVo documento = null;
        try {
            nombrePlantilla = this.obtenerNombrePlantilla(tipoactividad.getId());
            documento = this.actividadManager.buscarDocumento(nombrePlantilla);
            byte[] descargar = this.actividadManager.descargarPlantilla(documento.getRuta());
            this.documentStream = new ByteArrayInputStream(descargar);
            this.downloadFilename = nombrePlantilla +  "." + documento.getTipo();
            this.downloadFilesize = "" + documento.getTamano();
            this.downloadFiletype = "application/download";

        } catch (ArgosWebServiceException ex) {
            Logger.getLogger(ActividadAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FaltanDatosException ex) {
            Logger.getLogger(ActividadAction.class.getName()).log(Level.SEVERE, null, ex);
        }
        return SUCCESS;
    }

    private String obtenerNombrePlantilla(Integer idActividad){
        String nombrePlantilla;
        if (idActividad == 2 || idActividad == 1) {
          nombrePlantilla =  Constantes.NOMBRE_DOCUMENTO_MINUTA;
        } else if (idActividad == 4) {
          nombrePlantilla =  Constantes.NOMBRE_DOCUMENTO_PROPUESTA;
        } else { //9
          nombrePlantilla =  Constantes.NOMBRE_DOCUMENTO_PRESENTACION;
        }
        return nombrePlantilla;
    }

    public InputStream getDocumentStream() {
        return documentStream;
    }

    public void setDocumentStream(InputStream documentStream) {
        this.documentStream = documentStream;
    }

    public String getDownloadFilename() {
        return downloadFilename;
    }

    public void setDownloadFilename(String downloadFilename) {
        this.downloadFilename = downloadFilename;
    }

    public String getDownloadFilesize() {
        return downloadFilesize;
    }

    public void setDownloadFilesize(String downloadFilesize) {
        this.downloadFilesize = downloadFilesize;
    }

    public String getDownloadFiletype() {
        return downloadFiletype;
    }

    public void setDownloadFiletype(String downloadFiletype) {
        this.downloadFiletype = downloadFiletype;
    }

     @SkipValidation
    private DocumentoVo crearDocumento () {
        DocumentoVo documento = null;
        if (this.nombreDocumento != null && archivo != null){
            documento = new DocumentoVo();
            int indice = archivoFileName.lastIndexOf('.');

            String tipo = null;

            // Obtiene el tipo como el substring después del último '.'
           tipo = archivoFileName.substring(indice + 1);
           documento.setTamano("" + archivo.length());

            documento.setNombre(this.nombreDocumento);
            documento.setTipo(tipo);
           // documento.setOportunidad(oportunidad);
            documento.setRuta(archivo.getAbsolutePath());
        }

        return documento;
    }
    
}
