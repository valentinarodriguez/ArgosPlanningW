/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.suricata.argos.logica;

import com.suricata.argos.exception.ArgosWebServiceException;
import com.suricata.argos.exception.FaltanDatosException;
import com.suricata.argos.vo.OportunidadVo;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Valentina
 */
public interface OportunidadManager {

    void crearOportunidad(OportunidadVo oportunidad) throws ArgosWebServiceException, FaltanDatosException;

    void borrarOportunidad(OportunidadVo oportunidad) throws ArgosWebServiceException;

    List<OportunidadVo> listarOportunidades(String estado, Date fechaDesde, Date fechaHasta) throws ArgosWebServiceException;

    OportunidadVo buscarOportunidad(Integer id) throws ArgosWebServiceException;

    void modificarOportunidad(OportunidadVo oportunidad) throws ArgosWebServiceException, FaltanDatosException;

    List<OportunidadVo> listarUltimasOportunidades(Long idUsuario) throws ArgosWebServiceException;

    List<OportunidadVo> listarUltimasOportunidades() throws ArgosWebServiceException;
}
