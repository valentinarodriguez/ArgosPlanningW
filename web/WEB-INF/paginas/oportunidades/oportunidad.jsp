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
                <li class="active"> <s:url id="urlEdicion" action="oportunidadDownload" namespace="oportunidades" method="editar"> </s:url><s:a href="%{OportunidadEdicion}" accesskey="i">Editar Oportunidad</s:a></li>
                <li><s:url id="OportunidadCrear" action="OportunidadCrear"/><s:a href="%{OportunidadCrear}" accesskey="i">Crear Oportunidad</s:a></li>
              </s:if>
               <s:else>
                      <li class="active"><s:url id="OportunidadCrear" action="OportunidadCrear"/><s:a href="%{OportunidadCrear}" accesskey="i">Crear Oportunidad</s:a></li>
               </s:else>
          </ul>
    </div>
<p></p>
    	<s:form action="OportunidadSalvar" method="post" validate="true" enctype="multipart/form-data"  acceptcharset="UTF-8">
            <s:hidden id="id" name="id" />
            <s:hidden id="estado" name="estado" />
            <s:hidden id="usuario" name="usuario" />
            <s:hidden id="fecha" name="fecha" />
             <table>
                <tr>
                    <td width = '50%'><s:textfield name="titulo" label="Titulo" required="true"/></td>
                </tr>
                <tr>
                    <td width = '50%'><s:textfield name="codigoInterno" label="Código Interno"/></td>
                </tr>
                <tr>
                       <td width = '50%'>
                        <s:select name="empresa.id" label="Empresa" required="true"
                        list="listaEmpresas" listValue="nombre" listKey="id"
                        headerKey="" value="%{empresa.id}">
                         </s:select>
                    </td>
                </tr>
                <tr>
                    <td width = '50%'>
                        <s:select name="contacto.id" label="Contacto" required="true"
                        list="listaContactos" listValue="nombre" listKey="id"
                        headerKey="" value="%{contacto.id}">
                         </s:select>
                    </td>
                </tr>
                 <tr>
                       <td width = '50%'>
                        <s:select name="tipoproyecto.id" label="Tipo Proyecto" required="true"
                        list="listaTipoProyectos" listValue="nombre" listKey="id"
                        headerKey="" value="%{tipoproyecto.id}">
                         </s:select>
                    </td>
                </tr>

                 <tr>
                    <td width = '50%'>
                        <s:select name="tecnologia.id" label="Tecnología" required="true"
                        list="listaTecnologias" listValue="nombre" listKey="id"
                        headerKey="" value="%{tecnologia.id}">
                         </s:select>
                    </td>
                </tr>

                <tr>
                    <s:if test="%{#id != null}">
                        <td width = '50%'><s:textarea name="descripcionCierre" label="Descripción cierre"/></td>
                    </s:if>
                </tr>
                 <tr>
                     <td width = '50%'>
                         <s:file id="archivo" name="archivo" labelposition="top" label="Archivo" >
                        </s:file>
                     </td>
                </tr>
                <tr>
                    <td class="field">
                         <s:textfield label="Nombre archivo" name="nombreDocumento"/>
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

    </body>
</html>