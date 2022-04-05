<%-- 
    Document   : add
    Created on : 2/04/2022, 03:14:26 PM
    Author     : danil
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <title>Agregar</title>
    </head>
    <body>
        <div class="container">
            <div class="col-lg-5">
                <h1>Agregar Persona</h1>
                <%-- Formulario para agregar clientes --%>
                <form action="Controlador">
                    ID:<br>
                    <input class="form-control" type="text" name="textId"><br>
                    Nombre: <br>
                    <input class="form-control" type="text" name="textNombre"><br>
                    Apellido: <br>
                    <input class="form-control" type="text" name="textApellido"><br>
                    Valor prestamo: <br>
                    <input class="form-control" type="text" name="textPrestamo"><br>
                    <input class="btn btn-primary" type="submit" name="accion" value="Agregar">
                </form>
            </div>
        </div>
    </body>
</html>
