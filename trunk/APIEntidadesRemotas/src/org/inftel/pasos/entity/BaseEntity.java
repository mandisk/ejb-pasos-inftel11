package org.inftel.pasos.entity;

import static javax.persistence.GenerationType.TABLE;

import java.io.Serializable;
import java.util.logging.Logger;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.TableGenerator;

/**
 * Entidad base para las entidades persistentes. Permite unificar el comportamiento y facilita el
 * desarrollo de los servicios DAO.<br>
 * 
 * @author ibaca
 * 
 */
@MappedSuperclass
public abstract class BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    static final Logger log = Logger.getLogger(BaseEntity.class.getName());
    @Id
    @TableGenerator(name = "base_entity_generator", initialValue = 1)
    @GeneratedValue(strategy = TABLE, generator = "base_entity_generator")
    private Long id;    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        if (!(getClass().isAssignableFrom(object.getClass()))) {
            return false;
        }
        BaseEntity other = (BaseEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName().toLowerCase() + " [id=" + getId() + "]";
    }
}
