package org.example.dao;

import org.example.connection.ConexionORM;
import org.example.model.Festival;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.Timestamp;
import java.util.List;

public class FestivalORMDAO implements FestivalDao{
    /**
     *
     * @return
     */
    @Override
    public List<Festival> listar() {
        Session conexion= ConexionORM.obtenerConexion().getCurrentSession();
        Transaction tx = conexion.beginTransaction();
        List<Festival> lista = conexion.createQuery("from Festival", Festival.class).getResultList();
        tx.commit();
        conexion.close();
        return lista;
    }

    @Override
    public Festival consultar(int id) {
        Session conexion= ConexionORM.obtenerConexion().getCurrentSession();
        Transaction tx = conexion.beginTransaction();
        Festival obj = conexion.get(Festival.class, id);
        tx.commit();
        conexion.close();
        return obj;
    }

    @Override
    public void actualizar(Festival objeto) {
        Session conexion= ConexionORM.obtenerConexion().getCurrentSession();
        Transaction tx = conexion.beginTransaction();
        Festival objBD = conexion.load(Festival.class, objeto.getId());
        objBD.setNombre(objeto.getNombre());
        objBD.setDescripcion(objeto.getDescripcion());
        objBD.setInicio(new Timestamp(objeto.getInicio().getTime()));
        objBD.setFin(new Timestamp(objeto.getFin().getTime()));
        objBD.setAforo(objeto.getAforo());
        objBD.setPrecio(objeto.getPrecio());
        objBD.setVentas(objeto.getVentas());
        conexion.update(objBD);
        tx.commit();
        conexion.close();


    }

    @Override
    public void eliminar(int id) {
        Session conexion= ConexionORM.obtenerConexion().getCurrentSession();
        Transaction tx = conexion.beginTransaction();
        Festival obj = conexion.load(Festival.class, id);
        conexion.delete(obj);
        tx.commit();
        conexion.close();

    }

    @Override
    public int insertar(Festival objeto) throws Exception {
        Session conexion= ConexionORM.obtenerConexion().getCurrentSession();
        Transaction tx = conexion.beginTransaction();
        conexion.save(objeto);
        tx.commit();
        conexion.close();
        return objeto.getId();
    }
}
