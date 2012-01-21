/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.inftel.pasos.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author aljiru
 */
@Entity
@Table(name = "INCIDENCIAS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Incidencias.findAll", query = "SELECT i FROM Incidencias i"),
    @NamedQuery(name = "Incidencias.findByIncidencia", query = "SELECT i FROM Incidencias i WHERE i.incidencia = :incidencia"),
    @NamedQuery(name = "Incidencias.findByFecha", query = "SELECT i FROM Incidencias i WHERE i.fecha = :fecha"),
    @NamedQuery(name = "Incidencias.findByLongitud", query = "SELECT i FROM Incidencias i WHERE i.longitud = :longitud"),
    @NamedQuery(name = "Incidencias.findByLatitud", query = "SELECT i FROM Incidencias i WHERE i.latitud = :latitud"),
    @NamedQuery(name = "Incidencias.findByAltitud", query = "SELECT i FROM Incidencias i WHERE i.altitud = :altitud"),
    @NamedQuery(name = "Incidencias.findByTemperatura", query = "SELECT i FROM Incidencias i WHERE i.temperatura = :temperatura"),
    @NamedQuery(name = "Incidencias.findByNivelBateria", query = "SELECT i FROM Incidencias i WHERE i.nivelBateria = :nivelBateria"),
    @NamedQuery(name = "Incidencias.findByNumSatelites", query = "SELECT i FROM Incidencias i WHERE i.numSatelites = :numSatelites")})
public class Incidencias implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "INCIDENCIA")
    private BigDecimal incidencia;
    @Column(name = "FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Column(name = "LONGITUD")
    private String longitud;
    @Column(name = "LATITUD")
    private String latitud;
    @Column(name = "ALTITUD")
    private String altitud;
    @Column(name = "TEMPERATURA")
    private Double temperatura;
    @Column(name = "NIVEL_BATERIA")
    private BigInteger nivelBateria;
    @Column(name = "NUM_SATELITES")
    private BigInteger numSatelites;
    @JoinColumn(name = "ID_USUARIO", referencedColumnName = "IMEI")
    @ManyToOne
    private Usuarios idUsuario;
    @JoinColumn(name = "ID_TINCIDENCIA", referencedColumnName = "ID")
    @ManyToOne
    private TipoIncidencias idTincidencia;

    public Incidencias() {
    }

    public Incidencias(BigDecimal incidencia) {
        this.incidencia = incidencia;
    }

    public BigDecimal getIncidencia() {
        return incidencia;
    }

    public void setIncidencia(BigDecimal incidencia) {
        this.incidencia = incidencia;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getAltitud() {
        return altitud;
    }

    public void setAltitud(String altitud) {
        this.altitud = altitud;
    }

    public Double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(Double temperatura) {
        this.temperatura = temperatura;
    }

    public BigInteger getNivelBateria() {
        return nivelBateria;
    }

    public void setNivelBateria(BigInteger nivelBateria) {
        this.nivelBateria = nivelBateria;
    }

    public BigInteger getNumSatelites() {
        return numSatelites;
    }

    public void setNumSatelites(BigInteger numSatelites) {
        this.numSatelites = numSatelites;
    }

    public Usuarios getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuarios idUsuario) {
        this.idUsuario = idUsuario;
    }

    public TipoIncidencias getIdTincidencia() {
        return idTincidencia;
    }

    public void setIdTincidencia(TipoIncidencias idTincidencia) {
        this.idTincidencia = idTincidencia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (incidencia != null ? incidencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Incidencias)) {
            return false;
        }
        Incidencias other = (Incidencias) object;
        if ((this.incidencia == null && other.incidencia != null) || (this.incidencia != null && !this.incidencia.equals(other.incidencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.inftel.pasos.entity.Incidencias[ incidencia=" + incidencia + " ]";
    }
    
}
