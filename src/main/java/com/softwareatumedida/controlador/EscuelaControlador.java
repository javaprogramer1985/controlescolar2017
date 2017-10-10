package com.softwareatumedida.controlador;

import com.softwareatumedida.EJB.EscuelaFacadeLocal;
import com.softwareatumedida.modelo.Escuela;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ManagedBean
@ViewScoped
public class EscuelaControlador implements Serializable{    
    
    @EJB
    private EscuelaFacadeLocal escuelaEJB;
    private Escuela escuela;

    @PostConstruct
    public void init(){
        escuela = new Escuela();
    }
    
    public Escuela getEscuela() {
        return escuela;
    }

    public void setEscuela(Escuela escuela) {
        this.escuela = escuela;
    }
    
    public void registrar(){
        try{
            escuelaEJB.create(escuela);
            FacesMessage msg = new FacesMessage("Successfull", "El plantel se registro correctamente");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }catch(Exception e){
            FacesMessage msg = new FacesMessage("Error", "Ocurrio un error al tratar de guardar");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
            
    }
    
    public Escuela listarPK(int id){
        escuela = escuelaEJB.find(id);
        return escuela;
    }
}
