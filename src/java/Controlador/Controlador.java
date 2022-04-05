/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Persona;
import ModeloDAO.PersonaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author danil
 */
public class Controlador extends HttpServlet {

    // Definicion de diferentes elementos para su posterior uso
    String listar = "vistas/listar.jsp";
    String add = "vistas/add.jsp";
    String editar = "vistas/edit.jsp";
    String pagar = "vistas/pagar.jsp";
    Persona p = new Persona();
    PersonaDAO dao = new PersonaDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Controlador</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Controlador at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    
    //Método para realizar una acción, a partir una request y una response, definida
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acceso = "";
        String accion = request.getParameter("accion");
        //Otorga acceso a la subpagina listar
        if (accion.equalsIgnoreCase("listar")) {
            acceso = listar;
        } 
        //Otorga acceso a la subpagina add
        else if (accion.equalsIgnoreCase("add")) {
            acceso = add;
        } 
        //Realiza la captura de los datos correspondientes para realizar el proceso de agregado a la base de datos y su llamado
        else if (accion.equalsIgnoreCase("Agregar")) {
            String id = request.getParameter("textId");
            String nombre = request.getParameter("textNombre");
            String apellido = request.getParameter("textApellido");
            String valor_prestamo = request.getParameter("textPrestamo");
            int num_id = Integer.parseInt(id);
            double num_prestamo = Double.parseDouble(valor_prestamo);
            p.setId(num_id);
            p.setValorPrestamo(num_prestamo);
            p.setNombre(nombre);
            p.setApellido(apellido);
            p.setMes(1);
            dao.add(p);
            acceso = listar;
        } 
        //Otorga acceso a la subpagina add, y se lleva con el dato correspondiente a la id de la row seleccionada en la tabla
        else if (accion.equalsIgnoreCase("editar")) {
            request.setAttribute("idpersona", request.getParameter("id"));
            acceso = editar;
        } 
        //Realiza la captura de los datos correspondientes para realizar el proceso de modificación a la base de datos y su llamado
        else if (accion.equalsIgnoreCase("Actualizar")) {
            String id = request.getParameter("textId");
            String nombre = request.getParameter("textNombre");
            String apellido = request.getParameter("textApellido");
            String valor_prestamo = request.getParameter("textPrestamo");
            String mes = request.getParameter("textMes");
            int num_id = Integer.parseInt(id);
            double num_prestamo = Double.parseDouble(valor_prestamo);
            int num_mes;
            if (mes.indexOf(".") != -1) {
                num_mes = Integer.parseInt(mes.substring(0, mes.indexOf(".")));
            } else if (mes.indexOf(",") != -1) {
                num_mes = Integer.parseInt(mes.substring(0, mes.indexOf(",")));
            } else {
                num_mes = Integer.parseInt(mes);
            }
            p.setId(num_id);
            p.setValorPrestamo(num_prestamo);
            p.setNombre(nombre);
            p.setApellido(apellido);
            p.setMes(num_mes);
            dao.edit(p);
            acceso = listar;
        } 
        //Llama al proceso de borrado de la row seleccionada en la tabla
        else if (accion.equalsIgnoreCase("eliminar")) {
            int id = Integer.parseInt(request.getParameter("id"));
            p.setId(id);
            dao.eliminar(id);
            acceso = listar;
        } 
        //Otorga acceso a la subpagina pagar, y se lleva con el dato correspondiente a la id de la row seleccionada en la tabla
        else if (accion.equalsIgnoreCase("pagar")) {
            request.setAttribute("idper", request.getParameter("id"));
            acceso = pagar;
        } 
        //Realiza la captura de los datos correspondientes para realizar el proceso de abono para el cliente(segun id) y su llamado
        else if (accion.equalsIgnoreCase("abonar")) {
            int id = Integer.parseInt(request.getParameter("id"));
            String textAbono = request.getParameter("textAbono");
            double abono = Double.parseDouble(textAbono);
            double valorPagar = Double.parseDouble(request.getParameter("valorPagar"));
            double valorInteres = Double.parseDouble(request.getParameter("valorIntereses"));
            p = dao.list(id);
            p.setValorPrestamo(valorPagar - abono);
            if (abono >= valorInteres) {
                p.setMes(1);
            } else {
                p.setMes(p.getMes()+1);
                if (p.getMes() >= 18) {
                    p.setMes(18);
                }
            }
            dao.pagar(p);
            acceso = listar;
        }
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
