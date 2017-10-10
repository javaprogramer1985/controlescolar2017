package com.softwareatumedida.controlador;

import com.softwareatumedida.EJB.TestFacadeLocal;
import com.softwareatumedida.modelo.Test;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class TestControlador implements Serializable{
    
    @EJB
    private TestFacadeLocal testEJB;
    private Test test;

    @PostConstruct
    public void init(){
        test = new Test();
    }
    
    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }
           
    public void registrar(){
        testEJB.create(test);
    }
}
