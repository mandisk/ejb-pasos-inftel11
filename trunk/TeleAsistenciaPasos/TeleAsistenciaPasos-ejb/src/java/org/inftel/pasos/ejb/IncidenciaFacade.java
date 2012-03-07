/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.inftel.pasos.ejb;

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
                + "WHERE i.IDUSUARIOFK=u.ID AND u.IDPERSONAFK=per.ID AND i.IDTINCIDENCIAFK=ti.ID")
                .getResultList();
    }

    public List<Incidencia> findHigher(String ultimo) {
        return em.createQuery("SELECT i FROM Incidencia i WHERE i.id > :ultimo ORDER BY i.id ASC").
                setParameter("ultimo", new Long(ultimo)).getResultList();
    }    
}
