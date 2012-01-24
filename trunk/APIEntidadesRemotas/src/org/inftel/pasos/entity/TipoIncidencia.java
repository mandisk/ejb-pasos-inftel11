/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.inftel.pasos.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author aljiru
 */
@Entity
@Table(name = "TIPO_INCIDENCIA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoIncidencia.findAll", query = "SELECT t FROM TipoIncidencia t"),
    @NamedQuery(name = "TipoIncidencia.findById", query = "SELECT t FROM TipoIncidencia t WHERE t.id = :id"),
    @NamedQuery(name = "TipoIncidencia.findByDescripcion", query = "SELECT t FROM TipoIncidencia t WHERE t.descripcion = :descripcion")})
public class TipoIncidencia implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Size(max = 200)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @OneToMany(mappedBy = "idTincidencia")
    private Collection<Incidencia> incidenciaCollection;

    public TipoIncidencia() {
    }

    public TipoIncidencia(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public Collection<Incidencia> getIncidenciaCollection() {
        return incidenciaCollection;
    }

    public void setIncidenciaCollection(Collection<Incidencia> incidenciaCollection) {
        this.incidenciaCollection = incidenciaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoIncidencia)) {
            return false;
        }
        TipoIncidencia other = (TipoIncidencia) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.inftel.pasos.entity.TipoIncidencia[ id=" + id + " ]";
    }
    
}
