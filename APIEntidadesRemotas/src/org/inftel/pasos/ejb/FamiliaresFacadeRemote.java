/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.inftel.pasos.ejb;

import java.util.List;
import javax.ejb.Remote;
import org.inftel.pasos.entity.Familiares;

/**
 *
 * @author aljiru
 */
@Remote
public interface FamiliaresFacadeRemote {

    void create(Familiares familiares);

    void edit(Familiares familiares);

    void remove(Familiares familiares);

    Familiares find(Object id);

    List<Familiares> findAll();

    List<Familiares> findRange(int[] range);

    int count();
    
}
