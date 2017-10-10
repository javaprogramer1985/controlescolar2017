/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softwareatumedida.EJB;

import com.softwareatumedida.modelo.Colonia;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author a
 */
@Local
public interface ColoniaFacadeLocal {

    void create(Colonia colonia);

    void edit(Colonia colonia);

    void remove(Colonia colonia);

    Colonia find(Object id);

    List<Colonia> findAll();

    List<Colonia> findRange(int[] range);

    int count();
    
}
