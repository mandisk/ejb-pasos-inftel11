<%-- 
    Document   : usuario
    Created on : 23-ene-2012, 12:42:52
    Author     : Frank
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:useBean id="beanTerminal" class="org.inftel.pasos.util.terminalDatos" scope="page">
    <jsp:setProperty name="beanTerminal" property="trama" />
    <jsp:setProperty name="beanTerminal" property="alarma" />
    <jsp:setProperty name="beanTerminal" property="ld" />
</jsp:useBean>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Terminal de Usuario</title>
        <link rel="stylesheet" type="text/css" href="estiloterminal.css" />
    </head>
    <body>
        <div class="informacion">
            <h1>Nivel batería:</h1>
        </div>
        
        <div class="interaccion">
            <img src="images/alertar.jpg" ></img>
        </div>
        
        <div class="introducirdatos"> 
            <form action="../servletTerminal" METHOD="POST">
                <p>Alarma: <INPUT TYPE="TEXT" NAME="alarma" SIZE="20"></p>
                <p>GPS Location Date: <INPUT TYPE="TEXT" NAME="ld" SIZE="20"></p>
                <p>GPS Location Time <INPUT TYPE="TEXT" NAME="lh" SIZE="20"></p>
                <p>Longitude: <INPUT TYPE="TEXT" NAME="ln" SIZE="30"></p>
                <p>Latitude: <INPUT TYPE="TEXT" NAME="lt" SIZE="30"></p>
                <p>Level of batery: <INPUT TYPE="TEXT" NAME="pb" SIZE="20"></p>
                <p>Altitude: <INPUT TYPE="TEXT" NAME="la" SIZE="20"></p>
                <p>Temperature: <INPUT TYPE="TEXT" NAME="dt" SIZE="20"></p>
                <p><INPUT TYPE="SUBMIT" VALUE="Introducirdatos"></p>
        </div>
        
        
    </body>
</html>
