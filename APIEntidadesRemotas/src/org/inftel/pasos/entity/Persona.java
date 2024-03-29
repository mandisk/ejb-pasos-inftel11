/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.inftel.pasos.entity;

import java.math.BigInteger;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author aljiru
 */
@Entity
@Table(name = "PERSONA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Persona.findAll", query = "SELECT p FROM Persona p"),
    @NamedQuery(name = "Persona.findById", query = "SELECT p FROM Persona p WHERE p.id = :id"),
    @NamedQuery(name = "Persona.findByTelefono", query = "SELECT p FROM Persona p WHERE p.telefono = :telefono"),
    @NamedQuery(name = "Persona.findByApellido1", query = "SELECT p FROM Persona p WHERE p.apellido1 = :apellido1"),
    @NamedQuery(name = "Persona.findByApellido2", query = "SELECT p FROM Persona p WHERE p.apellido2 = :apellido2"),
    @NamedQuery(name = "Persona.findByDireccion", query = "SELECT p FROM Persona p WHERE p.direccion = :direccion"),
    @NamedQuery(name = "Persona.findByLocalidad", query = "SELECT p FROM Persona p WHERE p.localidad = :localidad"),
    @NamedQuery(name = "Persona.findByProvincia", query = "SELECT p FROM Persona p WHERE p.provincia = :provincia"),
    @NamedQuery(name = "Persona.findByCodpostal", query = "SELECT p FROM Persona p WHERE p.codpostal = :codpostal"),
    @NamedQuery(name = "Persona.findByFecnacimiento", query = "SELECT p FROM Persona p WHERE p.fecnacimiento = :fecnacimiento"),
    @NamedQuery(name = "Persona.findByEmail", query = "SELECT p FROM Persona p WHERE p.email = :email"),
    @NamedQuery(name = "Persona.findByNombre", query = "SELECT p FROM Persona p WHERE p.nombre = :nombre")})
public class Persona extends BaseEntity {
    @Column(name = "FECNACIMIENTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecnacimiento;
    @OneToMany(mappedBy = "idPersonaFk")
    private Collection<Usuario> usuarioCollection;
    @OneToMany(mappedBy = "idPersonaFk")
    private Collection<Empleado> empleadoCollection;
    @Column(name = "TELEFONO")
    private BigInteger telefono;
    @Size(max = 50)
    @Column(name = "APELLIDO1")
    private String apellido1;
    @Size(max = 50)
    @Column(name = "APELLIDO2")
    private String apellido2;
    @Size(max = 50)
    @Column(name = "DIRECCION")
    private String direccion;
    @Size(max = 100)
    @Column(name = "LOCALIDAD")
    private String localidad;
    @Size(max = 50)
    @Column(name = "PROVINCIA")
    private String provincia;
    @Column(name = "CODPOSTAL")
    private BigInteger codpostal;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 50)
    @Column(name = "EMAIL")
    private String email;
    @Size(max = 50)
    @Column(name = "NOMBRE")
    private String nombre;    

    public Persona() {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        String info = "";
        info += "NOMBRE: " + nombre;
        info += "\nAPELLIDO1: " + apellido1;
        info += "\nAPELLIDO2: " + apellido2;
        info += "\nDIRECCION: " + direccion;
        info += "\nLOCALIDAD: " + localidad;
        info += "\nPROVINCIA: " + provincia;
        info += "\nCODIGO POSTAL: " + codpostal;
        info += "\nTELEFONO: " + telefono;
        info += "\nFECHA DE NACIMIENTO: " + fecnacimiento;
        info += "\nEMAIL: " + email;
        return info;
    }

    public Date getFecnacimiento() {
        return fecnacimiento;
    }

    public void setFecnacimiento(Date fecnacimiento) {
        this.fecnacimiento = fecnacimiento;
    }

    @XmlTransient
    public Collection<Usuario> getUsuarioCollection() {
        return usuarioCollection;
    }

    public void setUsuarioCollection(Collection<Usuario> usuarioCollection) {
        this.usuarioCollection = usuarioCollection;
    }

    @XmlTransient
    public Collection<Empleado> getEmpleadoCollection() {
        return empleadoCollection;
    }

    public void setEmpleadoCollection(Collection<Empleado> empleadoCollection) {
        this.empleadoCollection = empleadoCollection;
    }    
}
