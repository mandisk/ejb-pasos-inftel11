<%-- 
    Document   : incidencias
    Created on : 22-ene-2012, 4:46:56
    Author     : Manuel Valls
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="org.inftel.pasos.beans.IncidenciaBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="incidenciaBean" scope="request" class="IncidenciaBean"></jsp:useBean>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Incidencias</title>
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
                        <li><a href="#" class="active"><span>Incidencias</span></a></li>
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
                    <div id="content">

                        <!-- Box -->
                        <div class="box">
                            <!-- Box Head -->
                            <div class="box-head">
                                <h2 class="left">Incidencias</h2>
                            </div>
                            <!-- End Box Head -->	

                            <!-- Table -->
                            <div class="table">
                                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                    <thead>
                                        <tr>
                                            <th>Nombre</th>
                                            <th>Apellidos</th>
                                            <th>Atendido por</th>
                                            <th>Tipo Incidencia</th>
                                            <th>Fecha</th>
                                            <th>Hora</th>
                                            <th>Temperatura</th>
                                            <th>Nivel de batería</th>
                                            <th>Acci&oacute;n</th>
                                        </tr>
                                    </thead>

                                    <tbody id="tBody">
                                        <c:forEach var="order" items="${incidenciaBean.incidenciaCollection}">
                                            <tr>
                                                <td>${order.idUsuarioFk.idPersonaFk.nombre}</td> 
                                                <td>${order.idUsuarioFk.idPersonaFk.apellido1} 
                                                    ${order.idUsuarioFk.idPersonaFk.apellido2}</td> 
                                                <td>${order.idEmpleadoFk.idPersonaFk.nombre} 
                                                    ${order.idEmpleadoFk.idPersonaFk.apellido1}</td> 
                                                <td>${order.idTincidenciaFk.descripcion}</td> 
                                                <td>${order.fecha}</td> 
                                                <td>${order.fecha}</td> 
                                                <td>${order.temperatura}ºC</td> 
                                                <td>${order.nivelBateria}%</td> 
                                                <td><a href="${pageContext.request.contextPath}/comUsuario?action=com&idPersona=${order.idUsuarioFk.id}">Atender Usuario</a></td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>

                                </table>
                                <input type="hidden" id="ultimo" value="${incidenciaBean.ultima}" />

                                <!-- Pagging -->
                                <div class="pagging">
                                    <div class="left">Mostrando 1-12 de 44</div>
                                    <div class="right">
                                        <a href="#">Anterior</a>
                                        <a href="#">1</a>
                                        <a href="#">2</a>
                                        <a href="#">3</a>
                                        <a href="#">4</a>
                                        <a href="#">245</a>
                                        <span>...</span>
                                        <a href="#">Siguiente</a>
                                        <a href="#">Ver todos</a>
                                    </div>
                                </div>
                                <!-- End Pagging -->

                            </div>
                            <!-- Table -->
                        </div>
                        <!-- End Box -->
                        <div class="cl">&nbsp;</div>	
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
        <script type="text/javascript">
            var ultimo = $("#ultimo").val();
            $(document).ready(function() {
                setInterval(function() {
                    // Do something every 2 seconds
                    console.log(ultimo);
                    $.ajax({
                        url: "ServletBuscaIncidencias",
                        data: "ult=" + ultimo,
                        success: function(data){
                            if (data.length > 5) {
                                $("#tBody").prepend(data);
                                ultimo = $(".nuevo").html();
                                $(".nuevo").removeClass("nuevo");
                            }
                                
                        }
                    });
                }, 2000);
            });
        </script>
    </body>
</html>
