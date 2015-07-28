/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */ 

package com.suricata.argos.logica;

import com.suricata.argos.exception.ArgosWebServiceException;
import com.suricata.argos.exception.FaltanDatosException;
import com.suricata.argos.vo.ContactoVo;
import java.util.List;

/**
 *
 * @author Valentina
 */
public interface ContactoManager {

    void crearContacto(ContactoVo contacto) throws ArgosWebServiceException, FaltanDatosException;

    void borrarContacto(ContactoVo Contacto) throws ArgosWebServiceException;

    List<ContactoVo> listarContactos() throws ArgosWebServiceException;

    ContactoVo buscarContacto(Integer id) throws ArgosWebServiceException;

    void modificarContacto(ContactoVo contacto) throws ArgosWebServiceException, FaltanDatosException;

}
