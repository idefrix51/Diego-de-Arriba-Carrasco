package org.example.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionSQLServer {
    private static final String BD_SERVIDOR = "jdbc:sqlserver://localhost:1433;databasename=";
    private static final String BD_NOMBRE = "Ubisoft";
    private static final String BD_USUARIO = "sa";
    private static final String BD_PASSWORD = "123456";
    private static Connection conexion;

    private ConexionSQLServer(){
        try{
            conexion = DriverManager.getConnection(BD_SERVIDOR + BD_NOMBRE, BD_USUARIO, BD_PASSWORD);
            System.out.println("Conexion con BD realizada");

        }catch (SQLException e){
            System.out.println("ERROR en apertura de BD");
            e.printStackTrace();
        }
    }
    public static Connection obtenerConexion(){
        if(conexion==null){
            new ConexionSQLServer();
        }
        return conexion;
    }
    public static void cerrarConexion(){
        if(conexion != null){
            try{
                conexion.close();
                System.out.println("BD cerrada");

            }catch (SQLException e){
                System.out.println("ERROR en el cierre de BD");
                e.printStackTrace();
            }
            conexion=null;
        }
    }


}
