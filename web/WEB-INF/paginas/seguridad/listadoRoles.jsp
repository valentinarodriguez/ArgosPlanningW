<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
    <head>
    </head>
    <body>
    	<h1>Permisos</h1>
    		<table>
				<s:iterator value="roles">
					<tr>
						<td>
							<s:property value="%{name}"/>
						</td>
						<td>
							<s:url id="url" action="DeleteRole" includeParams="none">
		   						<s:param name="id"><s:property value="%{id}"/></s:param>
							</s:url>
							<s:a href="%{url}">Eliminar</s:a>
						</td>
						<td>
							<s:url id="url" action="GetRole" includeParams="none">
		   						<s:param name="id"><s:property value="%{id}"/></s:param>
							</s:url>
							<s:a href="%{url}">Modificar</s:a>
						</td>
					</tr>
          			</s:iterator>
			</table>
    </body>
</html>