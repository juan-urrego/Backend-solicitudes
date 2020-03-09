package com.data;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.*;
import com.domain.Grupo;

@Stateless
public class GrupoDaoImpl implements GrupoDao{
    
    @PersistenceContext (unitName = "SolicitudPU")
    EntityManager em;
    
    @Override
    public List<Grupo> encontrarTodosGrupos() {
        return em.createNamedQuery("Grupo.encontrarTodosGrupos").getResultList();
    }

    @Override
    public Grupo encontrarGrupo(Grupo grupo) {
        return em.find(Grupo.class, grupo.getCodigo());
    }

    @Override
    public void insertarGrupo(Grupo grupo) {
        em.persist(grupo);
        em.flush();
    }

    @Override
    public void actualizarGrupo(Grupo grupo) {
        em.merge(grupo);
    }

    @Override
    public void eliminarGrupo(Grupo grupo) {
        em.remove(em.merge(grupo));
    }
}
