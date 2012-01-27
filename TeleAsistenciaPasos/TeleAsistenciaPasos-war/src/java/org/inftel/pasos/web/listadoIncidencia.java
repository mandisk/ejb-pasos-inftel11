/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.inftel.pasos.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.inftel.pasos.beans.IncidenciaBean;
import org.inftel.pasos.ejb.IncidenciaFacadeRemote;
import org.inftel.pasos.entity.Incidencia;

/**
 *
 * @author inftel
 */
@WebServlet(name = "listadoIncidencia", urlPatterns = {"/listadoIncidencia"})
public class listadoIncidencia extends HttpServlet {
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
        String dirJSP = "/incidencias.jsp";
        IncidenciaBean incidenciaBean = new IncidenciaBean();
        Collection<Incidencia> incidencias = incidenciaFacade.findAll();
        incidenciaBean.setIncidenciaCollection(incidencias);
        while (incidencias.iterator().hasNext()) {
            incidenciaBean.setUltima(incidencias.iterator().next().getIncidencia().intValue());
        }
        request.setAttribute("incidenciaBean", incidenciaBean);
        //List incidencias = incidenciaFacade.findAllIncidencias();
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(dirJSP);
        dispatcher.forward(request,response);
        
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
