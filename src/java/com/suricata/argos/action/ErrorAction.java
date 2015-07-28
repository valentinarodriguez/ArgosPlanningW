package com.suricata.argos.action;

import com.opensymphony.xwork2.ActionSupport;
import java.io.InputStream;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.SessionAware;


/**
 * Maneja el mensaje de error devuelto, si la pagina de error comun, o un xml para el componente flex.
 * @author 
 */
public class ErrorAction extends ActionSupport implements SessionAware
{
	private static final long serialVersionUID = -8049848969061445122L;

	private static final String ACCESO_DENEGADO = "accesoDenegado";

	public static final String REQUEST_ATTRIBUTE_EXCEPTION_STACK = "exceptionStack";

	public static final String REQUEST_ATTRIBUTE_EXCEPTION = "exception";
	
	/**
	 * Clave de sesi�n del stack de excepciones.
	 */
	public static final String CLAVE_SESION_EXCEPTION_STACK = "ErrorAction.exceptionStack";

	/**
	 * Clave de sesi�n de la excepci�n.
	 */
	public static final String CLAVE_SESION_EXCEPTION = "ErrorAction.exception";

	public static final String ACTION_URL = "error.action";

	private static final String HTML_INTERFACE_EXCEPTION = "htmlInterfaceException";

	private static final String MENSAJE_ENCABEZADO_EXCEPTION = "Ha ocurrido la siguiente exception:";

	private static Logger LOG = Logger.getLogger("Error");
	
	/*
	 * Se agregan 
	 * tipos de errores - mensajes y excepciones
	 */
	//MENSAJES
	private static final String ERROR_GENERICO_MSG = "error.mensajeGenerico";
	
	private static final String ERROR_ACCESO_DENEGADO_MSG = "error.AccesoDenegado";
	
	private static final String ERROR_404_MSG = "error.ubicacionNoExiste";
	
	private static final String ERROR_FILE_UPLOAD_MULTIPART_SIZE_EXCEEDED= "error.FileUploadMultipartSizeExceeded";
	
	//Excepciones - causas
	public static final String ERROR_ACCESO_DENEGADO_EXCEP = "Access is denied";
	private static final String ERROR_FILE_UPLOAD_MULTIPART_SIZE_EXCEEDED_EXCEP = "com.telefonica.iwc.excepcion.FileUploadMultipartSizeExceededException";
	public static final String ERROR_ACCESO_DENEGADO = "com.telefonica.iwc.vista.actions.ErrorAction.accesoDenegado";
	
	
	/**
	 * Utilizado si la respuesta fuera un archivo.
	 */
	private InputStream documentStream;

        private Map session;
	/**
	 * Utilizado si la respuesta fuera un archivo.
	 */
	private String downloadFilename;
	/**
	 * Utilizado si la respuesta fuera un archivo.
	 */
	private String downloadFilesize;
	/**
	 * Utilizado si la respuesta fuera un archivo.
	 */
	private String downloadFiletype;

	/**
	 * La excepci�n.
	 */
	private Exception exception;

	private String exceptionStack;

	/**
	 * Es el mensaje que se mostrar� en la p�gina de error.
	 */
	private String mensajeWeb;
	
	private String errorNoException;
	
	
	/**
	 * @return the mensajeWeb
	 */
	public String getMensajeWeb() {
		return mensajeWeb;
	}

	/**
	 * @param mensajeWeb the mensajeWeb to set
	 */
	public void setMensajeWeb(String mensajeWeb) {
		this.mensajeWeb = mensajeWeb;
	}

	/**
	 * Metodo principal se ejecuta al cargar la p�gina.
	 */
	public String execute()
	{
		
		//String retVal = ACCESO_DENEGADO;
		String retVal = HTML_INTERFACE_EXCEPTION;
		cargarValoresSesion();
		cargarMensajeError();
//      si se envio informacion de exception
		if (exception != null && errorNoException != null)
		{
//	  		loguear la informacion
	    	LOG.error(MENSAJE_ENCABEZADO_EXCEPTION,exception);
	    	
	    	if (exception.getCause() != null)
	    	{
		    	LOG.error("getCause():",exception.getCause());
	    	}
		}
		
                    exceptionStack = escapeHtml(exceptionStack);

                    retVal = HTML_INTERFACE_EXCEPTION;
		borrarValoresSesion();
		
		return retVal;
	}

	/**
	 * Seg�n el tipo de error se carga el mensaje a mostrar en pantalla.
	 */
	private void cargarMensajeError() {
            String errorMensaje = "";
		if (this.exception!= null &&  this.exception.getMessage()!=null && this.exception.getMessage().toString().equalsIgnoreCase(ERROR_ACCESO_DENEGADO_EXCEP)){
                    errorMensaje = "acceso denegado";
                    LOG.error(exception.getMessage(), exception);
  		} else if (this.exception!= null && this.exception.toString().equalsIgnoreCase(ERROR_FILE_UPLOAD_MULTIPART_SIZE_EXCEEDED_EXCEP)){
                    LOG.error(ERROR_FILE_UPLOAD_MULTIPART_SIZE_EXCEEDED_EXCEP, exception);
                    addActionError("file upload multipart");
		} else if (this.exception == null || this.exception.getMessage() == null ){
			 errorNoException = (String)this.getSession().get(this.ERROR_ACCESO_DENEGADO);
			if (errorNoException!= null && errorNoException.equalsIgnoreCase(ERROR_ACCESO_DENEGADO_EXCEP)) {
                                errorMensaje = "La página no existe";
                                LOG.error(errorMensaje, exception);
			} else {
                               errorMensaje = "Ocurrió un error en el sistema. Por favor comuníquese con el adminstrador";
                    LOG.error(errorMensaje, exception);
			}
		} else {
                    errorMensaje = "Ocurrió un error en el sistema. Por favor comuníquese con el adminstrador";
                    LOG.error(errorMensaje, exception);
		}

                getSession().put("ERROR_MSG", errorMensaje);
	}
	
	/**
	 * Borra los valores de la sesi�n.
	 */
	private void borrarValoresSesion()
	{
               this.session.put(CLAVE_SESION_EXCEPTION, null);
		getSession().put(CLAVE_SESION_EXCEPTION_STACK, null);
                getSession().put(ERROR_ACCESO_DENEGADO, null);
	}

	/**
	 * Carga los valores de la sesi�n.
	 */
	private void cargarValoresSesion()
	{
		if (getSession().get(CLAVE_SESION_EXCEPTION) instanceof Exception)
		{
			exception = (Exception) getSession().get(CLAVE_SESION_EXCEPTION);
		}
		if (getSession().get(CLAVE_SESION_EXCEPTION_STACK) instanceof String)
		{
			exceptionStack = (String) getSession().get(CLAVE_SESION_EXCEPTION_STACK);
		}
	}

	
	/**
	 * Formatea los espacios en html.
	 * @param value El string a formatear los espacios.
	 * @return El string con los espacios formateados.
	 */
	private String escapeHtml(String value)
	{
		if (value == null)
			return null;
		
		value = value.replaceAll(" ","&nbsp;");
		value = value.replaceAll("\t","&nbsp;&nbsp;&nbsp;");
		value = value.replaceAll("\n","<br />");
		
		return value;
	}
	

	public InputStream getDocumentStream()
	{
		return documentStream;
	}

	public void setDocumentStream(InputStream documentStream)
	{
		this.documentStream = documentStream;
	}

	public String getDownloadFilename()
	{
		return downloadFilename;
	}

	public void setDownloadFilename(String downloadFilename)
	{
		this.downloadFilename = downloadFilename;
	}

	public String getDownloadFilesize()
	{
		return downloadFilesize;
	}

	public void setDownloadFilesize(String downloadFilesize)
	{
		this.downloadFilesize = downloadFilesize;
	}

	public String getDownloadFiletype()
	{
		return downloadFiletype;
	}

	public void setDownloadFiletype(String downloadFiletype)
	{
		this.downloadFiletype = downloadFiletype;
	}

	public void setException(Exception exception)
	{
		this.exception = exception;
	}

	public Exception getException()
	{
		return exception;
	}

	public void setExceptionStack(String exceptionStack)
	{
		this.exceptionStack = exceptionStack;
	}

        public void setSession(Map session)
	{
		this.session = session;
	}

	public Map getSession()
	{
		return session;
	}

}