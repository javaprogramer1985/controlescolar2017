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
@Table(name = "estado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estado.findAll", query = "SELECT e FROM Estado e"),
    @NamedQuery(name = "Estado.findByEstadoId", query = "SELECT e FROM Estado e WHERE e.estadoId = :estadoId"),
    @NamedQuery(name = "Estado.findByEstadoNombre", query = "SELECT e FROM Estado e WHERE e.estadoNombre = :estadoNombre")})
@Data
public class Estado implements Serializable {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estadoId")
    private Collection<Familiar> familiarCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estadoId")
    private Collection<Region> regionCollection;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "EstadoId")
    private Integer estadoId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "EstadoNombre")
    private String estadoNombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estadoId")
    private Collection<Alumno> alumnoCollection;

    public Estado() {
    }

    public Estado(Integer estadoId) {
        this.estadoId = estadoId;
    }

    public Estado(Integer estadoId, String estadoNombre) {
        this.estadoId = estadoId;
        this.estadoNombre = estadoNombre;
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
        hash += (estadoId != null ? estadoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estado)) {
            return false;
        }
        Estado other = (Estado) object;
        return !((this.estadoId == null && other.estadoId != null) || (this.estadoId != null && !this.estadoId.equals(other.estadoId)));
    }

    @Override
    public String toString() {
        return "com.softwareatumedica.modelo.Estado[ estadoId=" + estadoId + " ]";
    }

    @XmlTransient
    public Collection<Familiar> getFamiliarCollection() {
        return familiarCollection;
    }

    public void setFamiliarCollection(Collection<Familiar> familiarCollection) {
        this.familiarCollection = familiarCollection;
    }

    @XmlTransient
    public Collection<Region> getRegionCollection() {
        return regionCollection;
    }

    public void setRegionCollection(Collection<Region> regionCollection) {
        this.regionCollection = regionCollection;
    }
    
}
