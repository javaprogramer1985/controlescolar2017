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
@Table(name = "colonia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Colonia.findAll", query = "SELECT c FROM Colonia c"),
    @NamedQuery(name = "Colonia.findByColoniaId", query = "SELECT c FROM Colonia c WHERE c.coloniaId = :coloniaId"),
    @NamedQuery(name = "Colonia.findByColoniaNombre", query = "SELECT c FROM Colonia c WHERE c.coloniaNombre = :coloniaNombre")})
public class Colonia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ColoniaId")
    private Integer coloniaId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "ColoniaNombre")
    private String coloniaNombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "coloniaId")
    private Collection<Familiar> familiarCollection;
    @JoinColumn(name = "CiudadId", referencedColumnName = "CiudadId")
    @ManyToOne(optional = false)
    private Ciudad ciudadId;

    public Colonia() {
    }

    public Colonia(Integer coloniaId) {
        this.coloniaId = coloniaId;
    }

    public Colonia(Integer coloniaId, String coloniaNombre) {
        this.coloniaId = coloniaId;
        this.coloniaNombre = coloniaNombre;
    }

    public Integer getColoniaId() {
        return coloniaId;
    }

    public void setColoniaId(Integer coloniaId) {
        this.coloniaId = coloniaId;
    }

    public String getColoniaNombre() {
        return coloniaNombre;
    }

    public void setColoniaNombre(String coloniaNombre) {
        this.coloniaNombre = coloniaNombre;
    }

    @XmlTransient
    public Collection<Familiar> getFamiliarCollection() {
        return familiarCollection;
    }

    public void setFamiliarCollection(Collection<Familiar> familiarCollection) {
        this.familiarCollection = familiarCollection;
    }

    public Ciudad getCiudadId() {
        return ciudadId;
    }

    public void setCiudadId(Ciudad ciudadId) {
        this.ciudadId = ciudadId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (coloniaId != null ? coloniaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Colonia)) {
            return false;
        }
        Colonia other = (Colonia) object;
        if ((this.coloniaId == null && other.coloniaId != null) || (this.coloniaId != null && !this.coloniaId.equals(other.coloniaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.softwareatumedida.modelo.Colonia[ coloniaId=" + coloniaId + " ]";
    }
    
}
