package org.example.festival;

import org.example.connection.ConexionORM;
import org.example.dao.FestivalDao;
import org.example.dao.FestivalORMDAO;
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
public class FestivalDaoORMTest {



    /**
    @Test
    public void t01establecerconexionMongoDB(){
        ConexionORM.obtenerConexion();
    }

    /**
     * @Test
     *     public void t02cerrarconexionMongoDB(){
     *         ConexionORM.cerrarConexion();
     *     }
     */


    FestivalDao daoFestival = new FestivalORMDAO();

    private static int idInsertado;

    @Test
    public void t03Insertar(){
        try{
            String fechaIni = "10/03/2022 10:00";
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm");
            Date parsedDate = dateFormat.parse(fechaIni);
            Timestamp fecInsertar = new Timestamp(parsedDate.getTime());

            String fechaFin = "10/04/2022 10:00";
            Date parsedDate2 = dateFormat.parse(fechaFin);
            Timestamp fecInsertar2 = new Timestamp(parsedDate2.getTime());

            Festival objeto = new Festival();
            objeto.setId(9);
            objeto.setNombre("Reunion Aulanosa");
            objeto.setDescripcion("una reunion entre compañeros de clase y profesores");
            objeto.setInicio(fecInsertar);
            objeto.setFin(fecInsertar2);
            objeto.setAforo(32);
            objeto.setPrecio(200);
            objeto.setVentas(35);
            idInsertado = daoFestival.insertar(objeto);
            assertTrue(idInsertado>0);


        }catch (Exception e){
            e.printStackTrace();
            assertTrue(false);
        }
    }

    @Test
    public void t04Consultar(){
        try{
            Festival objeto = daoFestival.consultar(idInsertado);
            assertEquals("Reunion Aulanosa", objeto.getNombre());
        }catch (Exception e){
            e.printStackTrace();
            assertTrue(false);
        }
    }

    @Test
    public void t05Listar(){
        try{
            List<Festival> lista = daoFestival.listar();
            assertTrue(lista.size()>0);
        }catch (Exception e){
            e.printStackTrace();
            assertTrue(false);
        }
    }

    @Test
    public void t06ActualizarDescripcion(){
        try{
            Festival objeto = daoFestival.consultar(idInsertado);
            objeto.setDescripcion("Cambio descripcion");
            daoFestival.actualizar(objeto);
            Festival objetoActualizado = daoFestival.consultar(idInsertado);
            assertEquals("Cambio descripcion", objetoActualizado.getDescripcion());
        }catch (Exception e){
            e.printStackTrace();
            assertTrue(false);
        }
    }

    @Test
    public void t07Eliminar(){
        try{
            daoFestival.eliminar(idInsertado);
            Festival objeto = daoFestival.consultar(idInsertado);
            assertNull(objeto);
        }catch (Exception e){
            e.printStackTrace();
            assertTrue(false);
        }
    }
}
