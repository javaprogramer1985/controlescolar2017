package com.softwareatumedida.controlador;

import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;


@Named
@ViewScoped
public class ControladorSinPermisos implements Serializable{

    FacesContext context;
    
    public ControladorSinPermisos() {
        context = FacesContext.getCurrentInstance();
    }
    
    
    public void redirect_login(){
        try {            
            
            context.getExternalContext().redirect("./../index.controlescolar");
        } catch (IOException ex) {
            Logger.getLogger(ControladorSinPermisos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
