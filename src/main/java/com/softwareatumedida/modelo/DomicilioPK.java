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
public class DomicilioPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "AlumnoMatricula")
    private String alumnoMatricula;
    @Basic(optional = false)
    @Column(name = "DomicilioId")
    private int domicilioId;

    public DomicilioPK() {
    }

    public DomicilioPK(String alumnoMatricula, int domicilioId) {
        this.alumnoMatricula = alumnoMatricula;
        this.domicilioId = domicilioId;
    }

    public String getAlumnoMatricula() {
        return alumnoMatricula;
    }

    public void setAlumnoMatricula(String alumnoMatricula) {
        this.alumnoMatricula = alumnoMatricula;
    }

    public int getDomicilioId() {
        return domicilioId;
    }

    public void setDomicilioId(int domicilioId) {
        this.domicilioId = domicilioId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (alumnoMatricula != null ? alumnoMatricula.hashCode() : 0);
        hash += (int) domicilioId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DomicilioPK)) {
            return false;
        }
        DomicilioPK other = (DomicilioPK) object;
        if ((this.alumnoMatricula == null && other.alumnoMatricula != null) || (this.alumnoMatricula != null && !this.alumnoMatricula.equals(other.alumnoMatricula))) {
            return false;
        }
        if (this.domicilioId != other.domicilioId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.softwareatumedida.modelo.DomicilioPK[ alumnoMatricula=" + alumnoMatricula + ", domicilioId=" + domicilioId + " ]";
    }
    
}
