package com.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "grupos")
@NamedQueries({
    @NamedQuery(name = "Grupo.encontrarTodosGrupos", query = "SELECT g FROM Grupo g ORDER BY g.idGrupo")
})
public class Grupo implements Serializable {

    @Id
    @Column(name = "id_grupo")
    private String idGrupo;
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

    public Grupo(String idGrupo) {
        this.idGrupo = idGrupo;
    }

    public Grupo(String idGrupo, String nombre, String codCol, List<Investigador> investigadores) {
        this.idGrupo = idGrupo;
        this.nombre = nombre;
        this.codCol = codCol;
        this.investigadores = investigadores;
    }

 
    
    public void setInvestigadores(Investigador investigador){
        if(this.investigadores == null){
            this.investigadores = new ArrayList<>();
        }
        
        this.investigadores.add(investigador);
    }

    public List<Investigador> getInvestigadores() {
        return investigadores;
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

    public String getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(String idGrupo) {
        this.idGrupo = idGrupo;

    }

    @Override
    public String toString() {
        return "Grupo{" + "idGrupo=" + idGrupo + ", nombre=" + nombre + ", codigo_col=" + codCol + ", investigadores=" + investigadores +'}';
    }

}
