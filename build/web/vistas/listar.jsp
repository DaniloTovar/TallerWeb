<%-- 
    Document   : listar
    Created on : 2/04/2022, 03:14:42 PM
    Author     : danil
--%>

<%@page import="Modelo.Persona"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="ModeloDAO.PersonaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <title>Lista</title>
    </head>
    <body>
        <div class="container">
            <h1>Personas</h1>
            <%-- Boton para acceder a la subpagina add --%>
            <a class="btn btn-info" href="Controlador?accion=add">Agregar Nuevo</a>
            <br>
            <br>
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th class="text-center">Id</th>
                        <th class="text-center">Nombre</th>
                        <th class="text-center">Apellido</th>
                        <th class="text-center">Valor restante(Sin intereses)</th>
                        <th class="text-center">Acciones</th>
                    </tr>
                    <%-- Recuperación de los datos desde la base de datos --%>
                    <%
                        PersonaDAO dao = new PersonaDAO();
                        List<Persona> list = dao.listar();
                        Iterator<Persona> iter = list.iterator();
                        Persona persona = null;
                        while(iter.hasNext()){
                            persona = iter.next();
                    %>
                </thead>
                <tbody>
                    <tr>
                        <%-- Iteración por row de la tabla, para mostrar los datos --%>
                        <td class="text-center"><%= persona.getId()%></td>
                        <td class="text-center"><%= persona.getNombre()%></td>
                        <td class="text-center"><%= persona.getApellido()%></td>
                        <td class="text-center"><%= persona.getValorPrestamo()%></td>
                        <td class="text-center">
                            <%-- Botones de acción, que redirigen a sus respectivos programas --%>
                            <a class="btn btn-success" href="Controlador?accion=pagar&id=<%= persona.getId()%>">Pagar</a>
                            <a class="btn btn-info" href="Controlador?accion=editar&id=<%= persona.getId()%>">Editar</a>
                            <a class="btn btn-danger" href="Controlador?accion=eliminar&id=<%= persona.getId()%>" onclick="return confirm('¿Quieres eliminar este cliente?')">Eliminar</a>
                        </td>
                        <%}%>
                    </tr>
                </tbody>
            </table>

        </div>
    </body>
</html>
