package com.softwareatumedida.bean;

import java.io.Serializable;
import lombok.Data;

@Data
public class TabViewTabInfo implements Serializable{
    
    public String tabTitulo = "";
    public String UrlContent = "";

    public TabViewTabInfo(String tabTitulo,String UrlContent) {
        this.tabTitulo = tabTitulo;
        this.UrlContent = UrlContent;
    }
}
