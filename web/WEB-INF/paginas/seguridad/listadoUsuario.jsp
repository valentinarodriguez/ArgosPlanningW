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
            <li class="active"><s:url id="listadoUsuarios" action="listadoUsuario"/><s:a href="%{listadoUsuarios}" accesskey="l">Listar Usuarios</s:a></li>
            <li><s:url id="UsuarioCrear" action="UsuarioCrear"/><s:a href="%{UsuarioCrear}" accesskey="c">Crear Usuario</s:a></li>
        </ul>
     
</div>
        <p>&nbsp;</p>
        <p>&nbsp;</p>
     
<s:set name="listadoUsuarios" value="listadoUsuarios" scope="request"/>
<display:table name="listadoUsuarios" class="queryTable" requestURI="" id="usuariosList" export="true" pagesize="5">
    <display:column property="id" sortable="true" title="ID"  style="font-size:15px;text-align: center" href="UsuarioEditar.action" paramId="id"/>
     <display:column property="nick" sortable="true" title="Usuario" style="font-size:15px;text-align: center"/>
    <display:column property="nombre" sortable="true" title="Nombre" style="font-size:15px;text-align: center"/>
    <display:column property="apellido" sortable="true" title="Apellido" style="font-size:15px;text-align: center"/>
</display:table>
</body>
</html>

<s:url id="paginationurl" action="UsuarioEditar" namespace="/seguridad">
<s:param name="id" value="2"></s:param>
<s:param name="direction" value="forward"></s:param>
</s:url>
<s:a href="%{paginationurl}">Next Record</s:a>