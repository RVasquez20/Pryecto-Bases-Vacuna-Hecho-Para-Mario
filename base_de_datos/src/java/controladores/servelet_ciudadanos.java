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
import modelos.Ciudadanos;

/**
 *
 * @author javie
 */
@WebServlet(name = "servelet_ciudadanos", urlPatterns = {"/servelet_ciudadanos"})
public class servelet_ciudadanos extends HttpServlet {

    Ciudadanos c;

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
            c = new Ciudadanos(request.getParameter("tnombre"), request.getParameter("tapellido"),
                    request.getParameter("tfechanac"), Integer.parseInt(request.getParameter("tdpi")),
                    Integer.parseInt(request.getParameter("ttelefono")));
            /* TODO output your page here. You may use following sample code. */
            if ("agregar".equals(request.getParameter("btn_agregar"))) {

                if (c.Registrar() > 0) {
                    out.println("<script type=\"text/javascript\">");
                    out.println("alert('Ingresado correctamente');");
                    out.println("location='Ciudadanos.jsp';");
                    out.println("</script>");

                } else {
                    out.println("<script type=\"text/javascript\">");
                    out.println("alert('Error al agregar ciudadano');");
                    out.println("location='Ciudadanos.jsp';");
                    out.println("</script>");

                }

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
