/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.inftel.pasos.ejb;

import java.util.List;
import javax.ejb.Remote;
import org.inftel.pasos.entity.Turno;

/**
 *
 * @author aljiru
 */
@Remote
public interface TurnoFacadeRemote {

    void create(Turno turno);

    void edit(Turno turno);

    void remove(Turno turno);

    Turno find(Object id);

    List<Turno> findAll();

    List<Turno> findRange(int[] range);

    int count();
    
}
