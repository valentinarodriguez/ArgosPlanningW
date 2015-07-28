<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:include page="../right.jsp" flush="true"/>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link rel="stylesheet" href="../style.css" type="text/css" />
</head>
<body>
      <div class="subMenu">
        <ul>
              <s:if test="%{id != null}">
                <li class="active"><s:url id="UsuarioEdicion" action="UsuarioEdicion"/><s:a href="%{UsuarioEdicion}" accesskey="i">Editar Usuario</s:a></li>
                <li><s:url id="UsuarioCrear" action="UsuarioCrear"/><s:a href="%{UsuarioCrear}" accesskey="i">Crear Usuario</s:a></li>
              </s:if>
               <s:else>
                      <li class="active"><s:url id="UsuarioCrear" action="UsuarioCrear"/><s:a href="%{UsuarioCrear}" accesskey="i">Crear Usuario</s:a></li>
               </s:else>
          </ul>
    </div>
<p></p>
    	<s:form action="UsuarioSalvar" method="post" validate="true">
            <s:hidden id="id" name="id" />
             <table>
                <tr>
                    <td width = '50%'><s:textfield name="nombre" label="Nombre" required="true"/></td>
                </tr>
                <tr>
                        <td width = '50%'><s:textfield name="apellido" label="Apellido" required="true"/></td>
                </tr>
                <tr>
                    <s:if test="%{#id != null}">
                        <td width = '50%'><s:textfield name="nick" label="Nick" required="true" readonly="true"/></td>
                    </s:if>
                    <s:else>
                         <td width = '50%'><s:textfield name="nick" label="Nick" required="true"/></td>
                    </s:else>
                    
             </tr>
                <tr>
                        <td width = '50%'><s:textfield name="telefono" label="Telefono"/></td>
                </tr>

                 <tr>
                        <td width = '50%'><s:textfield name="celular" label="Celular"/></td>
                </tr>

                 <tr>
                        <td width = '50%'><s:textfield name="cargo" label="Cargo" required="true"/></td>
                </tr>

                <tr>
                        <td width = '50%'><s:textfield name="email" label="Email" required="true"/></td>
                </tr>

                 <tr>
                        <td width = '50%'><s:password name="contrasena" label="Contraseña" required="true"/></td>
                </tr>
        
        </table>
           	<table>
                    <tr>
                        <td width="724">
                            <blockquote>
                              <blockquote>
                                <blockquote>
                                  <blockquote>
                                    <blockquote>
                                      <blockquote>
            			                  <blockquote>
                                                      <input type="submit" class="submit"  value="Salvar"/>
                                        </blockquote>
                                      </blockquote>
                                    </blockquote>
                                  </blockquote>
                                </blockquote>
                              </blockquote>
                            </blockquote></td>
          
              </tr>
          	</table>
     	</s:form>

<s:url id="paginationurl" action="UsuarioEditar" namespace="/seguridad">
<s:param name="id" value="2"></s:param>
<s:param name="direction" value="forward"></s:param>
</s:url>
<s:a href="%{paginationurl}">Next Record</s:a>
    </body>
</html>