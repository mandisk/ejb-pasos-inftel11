/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.inftel.pasos.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author aljiru
 */
@Entity
@Table(name = "FAMILIARES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Familiares.findAll", query = "SELECT f FROM Familiares f"),
    @NamedQuery(name = "Familiares.findByIdfamiliar", query = "SELECT f FROM Familiares f WHERE f.idFamiliar = :idFamiliar")})
public class Familiares implements Serializable {
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_FAMILIAR")
    private BigDecimal idFamiliar;
    private static final long serialVersionUID = 1L;
    @JoinColumn(name = "ID_USUARIO", referencedColumnName = "IMEI")
    @ManyToOne
    private Usuarios idUsuario;
    @JoinColumn(name = "ID_PERSONA", referencedColumnName = "ID_PERSONA")
    @ManyToOne
    private Personas idPersona;
    @JoinColumn(name = "ID_DISPONIBILIDAD", referencedColumnName = "ID")
    @ManyToOne
    private Disponibilidad idDisponibilidad;

    public Familiares() {
    }

    public Familiares(BigDecimal idFamiliar) {
        this.idFamiliar = idFamiliar;
    }

    public Usuarios getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuarios idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Personas getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Personas idPersona) {
        this.idPersona = idPersona;
    }

    public Disponibilidad getIdDisponibilidad() {
        return idDisponibilidad;
    }

    public void setIdDisponibilidad(Disponibilidad idDisponibilidad) {
        this.idDisponibilidad = idDisponibilidad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFamiliar != null ? idFamiliar.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Familiares)) {
            return false;
        }
        Familiares other = (Familiares) object;
        if ((this.idFamiliar == null && other.idFamiliar != null) || (this.idFamiliar != null && !this.idFamiliar.equals(other.idFamiliar))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.inftel.pasos.entity.Familiares[ idFamiliar=" + idFamiliar + " ]";
    }

    public BigDecimal getIdFamiliar() {
        return idFamiliar;
    }

    public void setIdFamiliar(BigDecimal idFamiliar) {
        this.idFamiliar = idFamiliar;
    }
    
}
