<%-- 
    Document   : altaUsuario
    Created on : Jan 21, 2012, 6:31:21 PM
    Author     : aljiru
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Crear nuevo usuario</title>
    </head>
    <body>
        <h1>Formulario: Crear Nuevo Usuario</h1>
        <form action="procesaNuevoUsuario" method="POST" name="formulario">
            <p>
                IMEI: <input type="text" name="imei"/>
            </p>
            <p>
                Nombre: <input type="text" name="nombre" />
            </p>
            <p>
                Apellido 1: <input type="text" name="apellido1" />
            </p>
            <p>
                Apellido 2: <input type="text" name="apellido2" />
            </p>
            <p>
                Dirección: <input type="text" name="direccion" />
            </p>
            <p>
                Localidad: <input type="text" name="localidad" />
            </p>
            <p>
                Provincia: <input type="text" name="provincia" />
            </p>
            <p>
                Código Postal: <input type="text" name="codPostal" />
            </p>
            <p>
                Teléfono: <input type="text" name="telefono" />
            </p>
            <p>
                E-mail: <input type="text" name="email" />
            </p>
            <p>
                Foto: <input type="file" name="foto" />
            </p>
            <input type="submit" value="Crear Usuario" />
        </form>
    </body>
</html>
