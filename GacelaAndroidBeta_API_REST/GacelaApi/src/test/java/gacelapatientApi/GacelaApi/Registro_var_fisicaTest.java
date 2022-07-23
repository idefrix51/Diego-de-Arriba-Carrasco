package gacelapatientApi.GacelaApi;


import gacelapatientApi.GacelaApi.dao.registro_var_fisica.Registro_var_fisicaDAO;
import gacelapatientApi.GacelaApi.dao.registro_var_fisica.Registro_var_fisicaDAOORM;
import gacelapatientApi.GacelaApi.model.Registro_var_fisica;
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
public class Registro_var_fisicaTest {
    Registro_var_fisicaDAO registro_var_fisicaDAO = new Registro_var_fisicaDAOORM();
    private static int idInsertado;
    private static int idInsertado2;







    @Test
    public void T02ProbarInsertar() {

        try {
            String fecha = "20/06/2028";
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date parseDate = dateFormat.parse(fecha);
            Timestamp fechaIn = new Timestamp(parseDate.getTime());


            registro_var_fisicaDAO.abrirConexion();
            Registro_var_fisica registro_var_fisica = new Registro_var_fisica();
            registro_var_fisica.setId_paciente(162);
            registro_var_fisica.setFecha(fechaIn);
            registro_var_fisica.setPeso(60);
            registro_var_fisica.setC_diarias(1500);
            registro_var_fisica.setAltura(175);
            registro_var_fisica.setPeso_ideal(75);

            Registro_var_fisica registro_var_fisica2 = new Registro_var_fisica();
            registro_var_fisica2.setId_paciente(162);
            registro_var_fisica2.setFecha(fechaIn);
            registro_var_fisica2.setPeso(60);
            registro_var_fisica2.setC_diarias(1500);
            registro_var_fisica2.setAltura(175);
            registro_var_fisica2.setPeso_ideal(75);


            idInsertado = registro_var_fisicaDAO.insertar(registro_var_fisica);
            idInsertado2 = registro_var_fisicaDAO.insertar(registro_var_fisica2);
            System.out.print(idInsertado);
            assertTrue(idInsertado > 0);
            registro_var_fisicaDAO.cerrarConexion();
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
            registro_var_fisicaDAO.abrirConexion();
            Registro_var_fisica registro_var_fisica = registro_var_fisicaDAO.consultar(idInsertado);
            int altura = registro_var_fisica.getAltura();

            assertEquals(175, altura);
            registro_var_fisicaDAO.cerrarConexion();
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);

        }

    }


    @Test
    public void T04ProbarListar() {
        try {
            registro_var_fisicaDAO.abrirConexion();
            List<Registro_var_fisica> lista = registro_var_fisicaDAO.listar();
            assertTrue(lista.size() > 0);
            registro_var_fisicaDAO.cerrarConexion();
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);

        }
    }


    @Test
    public void T05ProbarActualizar() throws ParseException {




        try {
            registro_var_fisicaDAO.abrirConexion();
            Registro_var_fisica registro_var_fisica = registro_var_fisicaDAO.consultar(idInsertado);
            registro_var_fisica.setPeso(75);
            registro_var_fisicaDAO.actualizar(registro_var_fisica);
            Registro_var_fisica registro_var_fisicaActualizado = registro_var_fisicaDAO.consultar(idInsertado);
            int formatted = registro_var_fisicaActualizado.getPeso();
            assertEquals(75, formatted);

            registro_var_fisicaDAO.cerrarConexion();
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }


    }


    @Test
    public void T06ProbarEliminar() {

        try {
            registro_var_fisicaDAO.abrirConexion();
            registro_var_fisicaDAO.eliminar(idInsertado);
            Registro_var_fisica registro_var_fisica = registro_var_fisicaDAO.consultar(idInsertado);
            assertNull(registro_var_fisica);
            registro_var_fisicaDAO.cerrarConexion();
        } catch (Exception e) {

            e.printStackTrace();
            assertTrue(false);

        }
    }

    /*@Test
    public void T07ProbarEliminarcascade() {

        try {
            registro_var_fisicaDAO.abrirConexion();
            registro_var_fisicaDAO.eliminar(149);

            registro_var_fisicaDAO.cerrarConexion();
        } catch (Exception e) {

            e.printStackTrace();
            assertTrue(false);

        }
    }
*/
}
