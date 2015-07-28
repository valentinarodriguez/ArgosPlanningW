/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.suricata.argos.logica;

import com.suricata.argos.exception.ArgosWebServiceException;
import com.suricata.argos.vo.EmpresaVo;
import com.suricata.argos.ws.client.ArgosWS;
import com.suricata.argos.ws.client.ArgosWSService;
import com.suricata.argos.ws.client.DatosDuplicadosException_Exception;
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
public class EmpresaManagerImpl implements EmpresaManager {
    private static final Logger LOGGER = Logger.getLogger(EmpresaManagerImpl.class);

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

  public EmpresaVo buscarEmpresa(Integer idEmpresa) throws ArgosWebServiceException {
        try {
            EmpresaVo empresa = null;
            empresa = ConvertidorUtiles.convertVoWSToVo(this.getWS().buscarEmpresa(idEmpresa));
            return empresa;
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


    public List<EmpresaVo> listarEmpresas() throws ArgosWebServiceException {
       try {
            List<EmpresaVo> listaVos = null;
            listaVos = new ArrayList<EmpresaVo>();
            List<com.suricata.argos.ws.client.EmpresaVo> listaEntity = this.getWS().listarEmpresas();
            Iterator it = listaEntity.iterator();
            while (it.hasNext()) {
                EmpresaVo usaurioVo = ConvertidorUtiles.convertVoWSToVo((com.suricata.argos.ws.client.EmpresaVo) it.next());
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

    public void modificarEmpresa(EmpresaVo empresa) throws ArgosWebServiceException, FaltanDatosException {
         try {
              if (validarDatosObligatorios(empresa) == true && empresa.getId() != 0){
                this.getWS().modificarEmpresa(ConvertidorUtiles.convertVoToVoWS(empresa));
              } else {
                 LOGGER.error(Constantes.ERROR_WS_FALTAN_DATOS);
                 throw new FaltanDatosException(Constantes.ERROR_WS_FALTAN_DATOS);
              }
        } catch (DatosDuplicadosException_Exception ex) {
             LOGGER.error(ex.getMessage(), ex);
             throw new ArgosWebServiceException(Constantes.ERROR_WS_DATOS_DUPLICADOS, ex);
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

    public void crearEmpresa(EmpresaVo empresa) throws ArgosWebServiceException, FaltanDatosException {
         try {
              if (validarDatosObligatorios(empresa) == true){
                this.getWS().crearEmpresa(ConvertidorUtiles.convertVoToVoWS(empresa));
              } else {
                 LOGGER.error(Constantes.ERROR_WS_FALTAN_DATOS);
                 throw new FaltanDatosException(Constantes.ERROR_WS_FALTAN_DATOS);
              }
        } catch (DatosDuplicadosException_Exception ex) {
             LOGGER.error(ex.getMessage(), ex);
             throw new ArgosWebServiceException(Constantes.ERROR_WS_DATOS_DUPLICADOS, ex);
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
     * @param empresa
     * @return
     */
    private boolean validarDatosObligatorios (EmpresaVo empresa) {
        boolean resultado = false;
        if (empresa != null && empresa.getNombre() != null) {
            resultado = true;
        }
        return resultado;
    }

    public void borrarEmpresa(EmpresaVo empresa) throws ArgosWebServiceException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
