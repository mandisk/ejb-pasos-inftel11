/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.inftel.pasos.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.inftel.pasos.ejb.PersonaFacadeRemote;
import org.inftel.pasos.ejb.UsuarioFacadeRemote;
import org.inftel.pasos.entity.Persona;
import org.inftel.pasos.entity.Usuario;

/**
 *
 * @author aljiru
 */
@WebServlet(name = "procesaNuevoUsuario", urlPatterns = {"/procesaNuevoUsuario"})
public class procesaNuevoUsuario extends HttpServlet {

    @EJB
    private UsuarioFacadeRemote usuariosFacade;
    @EJB
    private PersonaFacadeRemote personasFacade;

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
            user = new Usuario();
            user.setImei(new BigInteger(request.getParameter("imei")));
            user.setFoto(Utilities.formToBeanImage(request));
            Persona person = new Persona();
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
            System.out.println("Hostia tu!" + e.getMessage());
        }

        /*String nextJSP = "/admin/user.jsp";
        UsuarioBean bean = new UsuarioBean();
        System.out.println(user.getIdUsuario());
        Usuarios usuario = usuariosFacade.find(new BigDecimal("1010"));
        Personas persona = usuario.getIdPersona();
        bean.setApellido1(persona.getApellido1());
        bean.setApellido2(persona.getApellido2());
        bean.setCodpostal(persona.getCodpostal().intValue());
        bean.setDireccion(persona.getDireccion());
        bean.setEmail(persona.getEmail());

        String filename = "1010.jpg";
        File file = new File(filename);
        if (!file.exists()) {
            OutputStream os = new FileOutputStream(file);
            byte[] data = (byte[]) usuario.getFoto();
            os.write(data, 0, data.length);
            os.close();
        }

        bean.setFoto(filename);
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
            /* TODO output your page here    */
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Servlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Servlet at " + request.getContextPath() + "</h1>");
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
