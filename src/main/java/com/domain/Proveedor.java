package com.domain;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "proveedores")
@NamedQueries({
    @NamedQuery(name = "Proveedor.encontrarTodosProveedores", query = "SELECT p FROM Proveedor p ORDER BY p.codigoProveedor")
})
public class Proveedor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo")
    private int codigoProveedor;
    private int nit;
    private String nombre;
    private int telefono;

    public Proveedor() {
    }

    public Proveedor(int codigoProveedor) {
        this.codigoProveedor = codigoProveedor;
    }

    public Proveedor(int codigoProveedor, int nit, String nombre, int telefono) {
        this.codigoProveedor = codigoProveedor;
        this.nit = nit;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public int getCodigoProveedor() {
        return codigoProveedor;
    }

    public void setCodigoProveedor(int codigoProveedor) {
        this.codigoProveedor = codigoProveedor;
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
    
    @Override
    public String toString() {
        return "Proveedor{" + "codigo=" + codigoProveedor + ", nombre=" + nombre + ", nit=" + nit + ", telefono="+ telefono + '}';
    }
}
