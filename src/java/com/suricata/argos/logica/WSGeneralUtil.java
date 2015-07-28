package com.suricata.argos.logica;

import com.suricata.argos.constantes.Constantes;
import com.suricata.argos.ws.client.ArgosWSService;
import java.net.MalformedURLException;
import java.net.URL;



import javax.xml.namespace.QName;
/**
 * Clase utilitarios general para el acceso al Web Service 
 * @author valentina
 *
 */
public class WSGeneralUtil {

	/**
	 * 
	 */
	private static ArgosWSService webService;
	
	/**
	 * 
	 */
	private  static WSGeneralUtil instance;
	
	/**
	 * @return the instance
	 */
	public static WSGeneralUtil getInstance() {
		return instance = new WSGeneralUtil();
	}
	

    /**
     * Devuelve una instancia del Web Service
     * @author valentina
	 * @return the webServiceCRM
     * @throws MalformedURLException
     */
	public ArgosWSService getWebService() throws MalformedURLException
	{
		if (webService == null)
		{
	            URL urlWS = new URL(Constantes.URL_WSDL);
                    webService = new ArgosWSService(urlWS,new QName(Constantes.WEBSERVICE_TARGET_NAMESPACE, Constantes.WEBSERVICE_NAME));
		}
		
		return webService;
	}
	
	
}

