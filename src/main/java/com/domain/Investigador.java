package com.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "investigadores")
@NamedQueries({
    @NamedQuery(name = "Investigador.encontrarTodosInvestigadores", query = "SELECT g FROM Investigador g ORDER BY g.codigo")
})
public class Investigador implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private int codigo;
    @Column(name = "id_investigador")
    private int idInvestigador;
    private String nombre;
    private int telefono;
    
    
    @ManyToMany(mappedBy = "investigadores")
    private List<Grupo> grupos;

    public Investigador() {
    }

    public Investigador(int codigo) {
        this.codigo = codigo;
    }

    public Investigador(int codigo,int idInvestigador, String nombre, int telefono) {
        this.codigo = codigo;
        this.idInvestigador = idInvestigador;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
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
        return "Investigador{" + "codigo=" + codigo + ", Id_Investigador=" + idInvestigador + ", nombre=" + nombre + ", telefono="+ telefono + ", grupos=" + grupos + '}';
    }

    public List<Grupo> getGrupos() {
        return grupos;
    }

    public void setGrupos(List<Grupo> grupos) {
        this.grupos = grupos;
    }

    public int getIdInvestigador() {
        return idInvestigador;
    }

    public void setIdInvestigador(int idInvestigador) {
        this.idInvestigador = idInvestigador;
    }
}
