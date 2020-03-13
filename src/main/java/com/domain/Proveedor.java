package com.domain;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "proveedores")
@NamedQueries({
    @NamedQuery(name = "Proveedor.encontrarTodosProveedores", query = "SELECT p FROM Proveedor p ORDER BY p.idProveedor")
})
public class Proveedor implements Serializable {

    @Id
    @Column(name="id_proveedor")
    private String idProveedor;
    private int nit;
    private String nombre;
    private int telefono;

    public Proveedor() {
    }

    public Proveedor(String idProveedor) {
        this.idProveedor = idProveedor;
    }

    public Proveedor(String idProveedor, int nit, String nombre, int telefono) {
        this.idProveedor = idProveedor;
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

    public String getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(String idProveedor) {
        this.idProveedor = idProveedor;
    }

    @Override
    public String toString() {
        return "Proveedor{" + "idProveedor=" + idProveedor + ", nombre=" + nombre + ", nit=" + nit + ", telefono=" + telefono + '}';
    }

}
