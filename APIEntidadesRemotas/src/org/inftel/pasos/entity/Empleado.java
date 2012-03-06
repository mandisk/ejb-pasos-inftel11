/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.inftel.pasos.entity;

import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
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
@Table(name = "EMPLEADO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empleado.findAll", query = "SELECT e FROM Empleado e"),
    @NamedQuery(name = "Empleado.findById", query = "SELECT e FROM Empleado e WHERE e.id = :id")})
public class Empleado extends BaseEntity {
    @Size(max = 100)
    @Column(name = "USUARIO")
    private String usuario;
    @Size(max = 100)
    @Column(name = "CONTRASENA")
    private String contrasena;
    @OneToMany(mappedBy = "idEmpleadoFk")
    private Collection<Incidencia> incidenciaCollection;    
    @JoinColumn(name = "id_turno_fk", referencedColumnName = "id")
    @ManyToOne
    private Turno idTurnoFk;
    @JoinColumn(name = "id_persona_fk", referencedColumnName = "id")
    @ManyToOne
    private Persona idPersonaFk;

    public Empleado() {
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Turno getIdTurnoFk() {
        return idTurnoFk;
    }

    public void setIdTurnoFk(Turno idTurnoFk) {
        this.idTurnoFk = idTurnoFk;
    }

    public Persona getIdPersonaFk() {
        return idPersonaFk;
    }

    public void setIdPersonaFk(Persona idPersonaFk) {
        this.idPersonaFk = idPersonaFk;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    @XmlTransient
    public Collection<Incidencia> getIncidenciaCollection() {
        return incidenciaCollection;
    }

    public void setIncidenciaCollection(Collection<Incidencia> incidenciaCollection) {
        this.incidenciaCollection = incidenciaCollection;
    }    
}
