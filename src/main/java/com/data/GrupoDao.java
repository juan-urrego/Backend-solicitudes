package com.data;


import java.util.List;
import com.domain.Grupo;


public interface GrupoDao {
    
    public List<Grupo> encontrarTodosGrupos();
    
    public Grupo encontrarGrupo(Grupo grupo);
    
    public void insertarGrupo(Grupo grupo);
    
    public void actualizarGrupo(Grupo grupo);
    
    public void eliminarGrupo(Grupo grupo);
}
