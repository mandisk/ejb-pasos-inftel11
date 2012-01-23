/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.inftel.pasos.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.inftel.pasos.ejb.PersonasFacadeRemote;
import org.inftel.pasos.ejb.UsuariosFacadeRemote;
import org.inftel.pasos.entity.Personas;
import org.inftel.pasos.entity.Usuarios;

/**
 *
 * @author aljiru
 */
@WebServlet(name = "procesaNuevoUsuario", urlPatterns = {"/procesaNuevoUsuario"})
public class procesaNuevoUsuario extends HttpServlet {
    @EJB    
    private UsuariosFacadeRemote usuariosFacade;
    @EJB
    private PersonasFacadeRemote personasFacade;

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
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Creación de usuario</title>");
            out.println("</head>");
            out.println("<body>");
            try {
                Usuarios user = new Usuarios();
                user.setImei(new BigInteger(request.getParameter("imei")));
                user.setFoto(Utilities.formToBeanImage(request));
                Personas person = new Personas();
                person.setNombre(request.getParameter("nombre"));
                person.setApellido1(request.getParameter("apellido1"));
                person.setApellido2(request.getParameter("apellido2"));
                person.setDireccion(request.getParameter("direccion"));
                person.setLocalidad(request.getParameter("localidad"));
                person.setProvincia(request.getParameter("provincia"));
                person.setCodpostal(new BigInteger(request.getParameter("codPostal")));
                person.setTelefono(new BigInteger(request.getParameter("telefono")));
                person.setEmail(request.getParameter("email"));                
                
                user.setIdPersona(person);                
                usuariosFacade.create(user);
            } catch (Exception e) {
                out.println("<h1>Error en la creacion del Usuario.</h1>");
            }
            
            out.println("<h1>Nuevo Usuario Creado.</h1>");
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
