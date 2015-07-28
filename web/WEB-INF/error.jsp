<%@ page language="java" pageEncoding="UTF-8"%>
<%@page import="org.apache.log4j.Logger"%>
<%@page import="com.suricata.argos.action.ErrorAction"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

	
	<body style="text-align:center" class="tundra">
		<div id="container" align="center" >

			<div style="clear:both;"></div>
			<div id="mainBody">
				<div id="formContainer">
					

		<div id="login" style="height:300px; margin-top:60px">

		<h1><span>Página de Error</span></h1>
	
		<div style="width: 384px; font-size:12px;text-align:left" class="formBody">
			<p class="textSubTitle">Información</p>
<%
							    boolean handled = false; // Set to true after handling the error
							    
							    // Get the PageContext
							    if(pageContext != null) {
							    
							        // Get the ErrorData
							        ErrorData ed = null;
							        try {
							            ed = pageContext.getErrorData();
							        } catch(NullPointerException ne) {
							            // If the error page was accessed directly, a NullPointerException
							            // is thrown at (PageContext.java:514).
							            // Catch and ignore it... it effectively means we can't use the ErrorData
							        }
							
							        // Display error details for the user
							        if(ed != null) {
							    
							            // Output this part in HTML just for fun
						    
							            // Output details about the HTTP error
							            // (this should show error code 404, and the name of the missing page)
							            out.println("<B>Código de Error: </B>" + ed.getStatusCode() + "<br/>");
							            out.println("<B>URL: </B>" + ed.getRequestURI()+ "");
							    
							            // Error handled successfully, set a flag
							            handled = true;
							        }
							    }
							    
							    // Check if the error was handled
							    if(!handled) {
							    %>
							        <p />No existe información sobre el error.
							    <%
							    }
							%>
							<br/>
							<br/>  
		</div>
	
	</div>

				</div>
			</div>
			<div style="clear:both;"></div>
			<div id="push"></div>
		</div>
		
<div id="copyright"><span></span></div>
	</body>
</html>


