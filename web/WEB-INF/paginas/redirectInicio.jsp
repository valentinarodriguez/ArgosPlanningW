<%@page import="com.suricata.argos.action.LoginAction"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<%
	response.sendRedirect(LoginAction.REDIR_INICIO);
%>  
