<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<jsp:include page="../right.jsp" flush="true"/>
<s:set name="disabled" value="%{estadoId != 1}"/>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<sx:head />
<link rel="stylesheet" href="../style.css" type="text/css" />
<script type="text/javascript">
      function submitForm(url) {

    // en caso de que hayan componentes optionTransferSelect,
    // se deben seleccionar todos los options de los select para hacer el submit.

    var myForm = document.getElementsByTagName('form')[0];

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
              <s:if test="%{id != null}">
                <li class="active"><s:url id="ActividadEdicion" action="ActividadEdicion"/><s:a href="%{ActividadEdicion}" accesskey="i">Editar Actividad</s:a></li>
                <li><s:url id="ActividadCrear" action="ActividadCrear"/><s:a href="%{ActividadCrear}" accesskey="i">Crear Actividad</s:a></li>
              </s:if>
               <s:else>
                      <li class="active"><s:url id="ActividadCrear" action="ActividadCrear"/><s:a href="%{ActividadCrear}" accesskey="i">Crear Actividad</s:a></li>
               </s:else>
          </ul>
    </div>
<p></p>

    	<s:form action="actividadDownload" id="downloadForm" method="post" validate="true" acceptcharset="UTF-8" enctype="multipart/form-data" >
            	<s:form action="actividadDownload" id="salvarForm" method="post" validate="true" >
                <s:hidden id="id" name="id" />
                <s:hidden id="estadoId" name="estadoId" />
                <s:hidden id="usuarioId" name="usuarioId" />
                <s:hidden id="fechaCreacion" name="fechaCreacion" />
                 <s:hidden id="descripcionCierre" name="descripcionCierre" />

             <table>
                <tr>
                    <td width = '50%'><s:textfield name="titulo" label="Titulo" required="true" disabled="#disabled"/></td>
                </tr>
                <tr>
                       <td width = '50%'>
                        <s:select name="empresa.id" label="Empresa" required="true"
                        list="listaEmpresas" listValue="nombre" listKey="id"
                        headerKey="" value="%{empresa.id}" disabled="#disabled">
                         </s:select>
                    </td>
                </tr>
                <tr>
                    <td width = '50%'>
                        <s:select name="oportunidad.id" label="Oportunidad" required="true"
                        list="listaOportunidades" listValue="titulo" listKey="id"
                        headerKey="" value="%{oportunidad.id}" disabled="#disabled">
                         </s:select>
                    </td>
                </tr>
                 <tr>
                       <td width = '50%'>
                        <s:select name="tipoactividad.id" label="Tipo Actividad" required="true"
                        list="listaTipoActividad" listValue="nombre" listKey="id"
                        headerKey="" value="%{tipoactividad.id}" disabled="#disabled">
                         </s:select>
                    </td>
                </tr>
                <tr>
                    <td width = '50%'><s:textarea name="descripcion" label="Descripción"/></td>
                </tr>
                 <tr>
                    <td width = '50%'>
                        <s:select name="usuarioResponsable.id" label="Responsable Usuario" required="true"
                        list="listaResponsablesUsuarios" listValue="nombre" listKey="id"
                        headerKey="" value="%{usuarioResponsable.id}" disabled="#disabled">
                         </s:select>
                    </td>
                </tr>
                  <tr>
                    <td width = '50%'>
                        <s:select name="contactoResponsable.id" label="Responsable Cliente" required="true"
                        list="listaContactos" listValue="nombre" listKey="id"
                        headerKey="" value="%{contactoResponsable.id}" disabled="#disabled">
                         </s:select>
                    </td>
                </tr>
                 <tr>
                    <td width = '50%'>
                     <sx:datetimepicker name="fechaVencimiento" label="Vencimiento" displayFormat="dd-MMM-yyyy" value="%{'today'}" disabled="#disabled"/>
                    </td>
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
                    <td width = '50%'>

                            <s:url id="urlDown" action="actividadDownload" namespace="oportunidades" method="descargarDocumento">
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
                                             <s:url id="urlSalvar" action="actividadDownload" namespace="oportunidades" method="salvar"> </s:url>
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
            </s:form>
    </body>
</html>

