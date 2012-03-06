/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.inftel.pasos.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.inftel.pasos.entity.Usuario;

/**
 *
 * @author aljiru
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> {
    @PersistenceContext(unitName = "TeleAsistenciaPasos-ejbPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }
    public Usuario findById(Integer id) {
        return (Usuario) em.createQuery("SELECT u FROM Usuario u WHERE u.idUsuario = :id").
                setParameter("id", new Long(id)).getResultList().get(0);
    }
}
