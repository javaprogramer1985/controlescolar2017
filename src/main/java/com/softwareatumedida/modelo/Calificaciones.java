/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softwareatumedida.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author a
 */
@Entity
@Table(name = "calificaciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Calificaciones.findAll", query = "SELECT c FROM Calificaciones c"),
    @NamedQuery(name = "Calificaciones.findByAlumnoMatricula", query = "SELECT c FROM Calificaciones c WHERE c.calificacionesPK.alumnoMatricula = :alumnoMatricula"),
    @NamedQuery(name = "Calificaciones.findByCalificacionId", query = "SELECT c FROM Calificaciones c WHERE c.calificacionesPK.calificacionId = :calificacionId"),
    @NamedQuery(name = "Calificaciones.findByMateriaRegularizada", query = "SELECT c FROM Calificaciones c WHERE c.materiaRegularizada = :materiaRegularizada"),
    @NamedQuery(name = "Calificaciones.findByCalificacionPuntos", query = "SELECT c FROM Calificaciones c WHERE c.calificacionPuntos = :calificacionPuntos"),
    @NamedQuery(name = "Calificaciones.findByCalificacionObservacion", query = "SELECT c FROM Calificaciones c WHERE c.calificacionObservacion = :calificacionObservacion")})
public class Calificaciones implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CalificacionesPK calificacionesPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MateriaRegularizada")
    private boolean materiaRegularizada;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CalificacionPuntos")
    private int calificacionPuntos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "CalificacionObservacion")
    private String calificacionObservacion;
    @JoinColumn(name = "MateriasId", referencedColumnName = "MateriasId")
    @ManyToOne(optional = false)
    private Materias materiasId;
    @JoinColumn(name = "AlumnoMatricula", referencedColumnName = "AlumnoMatricula", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Alumno alumno;
    @JoinColumn(name = "CicloEscolarId", referencedColumnName = "CicloEscolarId")
    @ManyToOne(optional = false)
    private Cicloescolar cicloEscolarId;

    public Calificaciones() {
    }

    public Calificaciones(CalificacionesPK calificacionesPK) {
        this.calificacionesPK = calificacionesPK;
    }

    public Calificaciones(CalificacionesPK calificacionesPK, boolean materiaRegularizada, int calificacionPuntos, String calificacionObservacion) {
        this.calificacionesPK = calificacionesPK;
        this.materiaRegularizada = materiaRegularizada;
        this.calificacionPuntos = calificacionPuntos;
        this.calificacionObservacion = calificacionObservacion;
    }

    public Calificaciones(String alumnoMatricula, int calificacionId) {
        this.calificacionesPK = new CalificacionesPK(alumnoMatricula, calificacionId);
    }

    public CalificacionesPK getCalificacionesPK() {
        return calificacionesPK;
    }

    public void setCalificacionesPK(CalificacionesPK calificacionesPK) {
        this.calificacionesPK = calificacionesPK;
    }

    public boolean getMateriaRegularizada() {
        return materiaRegularizada;
    }

    public void setMateriaRegularizada(boolean materiaRegularizada) {
        this.materiaRegularizada = materiaRegularizada;
    }

    public int getCalificacionPuntos() {
        return calificacionPuntos;
    }

    public void setCalificacionPuntos(int calificacionPuntos) {
        this.calificacionPuntos = calificacionPuntos;
    }

    public String getCalificacionObservacion() {
        return calificacionObservacion;
    }

    public void setCalificacionObservacion(String calificacionObservacion) {
        this.calificacionObservacion = calificacionObservacion;
    }

    public Materias getMateriasId() {
        return materiasId;
    }

    public void setMateriasId(Materias materiasId) {
        this.materiasId = materiasId;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
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
        hash += (calificacionesPK != null ? calificacionesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Calificaciones)) {
            return false;
        }
        Calificaciones other = (Calificaciones) object;
        if ((this.calificacionesPK == null && other.calificacionesPK != null) || (this.calificacionesPK != null && !this.calificacionesPK.equals(other.calificacionesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.softwareatumedida.modelo.Calificaciones[ calificacionesPK=" + calificacionesPK + " ]";
    }
    
}
