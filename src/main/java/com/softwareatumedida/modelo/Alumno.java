/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softwareatumedida.modelo;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
@Table(name = "alumno")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Alumno.findAll", query = "SELECT a FROM Alumno a"),
    @NamedQuery(name = "Alumno.findByAlumnoMatricula", query = "SELECT a FROM Alumno a WHERE a.alumnoMatricula = :alumnoMatricula"),
    @NamedQuery(name = "Alumno.findByAlumnoNombre", query = "SELECT a FROM Alumno a WHERE a.alumnoNombre = :alumnoNombre"),
    @NamedQuery(name = "Alumno.findByAlumnoApPat", query = "SELECT a FROM Alumno a WHERE a.alumnoApPat = :alumnoApPat"),
    @NamedQuery(name = "Alumno.findByAlumnoApMat", query = "SELECT a FROM Alumno a WHERE a.alumnoApMat = :alumnoApMat"),
    @NamedQuery(name = "Alumno.findByAlumnoCurp", query = "SELECT a FROM Alumno a WHERE a.alumnoCurp = :alumnoCurp"),
    @NamedQuery(name = "Alumno.findByAlumnoFechaNacimiento", query = "SELECT a FROM Alumno a WHERE a.alumnoFechaNacimiento = :alumnoFechaNacimiento"),
    @NamedQuery(name = "Alumno.findByAlumnoSexo", query = "SELECT a FROM Alumno a WHERE a.alumnoSexo = :alumnoSexo"),
    @NamedQuery(name = "Alumno.findByAlumnoIndigena", query = "SELECT a FROM Alumno a WHERE a.alumnoIndigena = :alumnoIndigena"),
    @NamedQuery(name = "Alumno.findByAlumnoExtranjero", query = "SELECT a FROM Alumno a WHERE a.alumnoExtranjero = :alumnoExtranjero"),
    @NamedQuery(name = "Alumno.findByAlumnoNacionalidad", query = "SELECT a FROM Alumno a WHERE a.alumnoNacionalidad = :alumnoNacionalidad"),
    @NamedQuery(name = "Alumno.findByAlumnoTipoSangre", query = "SELECT a FROM Alumno a WHERE a.alumnoTipoSangre = :alumnoTipoSangre"),
    @NamedQuery(name = "Alumno.findByAlumnoPeso", query = "SELECT a FROM Alumno a WHERE a.alumnoPeso = :alumnoPeso"),
    @NamedQuery(name = "Alumno.findByAlumnoEstatura", query = "SELECT a FROM Alumno a WHERE a.alumnoEstatura = :alumnoEstatura"),
    @NamedQuery(name = "Alumno.findByAlumnoEdad", query = "SELECT a FROM Alumno a WHERE a.alumnoEdad = :alumnoEdad")})
@Data
public class Alumno implements Serializable {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "alumno")
    private Collection<Familiar> familiarCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "alumno")
    private Collection<Domicilio> domicilioCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "alumno")
    private Collection<Calificaciones> calificacionesCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "alumno")
    private Becas becas;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "AlumnoMatricula")
    private String alumnoMatricula;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "AlumnoNombre")
    private String alumnoNombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "AlumnoApPat")
    private String alumnoApPat;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "AlumnoApMat")
    private String alumnoApMat;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "AlumnoCurp")
    private String alumnoCurp;
    @Basic(optional = false)
    @NotNull
    @Column(name = "AlumnoFechaNacimiento")
    @Temporal(TemporalType.DATE)
    private Date alumnoFechaNacimiento;
    @Size(max = 2)
    @Column(name = "AlumnoSexo")
    private String alumnoSexo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "AlumnoIndigena")
    private boolean alumnoIndigena;
    @Column(name = "AlumnoExtranjero")
    private Boolean alumnoExtranjero;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "AlumnoNacionalidad")
    private String alumnoNacionalidad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "AlumnoTipoSangre")
    private String alumnoTipoSangre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "AlumnoPeso")
    private String alumnoPeso;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "AlumnoEstatura")
    private String alumnoEstatura;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "AlumnoEdad")
    private String alumnoEdad;
    @JoinColumn(name = "CicloEscolar", referencedColumnName = "CicloEscolarId")
    @ManyToOne(optional = false)
    private Cicloescolar cicloEscolar;
    @JoinColumn(name = "EscuelaId", referencedColumnName = "EscuelaId")
    @ManyToOne(optional = false)
    private Escuela escuelaId;
    @JoinColumn(name = "EstadoId", referencedColumnName = "EstadoId")
    @ManyToOne(optional = false)
    private Estado estadoId;
    @JoinColumn(name = "GradoId", referencedColumnName = "GradoId")
    @ManyToOne(optional = false)
    private Grado gradoId;
    @JoinColumn(name = "GrupoId", referencedColumnName = "GrupoId")
    @ManyToOne(optional = false)
    private Grupo grupoId;

    public Alumno() {
    }

    public Alumno(String alumnoMatricula) {
        this.alumnoMatricula = alumnoMatricula;
    }

    public Alumno(String alumnoMatricula, String alumnoNombre, String alumnoApPat, String alumnoApMat, String alumnoCurp, Date alumnoFechaNacimiento, boolean alumnoIndigena, String alumnoNacionalidad, String alumnoTipoSangre, String alumnoPeso, String alumnoEstatura, String alumnoEdad) {
        this.alumnoMatricula = alumnoMatricula;
        this.alumnoNombre = alumnoNombre;
        this.alumnoApPat = alumnoApPat;
        this.alumnoApMat = alumnoApMat;
        this.alumnoCurp = alumnoCurp;
        this.alumnoFechaNacimiento = alumnoFechaNacimiento;
        this.alumnoIndigena = alumnoIndigena;
        this.alumnoNacionalidad = alumnoNacionalidad;
        this.alumnoTipoSangre = alumnoTipoSangre;
        this.alumnoPeso = alumnoPeso;
        this.alumnoEstatura = alumnoEstatura;
        this.alumnoEdad = alumnoEdad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (alumnoMatricula != null ? alumnoMatricula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Alumno)) {
            return false;
        }
        Alumno other = (Alumno) object;
        return !((this.alumnoMatricula == null && other.alumnoMatricula != null) || (this.alumnoMatricula != null && !this.alumnoMatricula.equals(other.alumnoMatricula)));
    }

    @Override
    public String toString() {
        return "com.softwareatumedica.modelo.Alumno[ alumnoMatricula=" + alumnoMatricula + " ]";
    }

    public Becas getBecas() {
        return becas;
    }

    public void setBecas(Becas becas) {
        this.becas = becas;
    }

    @XmlTransient
    public Collection<Familiar> getFamiliarCollection() {
        return familiarCollection;
    }

    public void setFamiliarCollection(Collection<Familiar> familiarCollection) {
        this.familiarCollection = familiarCollection;
    }

    @XmlTransient
    public Collection<Domicilio> getDomicilioCollection() {
        return domicilioCollection;
    }

    public void setDomicilioCollection(Collection<Domicilio> domicilioCollection) {
        this.domicilioCollection = domicilioCollection;
    }

    @XmlTransient
    public Collection<Calificaciones> getCalificacionesCollection() {
        return calificacionesCollection;
    }

    public void setCalificacionesCollection(Collection<Calificaciones> calificacionesCollection) {
        this.calificacionesCollection = calificacionesCollection;
    }
    
}
