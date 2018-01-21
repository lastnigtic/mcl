<%@ page import="com.mcl.pojo.Account" %>
<%@ page import="com.mcl.common.Const" %>
<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%
    Account account = (Account)session.getAttribute(Const.CURRENT_USER);
    if(account==null) response.sendRedirect("/index.html");
%>
