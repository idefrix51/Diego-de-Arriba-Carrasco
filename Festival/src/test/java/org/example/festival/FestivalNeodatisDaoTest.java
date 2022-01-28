package org.example.festival;

import org.example.connection.ConexionNeodatis;

import org.example.dao.FestivalDao;
import org.example.dao.FestivalNeodatisDao;
import org.example.model.Festival;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FestivalNeodatisDaoTest {
    private static int idInsertado;
    private static List idListados;

    FestivalNeodatisDao fesDao= new FestivalNeodatisDao();
    Festival fes = new Festival();

    @Test
    public void t01Tryinsert()
    {
        try{
            String fechaIni = "10/03/2022 10:00";
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm");
            Date parsedDate = dateFormat.parse(fechaIni);
            Timestamp fecInsertar = new Timestamp(parsedDate.getTime());

            String fechaFin = "10/04/2022 10:00";
            Date parsedDate2 = dateFormat.parse(fechaFin);
            Timestamp fecInsertar2 = new Timestamp(parsedDate2.getTime());



            fes.setId(7);
            fes.setNombre("Reunion Aulanosa");
            fes.setDescripcion("una reunion entre compañeros de clase y profesores");
            fes.setInicio(fecInsertar);
            fes.setFin(fecInsertar2);
            fes.setAforo(32);
            fes.setPrecio(200);
            fes.setVentas(35);

            idInsertado = fesDao.insertar(fes);
            fesDao.actualizar(fes);

            assertTrue(idInsertado>0);


        }catch (Exception e){
            e.printStackTrace();
        }

    }
    /*
    * private int Id;
        private String Nombre;
        private String Descripcion;
        private Timestamp Inicio;
        private Timestamp Fin;
        private int Aforo;
        private int Precio;
        private int Ventas;*/
    @Test
    public void t02Consultar(){
        Festival objeto = fesDao.consultar(idInsertado);
        assertEquals("Reunion Aulanosa", objeto.getNombre());
    }

    @Test
    public void t09cerrarConexionNeodatis()
    {

        ConexionNeodatis.cerrarConexion();
    }
}
