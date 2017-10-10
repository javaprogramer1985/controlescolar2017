/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softwareatumedida.controlador;

import com.softwareatumedida.EJB.MenuFacadeLocal;
import com.softwareatumedida.modelo.Menu;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import lombok.Data;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

@Named
@ViewScoped
@Data
public class MenuControlador implements Serializable {

    @EJB
    private MenuFacadeLocal menufacadeEJB;
    private List<Menu> lista;
    private MenuModel model;

    @PostConstruct
    public void init() {
        lista = this.listar();
        model = new DefaultMenuModel();
        this.establecerPermisos();
    }

    public List<Menu> listar() {
        return menufacadeEJB.findAll();
    }

    public void establecerPermisos() {
        for (Menu m : lista) {
            if (m.getMenuTipo().equals("S")) {
                DefaultSubMenu firstsubmenu = new DefaultSubMenu(m.getMenuNombre());
                for (Menu i : lista) {
                    Menu submenu = i.getMenuCodigoSubmenu();
                    if (submenu != null) {
                        if (Objects.equals(submenu.getMenuCodigo(), m.getMenuCodigo())) {
                            DefaultMenuItem item = new DefaultMenuItem(i.getMenuNombre());
                            item.setCommand(i.getMenuCommando());
                            item.setIcon(i.getMenuIcon());
                            firstsubmenu.addElement(item);
                            item.setUpdate("form");
                        }
                    }
                }
                model.addElement(firstsubmenu);
            } else {
                if (m.getMenuCodigoSubmenu() == null) {
                    DefaultMenuItem item = new DefaultMenuItem(m.getMenuNombre());
                    item.setCommand(m.getMenuCommando());
                    item.setIcon(m.getMenuIcon());
                    model.addElement(item);
                }
            }
        }
    }

}
