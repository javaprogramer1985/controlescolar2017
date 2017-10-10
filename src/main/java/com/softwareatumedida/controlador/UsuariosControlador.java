    package com.softwareatumedida.controlador;

import com.softwareatumedida.util.Codificador;
import com.softwareatumedida.EJB.UsuariosFacadeLocal;
import com.softwareatumedida.modelo.Usuarios;
import com.softwareatumedida.modelo.UsuariosPK;
import java.io.Serializable;
import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import org.primefaces.event.FlowEvent;

@ManagedBean
public class UsuariosControlador implements Serializable{
    
    @Inject
    private UsuariosFacadeLocal usuarioEJB;    
    private Usuarios usuario;    
    private UsuariosPK usuariopk;    
    private FacesContext context;    
    private boolean skip;
    
    @PostConstruct
    public void init (){
        usuario = new Usuarios();
        usuariopk = new UsuariosPK();   
        
        context = FacesContext.getCurrentInstance();
        //fc.getExternalContext().getFlash().setKeepMessages(true);
    }

    public boolean isSkip() {
        return skip;
    }

    public void setSkip(boolean skip) {
        this.skip = skip;
    }
    
    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }     
    
    public UsuariosPK getUsuariopk() {
        return usuariopk;
    }

    public void setUsuariopk(UsuariosPK usuariopk) {
        this.usuariopk = usuariopk;
    }
    
    
    public void registrar(){
        try{
            
            Codificador cod = new Codificador();
            
            /*Codificamos la clave para buscarla en la base de datos*/
            String clavecodificada = cod.CODIDECO(usuariopk.getUsuarioUsu(), 1);
            usuariopk.setUsuarioPass(clavecodificada);
        
            usuario.setUsuariosPK(usuariopk);
            
            usuarioEJB.create(usuario);
            
            FacesMessage msg = new FacesMessage("Exito", "El usuario se registro correctamente");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            FacesContext fc = FacesContext.getCurrentInstance(); 
            NavigationHandler nh = fc.getApplication().getNavigationHandler();
            nh.handleNavigation(fc, null, "usuario.xhtml?faces-redirect=true");
        }catch(Exception e){
            FacesMessage msg = new FacesMessage("Error", "Ocurrio un error al tratar de guardar");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }

    public String login (){
        Codificador cod = new Codificador();
        String clavecodificada = cod.CODIDECO(usuariopk.getUsuarioPass(), 1);
        String redireccion="./Modulos/administrador/sinpermisos.xhtml?faces-redirect=true";
        usuariopk.setUsuarioPass(clavecodificada);          
        
        Usuarios datosusuario = usuarioEJB.find(usuariopk);
        if (datosusuario != null){
            
            switch(datosusuario.getUsuarioTipo()){
                //ADMINISTRADOR
                case "1":
                    FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("sessionUsuario", datosusuario);
                    redireccion = "./Modulos/administrador/principaladministrador.xhtml?faces-redirect=true";
                   break;
                //PROFESOR
                case "2":
                    FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("sessionUsuario", datosusuario);
                    redireccion = "./Modulos/profesor/principalprofesor.xhtml?faces-redirect=true";
                    break;
                //ESTUDIANTE
                case "3":
                    FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("sessionUsuario", datosusuario);
                    redireccion = "./Modulos/estudiante/principalestudiante.xhtml?faces-redirect=true";
                    break;
            }                
        }else{
            FacesMessage msg = new FacesMessage("Error", "El usuario no existe en la base de datos");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
        
        return redireccion;
    }
    
    public String cerrarSession(){
        context = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
        session.invalidate();
        return "./../../index.xhtml?faces-redirect=true";
    }

    public String onFlowProcess(FlowEvent event){
        if (skip){
            skip = false;
            return "confirm";
        }else{
            return event.getNewStep();
        }     
    }
    
}
