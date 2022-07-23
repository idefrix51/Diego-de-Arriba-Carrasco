package gacelapatientApi.GacelaApi.dao.historico_dosis;

import gacelapatientApi.GacelaApi.BaseDAOORM;
import gacelapatientApi.GacelaApi.dao.calorias_diarias_corporal.Calorias_diarias_corporalDAO;
import gacelapatientApi.GacelaApi.model.Historico_dosis;

import java.sql.Timestamp;
import java.util.List;

public class Historico_dosisDAOORM extends BaseDAOORM implements Historico_dosisDAO {
    @Override
    public int insertar(Historico_dosis objeto) throws Exception {
        conexion.save(objeto);
        return objeto.getHistorico_dosis_ID();
    }

    @Override
    public Historico_dosis consultar(int id) {
        Historico_dosis historico_dosis = conexion.get(Historico_dosis.class, id);
        return historico_dosis;
    }

    @Override
    public List<Historico_dosis> listar() {
        List<Historico_dosis> lista = conexion.createQuery("from Historico_dosis", Historico_dosis.class).getResultList();
        return lista;
    }

    @Override
    public void actualizar(Historico_dosis objeto) {
        Historico_dosis historico_dosisbd = conexion.load(Historico_dosis.class, objeto.getHistorico_dosis_ID());
        historico_dosisbd.setId_medipaciente(objeto.getId_medipaciente());
        historico_dosisbd.setDosis(objeto.isDosis());
        historico_dosisbd.setFecha(objeto.getFecha());
        conexion.update(historico_dosisbd);

    }

    @Override
    public void eliminar(int id) {
        Historico_dosis historico_dosis = conexion.load(Historico_dosis.class, id);
        conexion.delete(historico_dosis);
    }
}
