package org.example.dao;



import org.example.model.Actuacion;

import java.util.List;

public interface ActuacionDao {
    public List<Actuacion> listar();
    public Actuacion consultar(int id);
    public void actualizar(Actuacion objeto);
    public void eliminar(int id);
    public int insertar(Actuacion objeto);
}
