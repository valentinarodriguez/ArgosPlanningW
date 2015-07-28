<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
         <div class="right">
            <div class="right_urgents">
                <h3>Recordatorios:</h3>
            </div>

          <div class="right_articles">
          <s:set name="listaSeguimientosUsuario" value="listaSeguimientosUsuario" scope="request"/>
        <display:table name="listaSeguimientosUsuario" class="queryTable" requestURI="" id="seguimientosListUsuario" export="true" pagesize="3">
            <display:column property="id" sortable="true" title="ID"  style="font-size:15px;text-align: center" href="SeguimientoEditar.action" paramId="id"/>
            <display:column property="actividad.titulo" sortable="true" title="Actividad" style="font-size:15px;text-align: center"/>
            <display:column property="tiposeguimiento.nombre" sortable="true" title="Tipo" style="font-size:15px;text-align: center"/>
            <display:column property="enviado" sortable="true" title="Enviado" style="font-size:15px;text-align: center"/>
       </display:table>
         </div>
           <h3>Ultimas Actividades:</h3>
            <div class="right_articles">
          <s:set name="listaActividadesUsuario" value="listaActividadesUsuario" scope="request"/>
        <display:table name="listaActividadesUsuario" class="queryTable" requestURI="" id="actividadesListUsuario" export="true" pagesize="3">
            <display:column property="id" sortable="true" title="ID"  style="font-size:15px;text-align: center" href="ActividadEditar.action" paramId="id"/>
            <display:column property="titulo" sortable="true" title="Titulo" style="font-size:15px;text-align: center"/>
            <display:column property="oportunidad.titulo" sortable="true" title="Oportunidad" style="font-size:15px;text-align: center"/>
            <display:column property="tipoactividad.nombre" sortable="true" title="Tipo" style="font-size:15px;text-align: center"/>
       </display:table>
            </div>

            </div>
    </body>
</html>
