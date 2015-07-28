/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.suricata.argos.logica;

import com.suricata.argos.exception.ArgosWebServiceException;
import com.suricata.argos.exception.FaltanDatosException;
import com.suricata.argos.vo.SeguimientoVo;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Valentina
 */
public interface SeguimientoManager {

    void crearSeguimiento(SeguimientoVo seguimiento) throws ArgosWebServiceException, FaltanDatosException;

    void borrarSeguimiento(SeguimientoVo seguimiento) throws ArgosWebServiceException;

    List<SeguimientoVo> listarSeguimientos(String enviado, Date fechaDesde, Date fechaHasta) throws ArgosWebServiceException;

    SeguimientoVo buscarSeguimiento(Integer id) throws ArgosWebServiceException;

    void modificarSeguimiento(SeguimientoVo seguimiento) throws ArgosWebServiceException, FaltanDatosException;

    List<SeguimientoVo> listarUltimosSeguimientos(Long idUsuario) throws ArgosWebServiceException;

    List<SeguimientoVo> listarUltimosSeguimientos() throws ArgosWebServiceException;
}
