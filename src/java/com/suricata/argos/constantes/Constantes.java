/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.suricata.argos.constantes;

/**
 *
 * @author Valentina
 */
public class Constantes {


    /**
     * error generico en caso de alg�n tipo de error con el web service.
     */
    public static final String  ERROR_CRM_GENERICO = "error.webService.problemaConexion";

    /**
     * parametro de b�squeda donde se podr� obtener la url del web service.
     */
    public static final String URL_WSDL = "http://localhost:8080/ArgosComunitaeWebService/ArgosWSService?wsdl";

    /**
     * Donde se encuentra el web service, el namespace, para poder ubicarlo.
     */
    public static final String WEBSERVICE_TARGET_NAMESPACE = "http://ws.WS.argos.suricata.com/";

    /**
     * nombre del servicio web, para poder localizarlo.
     */
    public static final String WEBSERVICE_NAME = "ArgosWSService";

      public static final String ERROR_WS_GENERICO = "Ha ocurrido un error en el sistema. Por favor comuníquese con el administrador";

      public static final String ERROR_WS_DATOS_DUPLICADOS = "No se pueden salvar los datos. Los datos ingresados ya existen.";

      public static final String ERROR_WS_FALTAN_DATOS = "No se pueden salvar los datos. Faltan ingresar datos obligatorios";

      public static final String ERROR_WS_NO_EXISTE_DATO = "No existen elementos registrados para la búsqueda";

      public static final String ERROR_WS_TIPO_DATO = "Hubo un error con el tipo de datos. Consulte con el administrador";

      public static final String ERROR_WS_ARCHIVO_UPLOAD = "Hubo un error al querer adjuntar el archivo";

      public static final String ERROR_WS_ARCHIVO_DOWNLOAD = "Hubo un error al querer descargar el archivo";

      public static final String NOMBRE_DOCUMENTO_PRESENTACION = "presentacionPlantilla";

      public static final String NOMBRE_DOCUMENTO_MINUTA = "minutaPlantilla";

      public static final String NOMBRE_DOCUMENTO_PROPUESTA = "propuestaPlantilla";

      public static final String SESSION_USUARIO = "usuarioLogueado";

      public static final Integer ESTADO_CANCELADO_ID = 3;

      public static final Integer ESTADO_CERRADO_ID = 2;

      public static final Integer ESTADO_ABIERTO_ID = 1 ;

      public static final String ESTADO_CANCELADO_NOMBRE = "Cancelada";

      public static final String ESTADO_CERRADO_NOMBRE = "Cerrada";

      public static final String ESTADO_ABIERTO_NOMBRE = "Abierta";


}
