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
@Table(name = "municipio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Municipio.findAll", query = "SELECT m FROM Municipio m"),
    @NamedQuery(name = "Municipio.findByMunicipio", query = "SELECT m FROM Municipio m WHERE m.municipio = :municipio"),
    @NamedQuery(name = "Municipio.findByMunicipioNombre", query = "SELECT m FROM Municipio m WHERE m.municipioNombre = :municipioNombre")})
public class Municipio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Municipio")
    private Integer municipio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "MunicipioNombre")
    private String municipioNombre;
    @JoinColumn(name = "RegionId", referencedColumnName = "RegionId")
    @ManyToOne(optional = false)
    private Region regionId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "municipioId")
    private Collection<Familiar> familiarCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "municipioId")
    private Collection<Ciudad> ciudadCollection;

    public Municipio() {
    }

    public Municipio(Integer municipio) {
        this.municipio = municipio;
    }

    public Municipio(Integer municipio, String municipioNombre) {
        this.municipio = municipio;
        this.municipioNombre = municipioNombre;
    }

    public Integer getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Integer municipio) {
        this.municipio = municipio;
    }

    public String getMunicipioNombre() {
        return municipioNombre;
    }

    public void setMunicipioNombre(String municipioNombre) {
        this.municipioNombre = municipioNombre;
    }

    public Region getRegionId() {
        return regionId;
    }

    public void setRegionId(Region regionId) {
        this.regionId = regionId;
    }

    @XmlTransient
    public Collection<Familiar> getFamiliarCollection() {
        return familiarCollection;
    }

    public void setFamiliarCollection(Collection<Familiar> familiarCollection) {
        this.familiarCollection = familiarCollection;
    }

    @XmlTransient
    public Collection<Ciudad> getCiudadCollection() {
        return ciudadCollection;
    }

    public void setCiudadCollection(Collection<Ciudad> ciudadCollection) {
        this.ciudadCollection = ciudadCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (municipio != null ? municipio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Municipio)) {
            return false;
        }
        Municipio other = (Municipio) object;
        if ((this.municipio == null && other.municipio != null) || (this.municipio != null && !this.municipio.equals(other.municipio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.softwareatumedida.modelo.Municipio[ municipio=" + municipio + " ]";
    }
    
}
