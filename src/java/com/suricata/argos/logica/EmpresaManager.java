/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.suricata.argos.logica;

import com.suricata.argos.exception.ArgosWebServiceException;
import com.suricata.argos.exception.FaltanDatosException;
import com.suricata.argos.vo.EmpresaVo;
import java.util.List;

/**
 *
 * @author Valentina
 */
public interface EmpresaManager {

    void crearEmpresa(EmpresaVo empresa) throws ArgosWebServiceException, FaltanDatosException;

    void borrarEmpresa(EmpresaVo empresa) throws ArgosWebServiceException;

    List<EmpresaVo>  listarEmpresas() throws ArgosWebServiceException;

    EmpresaVo buscarEmpresa(Integer id) throws ArgosWebServiceException;

    void modificarEmpresa(EmpresaVo empresa) throws ArgosWebServiceException, FaltanDatosException;
}
