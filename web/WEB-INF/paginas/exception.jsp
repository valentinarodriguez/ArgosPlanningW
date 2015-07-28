<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
		<br/>
		<br/>
		<br/>
		<a href="#nowhere" onclick="document.getElementById('mensaje').style.display='block'"><s:text name="titulo.VerDetalle"></s:text></a>
		<div id="mensaje" style="display:none">
		<table width="100%" border="0" cellspacing="20" cellpadding="0">
		    <tr>
		     <td class="textomensage" style="text-align:left">
				<h2><s:text name="titulo.ErrorInesperado"></s:text></h2>
				  <p>
				  	<s:text name="mensaje.ErrorInesperado"></s:text>
				  </p>
				  <hr/>
				  <h3><s:text name="titulo.MensajeError"></s:text></h3>
				    <s:actionerror/>
				    <p>
				      <s:property value="exception.message"/>
				    </p>
				    <hr/>
				    <h3><s:text name="titulo.DetallesTecnicos"></s:text></h3>
				    <p>
				    	<s:property value="exceptionStack" escape="false" />
				    </p>
				    
		     </td>
		    </tr>
		</table>
		</div>
		
	<script type="text/javascript">
	    dojo.require("dijit.Dialog");
	</script>

	<div id="modalException" dojoType="dijit.Dialog" title="<s:text name="ventana.erroresAccion"/>" style="display:none">
		<div>
			<table>
				<tr>
					<td style="vertical-align:top"><img src="<s:url value='/imagenes/CWIcoMsgBoxError.gif' encode='false' includeParams='none'/>"/></td>
					<td style="padding-left:10px">
						<span class="errorMessage"><s:text name="error.Ejecucion"/></span>
					</td>
				</tr>	
			</table>
		</div>
	</div>

	<script type="text/javascript">
		dojo.addOnLoad(function(){
			dijit.byId("modalException").show();
  		});        						
	</script>