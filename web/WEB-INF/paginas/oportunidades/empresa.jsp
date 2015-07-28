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
    
                      <li class="active"><s:url id="EmpresaCrear" action="EmpresaCrear"/><s:a href="%{EmpresaCrear}" accesskey="i">Crear Empresa</s:a></li>
            
          </ul>
    </div>
<p></p>
    	<s:form action="EmpresaSalvar" method="post" validate="true">
              <s:hidden id="id" name="id" />
             <table>
                <tr>
                    <td width = '50%'><s:textfield name="nombre" label="Nombre" required="true"/></td>
                </tr>
                <tr>
                        <td width = '50%'><s:textfield name="rut" label="Rut"/></td>
                </tr>
                <tr>
                        <td width = '50%'><s:textfield name="telefono" label="Telefono"/></td>
                </tr>

                 <tr>
                        <td width = '50%'><s:textfield name="rubro" label="Rubro"/></td>
                </tr>

                 <tr>
                        <td width = '50%'><s:textfield name="direccion" label="Direccion"/></td>
                </tr>

                <tr>
                        <td width = '50%'><s:textarea name="descripcion" label="Descripción"/></td>
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

<s:url id="paginationurl" action="EmpresaEditar" namespace="/seguridad">
<s:param name="id" value="2"></s:param>
<s:param name="direction" value="forward"></s:param>
</s:url>
<s:a href="%{paginationurl}">Next Record</s:a>
    </body>
</html>