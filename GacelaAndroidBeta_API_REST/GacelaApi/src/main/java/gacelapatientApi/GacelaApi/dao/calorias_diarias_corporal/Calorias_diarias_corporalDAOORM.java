package gacelapatientApi.GacelaApi.dao.calorias_diarias_corporal;

import gacelapatientApi.GacelaApi.BaseDAOORM;
import gacelapatientApi.GacelaApi.dao.ci_tipo.Ci_tipoDAO;
import gacelapatientApi.GacelaApi.model.Calorias_diarias_corporal;
import org.hibernate.Session;

import java.util.List;

public class Calorias_diarias_corporalDAOORM extends BaseDAOORM implements Calorias_diarias_corporalDAO {

    @Override
    public int insertar(Calorias_diarias_corporal objeto) throws Exception {
        conexion.save(objeto);
        return objeto.getCalorias_diarias_corporales_ID();
    }

    @Override
    public Calorias_diarias_corporal consultar(int id) {
        Calorias_diarias_corporal calorias_diarias_corporal = conexion.get(Calorias_diarias_corporal.class, id);
        return calorias_diarias_corporal;
    }

    @Override
    public List<Calorias_diarias_corporal> listar() {
        List<Calorias_diarias_corporal> lista = conexion.createQuery("from Calorias_diarias_corporal", Calorias_diarias_corporal.class).getResultList();
        return lista;
    }

    @Override
    public void actualizar(Calorias_diarias_corporal objeto) {
        Calorias_diarias_corporal calorias_diarias_corporalbd = conexion.load(Calorias_diarias_corporal.class, objeto.getCalorias_diarias_corporales_ID());
        calorias_diarias_corporalbd.setCalorias_diarias_corporales_ID(objeto.getCalorias_diarias_corporales_ID());
        calorias_diarias_corporalbd.setId_registro_var_fisica(objeto.getId_registro_var_fisica());
        calorias_diarias_corporalbd.setFecha(objeto.getFecha());
        calorias_diarias_corporalbd.setCalorias_diarias_totales(objeto.getCalorias_diarias_totales());
        conexion.update(calorias_diarias_corporalbd);
    }

    @Override
    public void eliminar(int id) {
        Calorias_diarias_corporal calorias_diarias_corporal = conexion.load(Calorias_diarias_corporal.class, id);
        conexion.delete(calorias_diarias_corporal);
    }
}
