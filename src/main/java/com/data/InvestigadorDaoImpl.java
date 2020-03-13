package com.data;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.*;
import com.domain.Investigador;

@Stateless
public class InvestigadorDaoImpl implements InvestigadorDao{
    
    @PersistenceContext (unitName = "SolicitudPU")
    EntityManager em;
    
    @Override
    public List<Investigador> encontrarTodosInvestigadores() {
        return em.createNamedQuery("Investigador.encontrarTodosInvestigadores").getResultList();
    }

    @Override
    public Investigador encontrarInvestigador(Investigador investigador) {
        return em.find(Investigador.class, investigador.getIdInvestigador());
    }

    @Override
    public void insertarInvestigador(Investigador investigador) {
        em.persist(investigador);
        em.flush();
    }

    @Override
    public void actualizarInvestigador(Investigador investigador) {
        em.remove(em.merge(investigador));
        em.merge(investigador);
    }

    @Override
    public void eliminarInvestigador(Investigador investigador) {
        em.remove(em.merge(investigador));
    }
}
