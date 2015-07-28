/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.suricata.argos.logica.utiles;


import com.suricata.argos.vo.ActividadVo;
import com.suricata.argos.vo.ContactoVo;
import com.suricata.argos.vo.DocumentoVo;
import com.suricata.argos.vo.EmpresaVo;
import com.suricata.argos.vo.EstadoVo;
import com.suricata.argos.vo.OportunidadVo;
import com.suricata.argos.vo.RolVo;
import com.suricata.argos.vo.SeguimientoTipoSeguimientoVo;
import com.suricata.argos.vo.SeguimientoVo;
import com.suricata.argos.vo.TecnologiaVo;
import com.suricata.argos.vo.TipoActividadVo;
import com.suricata.argos.vo.TipoProyectoVo;
import com.suricata.argos.vo.TipoSeguimientoVo;
import com.suricata.argos.vo.UsuarioVo;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 *
 * @author Valentina
 */
public class ConvertidorUtiles {


     /**
     *
     * @param usuario
     * @return
     */
    public static UsuarioVo convertVoWSToVo(com.suricata.argos.ws.client.UsuarioVo usuario){
        UsuarioVo usuarioVo = new UsuarioVo();
        if (usuario != null) {
            usuarioVo.setApellido(usuario.getApellido());
            usuarioVo.setCargo(usuario.getCargo());
            usuarioVo.setEmail(usuario.getEmail());
            usuarioVo.setCelular(usuario.getCelular());
            usuarioVo.setId(usuario.getId());
            usuarioVo.setNick(usuario.getNick());
            usuarioVo.setNombre(usuario.getNombre());
            usuarioVo.setTelefono(usuario.getTelefono());
            usuarioVo.setContrasena(usuario.getContrasena());
        }
         return usuarioVo;
    }

    public static DocumentoVo convertVoWSToVo(com.suricata.argos.ws.client.DocumentoVo documento){
        DocumentoVo documentoVo = new DocumentoVo();
        if (documento != null) {
            documentoVo.setNombre(documento.getNombre());
            documentoVo.setRuta(documento.getRuta());
            documentoVo.setTipo(documento.getTipo());
            documentoVo.setTamano(documento.getTamano());
        }
         return documentoVo;
    }


    public static RolVo convertVoWSToVo(com.suricata.argos.ws.client.RolVo rol){
        RolVo rolVo = new RolVo();
        if (rol != null) {
            rolVo.setId(rol.getId());
            rolVo.setNombre(rol.getNombre());
        }
         return rolVo;
    }

      /**
       *
       * @param contactoVo
       * @return
       */
      public static  ContactoVo convertVoWSToVo(com.suricata.argos.ws.client.ContactoVo contacto){
        ContactoVo contactoVo = new ContactoVo();
        if (contactoVo != null) {
            contactoVo.setApellido(contacto.getApellido());
            contactoVo.setCargo(contacto.getCargo());
            contactoVo.setEmail(contacto.getEmail());
            contactoVo.setCelular(contacto.getCelular());
            contactoVo.setId(contacto.getId());
            contactoVo.setNombre(contacto.getNombre());
            contactoVo.setTelefono(contacto.getTelefono());
            contactoVo.setChat(contacto.getChat());
            contactoVo.setComentarios(contacto.getComentarios());
            contactoVo.setEmpresaVo(convertVoWSToVo(contacto.getEmpresaVo()));
        }
         return contactoVo;
    }

     /**
       *
       * @param contactoVo
       * @return
       */
      public static  SeguimientoVo convertVoWSToVo(com.suricata.argos.ws.client.SeguimientoVo seguimiento){
        SeguimientoVo seguimientoVo = new SeguimientoVo();
        if (seguimientoVo != null) {
            ActividadVo actividadVo = new ActividadVo();
            actividadVo.setId(seguimiento.getActividad().getId());
            actividadVo.setTitulo(seguimiento.getActividad().getTitulo());
            seguimientoVo.setActividad(actividadVo);
            seguimientoVo.setFechaAnuncio(seguimiento.getFechaAnuncio().toGregorianCalendar().getTime());
            seguimientoVo.setFechaVencimiento(seguimiento.getFechaVencimiento().toGregorianCalendar().getTime());
            seguimientoVo.setId(seguimiento.getId());
            Iterator<com.suricata.argos.ws.client.SeguimientoTipoSeguimientoVo>  it = seguimiento.getSeguimientotiposeguimientos().iterator();
            while (it.hasNext()){
                com.suricata.argos.ws.client.SeguimientoTipoSeguimientoVo seguimientoTipoSeguimiento = it.next();
                SeguimientoTipoSeguimientoVo seguimientoTipoSeguimientoVo = new SeguimientoTipoSeguimientoVo();
                seguimientoTipoSeguimientoVo.setId(seguimientoTipoSeguimiento.getId());
                TipoSeguimientoVo tipoSeguimientoVo = convertVoWSToVo(seguimientoTipoSeguimiento.getTiposeguimiento());
                seguimientoTipoSeguimientoVo.setTiposeguimiento(tipoSeguimientoVo);
                seguimientoVo.getSeguimientotiposeguimientos().add(seguimientoTipoSeguimientoVo);
            }
            UsuarioVo usuario = new UsuarioVo();
            usuario.setId(seguimiento.getUsuario().getId());
            seguimientoVo.setUsuario(usuario);
            seguimientoVo.setEnviado(seguimiento.getEnviado());
         }
         return seguimientoVo;
    }

      /**
       *
       * @param oportunidadVo
       * @return
       */
      public static OportunidadVo convertVoWSToVo(com.suricata.argos.ws.client.OportunidadVo oportunidad){
        OportunidadVo oportunidadVo = new OportunidadVo();
        if (oportunidadVo != null) {
            oportunidadVo.setCodigoInterno(oportunidad.getCodigoInterno());
            oportunidadVo.setContacto(convertVoWSToVo(oportunidad.getContacto()));
            oportunidadVo.setDescripcionCierre(oportunidad.getDescripcionCierre());
            oportunidadVo.setEmpresa(convertVoWSToVo(oportunidad.getEmpresa()));
            oportunidadVo.setEstado(convertVoWSToVo(oportunidad.getEstado()));
            oportunidadVo.setFecha(oportunidad.getFecha().toGregorianCalendar().getTime());
            oportunidadVo.setId(oportunidad.getId());
            oportunidadVo.setTecnologia(convertVoWSToVo(oportunidad.getTecnologia()));
            oportunidadVo.setTipoproyecto(convertVoWSToVo(oportunidad.getTipoproyecto()));
            oportunidadVo.setTitulo(oportunidad.getTitulo());
            oportunidadVo.setUsuario(convertVoWSToVo(oportunidad.getUsuario()));
            oportunidadVo.setId(oportunidad.getId());
            if (oportunidad.getFechaCierre() != null)
                oportunidadVo.setFechaCierre(oportunidad.getFechaCierre().toGregorianCalendar().getTime());

            if (oportunidad.getDocumento() != null){
                DocumentoVo documento= new DocumentoVo();
                documento.setNombre(oportunidad.getDocumento().getNombre());
                documento.setRuta(oportunidad.getDocumento().getRuta());
                documento.setTipo(oportunidad.getDocumento().getTipo());
                documento.setTamano(oportunidad.getDocumento().getTamano());
                oportunidadVo.setDocumento(documento);
            }

        }
        return oportunidadVo;
    }

        public static  EmpresaVo convertVoWSToVo(com.suricata.argos.ws.client.EmpresaVo empresa){
        EmpresaVo empresaVo = new EmpresaVo();
        if (empresaVo != null) {
         //   empresa.setContactos(converVoToEntity(empresaVo.get));
            //faltan contactos y oportunidades
            empresaVo.setDescripcion(empresa.getDescripcion());
            empresaVo.setDireccion(empresa.getDireccion());
            empresaVo.setRubro(empresa.getRubro());
            empresaVo.setId(empresa.getId());
            empresaVo.setNombre(empresa.getNombre());
            empresaVo.setTelefono(empresa.getTelefono());
            empresaVo.setRut(empresa.getRut());
        }
         return empresaVo;
    }

      public static  TipoProyectoVo convertVoWSToVo(com.suricata.argos.ws.client.TipoProyectoVo tipoproyecto){
        TipoProyectoVo tipoproyectoVo = new TipoProyectoVo();
        if (tipoproyectoVo != null) {
            tipoproyectoVo.setId(tipoproyecto.getId());
            tipoproyectoVo.setDescripcion(tipoproyecto.getDescripcion());
            tipoproyectoVo.setNombre(tipoproyecto.getNombre());
        }
        return tipoproyectoVo;
    }


     public static  TecnologiaVo convertVoWSToVo(com.suricata.argos.ws.client.TecnologiaVo tecnologia){
        TecnologiaVo tecnologiaVo = new TecnologiaVo();
        if (tecnologiaVo != null) {
            tecnologiaVo.setId(tecnologia.getId());
            tecnologiaVo.setDescripcion(tecnologia.getDescripcion());
            tecnologiaVo.setNombre(tecnologia.getNombre());
        }
        return tecnologiaVo;
    }

    public static  EstadoVo convertVoWSToVo(com.suricata.argos.ws.client.EstadoVo estado){
        EstadoVo estadoVo = new EstadoVo();
        if (estadoVo != null) {
            estadoVo.setId(estado.getId());
            estadoVo.setDescripcion(estado.getDescripcion());
            estadoVo.setNombre(estado.getNombre());
        }
        return estadoVo;
    }

      public static  TipoActividadVo convertVoWSToVo(com.suricata.argos.ws.client.TipoActividadVo tipoactividad){
        TipoActividadVo tipoactividadVo = new TipoActividadVo();
        if (tipoactividadVo != null) {
            tipoactividadVo.setId(tipoactividad.getId());
            tipoactividadVo.setDescripcion(tipoactividad.getDescripcion());
            tipoactividadVo.setNombre(tipoactividad.getNombre());
        }
        return tipoactividadVo;
    }

        public static  TipoSeguimientoVo convertVoWSToVo(com.suricata.argos.ws.client.TipoSeguimientoVo tiposeguimiento){
        TipoSeguimientoVo tiposeguimientoVo = new TipoSeguimientoVo();
        if (tiposeguimientoVo != null) {
            tiposeguimientoVo.setId(tiposeguimiento.getId());
            tiposeguimientoVo.setDescripcion(tiposeguimiento.getDescripcion());
            tiposeguimientoVo.setNombre(tiposeguimiento.getNombre());
        }
        return tiposeguimientoVo;
    }


        public static ActividadVo convertVoWSToVo(com.suricata.argos.ws.client.ActividadVo actividad){
            ActividadVo actividadVo = new ActividadVo();
            if (actividadVo != null) {
                actividadVo.setId(actividad.getId());
                actividadVo.setDescripcion(actividad.getDescripcion());
                actividadVo.setDescripcionCierre(actividad.getDescripcionCierre());
                actividadVo.setEstado(convertVoWSToVo(actividad.getEstado()));
                actividadVo.setFechaCreacion(actividad.getFechaCreacion().toGregorianCalendar().getTime());
                actividadVo.setFechaVencimiento(actividad.getFechaVencimiento().toGregorianCalendar().getTime());
                actividadVo.setOportunidad(convertVoWSToVo(actividad.getOportunidad()));
                actividadVo.setResponsableCliente(convertVoWSToVo(actividad.getResponsableCliente()));
                actividadVo.setResponsableUsuario(convertVoWSToVo(actividad.getResponsableUsuario()));
                actividadVo.setTipoactividad(convertVoWSToVo(actividad.getTipoactividad()));
                actividadVo.setTitulo(actividad.getTitulo());
                actividadVo.setUsuario(convertVoWSToVo(actividad.getUsuario()));
                if (actividad.getDocumento() != null){
                    DocumentoVo documento= new DocumentoVo();
                    documento.setNombre(actividad.getDocumento().getNombre());
                    documento.setRuta(actividad.getDocumento().getRuta());
                    documento.setTipo(actividad.getDocumento().getTipo());
                    documento.setTamano(actividad.getDocumento().getTamano());
                    actividadVo.setDocumento(documento);
                }
            }
        return actividadVo;
    }

     /**
       *
       * @param contactoVo
       * @return
       */
      public static com.suricata.argos.ws.client.ContactoVo convertVoToVoWS(ContactoVo contactoVo){
        com.suricata.argos.ws.client.ContactoVo contacto = new com.suricata.argos.ws.client.ContactoVo();
        if (contacto != null) {
            contacto.setApellido(contactoVo.getApellido());
            contacto.setCargo(contactoVo.getCargo());
            contacto.setEmail(contactoVo.getEmail());
            contacto.setCelular(contactoVo.getCelular());
            contacto.setId(contactoVo.getId());
            contacto.setNombre(contactoVo.getNombre());
            contacto.setTelefono(contactoVo.getTelefono());
            contacto.setChat(contactoVo.getChat());
            contacto.setComentarios(contactoVo.getComentarios());
            if (contactoVo.getEmpresaVo() != null)
                contacto.setEmpresaVo(convertVoToVoWS(contactoVo.getEmpresaVo()));
        }
         return contacto;
    }

      /**
       *
       * @param usuarioVo
       * @return
       */
      public static com.suricata.argos.ws.client.UsuarioVo convertVoToVoWS(UsuarioVo usuarioVo){
        com.suricata.argos.ws.client.UsuarioVo usuario = new com.suricata.argos.ws.client.UsuarioVo();
        if (usuario != null) {
            usuario.setApellido(usuarioVo.getApellido());
            usuario.setCargo(usuarioVo.getCargo());
            usuario.setEmail(usuarioVo.getEmail());
            usuario.setCelular(usuarioVo.getCelular());
            usuario.setId(usuarioVo.getId());
            usuario.setNick(usuarioVo.getNick());
            usuario.setNombre(usuarioVo.getNombre());
            usuario.setTelefono(usuarioVo.getTelefono());
            usuario.setContrasena(usuarioVo.getContrasena());
        }
         return usuario;
    }


      /**
       *
       * @param oportunidadVo
       * @return
       */
      public static com.suricata.argos.ws.client.OportunidadVo convertVoToVoWS(OportunidadVo oportunidadVo) throws DatatypeConfigurationException{
        com.suricata.argos.ws.client.OportunidadVo oportunidad = new com.suricata.argos.ws.client.OportunidadVo();
        if (oportunidad != null) {
            oportunidad.setCodigoInterno(oportunidadVo.getCodigoInterno());
           // com.suricata.argos.ws.client.ContactoVo contacto = new com.suricata.argos.ws.client.ContactoVo();
           // contacto.setId(oportunidadVo.getContacto().getId());
           // oportunidad.setContacto(contacto);
            oportunidad.setDescripcionCierre(oportunidadVo.getDescripcionCierre());
            //com.suricata.argos.ws.client.EmpresaVo empresa = new com.suricata.argos.ws.client.EmpresaVo();
            //empresa.setId(oportunidadVo.getEmpresa().getId());
            //oportunidad.setEmpresa(empresa);
          // com.suricata.argos.ws.client.EstadoVo estado = new com.suricata.argos.ws.client.EstadoVo();
          // if (oportunidadVo.getId() != null){
           //     estado.setId(oportunidadVo.getId());
          // }
          // oportunidad.setEstado(estado);
            oportunidad.setEstado(convertVoToVoWS(oportunidadVo.getEstado()));
           // Calendar c = new GregorianCalendar();
            //c.setTime(oportunidadVo.getFecha());
            //int month = c.get(Calendar.MONTH)+1;
            //int day = c.get(Calendar.DAY_OF_MONTH);
            //int year = c.get(Calendar.YEAR);
            //DatatypeFactory df = DatatypeFactory.newInstance();
            //XMLGregorianCalendar fechaGC = df.newXMLGregorianCalendarDate(year, month, day, c.getTimeZone().getOffset(oportunidadVo.getFecha().getTime())/(60*60*1000));
            GregorianCalendar gcal = new GregorianCalendar();
            gcal.setTime(oportunidadVo.getFecha());
            XMLGregorianCalendar xgcal = DatatypeFactory.newInstance()
            .newXMLGregorianCalendar(gcal);
            oportunidad.setFecha(xgcal);
            oportunidad.setTitulo(oportunidadVo.getTitulo());
            oportunidad.setUsuario(convertVoToVoWS(oportunidadVo.getUsuario()));
            oportunidad.setContacto(convertVoToVoWS(oportunidadVo.getContacto()));
            oportunidad.setTecnologia(convertVoToVoWS(oportunidadVo.getTecnologia()));
            oportunidad.setTipoproyecto(convertVoToVoWS(oportunidadVo.getTipoproyecto()));
            oportunidad.setEmpresa(convertVoToVoWS(oportunidadVo.getEmpresa()));
            oportunidad.setId(oportunidadVo.getId());

            if (oportunidadVo.getDocumento() != null){
                com.suricata.argos.ws.client.DocumentoVo documento= new com.suricata.argos.ws.client.DocumentoVo();
                documento.setNombre(oportunidadVo.getDocumento().getNombre());
                documento.setRuta(oportunidadVo.getDocumento().getRuta());
                documento.setTipo(oportunidadVo.getDocumento().getTipo());
                documento.setTamano(oportunidadVo.getDocumento().getTamano());
                oportunidad.setDocumento(documento);
            }
            //com.suricata.argos.ws.client.TecnologiaVo tecnologia = new com.suricata.argos.ws.client.TecnologiaVo();
           // tecnologia.setId(oportunidadVo.getTecnologia().getId());
           // oportunidad.setTecnologia(tecnologia);
           // com.suricata.argos.ws.client.TipoProyectoVo tipoProyecto = new com.suricata.argos.ws.client.TipoProyectoVo();
           // tipoProyecto.setId(oportunidadVo.getTipoproyecto().getId());
            //oportunidad.setTipoproyecto(tipoProyecto);
            
           //com.suricata.argos.ws.client.UsuarioVo usuario = new com.suricata.argos.ws.client.UsuarioVo();
           // usuario.setId(oportunidadVo.getUsuario().getId());
            //oportunidad.setUsuario(usuario);
          


        }
        return oportunidad;
    }

        public static com.suricata.argos.ws.client.EmpresaVo convertVoToVoWS(EmpresaVo empresaVo){
        com.suricata.argos.ws.client.EmpresaVo empresa = new com.suricata.argos.ws.client.EmpresaVo();
        if (empresa != null) {
         //   empresa.setContactos(converVoToEntity(empresaVo.get));
            //faltan contactos y oportunidades
            empresa.setDescripcion(empresaVo.getDescripcion());
            empresa.setDireccion(empresaVo.getDireccion());
            empresa.setRubro(empresaVo.getRubro());
            empresa.setId(empresaVo.getId());
            empresa.setNombre(empresaVo.getNombre());
            empresa.setTelefono(empresaVo.getTelefono());
            empresa.setRut(empresaVo.getRut());
        }
         return empresa;
    }

      public static com.suricata.argos.ws.client.TipoProyectoVo convertVoToVoWS(TipoProyectoVo tipoproyectoVo){
        com.suricata.argos.ws.client.TipoProyectoVo tipoproyecto = new com.suricata.argos.ws.client.TipoProyectoVo();
        if (tipoproyecto != null) {
            tipoproyecto.setId(tipoproyectoVo.getId());
            tipoproyecto.setDescripcion(tipoproyectoVo.getDescripcion());
            tipoproyecto.setNombre(tipoproyectoVo.getNombre());
        }
        return tipoproyecto;
    }


     public static com.suricata.argos.ws.client.TecnologiaVo convertVoToVoWS(TecnologiaVo tecnologiaVo){
        com.suricata.argos.ws.client.TecnologiaVo tecnologia = new com.suricata.argos.ws.client.TecnologiaVo();
        if (tecnologia != null) {
            tecnologia.setId(tecnologiaVo.getId());
            tecnologia.setDescripcion(tecnologiaVo.getDescripcion());
            tecnologia.setNombre(tecnologiaVo.getNombre());
        }
        return tecnologia;
    }

    public static com.suricata.argos.ws.client.EstadoVo convertVoToVoWS(EstadoVo estadoVo){
        com.suricata.argos.ws.client.EstadoVo estado = new com.suricata.argos.ws.client.EstadoVo();
        if (estadoVo != null) {
            estado.setId(estadoVo.getId());
            estado.setDescripcion(estadoVo.getDescripcion());
            estado.setNombre(estadoVo.getNombre());
        }
        return estado;
    }
   public static com.suricata.argos.ws.client.TipoActividadVo convertVoToVoWS(TipoActividadVo tipoActividad){
        com.suricata.argos.ws.client.TipoActividadVo tipoActividadVo = new com.suricata.argos.ws.client.TipoActividadVo();
        if (tipoActividadVo != null) {
            tipoActividadVo.setId(tipoActividad.getId());
            tipoActividadVo.setDescripcion(tipoActividad.getDescripcion());
            tipoActividadVo.setNombre(tipoActividad.getNombre());
        }
        return tipoActividadVo;
    }


     public static  com.suricata.argos.ws.client.TipoSeguimientoVo convertVoToVoWS(TipoSeguimientoVo tiposeguimiento){
        com.suricata.argos.ws.client.TipoSeguimientoVo tipoSeguimientoVo = new com.suricata.argos.ws.client.TipoSeguimientoVo();
        if (tipoSeguimientoVo != null) {
            tipoSeguimientoVo.setId(tiposeguimiento.getId());
            tipoSeguimientoVo.setDescripcion(tiposeguimiento.getDescripcion());
            tipoSeguimientoVo.setNombre(tiposeguimiento.getNombre());
        }
        return tipoSeguimientoVo;
    }

       public static com.suricata.argos.ws.client.SeguimientoVo convertVoToVoWS(SeguimientoVo seguimiento) throws DatatypeConfigurationException{
        com.suricata.argos.ws.client.SeguimientoVo seguimientoVo = new com.suricata.argos.ws.client.SeguimientoVo();
        if (seguimientoVo != null) {
            seguimientoVo.setId(seguimiento.getId());
            com.suricata.argos.ws.client.ActividadVo actividad = new com.suricata.argos.ws.client.ActividadVo();
            actividad.setId(seguimiento.getActividad().getId());
            seguimientoVo.setActividad(actividad);
            GregorianCalendar gcalAnuncio = new GregorianCalendar();
            gcalAnuncio.setTime(seguimiento.getFechaAnuncio());
            XMLGregorianCalendar xgcalAnuncio = DatatypeFactory.newInstance()
            .newXMLGregorianCalendar(gcalAnuncio);
            seguimientoVo.setFechaAnuncio(xgcalAnuncio);
            
            GregorianCalendar gcalVencimiento = new GregorianCalendar();
            gcalVencimiento.setTime(seguimiento.getFechaVencimiento());
            XMLGregorianCalendar xgcalVencimiento = DatatypeFactory.newInstance()
            .newXMLGregorianCalendar(gcalVencimiento);
            seguimientoVo.setFechaVencimiento(xgcalVencimiento);
            TipoSeguimientoVo tipoSeguimiento = new TipoSeguimientoVo();
            Iterator<SeguimientoTipoSeguimientoVo>  it = seguimiento.getSeguimientotiposeguimientos().iterator();
            while (it.hasNext()){
                SeguimientoTipoSeguimientoVo seguimientoTipoSeguimiento = it.next();
                com.suricata.argos.ws.client.SeguimientoTipoSeguimientoVo seguimientoTipoSeguimientoVo = new com.suricata.argos.ws.client.SeguimientoTipoSeguimientoVo();
                seguimientoTipoSeguimientoVo.setId(seguimientoTipoSeguimiento.getId());
                com.suricata.argos.ws.client.TipoSeguimientoVo tipoSeguimientoVo = convertVoToVoWS(seguimientoTipoSeguimiento.getTiposeguimiento());
                seguimientoTipoSeguimientoVo.setTiposeguimiento(tipoSeguimientoVo);
                seguimientoVo.getSeguimientotiposeguimientos().add(seguimientoTipoSeguimientoVo);
            }
            com.suricata.argos.ws.client.UsuarioVo usuario = new com.suricata.argos.ws.client.UsuarioVo();
            usuario.setId(seguimiento.getUsuario().getId());
            seguimientoVo.setUsuario(usuario);
        }
        return seguimientoVo;
    }

     public static com.suricata.argos.ws.client.ActividadVo convertVoToVoWS(ActividadVo actividad) throws DatatypeConfigurationException{
        com.suricata.argos.ws.client.ActividadVo actividadVo = new com.suricata.argos.ws.client.ActividadVo();
        if (actividadVo != null) {
            actividadVo.setDescripcion(actividad.getDescripcion());
            actividadVo.setDescripcionCierre(actividad.getDescripcionCierre());
            actividadVo.setEstado(convertVoToVoWS(actividad.getEstado()));
            GregorianCalendar gcalCreacion = new GregorianCalendar();
            gcalCreacion.setTime(actividad.getFechaCreacion());
            XMLGregorianCalendar xgcalCreacion = DatatypeFactory.newInstance()
            .newXMLGregorianCalendar(gcalCreacion);
            actividadVo.setFechaCreacion(xgcalCreacion);

            GregorianCalendar gcalVencimiento = new GregorianCalendar();
            gcalVencimiento.setTime(actividad.getFechaVencimiento());
            XMLGregorianCalendar xgcalVencimiento = DatatypeFactory.newInstance()
            .newXMLGregorianCalendar(gcalVencimiento);
            actividadVo.setFechaVencimiento(xgcalVencimiento);
            actividadVo.setId(actividad.getId());
            com.suricata.argos.ws.client.OportunidadVo oportunidadVo = new com.suricata.argos.ws.client.OportunidadVo();
            oportunidadVo.setId(actividad.getOportunidad().getId());
            actividadVo.setOportunidad(oportunidadVo);
            com.suricata.argos.ws.client.ContactoVo responsableCliente = new com.suricata.argos.ws.client.ContactoVo();
            responsableCliente.setId(actividad.getResponsableCliente().getId());
            actividadVo.setResponsableCliente(responsableCliente);
            com.suricata.argos.ws.client.UsuarioVo responsableUsuario = new com.suricata.argos.ws.client.UsuarioVo();
            responsableUsuario.setId(actividad.getResponsableUsuario().getId());
            actividadVo.setResponsableUsuario(responsableUsuario);
            actividadVo.setTipoactividad(convertVoToVoWS(actividad.getTipoactividad()));
            actividadVo.setTitulo(actividad.getTitulo());
            actividadVo.setUsuario(convertVoToVoWS(actividad.getUsuario()));
             if (actividad.getDocumento() != null){
                com.suricata.argos.ws.client.DocumentoVo documento= new com.suricata.argos.ws.client.DocumentoVo();
                documento.setNombre(actividad.getDocumento().getNombre());
                documento.setRuta(actividad.getDocumento().getRuta());
                documento.setTipo(actividad.getDocumento().getTipo());
                documento.setTamano(actividad.getDocumento().getTamano());
                actividadVo.setDocumento(documento);
            }
        }
        return actividadVo;
    }


     public static  com.suricata.argos.ws.client.RolVo convertVoToVoWS(RolVo rol){
        com.suricata.argos.ws.client.RolVo rolVo = new com.suricata.argos.ws.client.RolVo();
        if (rol != null) {
            rolVo.setId(rol.getId());
            rolVo.setNombre(rol.getNombre());
        }
        return rolVo;
    }

     public static XMLGregorianCalendar convertDate (Date fecha) throws DatatypeConfigurationException{
         XMLGregorianCalendar xgcal =  null;
         if (fecha != null) {
           GregorianCalendar gcal = new GregorianCalendar();
           gcal.setTime(fecha);
           xgcal = DatatypeFactory.newInstance()
            .newXMLGregorianCalendar(gcal);
       }
      return xgcal;
    }
}
