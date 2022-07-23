package gacelapatientApi.GacelaApi;


import gacelapatientApi.GacelaApi.dao.historico_clinico.Historico_clinicoDAO;
import gacelapatientApi.GacelaApi.dao.historico_clinico.Historico_clinicoDAOORM;
import gacelapatientApi.GacelaApi.model.Historico_clinico;
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
public class Historico_clinicoTest {
    Historico_clinicoDAO historico_clinicoDAO = new Historico_clinicoDAOORM();
    private static int idInsertado;
    private static int idInsertado2;

    @Test
    public void T02ProbarInsertar() {

        try {
            String fecha = "20/06/2028";
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date parseDate = dateFormat.parse(fecha);
            Timestamp fechaIn = new Timestamp(parseDate.getTime());

            historico_clinicoDAO.abrirConexion();
            Historico_clinico historico_clinico = new Historico_clinico();
            historico_clinico.setId_paciente(29);
            historico_clinico.setId_variable(45);
            historico_clinico.setFecha_registro(fechaIn);
            historico_clinico.setValor_int(0);
            historico_clinico.setValor_varchar("true");


            Historico_clinico historico_clinico2 = new Historico_clinico();
            historico_clinico2.setId_paciente(29);
            historico_clinico2.setId_variable(45);
            historico_clinico2.setFecha_registro(fechaIn);
            historico_clinico2.setValor_int(0);
            historico_clinico2.setValor_varchar("true");



            idInsertado = historico_clinicoDAO.insertar(historico_clinico);
            idInsertado2 = historico_clinicoDAO.insertar(historico_clinico2);
            System.out.print(idInsertado);
            assertTrue(idInsertado > 0);
            historico_clinicoDAO.cerrarConexion();
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
            historico_clinicoDAO.abrirConexion();
            Historico_clinico historico_clinico = historico_clinicoDAO.consultar(idInsertado);
            String nombre = historico_clinico.getValor_varchar();

            assertEquals("true", nombre);
            historico_clinicoDAO.cerrarConexion();
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);

        }

    }


    @Test
    public void T04ProbarListar() {
        try {
            historico_clinicoDAO.abrirConexion();
            List<Historico_clinico> lista = historico_clinicoDAO.listar();
            assertTrue(lista.size() > 0);
            historico_clinicoDAO.cerrarConexion();
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);

        }
    }


    @Test
    public void T05ProbarActualizar() throws ParseException {



        try {
            historico_clinicoDAO.abrirConexion();
            Historico_clinico historico_clinico = historico_clinicoDAO.consultar(idInsertado);
            historico_clinico.setValor_varchar("false");
            historico_clinicoDAO.actualizar(historico_clinico);
            Historico_clinico historico_clinicoactualizado = historico_clinicoDAO.consultar(idInsertado);
            String formatted = historico_clinicoactualizado.getValor_varchar();
            assertEquals("false", formatted);

            historico_clinicoDAO.cerrarConexion();
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }


    }


    @Test
    public void T06ProbarEliminar() {

        try {
            historico_clinicoDAO.abrirConexion();
            historico_clinicoDAO.eliminar(idInsertado);
            Historico_clinico historico_clinico = historico_clinicoDAO.consultar(idInsertado);
            assertNull(historico_clinico);
            historico_clinicoDAO.cerrarConexion();
        } catch (Exception e) {

            e.printStackTrace();
            assertTrue(false);

        }
    }
}
