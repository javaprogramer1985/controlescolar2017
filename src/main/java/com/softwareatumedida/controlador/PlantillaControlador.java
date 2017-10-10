package com.softwareatumedida.controlador;

import com.softwareatumedida.modelo.Usuarios;
import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class PlantillaControlador implements Serializable {

    Usuarios datosusuario;
            
    public PlantillaControlador() {
        datosusuario = (Usuarios) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("sessionUsuario");
    }

    public void validarSesion() {        
        try {

            if (datosusuario == null) {
                FacesContext.getCurrentInstance().getExternalContext().redirect("./../sinpermisos.controlescolar");
            }
        } catch (IOException ex) {
            Logger.getLogger(PlantillaControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void cerrarSession() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
            FacesContext.getCurrentInstance().getExternalContext().redirect("./../../");
        } catch (IOException ex) {
            Logger.getLogger(PlantillaControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String tipoUsuario(){
        String tipo;
        switch( datosusuario.getUsuarioTipo() ){
            case "1":
                tipo = "::.. Bienvenido Administrador ..::";
                break;
            case "2":
                tipo = "::.. Bienvenido Profesor ..::";
                break;
            default:
                tipo = "Desconocido";
        }
        return tipo;
    }
}
