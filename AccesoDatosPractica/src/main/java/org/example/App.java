package org.example;

import org.example.connection.ConexionSQLServer;
import org.example.dao.CiudadDao;
import org.example.dao.CiudadDaoSQLServer;
import org.example.model.Ciudad;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ConexionSQLServer.obtenerConexion();
        pruebaDAO();
        //pruebaDAOListar();
        ConexionSQLServer.cerrarConexion();

    }
    public static void pruebaDAO(){
        CiudadDao objCiudadDao = new CiudadDaoSQLServer();
        int insertado1 = objCiudadDao.insertar(new Ciudad(2,"Galicia",45,13,"España"));
        int insertado2 = objCiudadDao.insertar(new Ciudad(2,"Paris",405,103,"Francia"));
        int insertado3 = objCiudadDao.insertar(new Ciudad(2,"Aguadulce",435,143,"Panama"));
        objCiudadDao.listar();


        Ciudad objCiudad2 = objCiudadDao.consultar(insertado2);
        System.out.println(objCiudad2.getNombre());
        objCiudad2.setNombre("Puerro");
        System.out.println(objCiudad2.getNombre());
        objCiudadDao.actualizar(objCiudad2);
        objCiudadDao.listar();

        Ciudad objCiudad3 = objCiudadDao.consultar(insertado3);
        System.out.println(objCiudad3.getNombre());
        objCiudad3.setNombre("Aguasalada");
        System.out.println(objCiudad3.getNombre());
        objCiudadDao.listar();

    }
    public static void pruebaDAOListar(){
        CiudadDao objCiudadDao = new CiudadDaoSQLServer();
        objCiudadDao.listar();
    }

}
