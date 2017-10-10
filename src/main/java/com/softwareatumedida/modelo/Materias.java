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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author a
 */
@Entity
@Table(name = "materias")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Materias.findAll", query = "SELECT m FROM Materias m"),
    @NamedQuery(name = "Materias.findByMateriasId", query = "SELECT m FROM Materias m WHERE m.materiasId = :materiasId"),
    @NamedQuery(name = "Materias.findByMateriasDescripcion", query = "SELECT m FROM Materias m WHERE m.materiasDescripcion = :materiasDescripcion")})
public class Materias implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MateriasId")
    private Integer materiasId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "MateriasDescripcion")
    private String materiasDescripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "materiasId")
    private Collection<Calificaciones> calificacionesCollection;
    @JoinColumn(name = "GradoId", referencedColumnName = "GradoId")
    @ManyToOne(optional = false)
    private Grado gradoId;
    @JoinColumn(name = "CicloEscolarId", referencedColumnName = "CicloEscolarId")
    @ManyToOne(optional = false)
    private Cicloescolar cicloEscolarId;

    public Materias() {
    }

    public Materias(Integer materiasId) {
        this.materiasId = materiasId;
    }

    public Materias(Integer materiasId, String materiasDescripcion) {
        this.materiasId = materiasId;
        this.materiasDescripcion = materiasDescripcion;
    }

    public Integer getMateriasId() {
        return materiasId;
    }

    public void setMateriasId(Integer materiasId) {
        this.materiasId = materiasId;
    }

    public String getMateriasDescripcion() {
        return materiasDescripcion;
    }

    public void setMateriasDescripcion(String materiasDescripcion) {
        this.materiasDescripcion = materiasDescripcion;
    }

    @XmlTransient
    public Collection<Calificaciones> getCalificacionesCollection() {
        return calificacionesCollection;
    }

    public void setCalificacionesCollection(Collection<Calificaciones> calificacionesCollection) {
        this.calificacionesCollection = calificacionesCollection;
    }

    public Grado getGradoId() {
        return gradoId;
    }

    public void setGradoId(Grado gradoId) {
        this.gradoId = gradoId;
    }

    public Cicloescolar getCicloEscolarId() {
        return cicloEscolarId;
    }

    public void setCicloEscolarId(Cicloescolar cicloEscolarId) {
        this.cicloEscolarId = cicloEscolarId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (materiasId != null ? materiasId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Materias)) {
            return false;
        }
        Materias other = (Materias) object;
        if ((this.materiasId == null && other.materiasId != null) || (this.materiasId != null && !this.materiasId.equals(other.materiasId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.softwareatumedida.modelo.Materias[ materiasId=" + materiasId + " ]";
    }
    
}
