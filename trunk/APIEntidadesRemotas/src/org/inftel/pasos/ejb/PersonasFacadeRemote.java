/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.inftel.pasos.ejb;

import java.util.List;
import javax.ejb.Remote;
import org.inftel.pasos.entity.Personas;

/**
 *
 * @author aljiru
 */
@Remote
public interface PersonasFacadeRemote {

    void create(Personas personas);

    void edit(Personas personas);

    void remove(Personas personas);

    Personas find(Object id);

    List<Personas> findAll();

    List<Personas> findRange(int[] range);

    int count();
    
}
