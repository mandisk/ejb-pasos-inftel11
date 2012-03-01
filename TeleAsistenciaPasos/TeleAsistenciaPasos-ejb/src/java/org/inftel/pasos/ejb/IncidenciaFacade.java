/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.inftel.pasos.ejb;

import java.math.BigDecimal;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.inftel.pasos.entity.Incidencia;

/**
 *
 * @author aljiru
 */
@Stateless
public class IncidenciaFacade extends AbstractFacade<Incidencia> {
    @PersistenceContext(unitName = "TeleAsistenciaPasos-ejbPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public IncidenciaFacade() {
        super(Incidencia.class);
    }
    
    public List  findAllIncidencias() {
        return em.createQuery("SELECT per.NOMBRE,per.APELLIDO1,per.APELLIDO2,ti.DESCRIPCION,i.FECHA,i.TEMPERATURA,i.NIVEL_BATERIA"
                + "FROM PERSONA per, TIPO_INCIDENCIA ti,INCIDENCIA i,USUARIO u "
                + "WHERE i.ID_USUARIO=u.ID_USUARIO AND u.ID_PERSONA=per.ID_PERSONA AND i.ID_TINCIDENCIA=ti.ID")
                .getResultList();
    }

    public List<Incidencia> findHigher(String ultimo) {
        return em.createQuery("SELECT i FROM Incidencia i WHERE i.incidencia > :ultimo ORDER BY i.incidencia ASC").
                setParameter("ultimo", new BigDecimal(ultimo)).getResultList();
    }
    
}
