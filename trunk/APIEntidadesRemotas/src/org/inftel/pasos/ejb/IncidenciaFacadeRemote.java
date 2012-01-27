/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.inftel.pasos.ejb;

import java.util.List;
import javax.ejb.Remote;
import org.inftel.pasos.entity.Incidencia;

/**
 *
 * @author aljiru
 */
@Remote
public interface IncidenciaFacadeRemote {

    void create(Incidencia incidencia);

    void edit(Incidencia incidencia);

    void remove(Incidencia incidencia);

    Incidencia find(Object id);

    List<Incidencia> findAll();

    List<Incidencia> findRange(int[] range);

    int count();

    public List findAllIncidencias();
    
    List<Incidencia> findHigher(String ultimo);
    
}
