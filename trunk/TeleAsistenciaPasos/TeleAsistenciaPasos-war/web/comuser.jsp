<%-- 
    Document   : incidencias
    Created on : 22-ene-2012, 20:22:56
    Author     : Manuel Valls
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Incidencias</title>
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
			    <li><a href="incidencias.jsp" class="active"><span>Incidencias</span></a></li>
			    <li><a href="#"><span>Estadisticas</span></a></li>
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
                                            <img src="images/foto.jpg"  /> 
                                            <span>Nombre: Juan</span>
                                            <span>Apellidos: L&oacute;pez Peñalver</span>
                                            <span>Dirección: Calle Larios</span>
                                            <span>Localidad: Malaga</span>
                                            <span>Provincia: Málaga</span>
                                            <span>Cod. Postal: 29014</span>
                                            <span>Fecha de Nacimiento: 14/01/1970</span>
                                            <span>Email: elmejor@gmail.com</span>
                                        </div>
                                        <!-- End Info User -->
                                        
                                        <!-- Iframe Google Maps -->
                                        <iframe width="700" height="400" frameborder="0" scrolling="no" marginheight="0" marginwidth="0" src="http://maps.google.es/?ie=UTF8&amp;t=h&amp;vpsrc=0&amp;ll=36.712192,-4.463968&amp;spn=0.012041,0.018239&amp;z=15&amp;output=embed"></iframe>
                                        <br /><small><a href="http://maps.google.es/?ie=UTF8&amp;t=h&amp;vpsrc=0&amp;ll=36.712192,-4.463968&amp;spn=0.012041,0.018239&amp;z=15&amp;source=embed" style="color:#0000FF;text-align:left">Ver mapa más grande</a></small>
                                        
					<!-- End Ifame Google Maps -->
					
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
    </body>
</html>
