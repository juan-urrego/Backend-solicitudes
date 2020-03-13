package com.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "investigadores")
@NamedQueries({
    @NamedQuery(name = "Investigador.encontrarTodosInvestigadores", query = "SELECT g FROM Investigador g ORDER BY g.idInvestigador")
})
public class Investigador implements Serializable {

    @Id
    @Column(name = "id_investigador")
    private String idInvestigador;
    private String nombre;
    private int telefono;

    @ManyToMany(mappedBy = "investigadores")
    private List<Grupo> grupos;
    
    public Investigador() {
    }

    public Investigador(String idInvestigador) {
        this.idInvestigador = idInvestigador;
    }

    public Investigador(String idInvestigador, String nombre, int telefono, List<Grupo> grupos) {
        this.idInvestigador = idInvestigador;
        this.nombre = nombre;
        this.telefono = telefono;
        this.grupos = grupos;
    }


    public String getIdInvestigador() {
        return idInvestigador;
    }

    public void setIdInvestigador(String idInvestigador) {
        this.idInvestigador = idInvestigador;
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
    
    public List<Grupo> getGrupos() {
        return grupos;
    }

    public void setGrupos(List<Grupo> grupos) {
        this.grupos = grupos;
    }

    @Override
    public String toString() {
        return "Investigador{" + "idInvestigador=" + idInvestigador + ", nombre=" + nombre + ", telefono=" + telefono + '}';
    }


  
}
