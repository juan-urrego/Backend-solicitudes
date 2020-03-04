package com.data;


import java.util.List;
import com.domain.Proveedor;


public interface ProveedorDao {
    
    public List<Proveedor> encontrarTodosProveedores();
    
    public Proveedor encontrarProveedor(Proveedor proveedor);
    
    public void insertarProveedor(Proveedor proveedor);
    
    public void actualizarProveedor(Proveedor proveedor);
    
    public void eliminarProveedor(Proveedor proveedor);
}
