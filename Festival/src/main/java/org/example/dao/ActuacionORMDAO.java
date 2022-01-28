package org.example.dao;

import org.example.connection.ConexionORM;
import org.example.model.Actuacion;


import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.Timestamp;
import java.util.List;

public class ActuacionORMDAO implements ActuacionDao{
    @Override
    public List<Actuacion> listar() {
        Session conexion= ConexionORM.obtenerConexion().getCurrentSession();
        Transaction tx = conexion.beginTransaction();
        List<Actuacion> lista = conexion.createQuery("from Festival", Actuacion.class).getResultList();
        tx.commit();
        conexion.close();
        return lista;

    }

    @Override
    public Actuacion consultar(int id) {
        Session conexion= ConexionORM.obtenerConexion().getCurrentSession();
        Transaction tx = conexion.beginTransaction();
        Actuacion obj = conexion.get(Actuacion.class, id);
        tx.commit();
        conexion.close();
        return obj;

    }

    @Override
    public void actualizar(Actuacion objeto) {
        Session conexion= ConexionORM.obtenerConexion().getCurrentSession();
        Transaction tx = conexion.beginTransaction();
        Actuacion objBD = conexion.load(Actuacion.class, objeto.getId());
        objBD.setIdFestival(objeto.getIdFestival());
        objBD.setNombre(objeto.getNombre());
        objBD.setDescripcion(objeto.getDescripcion());
        objBD.setGrupo(objeto.getGrupo());
        objBD.setEscenario(objeto.getEscenario());
        objBD.setInicio(new Timestamp(objeto.getInicio().getTime()));
        objBD.setFin(new Timestamp(objeto.getFin().getTime()));


        conexion.update(objBD);
        tx.commit();
        conexion.close();
    }


    @Override
    public void eliminar(int id) {
        Session conexion= ConexionORM.obtenerConexion().getCurrentSession();
        Transaction tx = conexion.beginTransaction();
        Actuacion obj = conexion.load(Actuacion.class, id);
        conexion.delete(obj);
        tx.commit();
        conexion.close();

    }

    @Override
    public int insertar(Actuacion objeto) {

        return 0;
    }
}
