/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.inftel.pasos.service;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.*;
import org.inftel.pasos.entity.TipoIncidencia;

/**
 *
 * @author aljiru
 */
@Stateless
@Path("tipoincidencia")
public class TipoIncidenciaFacadeREST extends AbstractFacade<TipoIncidencia> {

    @PersistenceContext(unitName = "TeleAsistenciaPasos-warPU")
    private EntityManager em;

    public TipoIncidenciaFacadeREST() {
        super(TipoIncidencia.class);
    }

    @POST
    @Override
    @Consumes({"application/xml", "application/json"})
    public void create(TipoIncidencia entity) {
        super.create(entity);
    }

    @PUT
    @Override
    @Consumes({"application/xml", "application/json"})
    public void edit(TipoIncidencia entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Long id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public TipoIncidencia find(@PathParam("id") Long id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({"application/json"})
    public List<TipoIncidencia> findAll() {
        return (List<TipoIncidencia>) em.createQuery("SELECT t.id, t.descripcion FROM TipoIncidencia t").getResultList();        
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<TipoIncidencia> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST() {
        return String.valueOf(super.count());
    }

    @java.lang.Override
    protected EntityManager getEntityManager() {
        return em;
    }
}
