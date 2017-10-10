/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softwareatumedida.EJB;

import com.softwareatumedida.modelo.Calificaciones;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author a
 */
@Stateless
public class CalificacionesFacade extends AbstractFacade<Calificaciones> implements CalificacionesFacadeLocal {
    @PersistenceContext(unitName = "ControlPersistenceUnit")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CalificacionesFacade() {
        super(Calificaciones.class);
    }
    
}
