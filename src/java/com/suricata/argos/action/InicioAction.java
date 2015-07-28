/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.suricata.argos.action;

import com.suricata.argos.constantes.Constantes;
import com.suricata.argos.exception.ArgosWebServiceException;
import com.suricata.argos.logica.ActividadManager;
import com.suricata.argos.logica.ActividadManagerImpl;
import com.suricata.argos.logica.OportunidadManager;
import com.suricata.argos.logica.OportunidadManagerImpl;
import com.suricata.argos.logica.SeguimientoManager;
import com.suricata.argos.logica.SeguimientoManagerImpl;
import com.suricata.argos.vo.ActividadVo;
import com.suricata.argos.vo.OportunidadVo;
import com.suricata.argos.vo.SeguimientoVo;
import com.suricata.argos.vo.UsuarioVo;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Valentina
 */
public class InicioAction extends ArgosAction {
    private SeguimientoManager seguimientoManager = new SeguimientoManagerImpl();
    private OportunidadManager oportunidadManager = new OportunidadManagerImpl();
    private ActividadManager actividadManager = new ActividadManagerImpl();
  
    private Integer idUsuario;
    
    private List<OportunidadVo> listaOportunidades;
    private List<SeguimientoVo> listaSeguimientos;
    private List<ActividadVo> listaActividades;

    private List<ActividadVo> listaActividadesUsuario;
    private List<SeguimientoVo> listaSeguimientosUsuario;

    public List<SeguimientoVo> getListaSeguimientosUsuario() {
        return listaSeguimientosUsuario;
    }

    public void setListaSeguimientosUsuario(List<SeguimientoVo> listaSeguimientosUsuario) {
        this.listaSeguimientosUsuario = listaSeguimientosUsuario;
    }

    public List<ActividadVo> getListaActividadesUsuario() {
        return listaActividadesUsuario;
    }

    public void setListaActividadesUsuario(List<ActividadVo> listaActividadesUsuario) {
        this.listaActividadesUsuario = listaActividadesUsuario;
    }

    

    public List<ActividadVo> getListaActividades() {
        return listaActividades;
    }

    public void setListaActividades(List<ActividadVo> listaActividades) {
        this.listaActividades = listaActividades;
    }

    public List<OportunidadVo> getListaOportunidades() {
        return listaOportunidades;
    }

    public void setListaOportunidades(List<OportunidadVo> listaOportunidades) {
        this.listaOportunidades = listaOportunidades;
    }

    public List<SeguimientoVo> getListaSeguimientos() {
        return listaSeguimientos;
    }

    public void setListaSeguimientos(List<SeguimientoVo> listaSeguimientos) {
        this.listaSeguimientos = listaSeguimientos;
    }

  



    public String execute () {
        UsuarioVo usuarioVo = (UsuarioVo) this.getSession().get(Constantes.SESSION_USUARIO);
        idUsuario = usuarioVo.getId();
        try {
            this.cargarListasLeft();
            this.cargarListasRight();
        } catch (ArgosWebServiceException ex) {
           addActionError(ex.getMessage());
        }
        return SUCCESS;
    }

    private void cargarListasRight () throws ArgosWebServiceException {
        this.setListaActividadesUsuario(this.actividadManager.listarUltimasActividades(Long.parseLong(idUsuario.toString())));
        this.setListaSeguimientosUsuario(this.seguimientoManager.listarUltimosSeguimientos(Long.parseLong(idUsuario.toString())));
    }

     private void cargarListasLeft() throws ArgosWebServiceException {
        this.setListaActividades(this.actividadManager.listarUltimasActividades());
        this.setListaOportunidades(this.oportunidadManager.listarUltimasOportunidades());
        this.setListaSeguimientos(this.seguimientoManager.listarUltimosSeguimientos());
           if (this.getListaActividades() == null)
            listaActividades = new ArrayList();
           if (this.getListaOportunidades() == null)
            listaOportunidades = new ArrayList();
           if (this.getListaSeguimientos() == null)
            listaSeguimientos = new ArrayList();
    }
}
