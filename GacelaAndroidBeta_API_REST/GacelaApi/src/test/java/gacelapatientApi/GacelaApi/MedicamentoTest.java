package gacelapatientApi.GacelaApi;


import gacelapatientApi.GacelaApi.dao.medicamento.MedicamentoDAO;
import gacelapatientApi.GacelaApi.dao.medicamento.MedicamentoDAOORM;
import gacelapatientApi.GacelaApi.model.Medicamento;
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
public class MedicamentoTest {

    MedicamentoDAO medicamentoDAO = new MedicamentoDAOORM();
    private static int idInsertado;
    private static int idInsertado2;







    @Test
    public void T02ProbarInsertar() {

        try {



            medicamentoDAO.abrirConexion();
            Medicamento medicamento = new Medicamento();
            medicamento.setMedicamento_ID(0);
            medicamento.setNombre("medicamento1");
            medicamento.setDescripcion("de arriba carrasco");


            Medicamento medicamento2 = new Medicamento();
            medicamento2.setMedicamento_ID(0);
            medicamento2.setNombre("medicamento2");
            medicamento2.setDescripcion("medicamento descripcion 2");


            idInsertado = medicamentoDAO.insertar(medicamento);
            idInsertado2 = medicamentoDAO.insertar(medicamento2);
            System.out.print(idInsertado);
            assertTrue(idInsertado > 0);
            medicamentoDAO.cerrarConexion();
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
            medicamentoDAO.abrirConexion();
            Medicamento medicamento = medicamentoDAO.consultar(idInsertado);
            String nombre = medicamento.getNombre();

            assertEquals("medicamento1", nombre);
            medicamentoDAO.cerrarConexion();
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);

        }

    }


    @Test
    public void T04ProbarListar() {
        try {
            medicamentoDAO.abrirConexion();
            List<Medicamento> lista = medicamentoDAO.listar();
            assertTrue(lista.size() > 0);
            medicamentoDAO.cerrarConexion();
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);

        }
    }


    @Test
    public void T05ProbarActualizar() throws ParseException {




        try {
            medicamentoDAO.abrirConexion();
            Medicamento medicamento = medicamentoDAO.consultar(idInsertado);
            medicamento.setDescripcion("descripcion modificada");
            medicamentoDAO.actualizar(medicamento);
            Medicamento medicamentoActualizado = medicamentoDAO.consultar(idInsertado);
            String formatted = medicamentoActualizado.getDescripcion();
            assertEquals("descripcion modificada", formatted);

            medicamentoDAO.cerrarConexion();
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }


    }


    @Test
    public void T06ProbarEliminar() {

        try {
            medicamentoDAO.abrirConexion();
            medicamentoDAO.eliminar(idInsertado);
            Medicamento medicamento = medicamentoDAO.consultar(idInsertado);
            assertNull(medicamento);
            medicamentoDAO.cerrarConexion();
        } catch (Exception e) {

            e.printStackTrace();
            assertTrue(false);

        }
    }
    /*
    @Test
    public void T07ProbarEliminarcascade() {

        try {
            medicamentoDAO.abrirConexion();
            medicamentoDAO.eliminar(52);

            medicamentoDAO.cerrarConexion();
        } catch (Exception e) {

            e.printStackTrace();
            assertTrue(false);

        }
    }*/

}
