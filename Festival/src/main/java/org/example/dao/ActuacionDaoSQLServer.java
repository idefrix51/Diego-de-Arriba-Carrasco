package org.example.dao;

import org.example.connection.ConexionFestivalDDBB;

import org.example.dao.ActuacionDao;
import org.example.model.Actuacion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ActuacionDaoSQLServer implements ActuacionDao {
    public ActuacionDaoSQLServer(){}

    public List<Actuacion> listar() {
        List<Actuacion> lista = new ArrayList<Actuacion>();
        Statement sentencia = null;
        ResultSet resultado=null;
        try{
            sentencia = ConexionFestivalDDBB.obtenerConexion().createStatement();
            resultado = sentencia.executeQuery("SELECT * FROM ACTUACION");

            while (resultado.next() ){
                Actuacion objeto = new Actuacion();
                objeto.setId(resultado.getInt("Id"));
                objeto.setIdFestival(resultado.getInt("IdFestival"));
                objeto.setNombre(resultado.getString("Nombre"));
                objeto.setDescripcion(resultado.getString("Descripcion"));
                objeto.setGrupo(resultado.getString("Grupo"));
                objeto.setEscenario(resultado.getString("Escenario"));
                objeto.setInicio(resultado.getTimestamp("Inicio"));
                objeto.setFin(resultado.getTimestamp("Fin"));

                lista.add(objeto);
            }

        }catch (Exception e){
            e.printStackTrace();
        } finally{
            try{
                if(sentencia != null) sentencia.close();
                if(resultado != null) resultado.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        return lista;
    }

    @Override
    public Actuacion consultar(int id) {
        Actuacion objeto = null;
        PreparedStatement sentencia = null;
        ResultSet resultado=null;
        try{
            String sql = "SELECT * FROM ACTUACION WHERE Id = ?";
            sentencia = ConexionFestivalDDBB.obtenerConexion().prepareStatement(sql);
            sentencia.setInt(1, id);
            resultado= sentencia.executeQuery();

            while (resultado.next() ){
                objeto = new Actuacion();
                objeto.setId(resultado.getInt("Id"));
                objeto.setIdFestival(resultado.getInt("IdFestival"));
                objeto.setNombre(resultado.getString("Nombre"));
                objeto.setDescripcion(resultado.getString("Descripcion"));
                objeto.setGrupo(resultado.getString("Grupo"));
                objeto.setEscenario(resultado.getString("Escenario"));
                objeto.setInicio(resultado.getTimestamp("Inicio"));
                objeto.setFin(resultado.getTimestamp("Fin"));

            }

        }catch (Exception e){
            e.printStackTrace();
        } finally{
            try{
                if(sentencia != null) sentencia.close();
                if(resultado != null) resultado.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return objeto;
    }

    @Override
    public void actualizar(Actuacion objeto) {
        PreparedStatement sentencia = null;
        try{
            String sql = "UPDATE ACTUACION SET ";
            sql = sql + " Nombre = ? ";
            sql=sql + "WHERE Id = ?";
            sentencia = ConexionFestivalDDBB.obtenerConexion().prepareStatement(sql);
            sentencia.setString(1, objeto.getNombre());
            sentencia.setInt(2, objeto.getId());
            sentencia.executeUpdate();



        }catch (Exception e){
            e.printStackTrace();
        } finally{
            try{
                if(sentencia != null) sentencia.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public void eliminar(int id) {
        PreparedStatement sentencia = null;

        try{
            String sql = "DELETE FROM ACTUACION WHERE Id = ?";
            sentencia = ConexionFestivalDDBB.obtenerConexion().prepareStatement(sql);
            sentencia.setInt(1, id);
            sentencia.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        } finally{
            try{
                if(sentencia != null) sentencia.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public int insertar(Actuacion objeto) {
        int id = 0;
        PreparedStatement sentencia = null;
        ResultSet resultado = null;
        //int id, String nombre, int genre, int pegi, String platform, Date devStartDate, Date releaseDate, int subDeveloper
        try{
            String sql = "INSERT INTO ACTUACION (IdFestival, Nombre, Descripcion, Grupo, Escenario, Inicio, Fin) VALUES (?, ?, ?, ?, ?, ?, ?) ";
            sentencia = ConexionFestivalDDBB.obtenerConexion().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            sentencia.setInt(1, objeto.getIdFestival());
            sentencia.setString(2, objeto.getNombre());
            sentencia.setString(3, objeto.getDescripcion());
            sentencia.setString(4, objeto.getGrupo());
            sentencia.setString(5, objeto.getEscenario());
            sentencia.setTimestamp(6, objeto.getInicio());
            sentencia.setTimestamp(7, objeto.getFin());








            sentencia.executeUpdate();
            resultado = sentencia.getGeneratedKeys();
            resultado.next();
            id= resultado.getInt(1);
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(sentencia != null) sentencia.close();
                if(resultado != null) resultado.close();
            }catch (Exception e ){
                e.printStackTrace();
            }
        }




        return id;
    }


}
