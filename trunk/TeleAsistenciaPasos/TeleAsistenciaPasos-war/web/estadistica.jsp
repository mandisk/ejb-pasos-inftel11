
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
    <head>
        <title>Test Chart</title>
        <link rel="stylesheet" type="text/css" href="estilo.css" />
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
                        <li><a href="/TeleAsistenciaPasos-war/listadoIncidencia"><span>Incidencias</span></a></li>
                        <li><a href="/TeleAsistenciaPasos-war/estadistica.jsp" class="active"><span>Estadisticas</span></a></li>
                    </ul>
                </div>
                <!-- End Main Nav -->
            </div>
        </div>
        <!-- End Header -->
        <!-- Graphic Chart -->
        <div id="grafico">
            <div align=center>
                <img src="EstadisticasServlet" width=600 height=600 border=0 alt="Chart" />
            </div>
        </div>
        <!-- End Graphic Chart -->
        <!-- Footer -->
        <div id="footer" class="footerrel">
            <span class="left">2012 - Teleasistencia</span>
        </div>
        <!-- End Footer -->    
    </body>
</html>

