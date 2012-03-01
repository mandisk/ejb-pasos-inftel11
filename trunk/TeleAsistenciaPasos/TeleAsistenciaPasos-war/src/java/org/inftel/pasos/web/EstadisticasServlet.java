
import java.awt.Color;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Collection;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.inftel.pasos.ejb.IncidenciaFacade;
import org.inftel.pasos.entity.Incidencia;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author antonio
 */
@WebServlet(name = "EstadisticasServlet", urlPatterns = {"/EstadisticasServlet"})
public class EstadisticasServlet extends HttpServlet {

    @EJB
    private IncidenciaFacade incidenciaFacade;
    int enero, febrero, marzo, abril, mayo, junio, julio, agosto, septiembre, octubre, noviembre, diciembre;

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        calculaIncidencias();
        doTestPieChart(request, response);
    }

    protected void calculaIncidencias() {
        Collection<Incidencia> incidencias = incidenciaFacade.findAll();
        for (Incidencia incidencia : incidencias) {
            if (incidencia.getFecha().getMonth() == 0) {
                enero++;
            } else if (incidencia.getFecha().getMonth() == 1) {
                febrero++;
            } else if (incidencia.getFecha().getMonth() == 2) {
                marzo++;
            } else if (incidencia.getFecha().getMonth() == 3) {
                abril++;
            } else if (incidencia.getFecha().getMonth() == 4) {
                mayo++;
            } else if (incidencia.getFecha().getMonth() == 5) {
                junio++;
            } else if (incidencia.getFecha().getMonth() == 6) {
                julio++;
            } else if (incidencia.getFecha().getMonth() == 7) {
                agosto++;
            } else if (incidencia.getFecha().getMonth() == 8) {
                septiembre++;
            } else if (incidencia.getFecha().getMonth() == 9) {
                octubre++;
            } else if (incidencia.getFecha().getMonth() == 10) {
                noviembre++;
            } else {
                diciembre++;
            }
        }
    }
    //Diagrama de sectores

    protected void doTestPieChart(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException, ServletException {
        OutputStream out = response.getOutputStream();
        response.setContentType("image/png");
        try {
            DefaultPieDataset dataset = new DefaultPieDataset();

            dataset.setValue("Enero", enero);
            dataset.setValue("Febrero", febrero);
            dataset.setValue("Marzo", marzo);
            dataset.setValue("Abril", abril);
            dataset.setValue("Mayo", mayo);
            dataset.setValue("Junio", junio);
            dataset.setValue("Julio", julio);
            dataset.setValue("Agosto", agosto);
            dataset.setValue("Septiembre", septiembre);
            dataset.setValue("Octubre", octubre);
            dataset.setValue("Noviembre", noviembre);
            dataset.setValue("Diciembre", diciembre);



            JFreeChart chart = ChartFactory.createPieChart(
                    "Incidencias por Mes", // Titulo
                    dataset, // Datos
                    true, // Presenta las leyendas
                    false, // No, don't display tooltips
                    false // No, no URLs
                    );
            chart.setBackgroundPaint(Color.white);
            ChartUtilities.writeChartAsPNG(out, chart, 600, 600);
        } catch (Exception e) {
            System.out.println(e.toString());
        } finally {
            out.close();
        }
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">

    /**
     * Handles the HTTP
     * <code>GET</code> method.
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
     * Handles the HTTP
     * <code>POST</code> method.
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
