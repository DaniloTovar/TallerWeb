<%-- 
    Document   : edit
    Created on : 2/04/2022, 03:14:35 PM
    Author     : danil
--%>

<%@page import="Modelo.Persona"%>
<%@page import="ModeloDAO.PersonaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <title>Editar</title>
    </head>
    <body>
        <div class="container">
            <div class="col-lg-5">
                <%-- Recuperación de los datso de la base de datos --%>
                <%
                    PersonaDAO dao = new PersonaDAO();
                    int id = Integer.parseInt((String) request.getAttribute("idpersona"));
                    Persona p = (Persona) dao.list(id);
                %>
                <h1>Modificar Persona</h1>
                <%-- Form prellenado con los datos recuperados --%>
                <form action="Controlador">
                    <input type="hidden" name="textId" value="<%= p.getId()%>"><br>
                    Nombre: <br>
                    <input class="form-control" type="text" name="textNombre" value="<%= p.getNombre()%>"><br>
                    Apellido: <br>
                    <input class="form-control" type="text" name="textApellido" value="<%= p.getApellido()%>"><br>
                    Valor restante: <br>
                    <input class="form-control" type="text" name="textPrestamo" value="<%= p.getValorPrestamo()%>"><br>
                    Mes: <br>
                    <input class="form-control" type="text" name="textMes" value="<%= p.getMes()%>"><br>
                    <%-- Boton submit para enviar los datos modificados --%>
                    <input class="btn btn-primary" type="submit" name="accion" value="Actualizar">
                </form>
            </div>
        </div>
    </body>
</html>
