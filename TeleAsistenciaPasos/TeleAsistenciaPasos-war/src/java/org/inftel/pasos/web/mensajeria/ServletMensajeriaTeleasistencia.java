/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.inftel.pasos.web.mensajeria;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Date;
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
@WebServlet(name = "ServletMensajeria", urlPatterns = {"/ServletMensajeria"})
public class ServletMensajeriaTeleasistencia extends HttpServlet {

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
            Mensaje mensaje = new Mensaje();
            mensaje.setIdUsuario(new BigInteger(request.getParameter("sesion")));
            mensaje.setTeleasistencia(new BigInteger(request.getParameter("user")));
            mensaje.setTexto(request.getParameter("msg"));
            mensaje.setFecha(new Date());
            mensajeFacade.create(mensaje);
            
            Mensaje nMens = mensajeFacade.findByData(request.getParameter("sesion"), request.getParameter("user"), request.getParameter("msg"));
            out.println(nMens.getId());
        } catch (Exception ex) {
            Logger.getLogger(ServletMensajeriaTeleasistencia.class.getName()).log(Level.SEVERE, "Fallo al insertar mensaje", ex);
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
