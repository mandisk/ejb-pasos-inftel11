/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.inftel.pasos.web.mensajeria;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.inftel.pasos.ejb.MensajeFacade;
import org.inftel.pasos.entity.Mensaje;

/**
 *
 * @author aljiru
 */
@WebServlet(name = "ServletCargarMensajes", urlPatterns = {"/ServletCargarMensajes"})
public class ServletCargarMensajes extends HttpServlet {

    @EJB
    private MensajeFacade mensajeFacade;

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            String cadena = "";
            Long top = new Long(0);
            String usuario = request.getParameter("tel");            
            if (usuario.equals("0")) {
                cadena = "Usuario: ";
            } else {
                cadena = "Teleoperadora: ";
            }
            List<Mensaje> lMensaje = mensajeFacade.findHigher(request.getParameter("ult"), request.getParameter("ses"), usuario);
            if (!lMensaje.isEmpty()) {
                for (Mensaje men : lMensaje) {
                    out.println("<div>" + cadena + men.getTexto() + "</div>");
                    top = men.getId();
                }

                out.println("<div style='display: none;' class='maroto'>" + top + "</div>");
            } else {                
                out.println("");
            }

        } catch (Exception ex) {
            Logger.getLogger(ServletCargarMensajes.class.getName()).log(Level.SEVERE, "Fallo al cargar mensajes", ex);
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
