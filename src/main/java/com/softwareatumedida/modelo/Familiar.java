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
@Table(name = "familiar")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Familiar.findAll", query = "SELECT f FROM Familiar f"),
    @NamedQuery(name = "Familiar.findByAlumnoMatricula", query = "SELECT f FROM Familiar f WHERE f.familiarPK.alumnoMatricula = :alumnoMatricula"),
    @NamedQuery(name = "Familiar.findByFamiliarId", query = "SELECT f FROM Familiar f WHERE f.familiarPK.familiarId = :familiarId"),
    @NamedQuery(name = "Familiar.findByFamiliarCurp", query = "SELECT f FROM Familiar f WHERE f.familiarCurp = :familiarCurp"),
    @NamedQuery(name = "Familiar.findByFamiliarNombre", query = "SELECT f FROM Familiar f WHERE f.familiarNombre = :familiarNombre"),
    @NamedQuery(name = "Familiar.findByFamiliarApPat", query = "SELECT f FROM Familiar f WHERE f.familiarApPat = :familiarApPat"),
    @NamedQuery(name = "Familiar.findByFamiliarApMat", query = "SELECT f FROM Familiar f WHERE f.familiarApMat = :familiarApMat"),
    @NamedQuery(name = "Familiar.findByFamiliarOcupacion", query = "SELECT f FROM Familiar f WHERE f.familiarOcupacion = :familiarOcupacion"),
    @NamedQuery(name = "Familiar.findByFamiliarNivelEstudio", query = "SELECT f FROM Familiar f WHERE f.familiarNivelEstudio = :familiarNivelEstudio"),
    @NamedQuery(name = "Familiar.findByFamiliarTelefono", query = "SELECT f FROM Familiar f WHERE f.familiarTelefono = :familiarTelefono"),
    @NamedQuery(name = "Familiar.findByFamiliarTutor", query = "SELECT f FROM Familiar f WHERE f.familiarTutor = :familiarTutor"),
    @NamedQuery(name = "Familiar.findByFamiliarCalle", query = "SELECT f FROM Familiar f WHERE f.familiarCalle = :familiarCalle"),
    @NamedQuery(name = "Familiar.findByFamiliarNumInt", query = "SELECT f FROM Familiar f WHERE f.familiarNumInt = :familiarNumInt"),
    @NamedQuery(name = "Familiar.findByFamiliarNumExt", query = "SELECT f FROM Familiar f WHERE f.familiarNumExt = :familiarNumExt"),
    @NamedQuery(name = "Familiar.findByFamiliarCp", query = "SELECT f FROM Familiar f WHERE f.familiarCp = :familiarCp")})
public class Familiar implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected FamiliarPK familiarPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "FamiliarCurp")
    private String familiarCurp;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "FamiliarNombre")
    private String familiarNombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "FamiliarApPat")
    private String familiarApPat;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "FamiliarApMat")
    private String familiarApMat;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "FamiliarOcupacion")
    private String familiarOcupacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "FamiliarNivelEstudio")
    private String familiarNivelEstudio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "FamiliarTelefono")
    private String familiarTelefono;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FamiliarTutor")
    private boolean familiarTutor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "FamiliarCalle")
    private String familiarCalle;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "FamiliarNumInt")
    private String familiarNumInt;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "FamiliarNumExt")
    private String familiarNumExt;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "FamiliarCp")
    private String familiarCp;
    @JoinColumn(name = "AlumnoMatricula", referencedColumnName = "AlumnoMatricula", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Alumno alumno;
    @JoinColumn(name = "CiudadId", referencedColumnName = "CiudadId")
    @ManyToOne(optional = false)
    private Ciudad ciudadId;
    @JoinColumn(name = "ColoniaId", referencedColumnName = "ColoniaId")
    @ManyToOne(optional = false)
    private Colonia coloniaId;
    @JoinColumn(name = "MunicipioId", referencedColumnName = "Municipio")
    @ManyToOne(optional = false)
    private Municipio municipioId;
    @JoinColumn(name = "ParentescoId", referencedColumnName = "ParentescoId")
    @ManyToOne(optional = false)
    private Parentesco parentescoId;
    @JoinColumn(name = "RegionId", referencedColumnName = "RegionId")
    @ManyToOne(optional = false)
    private Region regionId;
    @JoinColumn(name = "EstadoId", referencedColumnName = "EstadoId")
    @ManyToOne(optional = false)
    private Estado estadoId;

    public Familiar() {
    }

    public Familiar(FamiliarPK familiarPK) {
        this.familiarPK = familiarPK;
    }

    public Familiar(FamiliarPK familiarPK, String familiarCurp, String familiarNombre, String familiarApPat, String familiarApMat, String familiarOcupacion, String familiarNivelEstudio, String familiarTelefono, boolean familiarTutor, String familiarCalle, String familiarNumInt, String familiarNumExt, String familiarCp) {
        this.familiarPK = familiarPK;
        this.familiarCurp = familiarCurp;
        this.familiarNombre = familiarNombre;
        this.familiarApPat = familiarApPat;
        this.familiarApMat = familiarApMat;
        this.familiarOcupacion = familiarOcupacion;
        this.familiarNivelEstudio = familiarNivelEstudio;
        this.familiarTelefono = familiarTelefono;
        this.familiarTutor = familiarTutor;
        this.familiarCalle = familiarCalle;
        this.familiarNumInt = familiarNumInt;
        this.familiarNumExt = familiarNumExt;
        this.familiarCp = familiarCp;
    }

    public Familiar(String alumnoMatricula, int familiarId) {
        this.familiarPK = new FamiliarPK(alumnoMatricula, familiarId);
    }

    public FamiliarPK getFamiliarPK() {
        return familiarPK;
    }

    public void setFamiliarPK(FamiliarPK familiarPK) {
        this.familiarPK = familiarPK;
    }

    public String getFamiliarCurp() {
        return familiarCurp;
    }

    public void setFamiliarCurp(String familiarCurp) {
        this.familiarCurp = familiarCurp;
    }

    public String getFamiliarNombre() {
        return familiarNombre;
    }

    public void setFamiliarNombre(String familiarNombre) {
        this.familiarNombre = familiarNombre;
    }

    public String getFamiliarApPat() {
        return familiarApPat;
    }

    public void setFamiliarApPat(String familiarApPat) {
        this.familiarApPat = familiarApPat;
    }

    public String getFamiliarApMat() {
        return familiarApMat;
    }

    public void setFamiliarApMat(String familiarApMat) {
        this.familiarApMat = familiarApMat;
    }

    public String getFamiliarOcupacion() {
        return familiarOcupacion;
    }

    public void setFamiliarOcupacion(String familiarOcupacion) {
        this.familiarOcupacion = familiarOcupacion;
    }

    public String getFamiliarNivelEstudio() {
        return familiarNivelEstudio;
    }

    public void setFamiliarNivelEstudio(String familiarNivelEstudio) {
        this.familiarNivelEstudio = familiarNivelEstudio;
    }

    public String getFamiliarTelefono() {
        return familiarTelefono;
    }

    public void setFamiliarTelefono(String familiarTelefono) {
        this.familiarTelefono = familiarTelefono;
    }

    public boolean getFamiliarTutor() {
        return familiarTutor;
    }

    public void setFamiliarTutor(boolean familiarTutor) {
        this.familiarTutor = familiarTutor;
    }

    public String getFamiliarCalle() {
        return familiarCalle;
    }

    public void setFamiliarCalle(String familiarCalle) {
        this.familiarCalle = familiarCalle;
    }

    public String getFamiliarNumInt() {
        return familiarNumInt;
    }

    public void setFamiliarNumInt(String familiarNumInt) {
        this.familiarNumInt = familiarNumInt;
    }

    public String getFamiliarNumExt() {
        return familiarNumExt;
    }

    public void setFamiliarNumExt(String familiarNumExt) {
        this.familiarNumExt = familiarNumExt;
    }

    public String getFamiliarCp() {
        return familiarCp;
    }

    public void setFamiliarCp(String familiarCp) {
        this.familiarCp = familiarCp;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Ciudad getCiudadId() {
        return ciudadId;
    }

    public void setCiudadId(Ciudad ciudadId) {
        this.ciudadId = ciudadId;
    }

    public Colonia getColoniaId() {
        return coloniaId;
    }

    public void setColoniaId(Colonia coloniaId) {
        this.coloniaId = coloniaId;
    }

    public Municipio getMunicipioId() {
        return municipioId;
    }

    public void setMunicipioId(Municipio municipioId) {
        this.municipioId = municipioId;
    }

    public Parentesco getParentescoId() {
        return parentescoId;
    }

    public void setParentescoId(Parentesco parentescoId) {
        this.parentescoId = parentescoId;
    }

    public Region getRegionId() {
        return regionId;
    }

    public void setRegionId(Region regionId) {
        this.regionId = regionId;
    }

    public Estado getEstadoId() {
        return estadoId;
    }

    public void setEstadoId(Estado estadoId) {
        this.estadoId = estadoId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (familiarPK != null ? familiarPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Familiar)) {
            return false;
        }
        Familiar other = (Familiar) object;
        if ((this.familiarPK == null && other.familiarPK != null) || (this.familiarPK != null && !this.familiarPK.equals(other.familiarPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.softwareatumedida.modelo.Familiar[ familiarPK=" + familiarPK + " ]";
    }
    
}
