/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softwareatumedida.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author a
 */
@Entity
@Table(name = "domicilio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Domicilio.findAll", query = "SELECT d FROM Domicilio d"),
    @NamedQuery(name = "Domicilio.findByAlumnoMatricula", query = "SELECT d FROM Domicilio d WHERE d.domicilioPK.alumnoMatricula = :alumnoMatricula"),
    @NamedQuery(name = "Domicilio.findByDomicilioId", query = "SELECT d FROM Domicilio d WHERE d.domicilioPK.domicilioId = :domicilioId"),
    @NamedQuery(name = "Domicilio.findByDomicilioCalle", query = "SELECT d FROM Domicilio d WHERE d.domicilioCalle = :domicilioCalle"),
    @NamedQuery(name = "Domicilio.findByDomicilioColonia", query = "SELECT d FROM Domicilio d WHERE d.domicilioColonia = :domicilioColonia"),
    @NamedQuery(name = "Domicilio.findByDomicilioNumExt", query = "SELECT d FROM Domicilio d WHERE d.domicilioNumExt = :domicilioNumExt"),
    @NamedQuery(name = "Domicilio.findByDomicilioNumInt", query = "SELECT d FROM Domicilio d WHERE d.domicilioNumInt = :domicilioNumInt"),
    @NamedQuery(name = "Domicilio.findByDomicilioCP", query = "SELECT d FROM Domicilio d WHERE d.domicilioCP = :domicilioCP"),
    @NamedQuery(name = "Domicilio.findByDomicilioTel", query = "SELECT d FROM Domicilio d WHERE d.domicilioTel = :domicilioTel")})
public class Domicilio implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DomicilioPK domicilioPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "DomicilioCalle")
    private String domicilioCalle;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "DomicilioColonia")
    private String domicilioColonia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "DomicilioNumExt")
    private String domicilioNumExt;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "DomicilioNumInt")
    private String domicilioNumInt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DomicilioCP")
    private int domicilioCP;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "DomicilioTel")
    private String domicilioTel;
    @JoinColumn(name = "AlumnoMatricula", referencedColumnName = "AlumnoMatricula", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Alumno alumno;

    public Domicilio() {
    }

    public Domicilio(DomicilioPK domicilioPK) {
        this.domicilioPK = domicilioPK;
    }

    public Domicilio(DomicilioPK domicilioPK, String domicilioCalle, String domicilioColonia, String domicilioNumExt, String domicilioNumInt, int domicilioCP, String domicilioTel) {
        this.domicilioPK = domicilioPK;
        this.domicilioCalle = domicilioCalle;
        this.domicilioColonia = domicilioColonia;
        this.domicilioNumExt = domicilioNumExt;
        this.domicilioNumInt = domicilioNumInt;
        this.domicilioCP = domicilioCP;
        this.domicilioTel = domicilioTel;
    }

    public Domicilio(String alumnoMatricula, int domicilioId) {
        this.domicilioPK = new DomicilioPK(alumnoMatricula, domicilioId);
    }

    public DomicilioPK getDomicilioPK() {
        return domicilioPK;
    }

    public void setDomicilioPK(DomicilioPK domicilioPK) {
        this.domicilioPK = domicilioPK;
    }

    public String getDomicilioCalle() {
        return domicilioCalle;
    }

    public void setDomicilioCalle(String domicilioCalle) {
        this.domicilioCalle = domicilioCalle;
    }

    public String getDomicilioColonia() {
        return domicilioColonia;
    }

    public void setDomicilioColonia(String domicilioColonia) {
        this.domicilioColonia = domicilioColonia;
    }

    public String getDomicilioNumExt() {
        return domicilioNumExt;
    }

    public void setDomicilioNumExt(String domicilioNumExt) {
        this.domicilioNumExt = domicilioNumExt;
    }

    public String getDomicilioNumInt() {
        return domicilioNumInt;
    }

    public void setDomicilioNumInt(String domicilioNumInt) {
        this.domicilioNumInt = domicilioNumInt;
    }

    public int getDomicilioCP() {
        return domicilioCP;
    }

    public void setDomicilioCP(int domicilioCP) {
        this.domicilioCP = domicilioCP;
    }

    public String getDomicilioTel() {
        return domicilioTel;
    }

    public void setDomicilioTel(String domicilioTel) {
        this.domicilioTel = domicilioTel;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (domicilioPK != null ? domicilioPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Domicilio)) {
            return false;
        }
        Domicilio other = (Domicilio) object;
        if ((this.domicilioPK == null && other.domicilioPK != null) || (this.domicilioPK != null && !this.domicilioPK.equals(other.domicilioPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.softwareatumedida.modelo.Domicilio[ domicilioPK=" + domicilioPK + " ]";
    }
    
}
