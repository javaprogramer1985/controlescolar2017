/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softwareatumedida.EJB;

import com.softwareatumedida.modelo.Cicloescolar;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author a
 */
@Local
public interface CicloescolarFacadeLocal {

    void create(Cicloescolar cicloescolar);

    void edit(Cicloescolar cicloescolar);

    void remove(Cicloescolar cicloescolar);

    Cicloescolar find(Object id);

    List<Cicloescolar> findAll();

    List<Cicloescolar> findRange(int[] range);

    int count();
    
}
