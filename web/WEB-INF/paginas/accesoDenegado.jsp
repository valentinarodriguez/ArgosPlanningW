<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

	<script type="text/javascript">
	    dojo.require("dijit.Dialog");
	</script>

	<div id="modalAccesoDenegado" dojoType="dijit.Dialog" title="<s:text name="ventana.erroresAccion"/>" style="display:none">
		<div>
			<table>
				<tr>
					<td style="vertical-align:top"><img src="<s:url value='/imagenes/CWIcoMsgBoxError.gif' encode='false' includeParams='none'/>"/></td>
					<td style="padding-left:10px">
							<span class="errorMessage"><s:text name="error.AccesoDenegado"/></span>
					</td>
				</tr>	
			</table>
		</div>
	</div>

	<script type="text/javascript">
		  dojo.addOnLoad(function(){
				dijit.byId("modalAccesoDenegado").show();
  		});        						
	</script>
