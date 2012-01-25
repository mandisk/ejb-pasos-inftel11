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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author aljiru
 */
@Entity
@Table(name = "INCIDENCIA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Incidencia.findAll", query = "SELECT i FROM Incidencia i"),
    @NamedQuery(name = "Incidencia.findByIncidencia", query = "SELECT i FROM Incidencia i WHERE i.incidencia = :incidencia"),
    @NamedQuery(name = "Incidencia.findByFecha", query = "SELECT i FROM Incidencia i WHERE i.fecha = :fecha"),
    @NamedQuery(name = "Incidencia.findByLongitud", query = "SELECT i FROM Incidencia i WHERE i.longitud = :longitud"),
    @NamedQuery(name = "Incidencia.findByLatitud", query = "SELECT i FROM Incidencia i WHERE i.latitud = :latitud"),
    @NamedQuery(name = "Incidencia.findByAltitud", query = "SELECT i FROM Incidencia i WHERE i.altitud = :altitud"),
    @NamedQuery(name = "Incidencia.findByTemperatura", query = "SELECT i FROM Incidencia i WHERE i.temperatura = :temperatura"),
    @NamedQuery(name = "Incidencia.findByNivelBateria", query = "SELECT i FROM Incidencia i WHERE i.nivelBateria = :nivelBateria"),
    @NamedQuery(name = "Incidencia.findByNumSatelites", query = "SELECT i FROM Incidencia i WHERE i.numSatelites = :numSatelites")})
public class Incidencia implements Serializable {
    @Column(name =     "FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @JoinColumn(name = "ID_EMPLEADO", referencedColumnName = "ID_EMPLEADO")
    @ManyToOne
    private Empleado idEmpleado;
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "INCIDENCIA")
    @GeneratedValue(strategy = GenerationType.AUTO, generator="personas_seq_gen")
    @SequenceGenerator(name="personas_seq_gen", sequenceName="PERSONAS_SEQUENCE")
    private BigDecimal incidencia;
    @Column(name = "LONGITUD")
    private BigDecimal longitud;
    @Column(name = "LATITUD")
    private BigDecimal latitud;
    @Column(name = "ALTITUD")
    private BigDecimal altitud;
    @Column(name = "TEMPERATURA")
    private Double temperatura;
    @Column(name = "NIVEL_BATERIA")
    private BigInteger nivelBateria;
    @Column(name = "NUM_SATELITES")
    private BigInteger numSatelites;
    @JoinColumn(name = "ID_USUARIO", referencedColumnName = "ID_USUARIO")
    @ManyToOne
    private Usuario idUsuario;
    @JoinColumn(name = "ID_TINCIDENCIA", referencedColumnName = "ID")
    @ManyToOne
    private TipoIncidencia idTincidencia;

    public Incidencia() {
    }

    public Incidencia(BigDecimal incidencia) {
        this.incidencia = incidencia;
    }

    public BigDecimal getIncidencia() {
        return incidencia;
    }

    public void setIncidencia(BigDecimal incidencia) {
        this.incidencia = incidencia;
    }

    public Empleado getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Empleado idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public BigDecimal getLongitud() {
        return longitud;
    }

    public void setLongitud(BigDecimal longitud) {
        this.longitud = longitud;
    }

    public BigDecimal getLatitud() {
        return latitud;
    }

    public void setLatitud(BigDecimal latitud) {
        this.latitud = latitud;
    }

    public BigDecimal getAltitud() {
        return altitud;
    }

    public void setAltitud(BigDecimal altitud) {
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

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    public TipoIncidencia getIdTincidencia() {
        return idTincidencia;
    }

    public void setIdTincidencia(TipoIncidencia idTincidencia) {
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
        if (!(object instanceof Incidencia)) {
            return false;
        }
        Incidencia other = (Incidencia) object;
        if ((this.incidencia == null && other.incidencia != null) || (this.incidencia != null && !this.incidencia.equals(other.incidencia))) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        String info = "";
        info += "FECHA: " + fecha;
        info += "\nLONGITUD: " + longitud;
        info += "\nLATITUD: " + latitud;
        info += "\nALTITUD: " + altitud;
        info += "\nTEMPERATURA: " + temperatura;
        info += "\nNIVEL BATERIA: " + nivelBateria;
        info += "\nNUMERO SATELITES: " + numSatelites;
        return info;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
}
