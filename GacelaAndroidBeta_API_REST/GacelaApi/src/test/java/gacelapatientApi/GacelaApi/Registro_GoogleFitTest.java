package gacelapatientApi.GacelaApi;


import gacelapatientApi.GacelaApi.dao.registro_GoogleFit.Registro_GoogleFitDAO;
import gacelapatientApi.GacelaApi.dao.registro_GoogleFit.Registro_GoogleFitDAOORM;
import gacelapatientApi.GacelaApi.model.Registro_GoogleFit;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.nio.charset.StandardCharsets;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Registro_GoogleFitTest {

    Registro_GoogleFitDAO registro_GoogleFitDAO = new Registro_GoogleFitDAOORM();
    private static int idInsertado;
    private static int idInsertado2;







    @Test
    public void T02ProbarInsertar() {

        try {
            String fecha = "20/06/2028";
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date parseDate = dateFormat.parse(fecha);
            Timestamp fechaIn = new Timestamp(parseDate.getTime());


            registro_GoogleFitDAO.abrirConexion();
            Registro_GoogleFit registro_GoogleFit = new Registro_GoogleFit();
            registro_GoogleFit.setId_registro_var_fisica(148);
            registro_GoogleFit.setId_calorias_diarias_corporales(157);
            registro_GoogleFit.setCalorias_consumidas(100);
            registro_GoogleFit.setDistancia_recorrida(1000);
            registro_GoogleFit.setPasos(500);
            registro_GoogleFit.setFecha(fechaIn);

            Registro_GoogleFit registro_GoogleFit2 = new Registro_GoogleFit();
            registro_GoogleFit2.setId_registro_var_fisica(148);
            registro_GoogleFit2.setId_calorias_diarias_corporales(157);
            registro_GoogleFit2.setCalorias_consumidas(100);
            registro_GoogleFit2.setDistancia_recorrida(1000);
            registro_GoogleFit2.setPasos(500);
            registro_GoogleFit2.setFecha(fechaIn);


            idInsertado = registro_GoogleFitDAO.insertar(registro_GoogleFit);
            idInsertado2 = registro_GoogleFitDAO.insertar(registro_GoogleFit2);
            System.out.print(idInsertado);
            assertTrue(idInsertado > 0);
            registro_GoogleFitDAO.cerrarConexion();
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
            registro_GoogleFitDAO.abrirConexion();
            Registro_GoogleFit registro_GoogleFit = registro_GoogleFitDAO.consultar(idInsertado);
            int calorias = registro_GoogleFit.getCalorias_consumidas();

            assertEquals(100, calorias);
            registro_GoogleFitDAO.cerrarConexion();
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);

        }

    }


    @Test
    public void T04ProbarListar() {
        try {
            registro_GoogleFitDAO.abrirConexion();
            List<Registro_GoogleFit> lista = registro_GoogleFitDAO.listar();
            assertTrue(lista.size() > 0);
            registro_GoogleFitDAO.cerrarConexion();
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);

        }
    }


    @Test
    public void T05ProbarActualizar() throws ParseException {




        try {
            registro_GoogleFitDAO.abrirConexion();
            Registro_GoogleFit registro_GoogleFit = registro_GoogleFitDAO.consultar(idInsertado);
            registro_GoogleFit.setDistancia_recorrida(2000);
            registro_GoogleFitDAO.actualizar(registro_GoogleFit);
            Registro_GoogleFit registro_GoogleFitActualizado = registro_GoogleFitDAO.consultar(idInsertado);
            int formatted = registro_GoogleFitActualizado.getDistancia_recorrida();
            assertEquals(2000, formatted);

            registro_GoogleFitDAO.cerrarConexion();
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }


    }


    @Test
    public void T06ProbarEliminar() {

        try {
            registro_GoogleFitDAO.abrirConexion();
            registro_GoogleFitDAO.eliminar(idInsertado);
            Registro_GoogleFit registro_GoogleFit = registro_GoogleFitDAO.consultar(idInsertado);
            assertNull(registro_GoogleFit);
            registro_GoogleFitDAO.cerrarConexion();
        } catch (Exception e) {

            e.printStackTrace();
            assertTrue(false);

        }
    }
    /*
    @Test
    public void T07ProbarEliminarcascade() {

        try {
            registro_GoogleFitDAO.abrirConexion();
            registro_GoogleFitDAO.eliminar(idInsertado);
            registro_GoogleFitDAO.cerrarConexion();
        } catch (Exception e) {

            e.printStackTrace();
            assertTrue(false);

        }
    }
*/

}
