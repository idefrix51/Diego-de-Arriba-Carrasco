package org.example.dao;



import org.example.model.Festival;

import java.util.List;

public interface FestivalDao {
    public List<Festival> listar();
    public Festival consultar(int id);
    public void actualizar(Festival objeto);
    public void eliminar(int id);
    public int insertar(Festival objeto) throws Exception;
}
