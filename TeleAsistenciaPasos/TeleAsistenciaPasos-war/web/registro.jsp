<%-- 
    Document   : registro
    Created on : 23-ene-2012, 23:00:28
    Author     : Manuel Valls
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro de usuarios</title>
        <link rel="stylesheet" type="text/css" href="estilo.css" />
    </head>
    <body>
        <!-- Header -->
        <div id="header">
            <div class="shell">
                <div id="top">
                    <h1><a href="#">Registro de usuarios</a></h1>
                </div>
                <!-- End Logo + Top Nav -->
            </div>
        </div>
        <!-- End Header -->

        <!-- Container -->
        <div id="container">
            <div class="shell">
                <br />
                <!-- Main -->
                <div id="main">
                    <div class="cl">&nbsp;</div>

                    <!-- Content -->
                    <div id="content">
                        <form action="procesaNuevoUsuario" method="post" enctype="multipart/form-data">

                            <!-- Form -->
                            <div class="form">
                                <p>
                                    <label>IMEI:</label> 
                                    <input type="text" name="imei" class="field size2" />
                                </p>
                                <p>
                                    <label>Nombre:</label>
                                    <input type="text" class="field size2" name="nombre" />
                                </p>	
                                <p>
                                    <label>Primer Apellido:</label>
                                    <input type="text" class="field size2" name="apellido1" />
                                </p>	
                                <p>
                                    <label>Segundo Apellido:</label>
                                    <input type="text" class="field size2" name="apellido2" />
                                </p>	
                                <p>
                                    <label>Direcci&oacute;n:</label>
                                    <input type="text" class="field size2" name="direccion" />
                                </p>
                                <p>
                                    <label>Localidad:</label>
                                    <input type="text" class="field size2" name="localidad" />
                                </p>
                                <p>
                                    <label>Provincia:</label>
                                    <input type="text" class="field size2" name="provincia" />
                                </p>
                                <p>
                                    <label>Código Postal:</label>
                                    <input type="text" class="field size2" name="codPostal" />
                                </p>
                                <p>
                                    <label>Tel&eacute;fono:</label>
                                    <input type="text" class="field size2" name="telefono" />
                                </p>
                                <p>
                                    <label>E-mail:</label>
                                    <input type="text" class="field size2" name="email" />
                                </p>
                                <p>
                                    <label>Foto:</label>
                                    <input type="file" class="field size2" name="foto" />
                                </p>
                            </div>
                            <!-- End Form -->

                            <!-- Form Buttons -->
                            <div class="buttons">
                                <input type="submit" class="button buttonreg" value="Completar Registro" />
                            </div>
                            <!-- End Form Buttons -->
                        </form>   
                    </div>
                    <!-- End Content -->
                </div>
                <!-- Main -->
            </div>
        </div>
        <!-- End Container -->
        <!-- Footer -->
        <div id="footer" class="footerrel">
            <span class="left">2012 - Teleasistencia</span>
        </div>
        <!-- End Footer -->
    </body>
</html>
