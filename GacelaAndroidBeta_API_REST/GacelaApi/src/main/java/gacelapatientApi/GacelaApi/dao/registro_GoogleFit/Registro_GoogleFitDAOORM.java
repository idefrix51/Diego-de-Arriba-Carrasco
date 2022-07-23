package gacelapatientApi.GacelaApi.dao.registro_GoogleFit;

import gacelapatientApi.GacelaApi.BaseDAOORM;
import gacelapatientApi.GacelaApi.dao.calorias_diarias_corporal.Calorias_diarias_corporalDAO;
import gacelapatientApi.GacelaApi.model.Registro_GoogleFit;

import java.sql.Timestamp;
import java.util.List;

public class Registro_GoogleFitDAOORM extends BaseDAOORM implements Registro_GoogleFitDAO {
    @Override
    public int insertar(Registro_GoogleFit objeto) throws Exception {
        conexion.save(objeto);
        return objeto.getRegistro_google_fit_ID();
    }

    @Override
    public Registro_GoogleFit consultar(int id) {
        Registro_GoogleFit registro_GoogleFit = conexion.get(Registro_GoogleFit.class, id);
        return registro_GoogleFit;
    }

    @Override
    public List<Registro_GoogleFit> listar() {
        List<Registro_GoogleFit> lista = conexion.createQuery("from Registro_GoogleFit", Registro_GoogleFit.class).getResultList();
        return lista;
    }

    @Override
    public void actualizar(Registro_GoogleFit objeto) {
        Registro_GoogleFit registro_GoogleFitbd = conexion.load(Registro_GoogleFit.class, objeto.getRegistro_google_fit_ID());
        registro_GoogleFitbd.setId_registro_var_fisica(objeto.getId_registro_var_fisica());
        registro_GoogleFitbd.setId_calorias_diarias_corporales(objeto.getId_calorias_diarias_corporales());
        registro_GoogleFitbd.setCalorias_consumidas(objeto.getCalorias_consumidas());
        registro_GoogleFitbd.setDistancia_recorrida(objeto.getDistancia_recorrida());
        registro_GoogleFitbd.setPasos(objeto.getPasos());
        registro_GoogleFitbd.setFecha(objeto.getFecha());
        conexion.update(registro_GoogleFitbd);
    }

    @Override
    public void eliminar(int id) {
        Registro_GoogleFit registro_GoogleFit = conexion.load(Registro_GoogleFit.class, id);
        conexion.delete(registro_GoogleFit);
    }
}
