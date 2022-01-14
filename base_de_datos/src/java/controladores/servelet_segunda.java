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
import modelos.dosis;
import modelos.fechas;
import modelos.inscripcion;
import modelos.primera_dosis;
import modelos.segunda_dosis;

/**
 *
 * @author javie
 */
@WebServlet(name = "servelet_segunda", urlPatterns = {"/servelet_segunda"})
public class servelet_segunda extends HttpServlet {

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
                //id inscripcion
                int id = ins.Registrado();
                if (id != 0) {
                    out.println("<h1>idinscripcion " + id + "</h1>");
//                    int id_registro=ins.idRegistro(id);
                    fechas f = new fechas();
                    segunda_dosis sd = new segunda_dosis();
                    int idregistroprimeradosis = sd.idRegistradoprimeradosis(id);

                    dosis d = new dosis();
                    int iddosis = d.iddosis(idregistroprimeradosis);
                    int id_registro = f.fechavalidaSegundaDosis(id);
                    segunda_dosis pd = new segunda_dosis(id_registro, iddosis);
                      int aplicada = pd.aplicada(id_registro);        
                    if (id_registro != 0) {
                          if (aplicada == 0) {
                        if (pd.Agregar() != 0) {
                          out.println("<script type=\"text/javascript\">");
                            out.println("alert('Registro completado');");
                            out.println("location='segunda.jsp';");
                            out.println("</script>");
                        } else {

                            out.println("<script type=\"text/javascript\">");
                            out.println("alert('Agregado fallo');");
                            out.println("location='segunda.jsp';");
                            out.println("</script>");
                        }
                        } else {
                            out.println("<script type=\"text/javascript\">");
                            out.println("alert('Este ciudadano ya cuenta con la segunda dosis');");
                            out.println("location='segunda.jsp';");
                            out.println("</script>");
                        }
                    } else {
                        out.println("<script type=\"text/javascript\">");
                        out.println("alert('la fecha asignada no coincide');");
                        out.println("location='segunda.jsp';");
                        out.println("</script>");

                    }
                } else {

                    out.println("<script type=\"text/javascript\">");
                    out.println("alert('Error ciudadano con ese dpi no inscrito aun');");
                    out.println("location='segunda.jsp';");
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
