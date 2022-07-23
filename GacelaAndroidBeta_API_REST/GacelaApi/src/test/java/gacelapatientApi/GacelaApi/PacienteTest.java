package gacelapatientApi.GacelaApi;

import gacelapatientApi.GacelaApi.dao.paciente.PacienteDAO;
import gacelapatientApi.GacelaApi.dao.paciente.PacienteDAOORM;
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


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PacienteTest
{

    PacienteDAO pacienteDAO = new PacienteDAOORM();
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
            pacienteDAO.abrirConexion();
            Paciente paciente = new Paciente();
            paciente.setId(0);
            paciente.setNombre("try");
            paciente.setApellidos("de arriba carrasco");
            paciente.setFechaNacimento(fechaIn);
            paciente.setGenero("hombre");
            paciente.setCipAutonomico("12312431");
            paciente.setCipNacional("1321412");
            paciente.setNif("45147434L");
            paciente.setDomicilio("dgadgadgda");
            paciente.setMobilePhone("32423423");
            paciente.setEmail("roer7@gmail.com");
            paciente.setTutorLegal(null);
            paciente.setFoto(buffer);
            paciente.setPassword("121212");

            Paciente paciente2 = new Paciente();
            paciente2.setId(1);
            paciente2.setNombre("test22");
            paciente2.setApellidos("afadsfa");
            paciente2.setFechaNacimento(fechaIn);
            paciente2.setGenero("mujer");
            paciente2.setCipAutonomico("12312431");
            paciente2.setCipNacional("1321412");
            paciente2.setNif("45441383L");
            paciente2.setDomicilio("dgadgadgda");
            paciente2.setMobilePhone("32423423");
            paciente2.setEmail("rere4@gmail.com");
            paciente2.setTutorLegal(null);
            paciente2.setFoto(buffer);
            paciente2.setPassword("121212");


            idInsertado = pacienteDAO.insertar(paciente);
            idInsertado2 = pacienteDAO.insertar(paciente2);
            System.out.print(idInsertado);
            assertTrue(idInsertado > 0);
            pacienteDAO.cerrarConexion();
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
            pacienteDAO.abrirConexion();
            Paciente paciente = pacienteDAO.consultar(idInsertado);
            String nombre = paciente.getNombre();

            assertEquals("try", nombre);
            pacienteDAO.cerrarConexion();
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);

        }

    }


    @Test
    public void T04ProbarListar() {
        try {
            pacienteDAO.abrirConexion();
            List<Paciente> lista = pacienteDAO.listar();
            assertTrue(lista.size() > 0);
            pacienteDAO.cerrarConexion();
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);

        }
    }


    @Test
    public void T05ProbarActualizar() throws ParseException {

        String fecha = "20/06/2029";
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date parseDate = dateFormat.parse(fecha);
        Timestamp fechaIn = new Timestamp(parseDate.getTime());


        try {
            pacienteDAO.abrirConexion();
            Paciente paciente = pacienteDAO.consultar(idInsertado);
            paciente.setFechaNacimento(fechaIn);
            pacienteDAO.actualizar(paciente);
            Paciente pacienteActualizado = pacienteDAO.consultar(idInsertado);
            String formatted = dateFormat.format(pacienteActualizado.getFechaNacimento());
            assertEquals("20/06/2029", formatted);

            pacienteDAO.cerrarConexion();
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
    }
    @Test
    public void T06ProbarEliminar() {

        try {
            pacienteDAO.abrirConexion();
            pacienteDAO.eliminar(idInsertado);
            Paciente paciente = pacienteDAO.consultar(idInsertado);
            assertNull(paciente);
            pacienteDAO.cerrarConexion();
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
    }/*
    @Test
    public void T07Trydeleteacascade(){
        try {
        pacienteDAO.abrirConexion();
        pacienteDAO.eliminar(83);
        pacienteDAO.cerrarConexion();
        } catch (Exception e) {

            e.printStackTrace();
            assertTrue(false);

        }
    }

*/
    @Test
    public void T08ProbarConsultaremail() {

        try {
            pacienteDAO.abrirConexion();
            Paciente paciente = pacienteDAO.consultarEmailpasword("roer@gmail.com", "121212");
            String nombre = paciente.getNombre();

            assertEquals("try", nombre);
            pacienteDAO.cerrarConexion();
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);

        }

    }

    @Test
    public void T09ProbarConsultarnif() {

        try {
            pacienteDAO.abrirConexion();
            Paciente paciente = pacienteDAO.consultarNIFpasword("45143434L", "121212");
            String nombre = paciente.getNombre();

            assertEquals("try", nombre);
            pacienteDAO.cerrarConexion();
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);

        }

    }

}
