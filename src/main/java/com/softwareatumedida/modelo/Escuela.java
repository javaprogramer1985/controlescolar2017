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
import javax.persistence.Lob;
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
@Table(name = "escuela")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Escuela.findAll", query = "SELECT e FROM Escuela e"),
    @NamedQuery(name = "Escuela.findByEscuelaId", query = "SELECT e FROM Escuela e WHERE e.escuelaId = :escuelaId"),
    @NamedQuery(name = "Escuela.findByEscuelaNombre", query = "SELECT e FROM Escuela e WHERE e.escuelaNombre = :escuelaNombre"),
    @NamedQuery(name = "Escuela.findByEscuelaCT", query = "SELECT e FROM Escuela e WHERE e.escuelaCT = :escuelaCT")})
@Data
public class Escuela implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "EscuelaId")
    private Integer escuelaId;
    @Size(max = 150)
    @Column(name = "EscuelaNombre")
    private String escuelaNombre;
    @Lob
    @Size(max = 65535)
    @Column(name = "EscuelaMision")
    private String escuelaMision;
    @Lob
    @Size(max = 65535)
    @Column(name = "EscuelaVision")
    private String escuelaVision;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "EscuelaCT")
    private String escuelaCT;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "escuelaId")
    private Collection<Alumno> alumnoCollection;

    public Escuela() {
    }

    public Escuela(Integer escuelaId) {
        this.escuelaId = escuelaId;
    }

    public Escuela(Integer escuelaId, String escuelaCT) {
        this.escuelaId = escuelaId;
        this.escuelaCT = escuelaCT;
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
        hash += (escuelaId != null ? escuelaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Escuela)) {
            return false;
        }
        Escuela other = (Escuela) object;
        return !((this.escuelaId == null && other.escuelaId != null) || (this.escuelaId != null && !this.escuelaId.equals(other.escuelaId)));
    }

    @Override
    public String toString() {
        return "com.softwareatumedica.modelo.Escuela[ escuelaId=" + escuelaId + " ]";
    }
    
}
