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
import modelos.inscripcion;
import modelos.primera_dosis;

/**
 *
 * @author javie
 */
@WebServlet(name = "servelet_inscripcion", urlPatterns = {"/servelet_inscripcion"})
public class servelet_inscripcion extends HttpServlet {

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
            Ciudadanos ciudadano = new Ciudadanos();
            ciudadano.setDPI(Integer.parseInt(request.getParameter("dpi")));
            if ("inscribir".equals(request.getParameter("agregar"))) {

                if (ciudadano.Registrado() != 0) {
                    int id = ciudadano.Id_edad();
                    if (id != 0) {
                        inscripcion incribir = new inscripcion(Integer.parseInt(request.getParameter("dpi")), id);
                        if (incribir.Registrar() != 0) {
                             primera_dosis pd =new primera_dosis();
                             String fechaAsignada = pd.fechaAsignada(Integer.parseInt(request.getParameter("dpi")));
                              out.println("<script type=\"text/javascript\">");
                            out.println("alert('Agregado correctamente');");
                            out.println("</script>");
                            out.println("<script type=\"text/javascript\">");
                            out.println("alert('La fecha para la primera dosis es : " + fechaAsignada + "');");
                            out.println("location='registro.jsp';");
                            out.println("</script>");
                        } else {
                            out.println("<script type=\"text/javascript\">");
                            out.println("alert('Error al agregar o ciudadano ya inscrito');");
                            out.println("location='registro.jsp';");
                            out.println("</script>");

                        }
                    } else {

                        out.println("<script type=\"text/javascript\">");
                        out.println("alert('Error ciudadano con ese dpi no aplica a ningun rango de edad');");
                        out.println("location='registro.jsp';");
                        out.println("</script>");

                    }

                } else {
                    out.println("<script type=\"text/javascript\">");
                    out.println("alert('Error ciudadano con ese dpi no ingresado aun');");
                    out.println("location='registro.jsp';");
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
