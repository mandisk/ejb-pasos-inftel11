/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.inftel.pasos.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author aljiru
 */
@Entity
@Table(name = "PERSONAS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Personas.findAll", query = "SELECT p FROM Personas p"),
    @NamedQuery(name = "Personas.findByIdPersona", query = "SELECT p FROM Personas p WHERE p.idPersona = :idPersona"),
    @NamedQuery(name = "Personas.findByTelefono", query = "SELECT p FROM Personas p WHERE p.telefono = :telefono"),
    @NamedQuery(name = "Personas.findByApellido1", query = "SELECT p FROM Personas p WHERE p.apellido1 = :apellido1"),
    @NamedQuery(name = "Personas.findByApellido2", query = "SELECT p FROM Personas p WHERE p.apellido2 = :apellido2"),
    @NamedQuery(name = "Personas.findByDireccion", query = "SELECT p FROM Personas p WHERE p.direccion = :direccion"),
    @NamedQuery(name = "Personas.findByLocalidad", query = "SELECT p FROM Personas p WHERE p.localidad = :localidad"),
    @NamedQuery(name = "Personas.findByProvincia", query = "SELECT p FROM Personas p WHERE p.provincia = :provincia"),
    @NamedQuery(name = "Personas.findByCodpostal", query = "SELECT p FROM Personas p WHERE p.codpostal = :codpostal"),
    @NamedQuery(name = "Personas.findByFecnacimiento", query = "SELECT p FROM Personas p WHERE p.fecnacimiento = :fecnacimiento"),
    @NamedQuery(name = "Personas.findByEmail", query = "SELECT p FROM Personas p WHERE p.email = :email")})
public class Personas implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_PERSONA")
    private BigDecimal idPersona;
    @Column(name = "TELEFONO")
    private BigInteger telefono;
    @Column(name = "APELLIDO1")
    private String apellido1;
    @Column(name = "APELLIDO2")
    private String apellido2;
    @Column(name = "DIRECCION")
    private String direccion;
    @Column(name = "LOCALIDAD")
    private String localidad;
    @Column(name = "PROVINCIA")
    private String provincia;
    @Column(name = "CODPOSTAL")
    private BigInteger codpostal;
    @Column(name = "FECNACIMIENTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecnacimiento;
    @Column(name = "EMAIL")
    private String email;
    @OneToMany(mappedBy = "idPersona")
    private Collection<Usuarios> usuariosCollection;
    @OneToMany(mappedBy = "idPersona")
    private Collection<Familiares> familiaresCollection;
    @OneToMany(mappedBy = "idPersona")
    private Collection<Empleados> empleadosCollection;

    public Personas() {
    }

    public Personas(BigDecimal idPersona) {
        this.idPersona = idPersona;
    }

    public BigDecimal getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(BigDecimal idPersona) {
        this.idPersona = idPersona;
    }

    public BigInteger getTelefono() {
        return telefono;
    }

    public void setTelefono(BigInteger telefono) {
        this.telefono = telefono;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public BigInteger getCodpostal() {
        return codpostal;
    }

    public void setCodpostal(BigInteger codpostal) {
        this.codpostal = codpostal;
    }

    public Date getFecnacimiento() {
        return fecnacimiento;
    }

    public void setFecnacimiento(Date fecnacimiento) {
        this.fecnacimiento = fecnacimiento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @XmlTransient
    public Collection<Usuarios> getUsuariosCollection() {
        return usuariosCollection;
    }

    public void setUsuariosCollection(Collection<Usuarios> usuariosCollection) {
        this.usuariosCollection = usuariosCollection;
    }

    @XmlTransient
    public Collection<Familiares> getFamiliaresCollection() {
        return familiaresCollection;
    }

    public void setFamiliaresCollection(Collection<Familiares> familiaresCollection) {
        this.familiaresCollection = familiaresCollection;
    }

    @XmlTransient
    public Collection<Empleados> getEmpleadosCollection() {
        return empleadosCollection;
    }

    public void setEmpleadosCollection(Collection<Empleados> empleadosCollection) {
        this.empleadosCollection = empleadosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPersona != null ? idPersona.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Personas)) {
            return false;
        }
        Personas other = (Personas) object;
        if ((this.idPersona == null && other.idPersona != null) || (this.idPersona != null && !this.idPersona.equals(other.idPersona))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.inftel.pasos.entity.Personas[ idPersona=" + idPersona + " ]";
    }
    
}
