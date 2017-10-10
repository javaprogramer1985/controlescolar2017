package com.softwareatumedida.EJB;

import com.softwareatumedida.modelo.Escuela;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class EscuelaFacade extends AbstractFacade<Escuela> implements EscuelaFacadeLocal {
    @PersistenceContext(unitName = "ControlPersistenceUnit")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EscuelaFacade() {
        super(Escuela.class);
    }
    
}
