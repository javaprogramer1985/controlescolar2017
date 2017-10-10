/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softwareatumedida.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.Data;

/**
 *
 * @author a
 */
@Entity
@Table(name = "becas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Becas.findAll", query = "SELECT b FROM Becas b"),
    @NamedQuery(name = "Becas.findByAlumnoMatricula", query = "SELECT b FROM Becas b WHERE b.alumnoMatricula = :alumnoMatricula"),
    @NamedQuery(name = "Becas.findByBecaDescripcion", query = "SELECT b FROM Becas b WHERE b.becaDescripcion = :becaDescripcion")})
@Data
public class Becas implements Serializable {
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
    @Column(name = "BecaDescripcion")
    private String becaDescripcion;
    @JoinColumn(name = "AlumnoMatricula", referencedColumnName = "AlumnoMatricula", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Alumno alumno;

    public Becas() {
    }

    public Becas(String alumnoMatricula) {
        this.alumnoMatricula = alumnoMatricula;
    }

    public Becas(String alumnoMatricula, String becaDescripcion) {
        this.alumnoMatricula = alumnoMatricula;
        this.becaDescripcion = becaDescripcion;
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
        if (!(object instanceof Becas)) {
            return false;
        }
        Becas other = (Becas) object;
        if ((this.alumnoMatricula == null && other.alumnoMatricula != null) || (this.alumnoMatricula != null && !this.alumnoMatricula.equals(other.alumnoMatricula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.softwareatumedida.modelo.Becas[ alumnoMatricula=" + alumnoMatricula + " ]";
    }
    
}
