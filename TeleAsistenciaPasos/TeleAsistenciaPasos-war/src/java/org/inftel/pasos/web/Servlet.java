/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.inftel.pasos.web;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.inftel.pasos.beans.TramaBean;
import org.inftel.pasos.ejb.IncidenciaFacade;
import org.inftel.pasos.ejb.TipoIncidenciaFacade;
import org.inftel.pasos.ejb.UsuarioFacade;
import org.inftel.pasos.entity.Incidencia;
import org.inftel.pasos.entity.TipoIncidencia;
import org.inftel.pasos.entity.Usuario;

/**
 *
 * @author Antonio
 */
@WebServlet(name = "Servlet", urlPatterns = {"/Servlet"})
public class Servlet extends HttpServlet {
    @EJB
    private TipoIncidenciaFacade tipoIncidenciaFacade;
    @EJB
    private UsuarioFacade usuarioFacade;
    @EJB
    private IncidenciaFacade incidenciaFacade;

    private String trama;
    private String cliente;
    private String tramaPE;
    Vector<Integer> a = new Vector<Integer>();
    TramaBean t = new TramaBean();

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            /* TODO output your page here    */
            
            HttpSession sesion = request.getSession(false);
            
            if ( sesion != null ) {
                trama = (String) sesion.getAttribute("dt");
                cliente = (String) sesion.getAttribute("sesCli");
                sesion.invalidate();
            }
            
            desmontarAU();
            request.setAttribute("t", t);

            Incidencia incidencia= new Incidencia();
            incidencia.setAltitud(new BigDecimal(t.getAlt()));
            incidencia.setFecha(new Date(t.getDate()));
            
            TipoIncidencia ti = tipoIncidenciaFacade.find(new Long("2222"));
            
            incidencia.setIdTincidenciaFk(ti);
            incidencia.setLatitud(new BigDecimal(t.getLat()));
            incidencia.setLongitud(new BigDecimal(t.getLon()));
            incidencia.setNivelBateria(new BigInteger(Integer.toString(t.getPb())));
            incidencia.setTemperatura((double)t.getTemp());
            Logger.getLogger(procesaNuevoUsuario.class.getName()).log(Level.SEVERE, String.valueOf(cliente));
            Usuario us = usuarioFacade.find(new Long(cliente));
            
            incidencia.setIdUsuarioFk(us);
            
            incidenciaFacade.create(incidencia);            

            RequestDispatcher d = getServletContext().getRequestDispatcher("/mensajes/chatCliente.jsp");
            
            request.setAttribute("ses", cliente);
            
            d.forward(request, response);
        } catch (Exception e) {
            Logger.getLogger(procesaNuevoUsuario.class.getName()).log(Level.SEVERE, "Fallo al crear usuario", e);
        }
    }

    void desmontarAU() {

        String[] b = trama.split("&");
        int i;


        for (i = 0; i < b.length; i++) {
            String aux = b[i];
            Pattern patron = Pattern.compile("([A-Z]+)"); //Cojo el primer grupo de caracteres
            Matcher matcher = patron.matcher(aux);
            matcher.find();
            Pattern patron2 = Pattern.compile("([0-9]+)"); //Cojo el grupo de digitos
            Matcher matcher2 = patron2.matcher(aux);
            matcher2.find();
             
            if ("*$AU".equals(matcher2.group(1))) {
            } else if ("LD".equals(matcher.group(1))) {
                t.setDate(Integer.parseInt(matcher2.group(1)));
            } else if ("LH".equals(matcher.group(1))) {
                t.setHora(Integer.parseInt(matcher2.group(1)));
            } else if ("LN".equals(matcher.group(1))) {
                t.setLon(Integer.parseInt(matcher2.group(1)));

            } else if ("LT".equals(matcher.group(1))) {
                t.setLat(Integer.parseInt(matcher2.group(1)));

            } else if ("PB".equals(matcher.group(1))) {
                t.setPb(Integer.parseInt(matcher2.group(1)));
            } else if ("LA".equals(matcher.group(1))) {
                t.setAlt(Integer.parseInt(matcher2.group(1)));
            } else if ("DT".equals(matcher.group(1))) {
                t.setTemp(Integer.parseInt(matcher2.group(1)));
            } else if ("RD".equals(matcher.group(1))) {
                t.setImei(Long.parseLong(matcher2.group(1)));
            }
        }

    }

    void desmontarPE() {
        Pattern patron = Pattern.compile("([0-9])"); //Cojo el primer digito
        Matcher matcher = patron.matcher(tramaPE);
        matcher.find();
        int n = Integer.parseInt(matcher.group(1)); //numero de localizaciones que trae la trama
        n = n * 4; //Multiplico por 4 porque tendra 4 elementos, fecha, hora, longitud, latitud
        String[] valores = tramaPE.split("&");

        for (int i = 1; i < n; i++) { //Empiezo desde el 1 para obviar el primer campo que ya lo hemos analizao antes
            patron = Pattern.compile("([0-9]+)");
            matcher = patron.matcher(valores[i]);
            matcher.find();
            a.add(Integer.parseInt(matcher.group(1)));

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
