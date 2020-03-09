package com.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "grupos")
@NamedQueries({
    @NamedQuery(name = "Grupo.encontrarTodosGrupos", query = "SELECT g FROM Grupo g ORDER BY g.codigo")
})
public class Grupo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;
    @Column(name = "id_grupo")
    private int idGrupo;
    private String nombre;
    @Column(name = "codigo_col")
    private String codCol;

    @JoinTable(
            name = "inv_grupos",
            joinColumns = @JoinColumn(name = "id_grupos", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "id_investigadores", nullable = false)
    )
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Investigador> investigadores;

    public Grupo() {
    }

    public Grupo(int codigo) {
        this.codigo = codigo;
    }

    public Grupo(int codigo,int idGrupo,String nombre, String codCol) {
        this.codigo = codigo;
        this.idGrupo = idGrupo;
        this.nombre = nombre;
        this.codCol = codCol;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigoGrupo) {
        this.codigo = codigoGrupo;
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

    public void setInvestigadores(Investigador investigador) {
        if (this.investigadores == null) {
            this.investigadores = new ArrayList<>();
        }

        this.investigadores.add(investigador);
    }

    public int getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(int idGrupo) {
        this.idGrupo = idGrupo;

    }

    @Override
    public String toString() {
        return "Grupo{" + "codigo=" + codigo + ", id_grupo=" + idGrupo + ", nombre=" + nombre + ", codigo_col=" + codCol + ", ivestigadores=" + investigadores + '}';
    }

    public List<Investigador> getInvestigadores() {
        return investigadores;
    }

}
