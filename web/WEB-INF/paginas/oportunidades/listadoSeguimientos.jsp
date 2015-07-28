<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
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
            <li class="active"><s:url id="listadoSeguimientos" action="listadoSeguimiento"/><s:a href="%{listadoSeguimientos}" accesskey="l">Listar Seguimientos</s:a></li>
            <li><s:url id="SeguimientoCrear" action="SeguimientoCrear"/><s:a href="%{SeguimientoCrear}" accesskey="c">Crear Seguimiento</s:a></li>
        </ul>

</div>
            <p>&nbsp;</p>
           <div class="search_field">
                <s:form action="listadoSeguimiento" method="post">
                  <div class="search_form">
                   <table>
                     <tr>
                       <td width = '20%' align="center">
                    <label>Enviado</label>
                    <s:checkbox name="enviado"/>
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
<s:set name="listadoSeguimientos" value="listadoSeguimientos" scope="request"/>
<display:table name="listadoSeguimientos" class="queryTable" requestURI="" id="seguimientosList" export="true" pagesize="5">
    <display:column property="id" sortable="true" title="ID"  style="font-size:15px;text-align: center" href="SeguimientoEditar.action" paramId="id"/>
    <display:column property="actividad.titulo" sortable="true" title="Actividad" style="font-size:15px;text-align: center"/>
    <display:column property="fechaVencimiento" sortable="true" title="Fecha Vencimiento" style="font-size:15px;text-align: center" format="{0,date,dd/MM/yyyy HH:mm}" />
</display:table>
</body>
</html>

