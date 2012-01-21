/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.inftel.pasos.ejb;

import java.util.List;
import javax.ejb.Remote;
import org.inftel.pasos.entity.Usuarios;

/**
 *
 * @author aljiru
 */
@Remote
public interface UsuariosFacadeRemote {

    void create(Usuarios usuarios);

    void edit(Usuarios usuarios);

    void remove(Usuarios usuarios);

    Usuarios find(Object id);

    List<Usuarios> findAll();

    List<Usuarios> findRange(int[] range);

    int count();
    
}
