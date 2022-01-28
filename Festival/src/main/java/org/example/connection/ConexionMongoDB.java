package org.example.connection;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

public class ConexionMongoDB {
    private static final String BD_SERVIDOR = "Localhost";
    private static final int BD_PUERTO = 27017;
    private static final String BD_NOMBRE = "festival";
    private static MongoDatabase conexion;
    private static MongoClient mongoClient;

    private ConexionMongoDB(){
        MongoClient mongo = new MongoClient(BD_SERVIDOR, BD_PUERTO);
        conexion = mongo.getDatabase(BD_NOMBRE);
    }
    public static MongoDatabase obtenerConexion(){
        if(conexion==null){
            new ConexionMongoDB();
        }
        return conexion;
    }
    public static void cerrarConexion(){
        if(mongoClient !=null){
            mongoClient.close();
            mongoClient = null;
        }
    }
}
