/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.inftel.pasos.ejb;

import java.math.BigInteger;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.inftel.pasos.entity.Mensaje;

/**
 *
 * @author aljiru
 */
@Stateless
public class MensajeFacade extends AbstractFacade<Mensaje> {

    @PersistenceContext(unitName = "TeleAsistenciaPasos-ejbPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public MensajeFacade() {
        super(Mensaje.class);
    }

    public List<Mensaje> findHigher(String idm, String ses, String tel) {
        return em.createQuery("SELECT m FROM Mensaje m WHERE m.id > :idm AND m.idUsuario = :ses AND m.teleasistencia = :tel ORDER BY m.id ASC").
                setParameter("idm", new Long(idm)).setParameter("ses", new BigInteger(ses)).
                setParameter("tel", new BigInteger(tel)).getResultList();
    }

    public Mensaje findByData(String ses, String tel, String txt) {
        return (Mensaje)em.createQuery("SELECT m FROM Mensaje m WHERE m.texto = :txt AND m.idUsuario = :ses AND m.teleasistencia = :tel ORDER BY m.id DESC").
                setParameter("txt", txt).setParameter("ses", new BigInteger(ses)).
                setParameter("tel", new BigInteger(tel)).getResultList().get(0);
    }    
}
