<%-- 
    Document   : prueba
    Created on : 24-ene-2012, 11:28:08
    Author     : inftel
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="org.inftel.pasos.beans.TramaBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="t" scope="request" class="TramaBean"></jsp:useBean>
    
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello ${t.date}</h1>
    </body>
</html>
