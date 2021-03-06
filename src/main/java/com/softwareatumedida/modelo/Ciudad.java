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
@Table(name = "ciudad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ciudad.findAll", query = "SELECT c FROM Ciudad c"),
    @NamedQuery(name = "Ciudad.findByCiudadId", query = "SELECT c FROM Ciudad c WHERE c.ciudadId = :ciudadId"),
    @NamedQuery(name = "Ciudad.findByCiudadNombre", query = "SELECT c FROM Ciudad c WHERE c.ciudadNombre = :ciudadNombre")})
public class Ciudad implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CiudadId")
    private Integer ciudadId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "CiudadNombre")
    private String ciudadNombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ciudadId")
    private Collection<Familiar> familiarCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ciudadId")
    private Collection<Colonia> coloniaCollection;
    @JoinColumn(name = "MunicipioId", referencedColumnName = "Municipio")
    @ManyToOne(optional = false)
    private Municipio municipioId;

    public Ciudad() {
    }

    public Ciudad(Integer ciudadId) {
        this.ciudadId = ciudadId;
    }

    public Ciudad(Integer ciudadId, String ciudadNombre) {
        this.ciudadId = ciudadId;
        this.ciudadNombre = ciudadNombre;
    }

    public Integer getCiudadId() {
        return ciudadId;
    }

    public void setCiudadId(Integer ciudadId) {
        this.ciudadId = ciudadId;
    }

    public String getCiudadNombre() {
        return ciudadNombre;
    }

    public void setCiudadNombre(String ciudadNombre) {
        this.ciudadNombre = ciudadNombre;
    }

    @XmlTransient
    public Collection<Familiar> getFamiliarCollection() {
        return familiarCollection;
    }

    public void setFamiliarCollection(Collection<Familiar> familiarCollection) {
        this.familiarCollection = familiarCollection;
    }

    @XmlTransient
    public Collection<Colonia> getColoniaCollection() {
        return coloniaCollection;
    }

    public void setColoniaCollection(Collection<Colonia> coloniaCollection) {
        this.coloniaCollection = coloniaCollection;
    }

    public Municipio getMunicipioId() {
        return municipioId;
    }

    public void setMunicipioId(Municipio municipioId) {
        this.municipioId = municipioId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ciudadId != null ? ciudadId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ciudad)) {
            return false;
        }
        Ciudad other = (Ciudad) object;
        if ((this.ciudadId == null && other.ciudadId != null) || (this.ciudadId != null && !this.ciudadId.equals(other.ciudadId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.softwareatumedida.modelo.Ciudad[ ciudadId=" + ciudadId + " ]";
    }
    
}
