package com.domain;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "inv_grupos")
@NamedQueries({
    @NamedQuery(name = "Inv_grupos.encontrarTodosInvestigadores", query = "SELECT g FROM Inv_grupos g ORDER BY g.codigo")
})
public class Inv_grupos implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;
    @ManyToOne
    @JoinColumn(name= "codigo_grupo")
    private Grupo codigoGrupo;
    
   
    @JoinColumn(name= "codigo_inv")
    @ManyToOne
    private Investigador codigoInv;
}
