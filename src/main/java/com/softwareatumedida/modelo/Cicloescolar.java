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
@Table(name = "cicloescolar")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cicloescolar.findAll", query = "SELECT c FROM Cicloescolar c"),
    @NamedQuery(name = "Cicloescolar.findByCicloEscolarId", query = "SELECT c FROM Cicloescolar c WHERE c.cicloEscolarId = :cicloEscolarId"),
    @NamedQuery(name = "Cicloescolar.findByCicloEscolarDescripcion", query = "SELECT c FROM Cicloescolar c WHERE c.cicloEscolarDescripcion = :cicloEscolarDescripcion")})
@Data
public class Cicloescolar implements Serializable {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cicloEscolarId")
    private Collection<Profesor> profesorCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cicloEscolarId")
    private Collection<Calificaciones> calificacionesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cicloEscolarId")
    private Collection<Materias> materiasCollection;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CicloEscolarId")
    private Integer cicloEscolarId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "CicloEscolarDescripcion")
    private String cicloEscolarDescripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cicloEscolar")
    private Collection<Alumno> alumnoCollection;

    public Cicloescolar() {
    }

    public Cicloescolar(Integer cicloEscolarId) {
        this.cicloEscolarId = cicloEscolarId;
    }

    public Cicloescolar(Integer cicloEscolarId, String cicloEscolarDescripcion) {
        this.cicloEscolarId = cicloEscolarId;
        this.cicloEscolarDescripcion = cicloEscolarDescripcion;
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
        hash += (cicloEscolarId != null ? cicloEscolarId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cicloescolar)) {
            return false;
        }
        Cicloescolar other = (Cicloescolar) object;
        if ((this.cicloEscolarId == null && other.cicloEscolarId != null) || (this.cicloEscolarId != null && !this.cicloEscolarId.equals(other.cicloEscolarId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.softwareatumedica.modelo.Cicloescolar[ cicloEscolarId=" + cicloEscolarId + " ]";
    }

    @XmlTransient
    public Collection<Profesor> getProfesorCollection() {
        return profesorCollection;
    }

    public void setProfesorCollection(Collection<Profesor> profesorCollection) {
        this.profesorCollection = profesorCollection;
    }

    @XmlTransient
    public Collection<Calificaciones> getCalificacionesCollection() {
        return calificacionesCollection;
    }

    public void setCalificacionesCollection(Collection<Calificaciones> calificacionesCollection) {
        this.calificacionesCollection = calificacionesCollection;
    }

    @XmlTransient
    public Collection<Materias> getMateriasCollection() {
        return materiasCollection;
    }

    public void setMateriasCollection(Collection<Materias> materiasCollection) {
        this.materiasCollection = materiasCollection;
    }
    
}
