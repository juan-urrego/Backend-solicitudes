package com.data;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.*;
import com.domain.Proveedor;

@Stateless
public class ProveedorDaoImpl implements ProveedorDao{
    
    @PersistenceContext (unitName = "SolicitudPU")
    EntityManager em;
    
    @Override
    public List<Proveedor> encontrarTodosProveedores() {
        return em.createNamedQuery("Proveedor.encontrarTodosProveedores").getResultList();
    }

    @Override
    public Proveedor encontrarProveedor(Proveedor proveedor) {
        return em.find(Proveedor.class, proveedor.getCodigo());
    }

    @Override
    public void insertarProveedor(Proveedor proveedor) {
        em.persist(proveedor);
        em.flush();
    }

    @Override
    public void actualizarProveedor(Proveedor proveedor) {
        em.merge(proveedor);
    }

    @Override
    public void eliminarProveedor(Proveedor proveedor) {
        em.remove(em.merge(proveedor));
    }
}
