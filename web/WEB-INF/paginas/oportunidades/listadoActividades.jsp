<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<jsp:include page="../right.jsp" flush="true"/>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <sx:head />
<link rel="stylesheet" href="../style.css" type="text/css" />
<link rel="stylesheet" href="../table.css" type="text/css" />
</head>
<body>
    <div class="subMenu">
        <ul>
            <li class="active"><s:url id="listadoActividades" action="listadoActividad"/><s:a href="%{listadoActividades}" accesskey="l">Listar Actividades</s:a></li>
            <li><s:url id="ActividadCrear" action="ActividadCrear"/><s:a href="%{ActividadCrear}" accesskey="c">Crear Actividad</s:a></li>
        </ul>

</div>
       <p>&nbsp;</p>
        <p>&nbsp;</p>
           <div class="search_field">
                <s:form action="listadoActividad" method="post">
                  <div class="search_form">
                   <table>
                     <tr>
                       <td width = '20%' align="center">
                      <s:select name="estado.nombre" label="Estado"
                        list="listaEstados" listValue="nombre" listKey="nombre"
                        headerKey="Abierta" value="%{estado.nombre}">
                         </s:select>
                     </td>

                    <td width = '20px' align="center">
                    <input type="submit" value="Buscar" class="submit" align="center"/>
                             </td>
                                </tr>
                                <tr>
                                      <s:hidden id="id" name="id" />

                    <td width = '30px' align="center">
                    <sx:datetimepicker name="fechaDesde" label="Fecha Desde" displayFormat="dd-MMM-yyyy"/>
                                </td>
                    <td width = '30px' align="center">
                     <sx:datetimepicker name="fechaHasta" label="Fecha Hasta" displayFormat="dd-MMM-yyyy"/>
                      </td>
                                </tr>
                   
                           </div>
                </s:form>
                    <p>&nbsp;</p>

            </div>
   <p>&nbsp;</p>

<s:set name="listadoActividades" value="listadoActividades" scope="request"/>
<display:table name="listadoActividades" class="queryTable" requestURI="" id="actividadesList" export="true" pagesize="5">
    <s:url id="actividadDownload" action="actividadDownload" method="editar">
        <s:param name="id" value="%{id}"/>
    </s:url>
    <display:column property="id" sortable="true" title="ID"  style="font-size:15px;text-align: center" href="${actividadDownload}" paramId="id"/>
    <display:column property="titulo" sortable="true" title="Titulo" style="font-size:15px;text-align: center"/>
    <display:column property="oportunidad.titulo" sortable="true" title="Oportunidad" style="font-size:15px;text-align: center"/>
    <display:column property="tipoactividad.nombre" sortable="true" title="Tipo" style="font-size:15px;text-align: center"/>
    <display:column property="fechaVencimiento" sortable="true" title="Fecha Vencimiento" style="font-size:15px;text-align: center" format="{0,date,dd/MM/yyyy HH:mm}" />
 
</display:table>
</body>
</html>

<s:url id="paginationurl" action="ActividadEditar" namespace="/seguridad">
<s:param name="id" value="2"></s:param>
<s:param name="direction" value="forward"></s:param>
</s:url>
<s:a href="%{paginationurl}">Next Record</s:a>
