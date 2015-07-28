<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<jsp:include page="../right.jsp" flush="true"/>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link rel="stylesheet" href="../style.css" type="text/css" />
<link rel="stylesheet" href="../table.css" type="text/css" />
</head>
<body>
    <div class="subMenu">
        <ul>
            <li class="active"><s:url id="listadoContactos" action="listadoContacto"/><s:a href="%{listadoContactos}" accesskey="l">Listar Contactos</s:a></li>
            <li><s:url id="ContactoCrear" action="ContactoCrear"/><s:a href="%{ContactoCrear}" accesskey="c">Crear Contacto</s:a></li>
        </ul>

</div>
        <p>&nbsp;</p>
        <p>&nbsp;</p>

<s:set name="listadoContactos" value="listadoContactos" scope="request"/>
<display:table name="listadoContactos" class="queryTable" requestURI="" id="contactosList" export="true" pagesize="5">
    <display:column property="id" sortable="true" title="ID"  style="font-size:15px;text-align: center" href="ContactoEditar.action" paramId="id"/>
    <display:column property="nombre" sortable="true" title="Nombre" style="font-size:15px;text-align: center"/>
    <display:column property="apellido" sortable="true" title="Apellido" style="font-size:15px;text-align: center"/>

</display:table>
</body>
</html>

<s:url id="paginationurl" action="ContactoEditar" namespace="/seguridad">
<s:param name="id" value="2"></s:param>
<s:param name="direction" value="forward"></s:param>
</s:url>
<s:a href="%{paginationurl}">Next Record</s:a>