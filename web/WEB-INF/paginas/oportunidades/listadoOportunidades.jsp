<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<jsp:include page="../right.jsp" flush="true"/>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <sx:head />
<link rel="stylesheet" href="../style.css" type="text/css" />
<link rel="stylesheet" href="../table.css" type="text/css" />
</head>
<body>
    <div class="subMenu">
        <ul>
            <li class="active"><s:url id="listadoOportunidades" action="listadoOportunidad"/><s:a href="%{listadoOportunidades}" accesskey="l">Listar Oportunidades</s:a></li>
            <li><s:url id="OportunidadCrear" action="OportunidadCrear"/><s:a href="%{OportunidadCrear}" accesskey="c">Crear Oportunidad</s:a></li>
        </ul>

</div>
        <p>&nbsp;</p>
        <p>&nbsp;</p>
           <div class="search_field">
                <s:form action="listadoOportunidad" method="post">
                  <div class="search_form">
                   <table>
                     <tr>
                       <td width = '20%' align="center">
                      <s:select name="estado.nombre" label="Estado" required="true"
                        list="listaEstados" listValue="nombre" listKey="nombre"
                        headerKey="Abierta" value="%{estado.nombre}" disabled="false">
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
<s:set name="listadoOportunidades" value="listadoOportunidades" scope="request"/>
<display:table name="listadoOportunidades" class="queryTable" requestURI="" id="oportunidadesList" export="true" pagesize="5">
    <s:url id="oportunidadDownload" action="oportunidadDownload" method="editar">
        <s:param name="id" value="%{id}"/>
    </s:url>
    <display:column property="id" sortable="true" title="ID"  style="font-size:15px;text-align: center" href="${oportunidadDownload}" paramId="id"/>
    <display:column property="codigoInterno" sortable="true" title="Codigo Interno" style="font-size:15px;text-align: center"/>
    <display:column property="titulo" sortable="true" title="Título" style="font-size:15px;text-align: center"/>
    <display:column property="empresa.nombre" sortable="true" title="Empresa" style="font-size:15px;text-align: center"/>
 
</display:table>
</body>
</html>

