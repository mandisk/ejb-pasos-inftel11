/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.inftel.pasos.ejb;

import java.util.List;
import javax.ejb.Remote;
import org.inftel.pasos.entity.Disponibilidad;

/**
 *
 * @author aljiru
 */
@Remote
public interface DisponibilidadFacadeRemote {

    void create(Disponibilidad disponibilidad);

    void edit(Disponibilidad disponibilidad);

    void remove(Disponibilidad disponibilidad);

    Disponibilidad find(Object id);

    List<Disponibilidad> findAll();

    List<Disponibilidad> findRange(int[] range);

    int count();
    
}
