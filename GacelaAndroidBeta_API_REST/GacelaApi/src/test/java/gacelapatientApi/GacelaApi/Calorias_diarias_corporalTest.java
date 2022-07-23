package gacelapatientApi.GacelaApi;


import gacelapatientApi.GacelaApi.dao.calorias_diarias_corporal.Calorias_diarias_corporalDAO;
import gacelapatientApi.GacelaApi.dao.calorias_diarias_corporal.Calorias_diarias_corporalDAOORM;
import gacelapatientApi.GacelaApi.model.Calorias_diarias_corporal;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Calorias_diarias_corporalTest {
    Calorias_diarias_corporalDAO calorias_diarias_corporalDAO = new Calorias_diarias_corporalDAOORM();
    private static int idInsertado;
    private static int idInsertado2;

    @Test
    public void T02ProbarInsertar() {

        try {
            String fecha = "20/06/2028";
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date parseDate = dateFormat.parse(fecha);
            Timestamp fechaIn = new Timestamp(parseDate.getTime());


            calorias_diarias_corporalDAO.abrirConexion();
            Calorias_diarias_corporal calorias_diarias_corporal = new Calorias_diarias_corporal();
            calorias_diarias_corporal.setCalorias_diarias_corporales_ID(1);
            calorias_diarias_corporal.setId_registro_var_fisica(164);
            calorias_diarias_corporal.setCalorias_diarias_corporales_ID(2);
            calorias_diarias_corporal.setCalorias_diarias_totales(10);
            calorias_diarias_corporal.setFecha(fechaIn);


            Calorias_diarias_corporal calorias_diarias_corporal2 = new Calorias_diarias_corporal();
            calorias_diarias_corporal2.setCalorias_diarias_corporales_ID(2);
            calorias_diarias_corporal2.setId_registro_var_fisica(164);
            calorias_diarias_corporal2.setCalorias_diarias_corporales_ID(2);
            calorias_diarias_corporal2.setCalorias_diarias_totales(5);
            calorias_diarias_corporal2.setFecha(fechaIn);



            idInsertado = calorias_diarias_corporalDAO.insertar(calorias_diarias_corporal);
            idInsertado2 = calorias_diarias_corporalDAO.insertar(calorias_diarias_corporal2);
            System.out.print(idInsertado);
            assertTrue(idInsertado > 0);
            calorias_diarias_corporalDAO.cerrarConexion();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }

    }


    @Test
    public void T03ProbarConsultar() {

        try {
            calorias_diarias_corporalDAO.abrirConexion();
            Calorias_diarias_corporal calorias_diarias_corporal = calorias_diarias_corporalDAO.consultar(idInsertado);
            int nombre = calorias_diarias_corporal.getCalorias_diarias_totales();

            assertEquals(10, nombre);
            calorias_diarias_corporalDAO.cerrarConexion();
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);

        }

    }


    @Test
    public void T04ProbarListar() {
        try {
            calorias_diarias_corporalDAO.abrirConexion();
            List<Calorias_diarias_corporal> lista = calorias_diarias_corporalDAO.listar();
            assertTrue(lista.size() > 0);
            calorias_diarias_corporalDAO.cerrarConexion();
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);

        }
    }


    @Test
    public void T05ProbarActualizar() throws ParseException {



        try {
            calorias_diarias_corporalDAO.abrirConexion();
            Calorias_diarias_corporal calorias_diarias_corporal = calorias_diarias_corporalDAO.consultar(idInsertado);
            calorias_diarias_corporal.setCalorias_diarias_totales(10);
            calorias_diarias_corporalDAO.actualizar(calorias_diarias_corporal);
            Calorias_diarias_corporal calorias_diarias_corporalactualizado = calorias_diarias_corporalDAO.consultar(idInsertado);
            int formatted = calorias_diarias_corporalactualizado.getCalorias_diarias_totales();
            assertEquals(10, formatted);

            calorias_diarias_corporalDAO.cerrarConexion();
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }


    }


    @Test
    public void T06ProbarEliminar() {

        try {
            calorias_diarias_corporalDAO.abrirConexion();
            calorias_diarias_corporalDAO.eliminar(idInsertado);
            Calorias_diarias_corporal calorias_diarias_corporal = calorias_diarias_corporalDAO.consultar(idInsertado);
            assertNull(calorias_diarias_corporal);
            calorias_diarias_corporalDAO.cerrarConexion();
        } catch (Exception e) {

            e.printStackTrace();
            assertTrue(false);

        }
    }/*
    @Test
    public void T07ProbarEliminarcascade() {

        try {
            calorias_diarias_corporalDAO.abrirConexion();
            calorias_diarias_corporalDAO.eliminar(156);

            calorias_diarias_corporalDAO.cerrarConexion();
        } catch (Exception e) {

            e.printStackTrace();
            assertTrue(false);

        }
    }*/
}
