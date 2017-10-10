package com.softwareatumedida.EJB;

import com.softwareatumedida.modelo.Escuela;
import java.util.List;
import javax.ejb.Local;

@Local
public interface EscuelaFacadeLocal {

    void create(Escuela escuela);

    void edit(Escuela escuela);

    void remove(Escuela escuela);

    Escuela find(Object id);

    List<Escuela> findAll();

    List<Escuela> findRange(int[] range);

    int count();
    
}
