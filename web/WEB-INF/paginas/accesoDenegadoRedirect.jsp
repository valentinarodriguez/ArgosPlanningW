<%@page import="com.suricata.argos.action.ErrorAction"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<%
 	session.setAttribute(ErrorAction.CLAVE_SESION_EXCEPTION, request
			.getAttribute(ErrorAction.REQUEST_ATTRIBUTE_EXCEPTION));
	session.setAttribute(ErrorAction.CLAVE_SESION_EXCEPTION_STACK, request
			.getAttribute(ErrorAction.REQUEST_ATTRIBUTE_EXCEPTION_STACK));

	session.setAttribute(ErrorAction.ERROR_ACCESO_DENEGADO,ErrorAction.ERROR_ACCESO_DENEGADO_EXCEP);
	response.sendRedirect(ErrorAction.ACTION_URL);
%>  
