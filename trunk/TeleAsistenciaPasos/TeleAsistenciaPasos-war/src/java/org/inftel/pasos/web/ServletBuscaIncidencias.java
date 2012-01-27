/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.inftel.pasos.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.inftel.pasos.ejb.IncidenciaFacadeRemote;
import org.inftel.pasos.entity.Incidencia;

/**
 *
 * @author aljiru
 */
@WebServlet(name = "ServletBuscaIncidencias", urlPatterns = {"/ServletBuscaIncidencias"})
public class ServletBuscaIncidencias extends HttpServlet {

    @EJB
    private IncidenciaFacadeRemote incidenciaFacade;

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
            BigDecimal top = new BigDecimal(0);
            Logger.getLogger(ServletBuscaIncidencias.class.getName()).log(Level.SEVERE, request.
                    getParameter("ult"));
            List<Incidencia> lIncidencia = incidenciaFacade.findHigher(request.getParameter("ult"));
            if (!lIncidencia.isEmpty()) {
                for (Incidencia in : lIncidencia) {
                    out.println("<tr class='alert'>");
                    out.println("<td>" + in.getIdUsuario().getIdPersona().getNombre() + "</td>");
                    out.println("<td>" + in.getIdUsuario().getIdPersona().getApellido1());
                    out.println(in.getIdUsuario().getIdPersona().getApellido2() + "</td>");
                    if (in.getIdEmpleado() != null) {
                        out.println("<td>" + in.getIdEmpleado().getIdPersona().getNombre() + "</td>");
                        out.println("<td>" + in.getIdEmpleado().getIdPersona().getApellido1() + "</td>");
                    } else {
                        out.println("<td></td>");
                        out.println("<td></td>");
                    }

                    if (in.getIdTincidencia() != null) {
                        out.println("<td>" + in.getIdTincidencia().getDescripcion() + "</td>");
                    } else {
                        out.println("<td></td>");
                    }

                    out.println("<td>" + in.getFecha() + "</td>");
                    out.println("<td>" + in.getTemperatura() + "ºC</td>");
                    out.println("<td>" + in.getNivelBateria() + "%</td>");
                    out.println("<td><a href='comUsuario?action=com&idPersona=" + in.getIdUsuario().
                            getIdUsuario() + "'>Atender Usuario</a></td>");
                    out.println("</tr>");
                    top = in.getIncidencia();
                }

                out.println("<tr style='display: none;'><td class='nuevo'>" + top + "</td></tr>");
            } else {
                out.println("");
            }

        } catch (Exception ex) {
            Logger.getLogger(ServletBuscaIncidencias.class.getName()).log(Level.SEVERE, "Fallo al cargar mensajes", ex);
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
