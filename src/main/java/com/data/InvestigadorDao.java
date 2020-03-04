package com.data;


import java.util.List;
import com.domain.Investigador;


public interface InvestigadorDao {
    
    public List<Investigador> encontrarTodosInvestigadores();
    
    public Investigador encontrarInvestigador(Investigador investigador);
    
    public void insertarInvestigador(Investigador investigador);
    
    public void actualizarInvestigador(Investigador investigador);
    
    public void eliminarInvestigador(Investigador investigador);
}
