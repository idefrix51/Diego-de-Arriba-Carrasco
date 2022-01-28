package org.example.dao;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.example.connection.ConexionMongoDB;
import org.example.model.Festival;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Filter;

import static com.mongodb.client.model.Filters.eq;

public class FestivalMongoDBDao implements FestivalDao{


    private static final String COLECCION = "festival";
    private Document festivalADoc(Festival objFestival){
        Document objDoc = null;

        if(objFestival != null){
            objDoc= new Document();
            objDoc.put("id", objFestival.getId());
            objDoc.put("nombre", objFestival.getNombre());
            objDoc.put("descripcion", objFestival.getDescripcion());
            objDoc.put("inicio", objFestival.getInicio());
            objDoc.put("fin", objFestival.getFin());
            objDoc.put("aforo", objFestival.getAforo());
            objDoc.put("precio", objFestival.getPrecio());
            objDoc.put("ventas", objFestival.getVentas());

            /*private String Descripcion;
            private Timestamp Inicio;
            private Timestamp Fin;
            private int Aforo;
            private int Precio;
            private int Ventas;*/
        }
        return objDoc;
    }
    private Festival docFestival(Document objDoc){
        Festival objFestival = null;

        if(objDoc != null){
            objFestival = new Festival();
            if(objDoc.getInteger("id") != null){
                objFestival.setId(objDoc.getInteger("id"));
            }
            objFestival.setNombre(objDoc.getString("nombre"));
            objFestival.setDescripcion(objDoc.getString("descripcion"));
            objFestival.setInicio(new Timestamp(objDoc.getDate("inicio").getTime()));
            objFestival.setFin(new Timestamp(objDoc.getDate("fin").getTime()));
            objFestival.setAforo(objDoc.getInteger("aforo"));
            objFestival.setPrecio(objDoc.getInteger("precio"));
            objFestival.setVentas(objDoc.getInteger("ventas"));
        }
        return objFestival;
    }

    @Override
    public List<Festival> listar() {

        List<Festival> resultado = new ArrayList<>();
        MongoDatabase conexion = ConexionMongoDB.obtenerConexion();
        MongoCollection<Document> colMongo = conexion.getCollection(COLECCION);
        List<Document> consulta = colMongo.find().into(new ArrayList<Document>());
        Festival festival = new Festival();
        for (int i = 0; i< consulta.size(); i++){
            festival = docFestival(consulta.get(i));
            resultado.add(festival);
        }
        return resultado;
    }

    @Override
    public Festival consultar(int id) {

        MongoDatabase conexion = ConexionMongoDB.obtenerConexion();
        MongoCollection<Document> colMongo = conexion.getCollection(COLECCION);
        Document documento = colMongo.find(eq("id", id)).first();
        return docFestival(documento);
    }

    @Override
    public void actualizar(Festival objeto) {

        MongoDatabase conexion = ConexionMongoDB.obtenerConexion();
        MongoCollection<Document> colMongo = conexion.getCollection(COLECCION);
        Document documento = festivalADoc(objeto);
        try{
            colMongo.replaceOne(Filters.eq("id", objeto.getId()), documento);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void eliminar(int id) {

        MongoDatabase conexion = ConexionMongoDB.obtenerConexion();
        MongoCollection<Document> colMongo = conexion.getCollection(COLECCION);
        try{
            colMongo.deleteOne(Filters.eq("id", id));
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public int insertar(Festival objeto) throws Exception {
        MongoDatabase conexion = ConexionMongoDB.obtenerConexion();
        MongoCollection<Document> colMongo = conexion.getCollection(COLECCION);
        Document documento = festivalADoc(objeto);
        try{
            colMongo.insertOne(documento);
            return objeto.getId();

        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }

    }
}
