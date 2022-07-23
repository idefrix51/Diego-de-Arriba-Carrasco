package gacelapatientApi.GacelaApi;


import gacelapatientApi.GacelaApi.dao.ci_medica.Ci_medicaDAO;
import gacelapatientApi.GacelaApi.dao.ci_medica.Ci_medicaDAOORM;
import gacelapatientApi.GacelaApi.dao.paciente.PacienteDAO;
import gacelapatientApi.GacelaApi.dao.paciente.PacienteDAOORM;
import gacelapatientApi.GacelaApi.model.Ci_medica;
import gacelapatientApi.GacelaApi.model.Paciente;
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
public class Ci_medicaTest {

    Ci_medicaDAO ci_medicaDAO = new Ci_medicaDAOORM();

    private static int idInsertado;
    private static int idInsertado2;







    @Test
    public void T02ProbarInsertar() {

        try {
            String fecha = "20/06/2028";
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date parseDate = dateFormat.parse(fecha);
            Timestamp fechaIn = new Timestamp(parseDate.getTime());


            ci_medicaDAO.abrirConexion();
            Ci_medica ci_medica = new Ci_medica();
            ci_medica.setId_paciente(29);
            ci_medica.setId_ci_tipo(95);
            ci_medica.setFecha(fechaIn);
            ci_medica.setAnotacion("objasdsa");



            Ci_medica ci_medica2 = new Ci_medica();
            ci_medica2.setId_paciente(29);
            ci_medica2.setId_ci_tipo(95);
            ci_medica2.setFecha(fechaIn);
            ci_medica2.setAnotacion("holaaa");




            idInsertado = ci_medicaDAO.insertar(ci_medica);
            idInsertado2 = ci_medicaDAO.insertar(ci_medica2);
            System.out.print(idInsertado);
            assertTrue(idInsertado > 0);
            ci_medicaDAO.cerrarConexion();
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
            ci_medicaDAO.abrirConexion();
            Ci_medica ci_medica = ci_medicaDAO.consultar(idInsertado);
            String nombre = ci_medica.getAnotacion();

            assertEquals("objasdsa", nombre);
            ci_medicaDAO.cerrarConexion();
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);

        }

    }


    @Test
    public void T04ProbarListar() {
        try {
            ci_medicaDAO.abrirConexion();
            List<Ci_medica> lista = ci_medicaDAO.listar();
            assertTrue(lista.size() > 0);
            ci_medicaDAO.cerrarConexion();
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);

        }
    }


    @Test
    public void T05ProbarActualizar() throws ParseException {




        try {
            ci_medicaDAO.abrirConexion();
            Ci_medica ci_medica = ci_medicaDAO.consultar(idInsertado);
            ci_medica.setAnotacion("actualizado");
            ci_medicaDAO.actualizar(ci_medica);
            Ci_medica ci_medicaactualizada = ci_medicaDAO.consultar(idInsertado);
            String formatted = ci_medicaactualizada.getAnotacion();
            assertEquals("actualizado", formatted);

            ci_medicaDAO.cerrarConexion();
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }


    }


    @Test
    public void T06ProbarEliminar() {

        try {
            ci_medicaDAO.abrirConexion();
            ci_medicaDAO.eliminar(idInsertado);
            Ci_medica ci_medica = ci_medicaDAO.consultar(idInsertado);
            assertNull(ci_medica);
            ci_medicaDAO.cerrarConexion();
        } catch (Exception e) {

            e.printStackTrace();
            assertTrue(false);

        }
    }
}
