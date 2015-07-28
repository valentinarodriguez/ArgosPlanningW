<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:include page="../right.jsp" flush="true"/>
<s:set name="disabled" value="%{estadoId != 1}"/>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link rel="stylesheet" href="../style.css" type="text/css" />
<script type="text/javascript">
    function submitForm(url) {

    // en caso de que hayan componentes optionTransferSelect,
    // se deben seleccionar todos los options de los select para hacer el submit.
        var myForm = document.getElementsByTagName("form")[0];
        myForm.action = url;
        try { //- Hack para el IE6
            myForm.submit();
        } catch (e) {}
    }

</script>
</head>
<body>
      <div class="subMenu">
        <ul>
             <li class="active"><s:url id="OportunidadEdicion" action="OportunidadEdicion"/><s:a href="%{OportunidadEdicion}" accesskey="i">Editar Oportunidad</s:a></li>
             <li><s:url id="OportunidadCrear" action="OportunidadCrear"/><s:a href="%{OportunidadCrear}" accesskey="i">Crear Oportunidad</s:a></li>
          </ul>
    </div>
<p></p>
    	<s:form action="oportunidadDownload" method="post" validate="true" enctype="multipart/form-data"  acceptcharset="UTF-8">
            <s:hidden id="id" name="id" />
            <s:hidden id="estadoId" name="estadoId" />
            <s:hidden id="usuarioId" name="usuarioId" />
            <s:hidden id="fecha" name="fecha" />
            <s:hidden id="fechaCierre" name="fechaCierre" />
             <table>
                <tr>
                    <td width = '50%'><s:textfield name="titulo" label="Titulo" required="true" disabled="#disabled"/></td>
                </tr>
                <tr>
                    <td width = '50%'><s:textfield name="codigoInterno" label="Código Interno" disabled="#disabled"/></td>
                </tr>
                <tr>
                    <td width = '50%'>
                        <s:select name="empresa.id" label="Empresa" required="true"
                        list="listaEmpresas" listValue="nombre" listKey="id"
                        headerKey="" value="%{empresa.id}" disabled="true">
                         </s:select>
                    </td>
                </tr>
                <tr>
                    <td width = '50%'>
                        <s:select name="contacto.id" label="Contacto" required="true"
                        list="listaContactos" listValue="nombre" listKey="id"
                        headerKey="" value="%{contacto.id}" disabled="#disabled">
                         </s:select>
                    </td>
                </tr>
                 <tr>
                       <td width = '50%'>
                        <s:select name="tipoproyecto.id" label="Tipo Proyecto" required="true"
                        list="listaTipoProyectos" listValue="nombre" listKey="id"
                        headerKey="" value="%{tipoproyecto.id}" disabled="#disabled">
                         </s:select>
                    </td>
                </tr>

                 <tr>
                    <td width = '50%'>
                        <s:select name="tecnologia.id" label="Tecnología" required="true"
                        list="listaTecnologias" listValue="nombre" listKey="id"
                        headerKey="" value="%{tecnologia.id}" disabled="#disabled">
                         </s:select>
                    </td>
                </tr>

                <tr>
                       <td width = '50%'><s:textarea name="descripcionCierre" label="Descripción cierre" disabled="#disabled"/></td>
                </tr>
                 <tr>
                      <s:url id="urlCerrar" action="oportunidadDownload" namespace="oportunidades" method="cerrarOportunidad"> </s:url>
                      <td width = '50%'><input type="button" class="submit"  value="Cerrar" onclick="submitForm('${urlCerrar}')" disabled="#disabled"/></td>
                </tr>

                 <tr>
                      <s:url id="urlCancelar" action="oportunidadDownload" namespace="oportunidades" method="cancelarOportunidad"> </s:url>
                      <td><input type="button" class="submit"  value="Cancelar" onclick="submitForm('${urlCancelar}')"/></td>
                </tr>

                <tr>
                    <td class="field">

                        <s:url id="urlDown" action="oportunidadDownload" namespace="oportunidades" method="descargarDocumento">
                            <s:param name="id" value="%{id}"/>
                        </s:url>
                        <s:a href="%{urlDown}" accesskey="i">Descargar Archivo</s:a>
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
                                                  <s:url id="urlSalvar" action="oportunidadDownload" namespace="oportunidades" method="salvar"> </s:url>
                                                  <input type="button" class="submit"  value="Salvar" onclick="submitForm('${urlSalvar}')" disabled="#disabled"/>

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