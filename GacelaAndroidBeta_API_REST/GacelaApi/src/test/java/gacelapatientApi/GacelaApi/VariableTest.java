package gacelapatientApi.GacelaApi;


import gacelapatientApi.GacelaApi.dao.variable.VariableDAO;
import gacelapatientApi.GacelaApi.dao.variable.VariableDAOORM;
import gacelapatientApi.GacelaApi.model.Variable;
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
public class VariableTest {

    VariableDAO variableDAO = new VariableDAOORM();
    private static int idInsertado;
    private static int idInsertado2;







    @Test
    public void T02ProbarInsertar() {

        try {
            String fecha = "20/06/2028";
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date parseDate = dateFormat.parse(fecha);
            Timestamp fechaIn = new Timestamp(parseDate.getTime());

            byte[] buffer = "some data".getBytes(StandardCharsets.UTF_8);
            variableDAO.abrirConexion();
            Variable variable = new Variable();
            variable.setNombre("variable1");
            variable.setNumerico(12);
            variable.setDescripcion("primera variable del sistema");

            Variable variable2 = new Variable();
            variable2.setNombre("variable2");
            variable2.setNumerico(10);
            variable2.setDescripcion("segunda variable del sistema");

            idInsertado = variableDAO.insertar(variable);
            idInsertado2 = variableDAO.insertar(variable2);
            System.out.print(idInsertado);
            assertTrue(idInsertado > 0);
            variableDAO.cerrarConexion();
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
            variableDAO.abrirConexion();
            Variable variable = variableDAO.consultar(idInsertado);
            String nombre = variable.getNombre();

            assertEquals("variable1", nombre);
            variableDAO.cerrarConexion();
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);

        }

    }


    @Test
    public void T04ProbarListar() {
        try {
            variableDAO.abrirConexion();
            List<Variable> lista = variableDAO.listar();
            assertTrue(lista.size() > 0);
            variableDAO.cerrarConexion();
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);

        }
    }


    @Test
    public void T05ProbarActualizar() throws ParseException {



        try {
            variableDAO.abrirConexion();
            Variable variable = variableDAO.consultar(idInsertado);
            variable.setDescripcion("descripcion cambiada");
            variableDAO.actualizar(variable);
            Variable variableactualizada = variableDAO.consultar(idInsertado);
            String formatted = variableactualizada.getDescripcion();
            assertEquals("descripcion cambiada", formatted);

            variableDAO.cerrarConexion();
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }


    }


    @Test
    public void T06ProbarEliminar() {

        try {
            variableDAO.abrirConexion();
            variableDAO.eliminar(idInsertado);
            Variable variable = variableDAO.consultar(idInsertado);
            assertNull(variable);
            variableDAO.cerrarConexion();
        } catch (Exception e) {

            e.printStackTrace();
            assertTrue(false);

        }
    }
    /*@Test
    public void T07ProbarEliminarcascade() {

        try {
            variableDAO.abrirConexion();
            variableDAO.eliminar(43);

            variableDAO.cerrarConexion();
        } catch (Exception e) {

            e.printStackTrace();
            assertTrue(false);

        }
    }*/
}
