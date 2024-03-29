/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.inftel.pasos.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.inftel.pasos.entity.TipoIncidencia;

/**
 *
 * @author aljiru
 */
@Stateless
public class TipoIncidenciaFacade extends AbstractFacade<TipoIncidencia> {
    @PersistenceContext(unitName = "TeleAsistenciaPasos-ejbPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoIncidenciaFacade() {
        super(TipoIncidencia.class);
    }
    
}
