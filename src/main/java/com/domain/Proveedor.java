package com.domain;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "proveedores")
@NamedQueries({
    @NamedQuery(name = "Proveedor.encontrarTodosProveedores", query = "SELECT p FROM Proveedor p ORDER BY p.id_proveedor")
})
public class Proveedor implements Serializable {
    @Id
    // @Column(name="id_proveedor")
    
    private int id_proveedor;
    private int nit;
    private String nombre;
    private int telefono;

    public Proveedor() {
    }

    public Proveedor(int id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public Proveedor(int id_proveedor, int nit, String nombre, int telefono) {
        this.id_proveedor = id_proveedor;
        this.nit = nit;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public int getNit() {
        return nit;
    }

    public void setNit(int nit) {
        this.nit = nit;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public int getIdProveedor() {
        return id_proveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.id_proveedor = idProveedor;
    }

    @Override
    public String toString() {
        return "Proveedor{" + "id_proveedor=" + id_proveedor + ", nombre=" + nombre + ", nit=" + nit + ", telefono=" + telefono + '}';
    }

}
