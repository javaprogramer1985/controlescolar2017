package com.softwareatumedida.controlador;

import com.softwareatumedida.EJB.MenuFacadeLocal;
import com.softwareatumedida.modelo.Menu;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import lombok.Data;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

@Data
@ViewScoped
@Named
@javax.faces.bean.RequestScoped
public class ModeloMenu implements Serializable{
    
    private MenuModel modelo;    
    
    public ModeloMenu() {
        //init();
        modelo = new DefaultMenuModel();
        //Primer submenu
        DefaultSubMenu primersubmenu = new DefaultSubMenu("Archivo");
        
        DefaultMenuItem item = new DefaultMenuItem("Salir");
        item.setCommand("#{plantillaControlador.cerrarSession()}");
        item.setIcon("ui-icon-arrowthick-1-w");
        item.setUpdate("menu");        
        primersubmenu.addElement(item);
        
        modelo.addElement(item);
        
        DefaultSubMenu segundoSubMenu = new DefaultSubMenu("Configuracion");
        item = new DefaultMenuItem("Entes");
        item.setCommand("#{tabViewItem.addTab('Entes','./ModulosImp/entes.controlescolar')}");
        item.setIcon("ui-icon-circle-plus");
        item.setUpdate("form");
        
        segundoSubMenu.addElement(item);
               
        item = new DefaultMenuItem("Modulos");
        item.setCommand("#{tabViewItem.addTab('Modulos','./modulo/modulos.xhtml')}");
        item.setIcon("ui-icon-link");
        item.setUpdate("form");
        segundoSubMenu.addElement(item);
        
        item = new DefaultMenuItem("Usuario");
        item.setCommand("#{tabViewItem.addTab('Usuarios','./usuario/usuarios.xhtml')}");
        item.setIcon("ui-icon-person");
        item.setUpdate("form");
        segundoSubMenu.addElement(item);
        
        item = new DefaultMenuItem("Nueva Pestaña");
        item.setCommand("#{tabViewItem.addTab('Nueva Pestaña','prueba.xhtml')}");
        item.setIcon("ui-icon-person");
        item.setUpdate("form");
        segundoSubMenu.addElement(item);
        
        modelo.addElement(segundoSubMenu);
        
    }
    
}
