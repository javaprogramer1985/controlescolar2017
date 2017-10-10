/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softwareatumedida.EJB;

import com.softwareatumedida.modelo.Becas;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author a
 */
@Local
public interface BecasFacadeLocal {

    void create(Becas becas);

    void edit(Becas becas);

    void remove(Becas becas);

    Becas find(Object id);

    List<Becas> findAll();

    List<Becas> findRange(int[] range);

    int count();
    
}
