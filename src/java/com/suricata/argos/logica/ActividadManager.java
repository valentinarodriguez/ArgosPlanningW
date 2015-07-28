/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */ 

package com.suricata.argos.logica;

import com.suricata.argos.exception.ArgosWebServiceException;
import com.suricata.argos.exception.FaltanDatosException;
import com.suricata.argos.vo.ActividadVo;
import com.suricata.argos.vo.DocumentoVo;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Valentina
 */
public interface ActividadManager {

    void crearActividad(ActividadVo actividad) throws ArgosWebServiceException, FaltanDatosException;

    void borrarActividad(ActividadVo actividad) throws ArgosWebServiceException;

    List<ActividadVo> listarActividads(String estado, Date fechaDesde, Date fechaHasta) throws ArgosWebServiceException;

    ActividadVo buscarActividad(Integer id) throws ArgosWebServiceException;

    void modificarActividad(ActividadVo actividad) throws ArgosWebServiceException, FaltanDatosException;
    
    List<ActividadVo> listarUltimasActividades(Long idUsuario) throws ArgosWebServiceException;

    List<ActividadVo> listarUltimasActividades() throws ArgosWebServiceException;

    byte[] descargarPlantilla(String ruta) throws ArgosWebServiceException, FaltanDatosException;

    DocumentoVo buscarDocumento(String nombrePlantilla) throws ArgosWebServiceException, FaltanDatosException;

}
