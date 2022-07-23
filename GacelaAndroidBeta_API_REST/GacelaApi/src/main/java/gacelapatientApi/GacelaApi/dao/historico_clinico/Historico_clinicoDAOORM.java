package gacelapatientApi.GacelaApi.dao.historico_clinico;

import gacelapatientApi.GacelaApi.BaseDAOORM;
import gacelapatientApi.GacelaApi.dao.calorias_diarias_corporal.Calorias_diarias_corporalDAO;
import gacelapatientApi.GacelaApi.model.Historico_clinico;

import java.sql.Timestamp;
import java.util.List;

public class Historico_clinicoDAOORM extends BaseDAOORM implements Historico_clinicoDAO {
    @Override
    public int insertar(Historico_clinico objeto) throws Exception {
        conexion.save(objeto);
        return objeto.getHisto_clinicos_ID();
    }

    @Override
    public Historico_clinico consultar(int id) {
        Historico_clinico historico_clinico = conexion.get(Historico_clinico.class, id);
        return historico_clinico;
    }

    @Override
    public List<Historico_clinico> listar() {
        List<Historico_clinico> lista = conexion.createQuery("from Historico_clinico", Historico_clinico.class).getResultList();
        return lista;
    }

    @Override
    public void actualizar(Historico_clinico objeto) {
        Historico_clinico historico_clinicoentidadbd = conexion.load(Historico_clinico.class, objeto.getHisto_clinicos_ID());
        historico_clinicoentidadbd.setId_paciente(objeto.getId_paciente());
        historico_clinicoentidadbd.setId_variable(objeto.getId_variable());
        historico_clinicoentidadbd.setFecha_registro(objeto.getFecha_registro());
        historico_clinicoentidadbd.setValor_int(objeto.getValor_int());
        historico_clinicoentidadbd.setValor_varchar(objeto.getValor_varchar());
        conexion.update(historico_clinicoentidadbd);
    }

    @Override
    public void eliminar(int id) {
        Historico_clinico historico_clinico = conexion.load(Historico_clinico.class, id);
        conexion.delete(historico_clinico);
    }
}
