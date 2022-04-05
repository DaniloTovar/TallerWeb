<%-- 
    Document   : pagar
    Created on : 4/04/2022, 12:31:45 AM
    Author     : danil

<a href="id=<%= persona.getId()%>&valorPagar=<%= valorPagar%>&valorIntereses=<%= valorIntereses%>">
--%>

<%@page import="Modelo.Persona"%>
<%@page import="ModeloDAO.PersonaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <title>Pagar</title>
    </head>
    <body>
        <div class="container">
            <div class="col-lg-5">
                <h1>Realizar pagos</h1>
                <table class="table table-bordered">
                    <thead>
                        <tr>
                            <th class="text-center">Valor restante</th>
                            <th class="text-center">Abono</th>
                        </tr>
                        <%-- 
                            Recuperación de los datos desde la base de datos y 
                             obtención de valor relacionados (Valor a pagar y valor por intereses) 
                        --%>
                        <%
                            PersonaDAO dao = new PersonaDAO();
                            int id = Integer.parseInt((String) request.getAttribute("idper"));
                            Persona persona = (Persona) dao.list(id);
                            double interes = 1.1;
                            double interescompuesto = 1;
                            for (int i = 0; i < persona.getMes(); i++) {
                                interescompuesto *= interes;
                            }
                            double valorPagar = persona.getValorPrestamo() * interescompuesto;
                            double valorIntereses = valorPagar - persona.getValorPrestamo();
                        %>
                    </thead>
                    <tbody>
                        <tr>
                            <td class="text-center"><%= valorPagar%></td>
                            <td class="text-center">
                                <%-- Form que envia los datos correspondientes para procesarlos en el controlador --%>
                                <form>
                                    <input class="form-control" type="text" name="textAbono">
                                    <input class="form-control" type="hidden" name="id" value="<%= persona.getId()%>">
                                    <input class="form-control" type="hidden" name="valorPagar" value="<%= valorPagar%>">
                                    <input class="form-control" type="hidden" name="valorIntereses" value="<%= valorIntereses%>">
                                    <input class="btn btn-success" type="submit" name="accion" value="Abonar">
                                </form>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>
