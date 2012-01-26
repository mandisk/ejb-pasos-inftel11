/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.inftel.pasos.ejb;

import java.util.List;
import javax.ejb.Remote;
import org.inftel.pasos.entity.Mensaje;

/**
 *
 * @author aljiru
 */
@Remote
public interface MensajeFacadeRemote {

    void create(Mensaje mensaje);

    void edit(Mensaje mensaje);

    void remove(Mensaje mensaje);

    Mensaje find(Object id);

    List<Mensaje> findAll();

    List<Mensaje> findRange(int[] range);
    
    List<Mensaje> findHigher(String idm, String ses, String tel);
    
    Mensaje findByData(String ses, String tel, String txt);

    int count();
    
}
