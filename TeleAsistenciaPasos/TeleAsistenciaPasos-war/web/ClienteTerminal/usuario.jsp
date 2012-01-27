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
        <link rel="stylesheet" type="text/css" href="../estilo.css" />
        <script src="../js/jquery-1.7.1.min.js" type="text/javascript"></script>
    </head>
    <body id="screenlog">
        <div class="contenlog">
            <br></br>
            <p><span>Terminal de Usuario</span></p>

            <div class="form"> 
                <form action="../servletTerminal" METHOD="POST">
                    <p>Alarma: <p><INPUT TYPE="TEXT" NAME="alarma" SIZE="20"></p></p>
                    <p>GPS Location Date: <p><INPUT TYPE="TEXT" NAME="ld" SIZE="20"></p></p>
                    <p>GPS Location Time: <p><INPUT TYPE="TEXT" NAME="lh" SIZE="20"></p></p>
                    <p>Longitude: <p><INPUT TYPE="TEXT" NAME="ln" SIZE="30"></p></p>
                    <p>Latitude: <p><INPUT TYPE="TEXT" NAME="lt" SIZE="30"></p></p>
                    <p>Level of batery: <p><INPUT TYPE="TEXT" NAME="pb" SIZE="20"></p></p>
                    <p>Altitude: <p><INPUT TYPE="TEXT" NAME="la" SIZE="20"></p></p>
                    <p>Temperature: <p><INPUT TYPE="TEXT" NAME="dt" SIZE="20"></p></p>
                    <p>Imei: <p><INPUT TYPE="TEXT" NAME="rd" SIZE="20"></p></p>
                    <select name="cliente" id="cliente">
                    </select>
                    <br></br>
                    <p><INPUT TYPE="SUBMIT" VALUE="Introducir Datos"></p>
            </div>
        </div>
        <script type="text/javascript">
            
            $(document).ready(function() {
                $.ajax({
                    url: "../ServletCargaSelect",
                    success: function(data){
                        $("#cliente").html(data);                                
                    }
                });
            });

        </script>
    </body>
</html>
