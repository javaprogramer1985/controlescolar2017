/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softwareatumedida.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author a
 */
@Embeddable
public class FamiliarPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "AlumnoMatricula")
    private String alumnoMatricula;
    @Basic(optional = false)
    @Column(name = "FamiliarId")
    private int familiarId;

    public FamiliarPK() {
    }

    public FamiliarPK(String alumnoMatricula, int familiarId) {
        this.alumnoMatricula = alumnoMatricula;
        this.familiarId = familiarId;
    }

    public String getAlumnoMatricula() {
        return alumnoMatricula;
    }

    public void setAlumnoMatricula(String alumnoMatricula) {
        this.alumnoMatricula = alumnoMatricula;
    }

    public int getFamiliarId() {
        return familiarId;
    }

    public void setFamiliarId(int familiarId) {
        this.familiarId = familiarId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (alumnoMatricula != null ? alumnoMatricula.hashCode() : 0);
        hash += (int) familiarId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FamiliarPK)) {
            return false;
        }
        FamiliarPK other = (FamiliarPK) object;
        if ((this.alumnoMatricula == null && other.alumnoMatricula != null) || (this.alumnoMatricula != null && !this.alumnoMatricula.equals(other.alumnoMatricula))) {
            return false;
        }
        if (this.familiarId != other.familiarId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.softwareatumedida.modelo.FamiliarPK[ alumnoMatricula=" + alumnoMatricula + ", familiarId=" + familiarId + " ]";
    }
    
}
