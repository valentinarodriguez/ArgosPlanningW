/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.suricata.argos.logica;

import com.suricata.argos.exception.ArgosWebServiceException;
import com.suricata.argos.exception.FaltanDatosException;
import com.suricata.argos.vo.RolVo;
import com.suricata.argos.ws.client.DatosNoEncontradosException;
import com.suricata.argos.ws.client.ErrorSQLException;
import com.suricata.argos.ws.client.FaltaParametroException;
import java.util.List;

/**
 *
 * @author Valentina
 */
public interface RolManager {

    void crearRol(RolVo rol) throws ArgosWebServiceException, FaltanDatosException;

    List<RolVo>  listarRoles() throws ArgosWebServiceException;

    RolVo buscarRol(Integer id) throws ArgosWebServiceException;

    void modificarRol(RolVo rol) throws ArgosWebServiceException, FaltanDatosException;

    List<RolVo> listarRolesPorUsuario(Integer idUsuario) throws ArgosWebServiceException, FaltanDatosException;
}
