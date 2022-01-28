package org.example.festival;

import com.mongodb.client.MongoDatabase;
import org.example.connection.ConexionMongoDB;
import org.example.dao.FestivalDao;
import org.example.dao.FestivalMongoDBDao;
import org.example.model.Festival;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FestivalDaoMongoDBTest {
        FestivalDao daoFestival = new FestivalMongoDBDao();
        private static int idInsertado;

    /**
     * conexion do MongoDB
     */
    @Test
    public void t01establecerconexionMongoDB(){
        ConexionMongoDB.obtenerConexion();
    }

    /**
     * cerrar conexion con MongoDB
     */
    @Test
    public void t02cerrarconexionMongoDB(){
        ConexionMongoDB.cerrarConexion();
    }

    /**
     *  Text de conexion con MongoDB a traves de un objeto
     */
    @Test
    public void t03ProbarConexion(){
        MongoDatabase conexion = ConexionMongoDB.obtenerConexion();
        assertNotNull(conexion);
    }

    /**
     *  prueba de insertado en DDBB de Mongo
     */
    @Test
    public void t04insertarfestival(){
    try{
        String fecha = "10/03/2022 10:00";
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm");
        Date parsedDate = dateFormat.parse(fecha);
        Timestamp fecInsertar = new Timestamp(parsedDate.getTime());

        String fechaFin = "10/04/2022 10:00";
        Date parsedDate2 = dateFormat.parse(fechaFin);
        Timestamp fecInsertar2 = new Timestamp(parsedDate2.getTime());

        Festival objeto = new Festival();
        objeto.setId(4);
        objeto.setNombre("by");
        objeto.setDescripcion("holaa");
        objeto.setInicio(fecInsertar);
        objeto.setFin(fecInsertar2);
        objeto.setAforo(32);
        objeto.setPrecio(200);
        objeto.setVentas(35);
        idInsertado = daoFestival.insertar(objeto);
        assertTrue(idInsertado>0);

    }catch (Exception e){
        e.printStackTrace();
    }

    }

    /**
     * prueba de consulta
     */

    @Test
    public void t05Consultar(){
        Festival objeto = daoFestival.consultar(idInsertado);
        assertEquals("holaa", objeto.getDescripcion());
    }

    /**
     * prueba de listado
     */
    @Test
    public void t06Listar(){
        List<Festival> lista = daoFestival.listar();
        assertTrue(lista.size()>0);
    }

    /**
     * prueva de actualicacion de datos almacenados en MondoDB
     */
    @Test
    public void t07ActualizarDescripcion(){
        Festival objeto = daoFestival.consultar(idInsertado);
        objeto.setDescripcion("cambio descripcion");
        daoFestival.actualizar(objeto);

        Festival objetoActualizado = daoFestival.consultar(idInsertado);
        assertEquals("cambio descripcion", objetoActualizado.getDescripcion());
    }

}
