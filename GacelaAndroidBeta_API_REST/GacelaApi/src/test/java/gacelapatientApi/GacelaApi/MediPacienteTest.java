package gacelapatientApi.GacelaApi;


import gacelapatientApi.GacelaApi.dao.mediPaciente.MediPacienteDAO;
import gacelapatientApi.GacelaApi.dao.mediPaciente.MediPacienteDAOORM;
import gacelapatientApi.GacelaApi.model.MediPaciente;
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
public class MediPacienteTest {

    MediPacienteDAO mediPacienteDAO = new MediPacienteDAOORM();
    private static int idInsertado;
    private static int idInsertado2;







    @Test
    public void T02ProbarInsertar() {

        try {



            mediPacienteDAO.abrirConexion();
            MediPaciente mediPaciente = new MediPaciente();
            mediPaciente.setMedipaciente_ID(0);
            mediPaciente.setId_paciente(29);
            mediPaciente.setId_medicamento(121);
            mediPaciente.setCantidad(12);


            MediPaciente mediPaciente2 = new MediPaciente();
            mediPaciente2.setMedipaciente_ID(0);
            mediPaciente2.setId_paciente(29);
            mediPaciente2.setId_medicamento(121);
            mediPaciente2.setCantidad(10);


            idInsertado = mediPacienteDAO.insertar(mediPaciente);
            idInsertado2 = mediPacienteDAO.insertar(mediPaciente2);
            System.out.print(idInsertado);
            assertTrue(idInsertado > 0);
            mediPacienteDAO.cerrarConexion();
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
            mediPacienteDAO.abrirConexion();
            MediPaciente mediPaciente = mediPacienteDAO.consultar(idInsertado);
            int cantidad = mediPaciente.getCantidad();

            assertEquals(12, cantidad);
            mediPacienteDAO.cerrarConexion();
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);

        }

    }


    @Test
    public void T04ProbarListar() {
        try {
            mediPacienteDAO.abrirConexion();
            List<MediPaciente> lista = mediPacienteDAO.listar();
            assertTrue(lista.size() > 0);
            mediPacienteDAO.cerrarConexion();
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);

        }
    }


    @Test
    public void T05ProbarActualizar() throws ParseException {




        try {
            mediPacienteDAO.abrirConexion();
            MediPaciente mediPaciente = mediPacienteDAO.consultar(idInsertado);
            mediPaciente.setCantidad(1);
            mediPacienteDAO.actualizar(mediPaciente);
            MediPaciente mediPacienteActualizado = mediPacienteDAO.consultar(idInsertado);
            int formatted = mediPacienteActualizado.getCantidad();
            assertEquals(1, formatted);

            mediPacienteDAO.cerrarConexion();
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }


    }


    @Test
    public void T06ProbarEliminar() {

        try {
            mediPacienteDAO.abrirConexion();
            mediPacienteDAO.eliminar(idInsertado);
            MediPaciente mediPaciente = mediPacienteDAO.consultar(idInsertado);
            assertNull(mediPaciente);
            mediPacienteDAO.cerrarConexion();
        } catch (Exception e) {

            e.printStackTrace();
            assertTrue(false);

        }
    }
    /*
    @Test
    public void T07ProbarEliminarcascade() {

        try {
            mediPacienteDAO.abrirConexion();
            mediPacienteDAO.eliminar(131);
            mediPacienteDAO.cerrarConexion();
        } catch (Exception e) {

            e.printStackTrace();
            assertTrue(false);

        }
    }*/

}
