/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softwareatumedida.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author a
 */
@Embeddable
public class UsuariosPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "UsuarioUsu")
    private String usuarioUsu;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "UsuarioPass")
    private String usuarioPass;

    public UsuariosPK() {
    }

    public UsuariosPK(String usuarioUsu, String usuarioPass) {
        this.usuarioUsu = usuarioUsu;
        this.usuarioPass = usuarioPass;
    }

    public String getUsuarioUsu() {
        return usuarioUsu;
    }

    public void setUsuarioUsu(String usuarioUsu) {
        this.usuarioUsu = usuarioUsu;
    }

    public String getUsuarioPass() {
        return usuarioPass;
    }

    public void setUsuarioPass(String usuarioPass) {
        this.usuarioPass = usuarioPass;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuarioUsu != null ? usuarioUsu.hashCode() : 0);
        hash += (usuarioPass != null ? usuarioPass.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuariosPK)) {
            return false;
        }
        UsuariosPK other = (UsuariosPK) object;
        if ((this.usuarioUsu == null && other.usuarioUsu != null) || (this.usuarioUsu != null && !this.usuarioUsu.equals(other.usuarioUsu))) {
            return false;
        }
        if ((this.usuarioPass == null && other.usuarioPass != null) || (this.usuarioPass != null && !this.usuarioPass.equals(other.usuarioPass))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.softwareatumedida.modelo.UsuariosPK[ usuarioUsu=" + usuarioUsu + ", usuarioPass=" + usuarioPass + " ]";
    }
    
}
