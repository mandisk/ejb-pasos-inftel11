/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.inftel.pasos.entity;

import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
    @NamedQuery(name = "Mensaje.findById", query = "SELECT m FROM Mensaje m WHERE m.id = :id"),
    @NamedQuery(name = "Mensaje.findByIdUsuario", query = "SELECT m FROM Mensaje m WHERE m.idUsuario = :idUsuario"),
    @NamedQuery(name = "Mensaje.findByTeleasistencia", query = "SELECT m FROM Mensaje m WHERE m.teleasistencia = :teleasistencia"),
    @NamedQuery(name = "Mensaje.findByTexto", query = "SELECT m FROM Mensaje m WHERE m.texto = :texto")})
public class Mensaje extends BaseEntity {
    @Column(name = "ID_USUARIO")
    private BigInteger idUsuario;
    @Column(name = "FECHA")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Column(name = "TELEASISTENCIA")
    private BigInteger teleasistencia;
    @Size(max = 255)
    @Column(name = "TEXTO")
    private String texto;

    public Mensaje() {
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
