package org.example.connection;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

;

public class ConexionORM {
    private static SessionFactory conexion;

    private ConexionORM(){
        conexion = new Configuration().configure().buildSessionFactory();
    }
    public static SessionFactory obtenerConexion(){
        if ( conexion == null){
            new ConexionORM();
        }
        return conexion;
    }
    public static void cerrarConexion(){
        if(conexion != null){
            conexion.close();
        }
    }
}
