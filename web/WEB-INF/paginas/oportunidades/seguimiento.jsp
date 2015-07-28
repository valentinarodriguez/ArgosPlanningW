<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<jsp:include page="../right.jsp" flush="true"/>
<s:set name="disabled" value="%{enviado == true}"/>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <sx:head />
<link rel="stylesheet" href="../style.css" type="text/css" />
</head>
<body>
      <div class="subMenu">
        <ul>
              <s:if test="%{id != null}">
                <li class="active"><s:url id="SeguimientoEdicion" action="SeguimientoEdicion"/><s:a href="%{SeguimientoEdicion}" accesskey="i">Editar Seguimiento</s:a></li>
                <li><s:url id="SeguimientoCrear" action="SeguimientoCrear"/><s:a href="%{SeguimientoCrear}" accesskey="i">Crear Seguimiento</s:a></li>
              </s:if>
               <s:else>
                      <li class="active"><s:url id="SeguimientoCrear" action="SeguimientoCrear"/><s:a href="%{SeguimientoCrear}" accesskey="i">Crear Seguimiento</s:a></li>
               </s:else>
          </ul>
    </div>
<p></p>
    	<s:form action="SeguimientoSalvar" method="post" validate="true">
            <s:hidden id="id" name="id" />
            <s:hidden id="usuarioId" name="usuarioId" />
            <s:hidden id="fecha" name="fecha" />
            <s:hidden id="enviado" name="enviado" />
             <table>
         
                <tr>
                       <td width = '20%'>
                        <s:select name="actividad.id" label="Actividad" required="true"
                        list="listaActividades" listValue="titulo" listKey="id"
                        headerKey="" value="%{actividad.id}" disabled="#disabled" >
                         </s:select>
                    </td>
                </tr>
                <tr>
                    <td width = '20px' align="center">
                        <img src="../images/email.jpg" class="image" alt="Imagen Email" />
                    </td>
                    <td width = '20px' align="center">
                        <img src="../images/sms.jpg" class="image" alt="Imagen SMS" />
                    </td>
                </tr>
                 <tr>
                     <td width = '20px' align="center">
                        <s:checkbox name="email" disabled="#disabled"  />
                    </td>
                    <td width = '20px' align="center">
                        <s:checkbox name="sms" disabled="#disabled" />
                    </td>
                </tr>
                <tr>
                    <td width = '70%'>
                        <sx:datetimepicker name="fechaVencimiento" label="Vencimiento" displayFormat="dd-MM-yyyy" value="%{'today'}" required="true" disabled="#disabled" />
                    </td>
                </tr>
                 <tr>
                    <td width = '50%'>
                        <s:textfield name="horaVencimiento" label="Hora Vencimiento" required="true" maxlength="5" size="5px" disabled="#disabled" />
                    </td>
                </tr>
                <tr>
                    <td width = '70%'>
                        <sx:datetimepicker name="fechaAnuncio" label="Anuncio (dd-MMM-yyyy)" displayFormat="dd-MMM-yyyy" value="%{'today'}" disabled="#disabled" />
                    </td>
                </tr>
                 <tr>
                    <td width = '50%'>
                        <s:textfield name="horaAnuncio" label="Hora Anuncio" required="true" maxlength="5" size="5px" disabled="#disabled"  />
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