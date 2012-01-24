/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.inftel.pasos.ejb;

import java.util.List;
import javax.ejb.Remote;
import org.inftel.pasos.entity.Familiar;

/**
 *
 * @author aljiru
 */
@Remote
public interface FamiliarFacadeRemote {

    void create(Familiar familiar);

    void edit(Familiar familiar);

    void remove(Familiar familiar);

    Familiar find(Object id);

    List<Familiar> findAll();

    List<Familiar> findRange(int[] range);

    int count();
    
}
