<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<jsp:include page="right.jsp" flush="true"/>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link rel="stylesheet" href="style.css" type="text/css" />
</head>
<body>
    <h3>Oportunidades Activas</h3>
    <div class="left_box">
       <s:set name="listaOportunidades" value="listaOportunidades" scope="request"/>
        <display:table name="listaOportunidades" class="queryTable" requestURI="" id="oportunidadesList" export="true" pagesize="3">
            <display:column property="id" sortable="true" title="ID"  style="font-size:15px;text-align: center" href="OportunidadEditar.action" paramId="id"/>
            <display:column property="codigoInterno" sortable="true" title="Codigo Interno" style="font-size:15px;text-align: center"/>
            <display:column property="tipoproyecto.nombre" sortable="true" title="Tipo Proyecto" style="font-size:15px;text-align: center"/>
            <display:column property="empresa.nombre" sortable="true" title="Empresa" style="font-size:15px;text-align: center"/>
       </display:table>
			 
</div>
	
    <h3>Actividades Activas</h3>
    <div class="left_box">
      <s:set name="listaActividades" value="listaActividades" scope="request"/>
        <display:table name="listaActividades" class="queryTable" requestURI="" id="actividadesList" export="true" pagesize="3">
            <display:column property="id" sortable="true" title="ID"  style="font-size:15px;text-align: center" href="ActividadEditar.action" paramId="id"/>
            <display:column property="titulo" sortable="true" title="Titulo" style="font-size:15px;text-align: center"/>
            <display:column property="oportunidad.titulo" sortable="true" title="Oportunidad" style="font-size:15px;text-align: center"/>
            <display:column property="tipoactividad.nombre" sortable="true" title="Tipo" style="font-size:15px;text-align: center"/>
       </display:table>
    </div>
    <h3>Proximos Seguimientos</h3>
    <div class="left_box">
         <s:set name="listaSeguimientos" value="listaSeguimientos" scope="request"/>
            <display:table name="listaSeguimientos" class="queryTable" requestURI="" id="seguimientosList" export="true" pagesize="3">
                <display:column property="id" sortable="true" title="ID"  style="font-size:15px;text-align: center" href="SeguimientoEditar.action" paramId="id"/>
                <display:column property="actividad.titulo" sortable="true" title="Actividad" style="font-size:15px;text-align: center"/>
                <display:column property="enviado" sortable="true" title="Enviado" style="font-size:15px;text-align: center"/>
           </display:table>
    </div>
	
       
                      	</body>
</html>