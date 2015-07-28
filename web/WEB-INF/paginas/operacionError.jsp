<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@page import="com.suricata.argos.action.ErrorAction"%>
<jsp:include page="right.jsp" flush="true"/>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link rel="stylesheet" href="../style.css" type="text/css" />
</head>
<body>
 <p></p>
  <p></p>
<h1><span>Página de Error</span></h1>
<p class="textSubTitle">
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
                             String msgError = (String)session.getAttribute("ERROR_MSG");
                            // Check if the error was handled
                            if(!handled) {
                                out.println("<B>Causa: </B>" + msgError + "");
                            }
                        %>

</p>
    </body>
</html>