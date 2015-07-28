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
                <li class="active"><s:url id="ContactoEdicion" action="ContactoEdicion"/><s:a href="%{ContactoEdicion}" accesskey="i">Editar Contacto</s:a></li>
                <li><s:url id="ContactoCrear" action="ContactoCrear"/><s:a href="%{ContactoCrear}" accesskey="i">Crear Contacto</s:a></li>
              </s:if>
               <s:else>
                      <li class="active"><s:url id="ContactoCrear" action="ContactoCrear"/><s:a href="%{ContactoCrear}" accesskey="i">Crear Contacto</s:a></li>
               </s:else>
          </ul>
    </div>
<p></p>
    	<s:form action="ContactoSalvar" method="post" validate="true">
              <s:hidden id="id" name="id" />
             <table>
                <tr>
                    <td width = '50%'><s:textfield name="nombre" label="Nombre" required="true"/></td>
                </tr>
                <tr>
                        <td width = '50%'><s:textfield name="apellido" label="Apellido" required="true"/></td>
                </tr>
                <tr>
                        <td width = '50%'><s:textfield name="chat" label="Chat"/></td>
                </tr>
                <tr>
                        <td width = '50%'><s:textfield name="telefono" label="Telefono"/></td>
                </tr>

                 <tr>
                        <td width = '50%'><s:textfield name="celular" label="Celular"/></td>
                </tr>

                 <tr>
                        <td width = '50%'><s:textfield name="cargo" label="Cargo" /></td>
                </tr>

                <tr>
                        <td width = '50%'><s:textfield name="email" label="Email"/></td>
                </tr>
                  <tr>
                      <td width = '50%'><s:textarea name="comentarios" label="Comentarios"/></td>
                </tr>
                 <tr>
                      <td width = '50%'>
                    <s:select name="empresa.id" label="Empresa" required="true"
                            list="listaEmpresas" listValue="nombre" listKey="id"
                            headerKey="" value="%{empresa.id}">
                    </s:select>

                    </td>
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

<s:url id="paginationurl" action="ContactoEditar" namespace="/seguridad">
<s:param name="id" value="2"></s:param>
<s:param name="direction" value="forward"></s:param>
</s:url>
<s:a href="%{paginationurl}">Next Record</s:a>
    </body>
</html>