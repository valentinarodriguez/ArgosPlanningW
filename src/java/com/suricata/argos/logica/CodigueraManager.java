/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.suricata.argos.logica;


import com.suricata.argos.exception.ArgosWebServiceException;
import com.suricata.argos.vo.EstadoVo;
import com.suricata.argos.vo.TecnologiaVo;
import com.suricata.argos.vo.TipoActividadVo;
import com.suricata.argos.vo.TipoProyectoVo;
import com.suricata.argos.vo.TipoSeguimientoVo;
import java.util.List;

/**
 *
 * @author Valentina
 */
public interface CodigueraManager {

      List<TipoProyectoVo>  listarTipoProyectos() throws ArgosWebServiceException;

      List<TecnologiaVo>  listarTecnologias() throws ArgosWebServiceException;

      List<EstadoVo>  listarEstados() throws ArgosWebServiceException;

      List<TipoActividadVo> listarTipoActividades() throws ArgosWebServiceException;

      List<TipoSeguimientoVo> listarTipoSeguimientos() throws ArgosWebServiceException;

}
