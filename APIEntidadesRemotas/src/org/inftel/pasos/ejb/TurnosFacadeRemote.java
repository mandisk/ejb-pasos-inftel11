/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.inftel.pasos.ejb;

import java.util.List;
import javax.ejb.Remote;
import org.inftel.pasos.entity.Turnos;

/**
 *
 * @author aljiru
 */
@Remote
public interface TurnosFacadeRemote {

    void create(Turnos turnos);

    void edit(Turnos turnos);

    void remove(Turnos turnos);

    Turnos find(Object id);

    List<Turnos> findAll();

    List<Turnos> findRange(int[] range);

    int count();
    
}
