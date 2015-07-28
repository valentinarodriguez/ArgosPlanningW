/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.suricata.argos.logica;

import com.suricata.argos.exception.ArgosWebServiceException;
import com.suricata.argos.vo.ContactoVo;
import com.suricata.argos.ws.client.ArgosWS;
import com.suricata.argos.ws.client.ArgosWSService;
import com.suricata.argos.ws.client.DatosNoEncontradosException_Exception;
import com.suricata.argos.ws.client.ErrorSQLException_Exception;
import com.suricata.argos.ws.client.FaltaParametroException_Exception;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.log4j.Logger;
import com.suricata.argos.constantes.Constantes;
import com.suricata.argos.exception.FaltanDatosException;
import com.suricata.argos.logica.utiles.ConvertidorUtiles;

/**
 *
 * @author Valentina
 */
public class ContactoManagerImpl implements ContactoManager {
    private static final Logger LOGGER = Logger.getLogger(ContactoManagerImpl.class);
    /**
     *
     * @return
     * @throws Exception
     */
    public ArgosWS getWS() throws MalformedURLException {
        ArgosWS proxy = null;
        ArgosWSService webService = WSGeneralUtil.getInstance().getWebService();
        proxy = webService.getArgosWSPort();
        return proxy;
    }


public ContactoVo buscarContacto(Integer idContacto) throws ArgosWebServiceException {
        try {
            ContactoVo contacto = null;
            contacto = ConvertidorUtiles.convertVoWSToVo(this.getWS().buscarContacto(idContacto));
            return contacto;
        } catch (DatosNoEncontradosException_Exception ex) {
            LOGGER.error(ex.getMessage(), ex);
            throw new ArgosWebServiceException(Constantes.ERROR_WS_NO_EXISTE_DATO, ex);
        } catch (ErrorSQLException_Exception ex) {
            LOGGER.error(ex.getMessage(), ex);
            throw new ArgosWebServiceException(Constantes.ERROR_WS_GENERICO, ex);
        } catch (MalformedURLException ex) {
            LOGGER.error(ex.getMessage(), ex);
            throw new ArgosWebServiceException(Constantes.ERROR_WS_GENERICO, ex);
        }
    }


    public List<ContactoVo> listarContactos() throws ArgosWebServiceException {
       try {
            List<ContactoVo> listaVos = null;
            listaVos = new ArrayList<ContactoVo>();
            List<com.suricata.argos.ws.client.ContactoVo> listaEntity = this.getWS().listarContactos();
            Iterator it = listaEntity.iterator();
            while (it.hasNext()) {
                ContactoVo usaurioVo = ConvertidorUtiles.convertVoWSToVo((com.suricata.argos.ws.client.ContactoVo) it.next());
                listaVos.add(usaurioVo);
            }
            return listaVos;
        } catch (ErrorSQLException_Exception ex) {
            LOGGER.error(ex.getMessage(), ex);
            throw new ArgosWebServiceException(Constantes.ERROR_WS_GENERICO, ex);
        } catch (MalformedURLException ex) {
            LOGGER.error(ex.getMessage(), ex);
            throw new ArgosWebServiceException(Constantes.ERROR_WS_GENERICO, ex);
        }
    }

    public void modificarContacto(ContactoVo contacto) throws ArgosWebServiceException,FaltanDatosException {
         try {
              if (validarDatosObligatorios(contacto) == true && contacto.getId() != 0){
                this.getWS().modificarContacto(ConvertidorUtiles.convertVoToVoWS(contacto));
              } else {
                 LOGGER.error(Constantes.ERROR_WS_FALTAN_DATOS);
                 throw new FaltanDatosException(Constantes.ERROR_WS_FALTAN_DATOS);
              }
   
        } catch (ErrorSQLException_Exception ex) {
             LOGGER.error(ex.getMessage(), ex);
             throw new ArgosWebServiceException(Constantes.ERROR_WS_GENERICO, ex);
        } catch (FaltaParametroException_Exception ex) {
             LOGGER.error(ex.getMessage(), ex);
             throw new ArgosWebServiceException(Constantes.ERROR_WS_FALTAN_DATOS, ex);
        } catch (MalformedURLException ex) {
            LOGGER.error(ex.getMessage(), ex);
            throw new ArgosWebServiceException(Constantes.ERROR_WS_GENERICO, ex);
        }

    }

    public void crearContacto(ContactoVo contacto) throws ArgosWebServiceException, FaltanDatosException {
         try {
              if (validarDatosObligatorios(contacto) == true){
                this.getWS().crearContacto(ConvertidorUtiles.convertVoToVoWS(contacto));
              } else {
                 LOGGER.error(Constantes.ERROR_WS_FALTAN_DATOS);
                 throw new FaltanDatosException(Constantes.ERROR_WS_FALTAN_DATOS);
              }
  
        } catch (ErrorSQLException_Exception ex) {
             LOGGER.error(ex.getMessage(), ex);
             throw new ArgosWebServiceException(Constantes.ERROR_WS_GENERICO, ex);
        } catch (FaltaParametroException_Exception ex) {
             LOGGER.error(ex.getMessage(), ex);
             throw new ArgosWebServiceException(Constantes.ERROR_WS_FALTAN_DATOS, ex);
        } catch (MalformedURLException ex) {
            LOGGER.error(ex.getMessage(), ex);
            throw new ArgosWebServiceException(Constantes.ERROR_WS_GENERICO, ex);
        }

    }


     

    /**
     *
     * @param contacto
     * @return
     */
    private boolean validarDatosObligatorios (ContactoVo contacto) {
        boolean resultado = false;
        if (contacto != null && contacto.getApellido()!= null && contacto.getNombre() != null &&
                contacto.getEmpresaVo() != null) {
            resultado = true;
        }
        return resultado;
    }

    public void borrarContacto(ContactoVo Contacto) throws ArgosWebServiceException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
