/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.inftel.pasos.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author aljiru
 */
@Entity
@Table(name = "USUARIOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuarios.findAll", query = "SELECT u FROM Usuarios u"),
    @NamedQuery(name = "Usuarios.findByImei", query = "SELECT u FROM Usuarios u WHERE u.imei = :imei")})
public class Usuarios implements Serializable {
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_USUARIO")
    @GeneratedValue(strategy = GenerationType.AUTO, generator="usuarios_seq_gen")
    @SequenceGenerator(name="usuarios_seq_gen", sequenceName="PERSONAS_SEQUENCE")
    private BigDecimal idUsuario;
    @Column(name = "IMEI")
    private BigInteger imei;
    private static final long serialVersionUID = 1L;
    @Lob
    @Column(name = "FOTO")
    private Serializable foto;
    @OneToMany(mappedBy = "idUsuario")
    private Collection<Incidencias> incidenciasCollection;
    @JoinColumn(name = "ID_PERSONA", referencedColumnName = "ID_PERSONA")
    @ManyToOne(cascade=CascadeType.PERSIST)
    private Personas idPersona;
    @OneToMany(mappedBy = "idUsuario")
    private Collection<Familiares> familiaresCollection;

    public Usuarios() {
    }

    public Serializable getFoto() {
        return foto;
    }

    public void setFoto(Serializable foto) {
        this.foto = foto;
    }

    @XmlTransient
    public Collection<Incidencias> getIncidenciasCollection() {
        return incidenciasCollection;
    }

    public void setIncidenciasCollection(Collection<Incidencias> incidenciasCollection) {
        this.incidenciasCollection = incidenciasCollection;
    }

    public Personas getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Personas idPersona) {
        this.idPersona = idPersona;
    }

    @XmlTransient
    public Collection<Familiares> getFamiliaresCollection() {
        return familiaresCollection;
    }

    public void setFamiliaresCollection(Collection<Familiares> familiaresCollection) {
        this.familiaresCollection = familiaresCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (imei != null ? imei.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuarios)) {
            return false;
        }
        Usuarios other = (Usuarios) object;
        if ((this.imei == null && other.imei != null) || (this.imei != null && !this.imei.equals(other.imei))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        String info = "";
        info += "\nIMEI: " + imei;
        info += "\nFOTO: " + foto;
        info += "\n" + idPersona.toString();
        return info;
    }

    public Usuarios(BigDecimal idUsuario) {
        this.idUsuario = idUsuario;
    }

    public BigDecimal getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(BigDecimal idUsuario) {
        this.idUsuario = idUsuario;
    }

    public BigInteger getImei() {
        return imei;
    }

    public void setImei(BigInteger imei) {
        this.imei = imei;
    }
    
}
