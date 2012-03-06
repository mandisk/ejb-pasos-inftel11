/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.inftel.pasos.beans;

import java.io.Serializable;
import java.util.Collection;
import org.inftel.pasos.entity.Incidencia;

/**
 *
 * @author Manuel Valls
 */
public class IncidenciaBean implements Serializable {

    Collection<Incidencia> incidenciaCollection;
    private int ultima;

    public IncidenciaBean() {
    }

    public Collection<Incidencia> getIncidenciaCollection() {
        return incidenciaCollection;
    }

    public void setIncidenciaCollection(Collection<Incidencia> incidenciaCollection) {
        this.incidenciaCollection = incidenciaCollection;
    }

    public int getUltima() {
        return ultima;
    }

    public void setUltima(int ultima) {
        this.ultima = ultima;
    }
}