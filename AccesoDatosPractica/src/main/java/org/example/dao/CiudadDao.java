package org.example.dao;

import org.example.model.Ciudad;
import org.example.model.Game;

import java.util.List;

public interface CiudadDao {
public List<Ciudad> listar();
public Ciudad consultar(int Id);
public void actualizar(Ciudad objeto);
public void eliminar(int Id);
public int insertar(Ciudad objeto);

/*
    public int insertarLista(List<Game> listaGame);
    public int actualizarLista(List<Game> listaGame);
    public int eliminarLista(List<Game> listaIDs);
*/
}

