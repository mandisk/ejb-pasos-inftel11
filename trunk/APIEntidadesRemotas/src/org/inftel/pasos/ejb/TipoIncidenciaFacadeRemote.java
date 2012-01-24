/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.inftel.pasos.ejb;

import java.util.List;
import javax.ejb.Remote;
import org.inftel.pasos.entity.TipoIncidencia;

/**
 *
 * @author aljiru
 */
@Remote
public interface TipoIncidenciaFacadeRemote {

    void create(TipoIncidencia tipoIncidencia);

    void edit(TipoIncidencia tipoIncidencia);

    void remove(TipoIncidencia tipoIncidencia);

    TipoIncidencia find(Object id);

    List<TipoIncidencia> findAll();

    List<TipoIncidencia> findRange(int[] range);

    int count();
    
}
