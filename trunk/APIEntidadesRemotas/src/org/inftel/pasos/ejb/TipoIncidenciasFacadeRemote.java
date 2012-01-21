/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.inftel.pasos.ejb;

import java.util.List;
import javax.ejb.Remote;
import org.inftel.pasos.entity.TipoIncidencias;

/**
 *
 * @author aljiru
 */
@Remote
public interface TipoIncidenciasFacadeRemote {

    void create(TipoIncidencias tipoIncidencias);

    void edit(TipoIncidencias tipoIncidencias);

    void remove(TipoIncidencias tipoIncidencias);

    TipoIncidencias find(Object id);

    List<TipoIncidencias> findAll();

    List<TipoIncidencias> findRange(int[] range);

    int count();
    
}
