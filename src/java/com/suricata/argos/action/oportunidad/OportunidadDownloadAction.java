/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.suricata.argos.action.oportunidad;

import com.suricata.argos.action.ArgosAction;
import com.suricata.argos.constantes.Constantes;
import java.io.InputStream;
import com.suricata.argos.exception.ArgosWebServiceException;
import com.suricata.argos.exception.FaltanDatosException;
import com.suricata.argos.logica.ActividadManager;
import com.suricata.argos.logica.ActividadManagerImpl;
import com.suricata.argos.logica.CodigueraManager;
import com.suricata.argos.logica.CodigueraManagerImpl;
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
import java.io.ByteArrayInputStream;
import java.util.Date;
import java.util.List;
import org.apache.struts2.interceptor.validation.SkipValidation;

/**
 *
 * @author Valentina
 */
public class OportunidadDownloadAction extends ArgosAction {
    private OportunidadManager oportunidadManager = new OportunidadManagerImpl();
    private EmpresaManager empresaManager = new EmpresaManagerImpl();
    private ContactoManager contactoManager = new ContactoManagerImpl();
    private CodigueraManager codigueraManager = new CodigueraManagerImpl();
    private UsuarioManager usuarioManager = new UsuarioManagerImpl();
    private ActividadManager actividadManager = new ActividadManagerImpl();

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
     private Date fechaCierre;
     private Integer empresaId;

     private Integer usuarioId;
     private Integer estadoId;

    public Integer getEstadoId() {
        return estadoId;
    }

    public void setEstadoId(Integer estadoId) {
        this.estadoId = estadoId;
    }

    public Integer getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Integer getEmpresaId() {
        return empresaId;
    }

    public void setEmpresaId(Integer empresaId) {
        this.empresaId = empresaId;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFechaCierre() {
        return fechaCierre;
    }

    public void setFechaCierre(Date fechaCierre) {
        this.fechaCierre = fechaCierre;
    }

    

     public String descargarDocumento() {
        try {
            OportunidadVo oportunidad = this.oportunidadManager.buscarOportunidad(id);
            String nombrePlantilla = oportunidad.getDocumento().getNombre();
            DocumentoVo documento = oportunidad.getDocumento();
            byte[] descargar = this.actividadManager.descargarPlantilla(oportunidad.getDocumento().getRuta());
            this.documentStream = new ByteArrayInputStream(descargar);
            this.downloadFilename = nombrePlantilla +  "." + documento.getTipo();
            this.downloadFilesize = "" + documento.getTamano();
            this.downloadFiletype = "application/download";

        } catch (ArgosWebServiceException ex) {
             addActionError(ex.getMessage());
        } catch (FaltanDatosException ex) {
            addActionError(ex.getMessage());
        }
        return SUCCESS;
    }
     
     
       @SkipValidation
     public String salvar() throws Exception {
        try {
            estado = new EstadoVo();
            estado.setId(estadoId);
            usuario = new UsuarioVo();
            usuario.setId(usuarioId);
            OportunidadVo oportunidad = new OportunidadVo( contacto,  tipoproyecto,  tecnologia,  usuario,  estado,  empresa,  codigoInterno,  titulo,  descripcionCierre,  fecha);
            oportunidad.setId(id);
            if (estado.getId() == Constantes.ESTADO_CANCELADO_ID || estado.getId() == Constantes.ESTADO_CERRADO_ID)
               oportunidad.setFechaCierre(new Date());
            this.oportunidadManager.modificarOportunidad(oportunidad);
          
        } catch (ArgosWebServiceException e) {
            addActionError(e.getMessage());
        } catch (FaltanDatosException e)  {
            addActionError(e.getMessage());
        } 
        return "salvar";
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
         this.setEstadoId(oportunidad.getEstado().getId());
         this.setUsuarioId(oportunidad.getUsuario().getId());
         this.setFechaCierre(oportunidad.getFechaCierre());
         try {
            this.cargarListas();
         } catch (ArgosWebServiceException e) {
            addActionError(e.getMessage());
        }
     
        return INPUT;
    }

    @SkipValidation
     public String cancelarOportunidad() throws Exception {
        this.cargarListas();
        estado = new EstadoVo();
        estado.setId(Constantes.ESTADO_CANCELADO_ID);
        usuario = new UsuarioVo();
        return this.editar();
    }

    @SkipValidation
     public String cerrarOportunidad() throws Exception {
         this.cargarListas();
        estado = new EstadoVo();
        estado.setId(Constantes.ESTADO_CERRADO_ID);
        usuario = new UsuarioVo();
        return "input_edit";
    }


    public void cargarListas() throws ArgosWebServiceException {
        this.setListaEmpresas(empresaManager.listarEmpresas());
        this.setListaContactos(contactoManager.listarContactos());
        this.setListaTecnologias(codigueraManager.listarTecnologias());
        this.setListaTipoProyectos(codigueraManager.listarTipoProyectos());
        this.setListaEstados(codigueraManager.listarEstados());
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

    public TecnologiaVo getTecnologia() {
        return tecnologia;
    }

    public void setTecnologia(TecnologiaVo tecnologia) {
        this.tecnologia = tecnologia;
    }

    public TipoProyectoVo getTipoproyecto() {
        return tipoproyecto;
    }

    public void setTipoproyecto(TipoProyectoVo tipoproyecto) {
        this.tipoproyecto = tipoproyecto;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public UsuarioVo getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioVo usuario) {
        this.usuario = usuario;
    }

}
