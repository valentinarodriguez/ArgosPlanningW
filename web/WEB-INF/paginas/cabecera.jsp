<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="content-type" content="text/html;charset=iso-8859-1" />
	<link rel="stylesheet" href="style.css" type="text/css" />
	<title>Argos Planning</title>
    <style type="text/css">
<!--
.style1 {color: #FF0000}
-->
    </style>
</head>
<body>
	<div class="content">
		<div class="header">
	                      <h1><a href="#" title="Argos Planning"><span class="dark">Argos</span>Planning</a></h1>
                              
                                <span class="dark" align="left"><a href="http://www.suricatateam.com/" title="Suricata">Ir a Suricata</a></span>

                                <span class="dark" align="left"><h4>Bienvenida <s:property value="usuarioVo.nombre"/></h4></span>
                            
	      <p>&nbsp;</p>
                </div>

<div class="bar">
			<ul>
                                <li><s:url id="inicio" action="inicio" namespace="/"/><s:a href="%{inicio}" accesskey="i">Inicio</s:a></li>
                                <li><s:url id="oportunidad" action="listadoOportunidad.action" namespace="/oportunidades"/><s:a href="%{oportunidad}" accesskey="o">Oportunidades</s:a></li>
			  	<li><s:url id="actividad" action="listadoActividad.action" namespace="/oportunidades"/><s:a href="%{actividad}" accesskey="a">Actividades</s:a></li>
			  	<li><s:url id="seguimiento" action="listadoSeguimiento.action" namespace="/oportunidades"/><s:a href="%{seguimiento}" accesskey="s">Seguimientos</s:a></li>
                                <li><s:url id="empresa" action="listadoEmpresa.action" namespace="/oportunidades"/><s:a href="%{empresa}" accesskey="e">Empresas</s:a></li>
				<li><s:url id="contacto" action="listadoContacto.action" namespace="/oportunidades"/><s:a href="%{contacto}" accesskey="c">Contactos</s:a></li>
                                <li><s:url id="listadoUsuarios" action='listadoUsuario.action' namespace="/seguridad" /><s:a href="%{listadoUsuarios}" accesskey="u">Usuarios</s:a></li>
			</ul>
		</div>
             </div>
         </body>
</html>