/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.inftel.pasos.beans;

import java.io.Serializable;
import org.inftel.pasos.entity.Persona;
import org.inftel.pasos.entity.Usuario;

/**
 *
 * @author Manuel Valls
 */
public class PersonaBean implements Serializable {
    Usuario usuario;
    public PersonaBean(){}

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

   
}
