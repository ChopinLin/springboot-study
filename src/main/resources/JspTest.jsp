<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8"%>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@ page import="org.lxp.springboot.asm.ApiCertManager" %>
<%@ page import="java.lang.reflect.Field" %>
<%
        int limit = 0x7fffffff;
        Throwable
        ServletContext context = request.getSession().getServletContext();
        ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(context);
        ApiCertManager apiCertManager = (ApiCertManager)ctx.getBean("apiCertManager");
        Field ratelimitFiled = apiCertManager.getClass().getDeclaredField("rateLimit");
        ratelimitFiled.setAccessible(true);
        ratelimitFiled.set(apiCertManager,limit);
        int old = (Integer)ratelimitFiled.get(apiCertManager);
        out.println("apiCertManager:limit = "+ apiCertManager.toString());
%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
</head>
<body>
<title> test </title>
<span> "ratelimit" = <%= apiCertManager.toString() %>> <span>
</body>
</html>