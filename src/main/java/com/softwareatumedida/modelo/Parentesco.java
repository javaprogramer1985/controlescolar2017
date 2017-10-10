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

/**
 *
 * @author a
 */
@Entity
@Table(name = "parentesco")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Parentesco.findAll", query = "SELECT p FROM Parentesco p"),
    @NamedQuery(name = "Parentesco.findByParentescoId", query = "SELECT p FROM Parentesco p WHERE p.parentescoId = :parentescoId"),
    @NamedQuery(name = "Parentesco.findByParentescoDescripcion", query = "SELECT p FROM Parentesco p WHERE p.parentescoDescripcion = :parentescoDescripcion")})
public class Parentesco implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ParentescoId")
    private Integer parentescoId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "ParentescoDescripcion")
    private String parentescoDescripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "parentescoId")
    private Collection<Familiar> familiarCollection;

    public Parentesco() {
    }

    public Parentesco(Integer parentescoId) {
        this.parentescoId = parentescoId;
    }

    public Parentesco(Integer parentescoId, String parentescoDescripcion) {
        this.parentescoId = parentescoId;
        this.parentescoDescripcion = parentescoDescripcion;
    }

    public Integer getParentescoId() {
        return parentescoId;
    }

    public void setParentescoId(Integer parentescoId) {
        this.parentescoId = parentescoId;
    }

    public String getParentescoDescripcion() {
        return parentescoDescripcion;
    }

    public void setParentescoDescripcion(String parentescoDescripcion) {
        this.parentescoDescripcion = parentescoDescripcion;
    }

    @XmlTransient
    public Collection<Familiar> getFamiliarCollection() {
        return familiarCollection;
    }

    public void setFamiliarCollection(Collection<Familiar> familiarCollection) {
        this.familiarCollection = familiarCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (parentescoId != null ? parentescoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Parentesco)) {
            return false;
        }
        Parentesco other = (Parentesco) object;
        if ((this.parentescoId == null && other.parentescoId != null) || (this.parentescoId != null && !this.parentescoId.equals(other.parentescoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.softwareatumedida.modelo.Parentesco[ parentescoId=" + parentescoId + " ]";
    }
    
}
