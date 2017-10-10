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
@Table(name = "region")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Region.findAll", query = "SELECT r FROM Region r"),
    @NamedQuery(name = "Region.findByRegionId", query = "SELECT r FROM Region r WHERE r.regionId = :regionId"),
    @NamedQuery(name = "Region.findByRegionNombre", query = "SELECT r FROM Region r WHERE r.regionNombre = :regionNombre")})
public class Region implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "RegionId")
    private Integer regionId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "RegionNombre")
    private String regionNombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "regionId")
    private Collection<Municipio> municipioCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "regionId")
    private Collection<Familiar> familiarCollection;
    @JoinColumn(name = "EstadoId", referencedColumnName = "EstadoId")
    @ManyToOne(optional = false)
    private Estado estadoId;

    public Region() {
    }

    public Region(Integer regionId) {
        this.regionId = regionId;
    }

    public Region(Integer regionId, String regionNombre) {
        this.regionId = regionId;
        this.regionNombre = regionNombre;
    }

    public Integer getRegionId() {
        return regionId;
    }

    public void setRegionId(Integer regionId) {
        this.regionId = regionId;
    }

    public String getRegionNombre() {
        return regionNombre;
    }

    public void setRegionNombre(String regionNombre) {
        this.regionNombre = regionNombre;
    }

    @XmlTransient
    public Collection<Municipio> getMunicipioCollection() {
        return municipioCollection;
    }

    public void setMunicipioCollection(Collection<Municipio> municipioCollection) {
        this.municipioCollection = municipioCollection;
    }

    @XmlTransient
    public Collection<Familiar> getFamiliarCollection() {
        return familiarCollection;
    }

    public void setFamiliarCollection(Collection<Familiar> familiarCollection) {
        this.familiarCollection = familiarCollection;
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
        hash += (regionId != null ? regionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Region)) {
            return false;
        }
        Region other = (Region) object;
        if ((this.regionId == null && other.regionId != null) || (this.regionId != null && !this.regionId.equals(other.regionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.softwareatumedida.modelo.Region[ regionId=" + regionId + " ]";
    }
    
}
