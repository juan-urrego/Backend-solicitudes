package com.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "investigadores_ppales")
@NamedQueries({
    @NamedQuery(name = "Investigador.encontrarTodosInvestigadores", query = "SELECT g FROM Investigador g ORDER BY g.codigoInvestigador")
})
public class Investigador implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo")
    private int codigoInvestigador;
    @Column(name= "id_investigador")
    private int idInvestigador;
    private String nombre;
    private int telefono;
    @OneToMany(mappedBy = "codigoInv")
    private List<Inv_grupos> inv_gruposs;
    @OneToOne(mappedBy = "codigoInv")
    private Inv_grupos inv_grupos;

    public Investigador() {
    }

    public Investigador(int codigoInvestigador) {
        this.codigoInvestigador = codigoInvestigador;
    }

    public Investigador(int codigoInvestigador, int idInvestigador, String nombre, int telefono) {
        this.codigoInvestigador = codigoInvestigador;
        this.idInvestigador = idInvestigador;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public int getCodigoInvestigador() {
        return codigoInvestigador;
    }

    public void setCodigoInvestigador(int codigoInvestigador) {
        this.codigoInvestigador = codigoInvestigador;
    }

    public int getIdInvestigador() {
        return idInvestigador;
    }

    public void setIdInvestigador(int id_investigador) {
        this.idInvestigador = id_investigador;
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
        return "Proveedor{" + "codigo=" + codigoInvestigador + ", id_investigador=" + idInvestigador + ", nombre=" + nombre + ", telefono="+ telefono + '}';
    }
}
