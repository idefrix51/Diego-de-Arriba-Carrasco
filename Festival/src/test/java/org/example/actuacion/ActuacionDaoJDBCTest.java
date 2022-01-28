package org.example.actuacion;

import static org.junit.Assert.*;

import org.example.connection.ConexionFestivalDDBB;
import org.example.connection.ConexionNeodatis;
import org.example.model.Actuacion;
import org.example.dao.ActuacionDao;
import org.example.dao.ActuacionDaoSQLServer;
import org.junit.Test;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class ActuacionDaoJDBCTest
{
    /**
     * Rigorous Test :-)
     */
private static int idInsertado;
private static List idListados;
    @Test
    public void shouldAnswerWithTrue()
    {
        ConexionFestivalDDBB.obtenerConexion();
        ConexionFestivalDDBB.cerrarConexion();
    }
    @Test
    public void Tryinsert()
    {
        try{
            String fechaIni = "10/03/2022 10:00";
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm");
            Date parsedDate = dateFormat.parse(fechaIni);
            Timestamp fecInsertar = new Timestamp(parsedDate.getTime());

            String fechaFin = "10/03/2022 10:00";
            Date parsedDate2 = dateFormat.parse(fechaFin);
            Timestamp fecInsertar2 = new Timestamp(parsedDate2.getTime());

            ActuacionDao actDao= new ActuacionDaoSQLServer();
            Actuacion act = new Actuacion();

            act.setId(idInsertado);
            act.setIdFestival(1);
            act.setNombre("Reunion Aulanosa");
            act.setDescripcion("una reunion entre compañeros de clase y profesores");
            act.setInicio(fecInsertar);
            act.setFin(fecInsertar2);
            act.setGrupo("dessarrolloDAM");
            act.setEscenario("aulanosa");

            idInsertado = actDao.insertar(act);
            actDao.actualizar(act);

            assertTrue(idInsertado>0);


        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Test
    public void TryDelete(){
        ActuacionDao actDao= new ActuacionDaoSQLServer();
        actDao.eliminar(idInsertado);
        Actuacion act = actDao.consultar(idInsertado);
        assertNull(act);
    }
    @Test
    public void Trylistar(){
        ActuacionDao actDao= new ActuacionDaoSQLServer();

        idListados = actDao.listar();
        assertTrue(idListados.size()>0);


    }


}
