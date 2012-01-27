/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.inftel.pasos.beans;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Date;
import org.inftel.pasos.entity.Incidencia;
import org.inftel.pasos.entity.TipoIncidencia;
import org.inftel.pasos.entity.Usuario;

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