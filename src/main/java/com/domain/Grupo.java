package com.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "grupos")
@NamedQueries({
    @NamedQuery(name = "Grupo.encontrarTodosGrupos", query = "SELECT g FROM Grupo g ORDER BY g.codigoGrupo")
})
public class Grupo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo")
    private int codigoGrupo;
    private String nombre;
    @Column(name = "codigo_col")
    private String codCol;
    @OneToMany(mappedBy = "codigoGrupo")
    private List<Inv_grupos> inv_gruposs;

    public Grupo() {
    }

    public Grupo(int codigoGrupo) {
        this.codigoGrupo = codigoGrupo;
    }

    public Grupo(int codigoGrupo, String nombre, String codCol) {
        this.codigoGrupo = codigoGrupo;
        this.nombre = nombre;
        this.codCol = codCol;
    }

    public int getCodigoGrupo() {
        return codigoGrupo;
    }

    public void setCodigoGrupo(int codigoGrupo) {
        this.codigoGrupo = codigoGrupo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodCol() {
        return codCol;
    }

    public void setCodCol(String codCol) {
        this.codCol = codCol;
    }
    
    @Override
    public String toString() {
        return "Grupo{" + "codigo=" + codigoGrupo + ", nombre=" + nombre + ", codigo_col=" + codCol + '}';
    }
}
    