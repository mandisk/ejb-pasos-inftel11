/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.inftel.pasos.entity;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "INCIDENCIA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Incidencia.findAll", query = "SELECT i FROM Incidencia i ORDER BY i.id DESC"),
    @NamedQuery(name = "Incidencia.findById", query = "SELECT i FROM Incidencia i WHERE i.id = :id"),
    @NamedQuery(name = "Incidencia.findByFecha", query = "SELECT i FROM Incidencia i WHERE i.fecha = :fecha"),
    @NamedQuery(name = "Incidencia.findByLongitud", query = "SELECT i FROM Incidencia i WHERE i.longitud = :longitud"),
    @NamedQuery(name = "Incidencia.findByLatitud", query = "SELECT i FROM Incidencia i WHERE i.latitud = :latitud"),
    @NamedQuery(name = "Incidencia.findByAltitud", query = "SELECT i FROM Incidencia i WHERE i.altitud = :altitud"),
    @NamedQuery(name = "Incidencia.findByTemperatura", query = "SELECT i FROM Incidencia i WHERE i.temperatura = :temperatura"),
    @NamedQuery(name = "Incidencia.findByNivelBateria", query = "SELECT i FROM Incidencia i WHERE i.nivelBateria = :nivelBateria"),
    @NamedQuery(name = "Incidencia.findByNumSatelites", query = "SELECT i FROM Incidencia i WHERE i.numSatelites = :numSatelites")})
public class Incidencia extends BaseEntity {
    @Column(name = "FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @JoinColumn(name = "id_empleado_fk", referencedColumnName = "id")
    @ManyToOne
    private Empleado idEmpleadoFk;    
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
    @JoinColumn(name = "id_usuario_fk", referencedColumnName = "id")
    @ManyToOne
    private Usuario idUsuarioFk;
    @JoinColumn(name = "id_tincidencia_fk", referencedColumnName = "id")
    @ManyToOne
    private TipoIncidencia idTincidenciaFk;

    public Incidencia() {
    }

    public Empleado getIdEmpleadoFk() {
        return idEmpleadoFk;
    }

    public void setIdEmpleadoFk(Empleado idEmpleadoFk) {
        this.idEmpleadoFk = idEmpleadoFk;
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

    public TipoIncidencia getIdTincidenciaFk() {
        return idTincidenciaFk;
    }

    public void setIdTincidenciaFk(TipoIncidencia idTincidenciaFk) {
        this.idTincidenciaFk = idTincidenciaFk;
    }

    public Usuario getIdUsuarioFk() {
        return idUsuarioFk;
    }

    public void setIdUsuarioFk(Usuario idUsuarioFk) {
        this.idUsuarioFk = idUsuarioFk;
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
