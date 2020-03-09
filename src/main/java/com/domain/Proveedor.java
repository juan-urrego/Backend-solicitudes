package com.domain;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "proveedores")
@NamedQueries({
    @NamedQuery(name = "Proveedor.encontrarTodosProveedores", query = "SELECT p FROM Proveedor p ORDER BY p.codigo")
})
public class Proveedor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;
    @Column(name="id_proveedor")
    private int idProveedor;
    private int nit;
    private String nombre;
    private int telefono;

    public Proveedor() {
    }

    public Proveedor(int codigo) {
        this.codigo = codigo;
    }

    public Proveedor(int codigo,int idProveedor ,int nit, String nombre, int telefono) {
        this.codigo = codigo;
        this.idProveedor = idProveedor;
        this.nit = nit;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
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
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }
    
    
    @Override
    public String toString() {
        return "Proveedor{" + "codigo=" + codigo + ", idProveedor=" + idProveedor + ", nombre=" + nombre + ", nit=" + nit + ", telefono="+ telefono + '}';
    }


}
