/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.inftel.pasos.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author aljiru
 */
@Entity
@Table(name = "FAMILIAR")
@XmlRootElement 
@NamedQueries({
    @NamedQuery(name = "Familiar.findAll", query = "SELECT f FROM Familiar f"),
    @NamedQuery(name = "Familiar.findById", query = "SELECT f FROM Familiar f WHERE f.id = :id")})
public class Familiar extends BaseEntity {
    @JoinColumn(name = "id_usuario_fk", referencedColumnName = "id")
    @ManyToOne
    private Usuario idUsuarioFk;
    @JoinColumn(name = "id_disponibilidad_fk", referencedColumnName = "id")
    @ManyToOne
    private Disponibilidad idDisponibilidadFk;

    public Familiar() {
    }

    public Disponibilidad getIdDisponibilidadFk() {
        return idDisponibilidadFk;
    }

    public void setIdDisponibilidadFk(Disponibilidad idDisponibilidadFk) {
        this.idDisponibilidadFk = idDisponibilidadFk;
    }

    public Usuario getIdUsuarioFk() {
        return idUsuarioFk;
    }

    public void setIdUsuarioFk(Usuario idUsuarioFk) {
        this.idUsuarioFk = idUsuarioFk;
    }
}
