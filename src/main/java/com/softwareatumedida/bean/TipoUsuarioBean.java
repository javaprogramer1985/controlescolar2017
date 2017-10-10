package com.softwareatumedida.bean;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.model.SelectItem;
import lombok.Data;

@ManagedBean
@Data
public class TipoUsuarioBean {
    
    private String tipo;
    private Map<String,String> tiposUsuario = new HashMap<>();

    
    @PostConstruct
    public void init(){
        tiposUsuario = new HashMap<>();
        tiposUsuario.put("1", "Profesor");
        tiposUsuario.put("2", "Administrador");        
    }
    
    public TipoUsuarioBean(String tipo) {
        this.tipo = tipo;
    }

    public TipoUsuarioBean() {
    }
    
    
    
}
