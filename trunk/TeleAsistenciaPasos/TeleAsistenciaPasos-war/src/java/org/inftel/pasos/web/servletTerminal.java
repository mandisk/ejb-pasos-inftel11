/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.inftel.pasos.web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.inftel.pasos.util.terminalDatos;

/**
 *
 * @author Frank
 */
@WebServlet(name = "servletTerminal",urlPatterns={"/servletTerminal"})
public class servletTerminal extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            String alarma;
            String ld;
            String lh;
            String ln;
            String lt;
            String pb;
            String la;
            String dt;
            String rd;
            
            alarma = request.getParameter("alarma");
            ld = request.getParameter("ld");
            lh = request.getParameter("lh");
            ln = request.getParameter("ln");
            lt = request.getParameter("lt");
            pb = request.getParameter("pb");
            la = request.getParameter("la");
            dt = request.getParameter("dt");
            rd = request.getParameter("rd");
        
            terminalDatos terminaldatos = new terminalDatos();
            if(!alarma.isEmpty())
                terminaldatos.setAlarma(alarma);
            if(!ld.isEmpty())
                terminaldatos.setLd(ld);
            if(!lh.isEmpty())
                terminaldatos.setLh(lh);
            if(!ln.isEmpty())
                terminaldatos.setLn(ln);
            if(!lt.isEmpty())
                terminaldatos.setLt(lt);
            if(!pb.isEmpty())
                terminaldatos.setPb(pb);
            if(!la.isEmpty())
                terminaldatos.setLa(la);
            if(!dt.isEmpty())
                terminaldatos.setDt(dt);
            if(!rd.isEmpty())
                terminaldatos.setRd(rd);
            
            terminaldatos.terminalDatos();
            
            HttpSession sesion = request.getSession( true );
            sesion.setAttribute("dt", terminaldatos.getTrama());
            
            RequestDispatcher rdd;
            rdd = getServletContext().getRequestDispatcher("/Servlet");
            rdd.forward(request, response);
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
