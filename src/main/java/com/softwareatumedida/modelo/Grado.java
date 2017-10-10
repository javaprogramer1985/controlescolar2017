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
@Table(name = "grado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Grado.findAll", query = "SELECT g FROM Grado g"),
    @NamedQuery(name = "Grado.findByGradoId", query = "SELECT g FROM Grado g WHERE g.gradoId = :gradoId"),
    @NamedQuery(name = "Grado.findByGradoDescripcion", query = "SELECT g FROM Grado g WHERE g.gradoDescripcion = :gradoDescripcion")})
@Data
public class Grado implements Serializable {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gradoId")
    private Collection<Profesor> profesorCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gradoId")
    private Collection<Materias> materiasCollection;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "GradoId")
    private Integer gradoId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "GradoDescripcion")
    private String gradoDescripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gradoId")
    private Collection<Alumno> alumnoCollection;

    public Grado() {
    }

    public Grado(Integer gradoId) {
        this.gradoId = gradoId;
    }

    public Grado(Integer gradoId, String gradoDescripcion) {
        this.gradoId = gradoId;
        this.gradoDescripcion = gradoDescripcion;
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
        hash += (gradoId != null ? gradoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Grado)) {
            return false;
        }
        Grado other = (Grado) object;
        return !((this.gradoId == null && other.gradoId != null) || (this.gradoId != null && !this.gradoId.equals(other.gradoId)));
    }

    @Override
    public String toString() {
        return "com.softwareatumedica.modelo.Grado[ gradoId=" + gradoId + " ]";
    }

    @XmlTransient
    public Collection<Profesor> getProfesorCollection() {
        return profesorCollection;
    }

    public void setProfesorCollection(Collection<Profesor> profesorCollection) {
        this.profesorCollection = profesorCollection;
    }

    @XmlTransient
    public Collection<Materias> getMateriasCollection() {
        return materiasCollection;
    }

    public void setMateriasCollection(Collection<Materias> materiasCollection) {
        this.materiasCollection = materiasCollection;
    }
    
}
