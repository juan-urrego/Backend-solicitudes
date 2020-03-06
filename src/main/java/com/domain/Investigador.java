package com.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "investigadores")
@NamedQueries({
    @NamedQuery(name = "Investigador.encontrarTodosInvestigadores", query = "SELECT g FROM Investigador g ORDER BY g.codigoInvestigador")
})
public class Investigador implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo")
    private int codigoInvestigador;
    private String nombre;
    private int telefono;
    
    
    @ManyToMany(mappedBy = "investigadores")
    private List<Grupo> grupos;

    public Investigador() {
    }

    public Investigador(int codigoInvestigador) {
        this.codigoInvestigador = codigoInvestigador;
    }

    public Investigador(int codigoInvestigador, String nombre, int telefono) {
        this.codigoInvestigador = codigoInvestigador;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public int getCodigoInvestigador() {
        return codigoInvestigador;
    }

    public void setCodigoInvestigador(int codigoInvestigador) {
        this.codigoInvestigador = codigoInvestigador;
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
        return "Investigador{" + "codigo=" + codigoInvestigador +  ", nombre=" + nombre + ", telefono="+ telefono + ", grupos=" + grupos + '}';
    }

    public List<Grupo> getGrupos() {
        return grupos;
    }

    public void setGrupos(List<Grupo> grupos) {
        this.grupos = grupos;
    }
}
