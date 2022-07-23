package gacelapatientApi.GacelaApi;

import gacelapatientApi.GacelaApi.dao.historico_dosis.Historico_dosisDAO;
import gacelapatientApi.GacelaApi.dao.historico_dosis.Historico_dosisDAOORM;
import gacelapatientApi.GacelaApi.model.Historico_dosis;
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
public class Historico_dosisTEST {
    Historico_dosisDAO historico_dosisDAO = new Historico_dosisDAOORM();
    private static int idInsertado;
    private static int idInsertado2;







    @Test
    public void T02ProbarInsertar() {

        try {

            String fecha = "20/06/2028";
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date parseDate = dateFormat.parse(fecha);
            Timestamp fechaIn = new Timestamp(parseDate.getTime());

            historico_dosisDAO.abrirConexion();
            Historico_dosis historico_dosis = new Historico_dosis();
            historico_dosis.setHistorico_dosis_ID(0);
            historico_dosis.setId_medipaciente(160);
            historico_dosis.setDosis(false);
            historico_dosis.setFecha(fechaIn);


            Historico_dosis historico_dosis2 = new Historico_dosis();
            historico_dosis2.setHistorico_dosis_ID(0);
            historico_dosis2.setId_medipaciente(160);
            historico_dosis2.setDosis(true);
            historico_dosis2.setFecha(fechaIn);


            idInsertado = historico_dosisDAO.insertar(historico_dosis);
            idInsertado2 = historico_dosisDAO.insertar(historico_dosis2);
            System.out.print(idInsertado);
            assertTrue(idInsertado > 0);
            historico_dosisDAO.cerrarConexion();
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
            historico_dosisDAO.abrirConexion();
            Historico_dosis historico_dosis = historico_dosisDAO.consultar(idInsertado);
            boolean dosis = historico_dosis.isDosis();

            assertEquals(false, dosis);
            historico_dosisDAO.cerrarConexion();
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);

        }

    }


    @Test
    public void T04ProbarListar() {
        try {
            historico_dosisDAO.abrirConexion();
            List<Historico_dosis> lista = historico_dosisDAO.listar();
            assertTrue(lista.size() > 0);
            historico_dosisDAO.cerrarConexion();
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);

        }
    }


    @Test
    public void T05ProbarActualizar() throws ParseException {




        try {
            historico_dosisDAO.abrirConexion();
            Historico_dosis historico_dosis = historico_dosisDAO.consultar(idInsertado);
            historico_dosis.setDosis(true);
            historico_dosisDAO.actualizar(historico_dosis);
            Historico_dosis historico_dosisActualizado = historico_dosisDAO.consultar(idInsertado);
            boolean formatted = historico_dosisActualizado.isDosis();
            assertEquals(true, formatted);

            historico_dosisDAO.cerrarConexion();
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }


    }


    @Test
    public void T06ProbarEliminar() {

        try {
            historico_dosisDAO.abrirConexion();
            historico_dosisDAO.eliminar(idInsertado);
            Historico_dosis historico_dosis = historico_dosisDAO.consultar(idInsertado);
            assertNull(historico_dosis);
            historico_dosisDAO.cerrarConexion();
        } catch (Exception e) {

            e.printStackTrace();
            assertTrue(false);

        }
    }
}
