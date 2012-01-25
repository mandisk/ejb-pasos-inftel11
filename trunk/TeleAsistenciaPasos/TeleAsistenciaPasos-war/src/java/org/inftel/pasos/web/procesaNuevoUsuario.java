/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.inftel.pasos.web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.inftel.pasos.ejb.UsuarioFacadeRemote;
import org.inftel.pasos.entity.Usuario;
import org.inftel.pasos.util.Utilities;

/**
 *
 * @author aljiru
 */
@WebServlet(name = "procesaNuevoUsuario", urlPatterns = {"/procesaNuevoUsuario"})
public class procesaNuevoUsuario extends HttpServlet {

    @EJB
    private UsuarioFacadeRemote usuarioFacade;

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Usuario user = null;
        try {
            user = Utilities.formToBeanUser(request);
            System.out.println(user.toString());
            usuarioFacade.create(user);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
               
        /*String nextJSP = "/admin/user.jsp";
        UsuarioBean bean = new UsuarioBean();
        Usuario usuario = usuarioFacade.find(new BigDecimal("1021"));
        Persona persona = usuario.getIdPersona();
        bean.setApellido1(persona.getApellido1());
        bean.setApellido2(persona.getApellido2());
        bean.setCodpostal(persona.getCodpostal().intValue());
        bean.setDireccion(persona.getDireccion());
        bean.setEmail(persona.getEmail());
        
        bean.setImei(usuario.getImei().intValue());
        bean.setLocalidad(persona.getLocalidad());
        bean.setNombre(persona.getNombre());
        bean.setProvincia(persona.getProvincia());
        bean.setTelefono(persona.getTelefono().intValue());
        request.setAttribute("usuarioBean", bean);
        
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
        dispatcher.forward(request, response);*/
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Creación Usuario</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Usuario creado.</h1>");
            out.println("</body>");
            out.println("</html>");

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
