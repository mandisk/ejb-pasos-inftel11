/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.inftel.pasos.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.inftel.pasos.entity.Personas;

/**
 *
 * @author aljiru
 */
@Stateless
public class PersonasFacade extends AbstractFacade<Personas> implements PersonasFacadeRemote {
    @PersistenceContext(unitName = "TeleAsistenciaPasos-ejbPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public PersonasFacade() {
        super(Personas.class);
    }
    
}
