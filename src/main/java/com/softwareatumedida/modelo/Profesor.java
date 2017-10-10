/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softwareatumedida.modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author a
 */
@Entity
@Table(name = "profesor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Profesor.findAll", query = "SELECT p FROM Profesor p"),
    @NamedQuery(name = "Profesor.findByProfesorId", query = "SELECT p FROM Profesor p WHERE p.profesorId = :profesorId"),
    @NamedQuery(name = "Profesor.findByProfesorRFC", query = "SELECT p FROM Profesor p WHERE p.profesorRFC = :profesorRFC"),
    @NamedQuery(name = "Profesor.findByProfesorNombre", query = "SELECT p FROM Profesor p WHERE p.profesorNombre = :profesorNombre"),
    @NamedQuery(name = "Profesor.findByProfesorApellidos", query = "SELECT p FROM Profesor p WHERE p.profesorApellidos = :profesorApellidos"),
    @NamedQuery(name = "Profesor.findByProfesorEstado", query = "SELECT p FROM Profesor p WHERE p.profesorEstado = :profesorEstado"),
    @NamedQuery(name = "Profesor.findByProfesorFechaAlta", query = "SELECT p FROM Profesor p WHERE p.profesorFechaAlta = :profesorFechaAlta"),
    @NamedQuery(name = "Profesor.findByProfesorFechaBaja", query = "SELECT p FROM Profesor p WHERE p.profesorFechaBaja = :profesorFechaBaja")})
public class Profesor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ProfesorId")
    private Integer profesorId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "ProfesorRFC")
    private String profesorRFC;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "ProfesorNombre")
    private String profesorNombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "ProfesorApellidos")
    private String profesorApellidos;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ProfesorEstado")
    private boolean profesorEstado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ProfesorFechaAlta")
    @Temporal(TemporalType.DATE)
    private Date profesorFechaAlta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ProfesorFechaBaja")
    @Temporal(TemporalType.DATE)
    private Date profesorFechaBaja;
    @JoinColumn(name = "CicloEscolarId", referencedColumnName = "CicloEscolarId")
    @ManyToOne(optional = false)
    private Cicloescolar cicloEscolarId;
    @JoinColumn(name = "GradoId", referencedColumnName = "GradoId")
    @ManyToOne(optional = false)
    private Grado gradoId;
    @JoinColumn(name = "GrupoId", referencedColumnName = "GrupoId")
    @ManyToOne(optional = false)
    private Grupo grupoId;

    public Profesor() {
    }

    public Profesor(Integer profesorId) {
        this.profesorId = profesorId;
    }

    public Profesor(Integer profesorId, String profesorRFC, String profesorNombre, String profesorApellidos, boolean profesorEstado, Date profesorFechaAlta, Date profesorFechaBaja) {
        this.profesorId = profesorId;
        this.profesorRFC = profesorRFC;
        this.profesorNombre = profesorNombre;
        this.profesorApellidos = profesorApellidos;
        this.profesorEstado = profesorEstado;
        this.profesorFechaAlta = profesorFechaAlta;
        this.profesorFechaBaja = profesorFechaBaja;
    }

    public Integer getProfesorId() {
        return profesorId;
    }

    public void setProfesorId(Integer profesorId) {
        this.profesorId = profesorId;
    }

    public String getProfesorRFC() {
        return profesorRFC;
    }

    public void setProfesorRFC(String profesorRFC) {
        this.profesorRFC = profesorRFC;
    }

    public String getProfesorNombre() {
        return profesorNombre;
    }

    public void setProfesorNombre(String profesorNombre) {
        this.profesorNombre = profesorNombre;
    }

    public String getProfesorApellidos() {
        return profesorApellidos;
    }

    public void setProfesorApellidos(String profesorApellidos) {
        this.profesorApellidos = profesorApellidos;
    }

    public boolean getProfesorEstado() {
        return profesorEstado;
    }

    public void setProfesorEstado(boolean profesorEstado) {
        this.profesorEstado = profesorEstado;
    }

    public Date getProfesorFechaAlta() {
        return profesorFechaAlta;
    }

    public void setProfesorFechaAlta(Date profesorFechaAlta) {
        this.profesorFechaAlta = profesorFechaAlta;
    }

    public Date getProfesorFechaBaja() {
        return profesorFechaBaja;
    }

    public void setProfesorFechaBaja(Date profesorFechaBaja) {
        this.profesorFechaBaja = profesorFechaBaja;
    }

    public Cicloescolar getCicloEscolarId() {
        return cicloEscolarId;
    }

    public void setCicloEscolarId(Cicloescolar cicloEscolarId) {
        this.cicloEscolarId = cicloEscolarId;
    }

    public Grado getGradoId() {
        return gradoId;
    }

    public void setGradoId(Grado gradoId) {
        this.gradoId = gradoId;
    }

    public Grupo getGrupoId() {
        return grupoId;
    }

    public void setGrupoId(Grupo grupoId) {
        this.grupoId = grupoId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (profesorId != null ? profesorId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Profesor)) {
            return false;
        }
        Profesor other = (Profesor) object;
        if ((this.profesorId == null && other.profesorId != null) || (this.profesorId != null && !this.profesorId.equals(other.profesorId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.softwareatumedida.modelo.Profesor[ profesorId=" + profesorId + " ]";
    }
    
}
