<%--
    Document   : login
    Created on : 03/08/2010, 02:09:49 AM
    Author     : Valentina
--%>

<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="content-type" content="text/html;charset=iso-8859-1" />
	<link rel="stylesheet" href="../images/style.css" type="text/css" />
	<title>Argos Planning</title>
    <style type="text/css">
<!--
.style1 {color: #FF0000}
-->
    </style>
</head>
<body>
 
            <div style="background:#F6F6F6;height:400px;">
              
	        <s:form id="loginForm" method="post" action="validarUsuario">
                    <table align="center" width="700px">
            	<tr>
                <td>
                    <img src="images/login.gif" class="image" alt="Imagen Principal" />
                </td>
           
                <td align="center">
                   <table align="center">
                    <tr>
                        <td width="20px" align="center">
                        <s:textfield name="usuario" label="Usuario" required="true"/>
                    </td>
                        </tr>
                         <tr>
                    <td width="20px" align="center">
                        <s:password name="contrasena" label="Contraseña" required="true"/>
                    </td>
                         </tr>
                          <tr>
                    <td width="20px" align="center"><input type="submit" class="submit"  value="Ingresar"/>
                    </td>
                </tr>
                </table>
                </td>
              </tr>
            </table>
        </s:form>
	        <p><br />
          </p>
</div>

</body>
</html>