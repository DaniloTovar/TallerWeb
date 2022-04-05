<%-- 
    Document   : index
    Created on : 2/04/2022, 03:13:07 PM
    Author     : Danilo
    
    Codigo apoyado en la siguiente coleccion de videos: Como Hacer CRUD en JAVA JSP con Patron MVC y MYSQL - Parte 1 a 5
        Link: https://www.youtube.com/playlist?list=PLG1l7S-453CauhEV_WAQdHozalUVkP9X7
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="./css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <title>Inicio</title>
    </head>
        <br>
        <br>
        <%-- Boton para acceder a la subpagina listar --%>
        <div class="container">
            <a class="btn btn-success btn-md" href="Controlador?accion=listar">Listar Persona</a>
        </div>
    </body>
</html>
