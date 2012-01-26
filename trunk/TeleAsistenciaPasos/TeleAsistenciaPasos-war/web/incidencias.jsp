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
							<c:forEach var="order" items="${incidenciaBean.incidenciaCollection}">
                                                            <tr>
                                                                <td>${order.idUsuario.idPersona.nombre}</td> 
                                                                <td>${order.idUsuario.idPersona.apellido1} 
                                                                    ${order.idUsuario.idPersona.apellido2}</td> 
                                                                <td>${order.idEmpleado.idPersona.nombre} 
                                                                    ${order.idEmpleado.idPersona.apellido1}</td> 
                                                                <td>${order.idTincidencia.descripcion}</td> 
                                                                <td>${order.fecha}</td> 
                                                                <td>${order.fecha}</td> 
                                                                <td>${order.temperatura}ºC</td> 
                                                                <td>${order.nivelBateria}%</td> 
                                                                <td><a href="${pageContext.request.contextPath}/comUsuario?action=com&idPersona=${order.idUsuario.idUsuario}">Atender Usuario</a></td>
                                                            </tr>
                                                        </c:forEach>
                                                        <tr>
                                                                <td>Jose</td>
                                                                <td>Rodríguez Rodríguez</td>
                                                                <td>Juana Acosta</td>
                                                                <td>Accidente</td>
                                                                <td>17/01/2012</td>
                                                                <td>17:15</td>
                                                                <td>7ºC</td>
                                                                <td>50%</td>
                                                                <td><a href="comuser.jsp">Atender Usuario</a></td>
                                                        </tr>
                                                         <tr class="odd">
                                                                <td>Juana</td>
                                                                <td>Rodríguez Rodríguez</td>
                                                                <td>Jose Acosta</td>
                                                                <td>Accidente</td>
                                                                <td>18/01/2012</td>
                                                                <td>13:15</td>
                                                                <td>8ºC</td>
                                                                <td>50%</td>
                                                                <td><a href="#">Atender Usuario</a></td>
                                                        </tr>
                                                         <tr>
                                                                <td>Ana</td>
                                                                <td>García Rodríguez</td>
                                                                <td>Antonio Acosta</td>
                                                                <td>Accidente</td>
                                                                <td>19/01/2012</td>
                                                                <td>17:35</td>
                                                                <td>9ºC</td>
                                                                <td>80%</td>
                                                                <td><a href="#">Atender Usuario</a></td>
                                                        </tr>
                                                         <tr class="odd">
                                                                <td>Rodrigo</td>
                                                                <td>Rodríguez Rodríguez</td>
                                                                <td>Felipe Acosta</td>
                                                                <td>Accidente</td>
                                                                <td>12/01/2012</td>
                                                                <td>11:15</td>
                                                                <td>10ºC</td>
                                                                <td>50%</td>
                                                                <td><a href="#">Atender Usuario</a></td>
                                                        </tr>
                                                         <tr>
                                                                <td>Francisco</td>
                                                                <td>Garcia Rodríguez</td>
                                                                <td>Juan Acosta</td>
                                                                <td>Accidente</td>
                                                                <td>17/12/2011</td>
                                                                <td>12:15</td>
                                                                <td>9ºC</td>
                                                                <td>50%</td>
                                                                <td><a href="#">Atender Usuario</a></td>
                                                                </tr>
            
						</table>
						
						
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
    </body>
</html>
