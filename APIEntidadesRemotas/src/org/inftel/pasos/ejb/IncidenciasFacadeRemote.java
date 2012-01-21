/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.inftel.pasos.ejb;

import java.util.List;
import javax.ejb.Remote;
import org.inftel.pasos.entity.Incidencias;

/**
 *
 * @author aljiru
 */
@Remote
public interface IncidenciasFacadeRemote {

    void create(Incidencias incidencias);

    void edit(Incidencias incidencias);

    void remove(Incidencias incidencias);

    Incidencias find(Object id);

    List<Incidencias> findAll();

    List<Incidencias> findRange(int[] range);

    int count();
    
}
