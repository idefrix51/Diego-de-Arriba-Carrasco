package org.example.dao;


import org.example.connection.ConexionSQLServer;
import org.example.model.Ciudad;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
public class CiudadDaoSQLServer implements CiudadDao {

    public CiudadDaoSQLServer(){


    }
    @Override
    public List<Ciudad> listar() {
        List<Ciudad> lista = new ArrayList<Ciudad>();
        Statement sentencia = null;
        ResultSet resultado=null;
        try{
            sentencia = ConexionSQLServer.obtenerConexion().createStatement();
            resultado = sentencia.executeQuery("SELECT * FROM Ciudad");

            while (resultado.next() ){
                Ciudad objeto = new Ciudad();
                objeto.setId(resultado.getInt("Id"));
                objeto.setNombre(resultado.getString("Nombre"));
                System.out.println(resultado.getString("Nombre"));
                objeto.setPais(resultado.getString("Pais"));
                objeto.setPoblacionONU(resultado.getInt("PoblacionONU"));
                objeto.setPoblacionCenso(resultado.getInt("PoblacionCENSO"));
                lista.add(objeto);
                System.out.println(objeto.toString());
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
    public Ciudad consultar(int Id) {

        Ciudad objeto = null;
        PreparedStatement sentencia = null;
        ResultSet resultado=null;
        try{
            String sql = "SELECT * FROM Ciudad WHERE Id = ?";
            sentencia = ConexionSQLServer.obtenerConexion().prepareStatement(sql);
            sentencia.setInt(1, Id);
            resultado= sentencia.executeQuery();

            while (resultado.next() ){
                objeto = new Ciudad();
                objeto.setId(resultado.getInt("Id"));
                objeto.setNombre(resultado.getString("Nombre"));
                objeto.setPais(resultado.getString("Pais"));
                objeto.setPoblacionONU(resultado.getInt("PoblacionONU"));
                objeto.setPoblacionCenso(resultado.getInt("PoblacionCENSO"));

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
    public void actualizar(Ciudad objeto) {

        PreparedStatement sentencia = null;
        try{
            String sql = "UPDATE Ciudad SET ";
            sql = sql + " Nombre = ? ";
            sql=sql + "WHERE Id = ?";
            sentencia = ConexionSQLServer.obtenerConexion().prepareStatement(sql);
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
            String sql = "DELETE FROM Ciudad WHERE Id = ?";
            sentencia = ConexionSQLServer.obtenerConexion().prepareStatement(sql);
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
    public int insertar(Ciudad objeto) {
        int Id = 0;
        PreparedStatement sentencia = null;
        ResultSet resultado = null;
        //int id, String nombre, int genre, int pegi, String platform, Date devStartDate, Date releaseDate, int subDeveloper
        try{
            String sql = "INSERT INTO Ciudad (Nombre, Pais, PoblacionONU, PoblacionCENSO) VALUES (?, ?, ?, ?) ";
            sentencia = ConexionSQLServer.obtenerConexion().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            sentencia.setString(1, objeto.getNombre());
            sentencia.setString(2, objeto.getPais());
            sentencia.setInt(3, objeto.getPoblacionONU());
            sentencia.setInt(4, objeto.getPoblacionCenso());






            sentencia.executeUpdate();
            resultado = sentencia.getGeneratedKeys();
            resultado.next();
            Id= resultado.getInt(1);
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




        return Id;
    }
}
