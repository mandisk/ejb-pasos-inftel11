/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.inftel.pasos.entity;

import java.math.BigInteger;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author aljiru
 */
@Entity
@Table(name = "USUARIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findByIdUsuario", query = "SELECT u FROM Usuario u WHERE u.id = :idUsuario"),
    @NamedQuery(name = "Usuario.findByImei", query = "SELECT u FROM Usuario u WHERE u.imei = :imei")})
public class Usuario extends BaseEntity {
    @Lob
    @Column(name = "FOTO")
    private byte[] foto;
    @Column(name = "IMEI")
    private BigInteger imei;
    @JoinColumn(name = "id_persona_fk", referencedColumnName = "id")
    @ManyToOne(cascade=CascadeType.PERSIST)
    private Persona idPersonaFk;
    @OneToMany(mappedBy = "idUsuarioFk")
    private Collection<Incidencia> incidenciaCollection;
    @OneToMany(mappedBy = "idUsuarioFk")
    private Collection<Familiar> familiarCollection;
    @Size(max = 255)
    @Column(name = "GRUPO")
    private String grupo;


    public Usuario() {
    }

    public BigInteger getImei() {
        return imei;
    }

    public void setImei(BigInteger imei) {
        this.imei = imei;
    }

    public Persona getIdPersonaFk() {
        return idPersonaFk;
    }

    public void setIdPersonaFk(Persona idPersonaFk) {
        this.idPersonaFk = idPersonaFk;
    }

    @XmlTransient
    public Collection<Incidencia> getIncidenciaCollection() {
        return incidenciaCollection;
    }

    public void setIncidenciaCollection(Collection<Incidencia> incidenciaCollection) {
        this.incidenciaCollection = incidenciaCollection;
    }

    @XmlTransient
    public Collection<Familiar> getFamiliarCollection() {
        return familiarCollection;
    }

    public void setFamiliarCollection(Collection<Familiar> familiarCollection) {
        this.familiarCollection = familiarCollection;
    }

    @Override
    public String toString() {
        String info = "";
        info += "IMEI: " + imei;
        info += "\n" + idPersonaFk.toString();
        return info;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }
    
}
