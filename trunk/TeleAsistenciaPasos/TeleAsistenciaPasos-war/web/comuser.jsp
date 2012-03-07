<%-- 
    Document   : incidencias
    Created on : 22-ene-2012, 20:22:56
    Author     : Manuel Valls
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="org.inftel.pasos.beans.PersonaBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="personaBean" scope="request" class="PersonaBean"></jsp:useBean>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Incidencia del usuario</title>
        <link rel="stylesheet" type="text/css" href="estilo.css" />
        <script src="js/jquery-1.7.1.min.js" type="text/javascript"></script>
    </head>
    <body>
        <!-- Header -->
        <div id="header">
            <div class="shell">
                <div id="top">
                    <h1><a href="#">Teleasistencia</a></h1>
                    <div id="top-navigation">
                        Bienvenido <a href="#"><strong>usuario</strong></a>
                        <span>|</span>
                        <a href="#">Ayuda</a>
                        <span>|</span>
                        <a href="#">Ajustes</a>
                        <span>|</span>
                        <a href="#">Cerrar sesi&oacute;n</a>
                    </div>
                </div>
                <!-- End Logo + Top Nav -->

                <!-- Main Nav -->
                <div id="navigation">
                    <ul>
                        <li><a href="/TeleAsistenciaPasos-war/listadoIncidencia" class="active"><span>Incidencias</span></a></li>
                        <li><a href="/TeleAsistenciaPasos-war/estadistica.jsp"><span>Estadisticas</span></a></li>
                    </ul>
                </div>
                <!-- End Main Nav -->
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
                    <div id="contentinfo">

                        <!-- Box -->
                        <div class="box">
                            <!-- Box Head -->
                            <div class="box-head">
                                <h2 class="left">Datos del usuario</h2>
                            </div>
                            <!-- End Box Head -->	

                            <!-- Info User -->
                            <div class="info">
                                <div class="left">
                                    <c:choose>
                                        <c:when test="${personaBean.usuario.foto != null}">
                                            <img src="http://localhost:8080/TeleAsistenciaPasos-war/ServletAvatar?id=${personaBean.usuario.id}&rnd=<%=System.currentTimeMillis()%>" />
                                        </c:when>
                                        <c:otherwise>
                                            <img src="images/foto.jpg"  /> 
                                        </c:otherwise>
                                    </c:choose>
                                </div>
                                <table cellspacing="6">
                                    <tr>
                                        <td><b>Nombre:</b> ${personaBean.usuario.idPersonaFk.nombre}</td> 
                                        <td><b>Apellidos:</b> ${personaBean.usuario.idPersonaFk.apellido1} ${personaBean.usuario.idPersonaFk.apellido2}</td>
                                    </tr>
                                    <tr>
                                        <td><b>Dirección:</b> ${personaBean.usuario.idPersonaFk.direccion}</td>
                                        <td><b>Localidad:</b> ${personaBean.usuario.idPersonaFk.localidad}</td>
                                    </tr>
                                    <tr>
                                        <td><b>Provincia:</b> ${personaBean.usuario.idPersonaFk.provincia}</td>
                                        <td><b>Cod. Postal:</b> ${personaBean.usuario.idPersonaFk.codpostal}</td>
                                    </tr>
                                    <tr>
                                        <td><b>Fecha de Nacimiento:</b> ${personaBean.usuario.idPersonaFk.fecnacimiento}</td>
                                        <td><b>Email:</b> ${personaBean.usuario.idPersonaFk.email}</td>
                                    </tr>
                                </table>
                            </div>
                            <!-- End Info User -->
                            <div class="cl"></div>
                            <!-- Iframe Google Maps -->
                            <iframe width="500" height="400" frameborder="0" scrolling="no" marginheight="0" marginwidth="0" src="http://maps.google.es/?ie=UTF8&amp;t=h&amp;vpsrc=0&amp;ll=36.712192,-4.463968&amp;spn=0.012041,0.018239&amp;z=15&amp;output=embed"></iframe>
                            <br /><small><a href="http://maps.google.es/?ie=UTF8&amp;t=h&amp;vpsrc=0&amp;ll=36.712192,-4.463968&amp;spn=0.012041,0.018239&amp;z=15&amp;source=embed" style="color:#0000FF;text-align:left">Ver mapa más grande</a></small>

                            <!-- End Ifame Google Maps -->

                        </div>
                        <!-- End Box -->


                        <!-- Box -->
                        <div class="box">
                            <!-- Box Head -->
                            <div class="box-head">
                                <h2 class="left">Comunicaci&oacute;n con el usuario</h2>
                            </div>
                            <!-- End Box Head -->

                            <!-- Frame Receptor -->
                            <form action="ServletMensajeria" id="formu" method="post">

                                <!-- Form -->

                                <div class="form">
                                    <p>
                                        <label>Comunicación <span>(con usuario)</span></label>    
                                        <span id="chat"></span>
                                    </p>                                    
                                    <p>
                                        <input type="hidden" name="user" value="1" />
                                        <input type="text" id="msgText" name="msg" style="width: 60%;" />
                                        <input type="hidden" id="sesText" name="sesion" value="${personaBean.usuario.id}" />
                                    </p>	

                                </div>
                                <!-- End Form -->
                                <!-- Form Buttons -->
                                <div class="buttons">
                                    <input type="submit" class="button buttonuser" value="Enviar Mensaje" />
                                </div>
                                <!-- End Form Buttons -->	

                            </form>

                            <!-- End Frame receptor -->

                        </div>
                        <!-- End Box -->


                    </div>
                    <!-- End Content -->

                    <!-- Sidebar -->
                    <div id="sidebar">

                        <!-- Box -->
                        <div class="box">

                            <!-- Box Head -->
                            <div class="box-head">
                                <h2>Familiares</h2>
                            </div>
                            <!-- End Box Head-->

                            <div class="box-content">
                                Info familiares
                            </div>
                        </div>
                        <!-- End Box -->
                    </div>
                    <!-- End Sidebar -->
                    <div class="cl">&nbsp;</div>
                </div>
                <!-- Main -->
            </div>
        </div>
        <!-- End Container -->

        <!-- Footer -->
        <div id="footer">
            <span class="left">2012 - Teleasistencia</span>
        </div>
        <!-- End Footer -->
        <script type="text/javascript">
            var ultimo = -1;
            $("#formu").submit(function() {
                $.ajax({
                    url: "ServletMensajeria",
                    data: $(this).serialize(),
                    success: function(data){
                        $("#chat").html($("#chat").html() + "<div>Teleoperadora: " + $("#msgText").val() + "</div>");
                        ultimo = data;
                        $("#msgText").val("");
                    }
                });
                return false;
            });
            
            $(document).ready(function() {
                setInterval(function() {
                    // Do something every 2 seconds
                    $.ajax({
                        url: "ServletCargarMensajes",
                        data: "ult=" + ultimo + "&tel=0&ses=" + $("#sesText").val(),
                        success: function(data){
                            if (data.length > 5) {
                                $("#chat").html($("#chat").html() + data);
                                ultimo = $(".maroto").html();
                                $(".maroto").removeClass("maroto");
                            }
                                
                        }
                    });
                }, 2000);
            });

        </script>
    </body>
</html>
