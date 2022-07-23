package gacelapatientApi.GacelaApi;


import gacelapatientApi.GacelaApi.dao.ci_tipo.Ci_tipoDAO;
import gacelapatientApi.GacelaApi.dao.ci_tipo.Ci_tipoDAOORM;
import gacelapatientApi.GacelaApi.model.Ci_tipo;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.text.ParseException;
import java.util.List;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Ci_tiposTest {
    Ci_tipoDAO ci_tipoDAO = new Ci_tipoDAOORM();
    private static int idInsertado;
    private static int idInsertado2;

    @Test
    public void T02ProbarInsertar() {

        try {

            ci_tipoDAO.abrirConexion();
            Ci_tipo ci_tipo = new Ci_tipo();
            ci_tipo.setCi_tipo_ID(0);
            ci_tipo.setNombre("primerTipo");
            ci_tipo.setDescripcion("tipo numero uno");


            Ci_tipo ci_tipo2 = new Ci_tipo();
            ci_tipo2.setCi_tipo_ID(1);
            ci_tipo2.setNombre("segundo");
            ci_tipo2.setDescripcion("tipo numero dos");



            idInsertado = ci_tipoDAO.insertar(ci_tipo);
            idInsertado2 = ci_tipoDAO.insertar(ci_tipo2);
            System.out.print(idInsertado);
            assertTrue(idInsertado > 0);
            ci_tipoDAO.cerrarConexion();
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
            ci_tipoDAO.abrirConexion();
            Ci_tipo ci_tipo = ci_tipoDAO.consultar(idInsertado);
            String nombre = ci_tipo.getNombre();

            assertEquals("primerTipo", nombre);
            ci_tipoDAO.cerrarConexion();
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);

        }

    }


    @Test
    public void T04ProbarListar() {
        try {
            ci_tipoDAO.abrirConexion();
            List<Ci_tipo> lista = ci_tipoDAO.listar();
            assertTrue(lista.size() > 0);
            ci_tipoDAO.cerrarConexion();
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);

        }
    }


    @Test
    public void T05ProbarActualizar() throws ParseException {



        try {
            ci_tipoDAO.abrirConexion();
            Ci_tipo ci_tipo = ci_tipoDAO.consultar(idInsertado);
            ci_tipo.setDescripcion("descripcion actualizada");
            ci_tipoDAO.actualizar(ci_tipo);
            Ci_tipo ci_tipoactualizado = ci_tipoDAO.consultar(idInsertado);
            String formatted = ci_tipoactualizado.getDescripcion();
            assertEquals("descripcion actualizada", formatted);

            ci_tipoDAO.cerrarConexion();
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }


    }


    @Test
    public void T06ProbarEliminar() {

        try {
            ci_tipoDAO.abrirConexion();
            ci_tipoDAO.eliminar(idInsertado);
            Ci_tipo ci_tipo = ci_tipoDAO.consultar(idInsertado);
            assertNull(ci_tipo);
            ci_tipoDAO.cerrarConexion();
        } catch (Exception e) {

            e.printStackTrace();
            assertTrue(false);

        }
    }/*
    @Test
    public void T07ProbarEliminar() {

        try {
            ci_tipoDAO.abrirConexion();
            ci_tipoDAO.eliminar(99);
            ci_tipoDAO.cerrarConexion();
        } catch (Exception e) {

            e.printStackTrace();
            assertTrue(false);

        }
    }*/


}
