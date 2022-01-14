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
import modelos.fechas;
import modelos.inscripcion;
import modelos.primera_dosis;

/**
 *
 * @author javie
 */
@WebServlet(name = "servelet_primera", urlPatterns = {"/servelet_primera"})
public class servelet_primera extends HttpServlet {

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
            if ("agregar".equals(request.getParameter("btn_agregar"))) {
                inscripcion ins = new inscripcion();
                ins.setDpi(Integer.parseInt(request.getParameter("dpi")));
                int id = ins.Registrado();
                if (id != 0) {
                    out.println("<h1>id " + id + "</h1>");
                    //int id_registro=ins.idRegistro(id);
                    fechas f = new fechas();
                    int id_registro = f.fechavalidaPrimeraDosis(id);
                    out.println("<h1>idr " + id_registro + "</h1>");
                    primera_dosis pd = new primera_dosis(id_registro, Integer.parseInt(request.getParameter("optradio")));
                    String fecha = pd.fechaAsignada(id);
                    int aplicada = pd.aplicada(id_registro);
                    if (id_registro != 0) {

                        if (aplicada == 0) {
                            if (pd.Agregar() != 0) {
                                String fechaAsignada = pd.fechaAsignadaSegunda(id);
                                out.println("<script type=\"text/javascript\">");
                                out.println("alert('La fecha para la segunda dosis es : " + fechaAsignada + "');");
                                out.println("location='primera.jsp';");
                                out.println("</script>");
                                //response.sendRedirect("primera.jsp");
                            } else {
                                out.println("<script type=\"text/javascript\">");
                                out.println("alert('Agregado fallo');");
                                out.println("location='primera.jsp';");
                                out.println("</script>");
                            }
                        } else {
                            out.println("<script type=\"text/javascript\">");
                            out.println("alert('Este ciudadano ya cuenta con la primer dosis');");
                            out.println("location='primera.jsp';");
                            out.println("</script>");
                        }
                    } else {
                        out.println("<script type=\"text/javascript\">");
                        out.println("alert('la fecha asignada no coincide la fecha para la primera dosis es " + fecha + "');");
                        out.println("location='primera.jsp';");
                        out.println("</script>");

                    }
                } else {
                    out.println("<script type=\"text/javascript\">");
                    out.println("alert('Error ciudadano con ese dpi no inscrito aun');");
                    out.println("location='primera.jsp';");
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
