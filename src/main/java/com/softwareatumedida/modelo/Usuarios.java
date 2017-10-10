/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softwareatumedida.modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author a
 */
@Entity
@Table(name = "usuarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuarios.findAll", query = "SELECT u FROM Usuarios u"),
    @NamedQuery(name = "Usuarios.findByUsuarioUsu", query = "SELECT u FROM Usuarios u WHERE u.usuariosPK.usuarioUsu = :usuarioUsu"),
    @NamedQuery(name = "Usuarios.findByUsuarioPass", query = "SELECT u FROM Usuarios u WHERE u.usuariosPK.usuarioPass = :usuarioPass"),
    @NamedQuery(name = "Usuarios.findByUsuarioTipo", query = "SELECT u FROM Usuarios u WHERE u.usuarioTipo = :usuarioTipo"),
    @NamedQuery(name = "Usuarios.findByUsuarioNombre", query = "SELECT u FROM Usuarios u WHERE u.usuarioNombre = :usuarioNombre"),
    @NamedQuery(name = "Usuarios.findByUsuarioApellidos", query = "SELECT u FROM Usuarios u WHERE u.usuarioApellidos = :usuarioApellidos"),
    @NamedQuery(name = "Usuarios.findByUsuarioFechaAlta", query = "SELECT u FROM Usuarios u WHERE u.usuarioFechaAlta = :usuarioFechaAlta"),
    @NamedQuery(name = "Usuarios.findByUsuarioEstado", query = "SELECT u FROM Usuarios u WHERE u.usuarioEstado = :usuarioEstado"),
    @NamedQuery(name = "Usuarios.findByUsuarioFechaBaja", query = "SELECT u FROM Usuarios u WHERE u.usuarioFechaBaja = :usuarioFechaBaja")})
public class Usuarios implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected UsuariosPK usuariosPK;
    @Size(max = 2)
    @Column(name = "UsuarioTipo")
    private String usuarioTipo;
    @Size(max = 100)
    @Column(name = "UsuarioNombre")
    private String usuarioNombre;
    @Size(max = 150)
    @Column(name = "UsuarioApellidos")
    private String usuarioApellidos;
    @Basic(optional = false)
    @NotNull
    @Column(name = "UsuarioFechaAlta")
    @Temporal(TemporalType.DATE)
    private Date usuarioFechaAlta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "UsuarioEstado")
    private String usuarioEstado="A";
    @Column(name = "UsuarioFechaBaja")
    @Temporal(TemporalType.DATE)
    private Date usuarioFechaBaja;

    public Usuarios() {
    }

    public Usuarios(UsuariosPK usuariosPK) {
        this.usuariosPK = usuariosPK;
    }

    public Usuarios(UsuariosPK usuariosPK, Date usuarioFechaAlta, String usuarioEstado) {
        this.usuariosPK = usuariosPK;
        this.usuarioFechaAlta = usuarioFechaAlta;
        this.usuarioEstado = usuarioEstado;
    }

    public Usuarios(String usuarioUsu, String usuarioPass) {
        this.usuariosPK = new UsuariosPK(usuarioUsu, usuarioPass);
    }

    public UsuariosPK getUsuariosPK() {
        return usuariosPK;
    }

    public void setUsuariosPK(UsuariosPK usuariosPK) {
        this.usuariosPK = usuariosPK;
    }

    public String getUsuarioTipo() {
        return usuarioTipo;
    }

    public void setUsuarioTipo(String usuarioTipo) {
        this.usuarioTipo = usuarioTipo;
    }

    public String getUsuarioNombre() {
        return usuarioNombre;
    }

    public void setUsuarioNombre(String usuarioNombre) {
        this.usuarioNombre = usuarioNombre;
    }

    public String getUsuarioApellidos() {
        return usuarioApellidos;
    }

    public void setUsuarioApellidos(String usuarioApellidos) {
        this.usuarioApellidos = usuarioApellidos;
    }

    public Date getUsuarioFechaAlta() {
        return usuarioFechaAlta;
    }

    public void setUsuarioFechaAlta(Date usuarioFechaAlta) {
        this.usuarioFechaAlta = usuarioFechaAlta;
    }

    public String getUsuarioEstado() {
        return usuarioEstado;
    }

    public void setUsuarioEstado(String usuarioEstado) {
        this.usuarioEstado = usuarioEstado;
    }

    public Date getUsuarioFechaBaja() {
        return usuarioFechaBaja;
    }

    public void setUsuarioFechaBaja(Date usuarioFechaBaja) {
        this.usuarioFechaBaja = usuarioFechaBaja;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuariosPK != null ? usuariosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuarios)) {
            return false;
        }
        Usuarios other = (Usuarios) object;
        if ((this.usuariosPK == null && other.usuariosPK != null) || (this.usuariosPK != null && !this.usuariosPK.equals(other.usuariosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.softwareatumedida.modelo.Usuarios[ usuariosPK=" + usuariosPK + " ]";
    }
    
}
