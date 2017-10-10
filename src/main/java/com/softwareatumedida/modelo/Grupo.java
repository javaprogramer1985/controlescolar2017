/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softwareatumedida.modelo;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import lombok.Data;

/**
 *
 * @author a
 */
@Entity
@Table(name = "grupo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Grupo.findAll", query = "SELECT g FROM Grupo g"),
    @NamedQuery(name = "Grupo.findByGrupoId", query = "SELECT g FROM Grupo g WHERE g.grupoId = :grupoId"),
    @NamedQuery(name = "Grupo.findByGrupoDescripcion", query = "SELECT g FROM Grupo g WHERE g.grupoDescripcion = :grupoDescripcion")})
@Data
public class Grupo implements Serializable {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "grupoId")
    private Collection<Profesor> profesorCollection;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "GrupoId")
    private Integer grupoId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "GrupoDescripcion")
    private String grupoDescripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "grupoId")
    private Collection<Alumno> alumnoCollection;

    public Grupo() {
    }

    public Grupo(Integer grupoId) {
        this.grupoId = grupoId;
    }

    public Grupo(Integer grupoId, String grupoDescripcion) {
        this.grupoId = grupoId;
        this.grupoDescripcion = grupoDescripcion;
    }

//    @XmlTransient
//    public Collection<Alumno> getAlumnoCollection() {
//        return alumnoCollection;
//    }
//
//    public void setAlumnoCollection(Collection<Alumno> alumnoCollection) {
//        this.alumnoCollection = alumnoCollection;
//    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (grupoId != null ? grupoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Grupo)) {
            return false;
        }
        Grupo other = (Grupo) object;
        return !((this.grupoId == null && other.grupoId != null) || (this.grupoId != null && !this.grupoId.equals(other.grupoId)));
    }

    @Override
    public String toString() {
        return "com.softwareatumedica.modelo.Grupo[ grupoId=" + grupoId + " ]";
    }

    @XmlTransient
    public Collection<Profesor> getProfesorCollection() {
        return profesorCollection;
    }

    public void setProfesorCollection(Collection<Profesor> profesorCollection) {
        this.profesorCollection = profesorCollection;
    }
    
}
