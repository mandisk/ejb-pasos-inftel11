<%-- 
    Document   : index
    Created on : Jan 20, 2012, 7:55:07 AM
    Author     : Manuel Valls
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inicio de sesi&oacute;n</title>
        <link rel="stylesheet" type="text/css" href="estilo.css" />
    </head>
    <body id="screenlog">
        <!-- Log in -->
        <div id="contenlog">
            <span>Teleasisencia para escaladores</span>

            <!-- Logo User -->
            <div id="logouser"></div>
            <!-- End Logo User -->
            <form action="/TeleAsistenciaPasos-war/ServletLogin" method="post">
                <!-- Form -->
                <div class="form">
                    <p>
                        <label>Usuario:</label>
                        <input type="text" name="usuario" class="field size2" />
                    </p>	
                    <p>
                        <label>Contraseña:</label>
                        <input type="password" name="password" class="field size2" />
                    </p>
                </div>
                <!-- End Form -->
                <!-- Form Buttons -->
                <div class="buttons">
                    <input type="submit" class="button buttonlog" value="Entrar" />
                </div>
                <!-- End Form Buttons -->
            </form>
            <a class="newuser" href="/TeleAsistenciaPasos-war/registro.jsp">¿Nuevo usuario? Reg&iacute;strate</a>
        </div>
        <!-- End Log in -->
    </body>
</html>
