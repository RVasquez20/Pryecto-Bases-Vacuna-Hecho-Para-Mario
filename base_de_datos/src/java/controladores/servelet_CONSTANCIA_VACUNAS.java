/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.table.DefaultTableModel;
import modelos.inscripcion;

/**
 *
 * @author javie
 */
@WebServlet(name = "servelet_CONSTANCIA_VACUNAS", urlPatterns = {"/servelet_CONSTANCIA_VACUNAS"})
public class servelet_CONSTANCIA_VACUNAS extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
                       
            if ("vconsulta".equals(request.getParameter("vConsultar"))) {
                out.println("<!DOCTYPE html>");
                out.println("<html lang='es'>");
                out.println("<head>");
                out.println("<title>constancia vacunas</title>");
                out.println("<meta charset='utf-8'>");
                out.println("<meta name='viewport' content='width=device-width, initial-scale=1'>");
                out.println("<link rel='stylesheet'href='https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css'>");
                out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js'></script>");
                out.println("<script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js'></script>");   
            out.println("<script type=\"text/javascript\">");
                    out.println("$(document).ready(function(){");
                    out.println("$('#myModal').modal('show');");
                    out.println("});");
                    out.println("</script>");
                    out.println("</head>");
                out.println("<body>");
                out.println("<div class='container'>");      
                    out.println("<div class='modal' id='myModal' role='dialog'>");
                    out.println("<div class='modal-dialog'>");
                    out.println("<div class='modal-content'>");
                    out.println("<div class='modal-header'>");
                    out.println("<h4 class='modal-title'>Constancia de Vacunacion</h4>");
                    out.println("</div>");
                    out.println("<div class='modal-body'>");
                    out.println("<table class='table table-bordered text-center'>");
                    out.println("<thead ><tr>");
                    out.println("<th class='text-center'>NOMBRE</th>");
                    out.println("<th class='text-center'>APELLIDO</th>");
                    out.println("<th class='text-center'>DPI</th>");
                    out.println("<th class='text-center'>FECHA DE NACIMIENTO</th>");
                    out.println("<th class='text-center'>TELEFONO</th>");
                    out.println("</tr class='text-center'></thead>");
                    out.println("<tbody class='text-center'>");
                    inscripcion x=new inscripcion();
                    x.setDpi(Integer.parseInt(request.getParameter("dpi")));
                    DefaultTableModel Registro=x.ConstanciaRegistros();
                   for (int i = 0; i < Registro.getRowCount(); i++) {
                       out.println("<tr>");
                       out.println("<td>" + Registro.getValueAt(i, 0) + "</td>");
                            out.println("<td>" + Registro.getValueAt(i, 1) + "</td>");
                            out.println("<td>" + Registro.getValueAt(i, 2) + "</td>");
                            out.println("<td>" + Registro.getValueAt(i, 3) + "</td>");
                            out.println("<td>" + Registro.getValueAt(i, 4) + "</td>");
                    }
                    out.println("</tbody></table>");
                    
                    
                    
                    
                    
                    
                    
                    
                     out.println("<table class='table table-bordered text-center'>");
                    out.println("<thead ><tr>");
                    out.println("<th class='text-center'>DOSIS ADMINISTRADA</th>");
                    out.println("<th class='text-center'>NOMBRE DE LA VACUNA</th>");
                    out.println("<th class='text-center'>FECHA DE APLICACION</th>");
                    out.println("</tr class='text-center'></thead>");
                    out.println("<tbody class='text-center'>");
                    DefaultTableModel Registrov=x.ConstanciaVacunas();
                   for (int i = 0; i < Registrov.getRowCount(); i++) {
                       out.println("<tr>");
                       out.println("<td>" + Registrov.getValueAt(i, 0) + "</td>");
                            out.println("<td>" + Registrov.getValueAt(i, 1) + "</td>");
                            out.println("<td>" + Registrov.getValueAt(i, 2) + "</td>");
                    }
                    out.println("</tbody></table>");
                    out.println("</div>");
                    out.println("<div class='modal-footer'>");
                    out.println("<button type='button' onclick=\"location.href='consulta_aplicacion.jsp'\" class='btn btn-default' data-dismiss='modal'>Close</button>");
                out.println("</div></div></div></div></div></body></html>");

            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
