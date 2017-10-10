package com.softwareatumedida.bean;

import java.io.Serializable;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;
import lombok.Data;

@Named(value = "tabViewItem")
@ManagedBean
@ViewScoped
@Data
public class TabViewBean implements Serializable{
    
    ArrayList<TabViewTabInfo> itemTabInfo;
    
    int activeIndex;

    public TabViewBean() {
        init();
    }
    
    @PostConstruct
    private void init(){
        itemTabInfo = new ArrayList<>();                        
        itemTabInfo.add(new TabViewTabInfo("Bienvenido", "Bienvenido.controlescolar"));
        activeIndex = 0;
    }
    
    public void addTab(String titulo,String content){
        TabViewTabInfo newItem = new TabViewTabInfo(titulo,content);
        if ( !existsTab(newItem) )
            itemTabInfo.add(newItem);            
    }  
    
    public void onTabClose(TabViewTabInfo tab){
        itemTabInfo.remove(tab);
    }
    
    /***
     * 
     * @param item Recibe un objeto tipo TabViewItems
     * @return Regresa verdadero si encuentra la pestaña creada
     */
    private boolean existsTab(TabViewTabInfo item){
        for (TabViewTabInfo tab : itemTabInfo) {
            if ( item.getTabTitulo().equals(tab.getTabTitulo())){
                activeIndex = itemTabInfo.indexOf(tab);//Establece el indice activo con el indice en donde se encontro la pestaña 
                return true;
            }
            
            activeIndex = itemTabInfo.size();//Si se no se encontro pongo como activa la ultima que se agrega
        }
        return false;
    }
}
