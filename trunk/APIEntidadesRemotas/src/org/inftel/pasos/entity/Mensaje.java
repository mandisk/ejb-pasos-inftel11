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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author aljiru
 */
@Entity
@Table(name = "MENSAJE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mensaje.findAll", query = "SELECT m FROM Mensaje m"),
    @NamedQuery(name = "Mensaje.findByIdMensaje", query = "SELECT m FROM Mensaje m WHERE m.idMensaje = :idMensaje"),
    @NamedQuery(name = "Mensaje.findByIdUsuario", query = "SELECT m FROM Mensaje m WHERE m.idUsuario = :idUsuario"),
    @NamedQuery(name = "Mensaje.findByTeleasistencia", query = "SELECT m FROM Mensaje m WHERE m.teleasistencia = :teleasistencia"),
    @NamedQuery(name = "Mensaje.findByTexto", query = "SELECT m FROM Mensaje m WHERE m.texto = :texto")})
public class Mensaje implements Serializable {
    @Column(name = "ID_USUARIO")
    private BigInteger idUsuario;
    @Column(name = "FECHA")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_MENSAJE")
    @GeneratedValue(strategy = GenerationType.AUTO, generator="msg_seq_gen")
    @SequenceGenerator(name="msg_seq_gen", sequenceName="SEQUENCE1", allocationSize=1)
    private BigDecimal idMensaje;
    @Column(name = "TELEASISTENCIA")
    private BigInteger teleasistencia;
    @Size(max = 255)
    @Column(name = "TEXTO")
    private String texto;

    public Mensaje() {
    }

    public Mensaje(BigDecimal idMensaje) {
        this.idMensaje = idMensaje;
    }

    public BigDecimal getIdMensaje() {
        return idMensaje;
    }

    public void setIdMensaje(BigDecimal idMensaje) {
        this.idMensaje = idMensaje;
    }

    public BigInteger getTeleasistencia() {
        return teleasistencia;
    }

    public void setTeleasistencia(BigInteger teleasistencia) {
        this.teleasistencia = teleasistencia;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMensaje != null ? idMensaje.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mensaje)) {
            return false;
        }
        Mensaje other = (Mensaje) object;
        if ((this.idMensaje == null && other.idMensaje != null) || (this.idMensaje != null && !this.idMensaje.equals(other.idMensaje))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        String info = "";
        info += "\nUSUARIO: " + idUsuario;
        info += "\nTELEASISTENCIA: " + teleasistencia;
        info += "\nTEXTO: " + texto;
        return info;
    }

    public BigInteger getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(BigInteger idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
}
