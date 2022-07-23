package gacelapatientApi.GacelaApi.dao.ci_medica;

import gacelapatientApi.GacelaApi.BaseDAOORM;
import gacelapatientApi.GacelaApi.dao.calorias_diarias_corporal.Calorias_diarias_corporalDAO;
import gacelapatientApi.GacelaApi.model.Ci_medica;

import java.sql.Timestamp;
import java.util.List;

public class Ci_medicaDAOORM extends BaseDAOORM implements Ci_medicaDAO {
    @Override
    public int insertar(Ci_medica objeto) throws Exception {
        conexion.save(objeto);
        return objeto.getCi_medica_ID();
    }

    @Override
    public Ci_medica consultar(int id) {
        Ci_medica ci_medica = conexion.get(Ci_medica.class, id);
        return ci_medica;
    }

    @Override
    public List<Ci_medica> listar() {
        List<Ci_medica> lista = conexion.createQuery("from Ci_medica", Ci_medica.class).getResultList();
        return lista;
    }

    @Override
    public void actualizar(Ci_medica objeto) {
        Ci_medica ci_medicabd = conexion.load(Ci_medica.class, objeto.getCi_medica_ID());
        ci_medicabd.setId_paciente(objeto.getId_paciente());
        ci_medicabd.setId_ci_tipo(objeto.getId_ci_tipo());
        ci_medicabd.setFecha(objeto.getFecha());
        ci_medicabd.setAnotacion(objeto.getAnotacion());
        conexion.update(ci_medicabd);

    }

    @Override
    public void eliminar(int id) {
        Ci_medica ci_medica = conexion.load(Ci_medica.class, id);
        conexion.delete(ci_medica);
    }
}
