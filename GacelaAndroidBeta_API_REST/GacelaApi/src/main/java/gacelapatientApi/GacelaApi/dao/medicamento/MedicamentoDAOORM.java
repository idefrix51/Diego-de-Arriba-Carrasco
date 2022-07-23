package gacelapatientApi.GacelaApi.dao.medicamento;

import gacelapatientApi.GacelaApi.BaseDAOORM;
import gacelapatientApi.GacelaApi.dao.calorias_diarias_corporal.Calorias_diarias_corporalDAO;
import gacelapatientApi.GacelaApi.model.Medicamento;

import java.util.List;

public class MedicamentoDAOORM extends BaseDAOORM implements MedicamentoDAO {
    @Override
    public int insertar(Medicamento objeto) throws Exception {
        conexion.save(objeto);
        return objeto.getMedicamento_ID();
    }

    @Override
    public Medicamento consultar(int id) {
        Medicamento medicamento = conexion.get(Medicamento.class, id);
        return medicamento;
    }

    @Override
    public List<Medicamento> listar() {
        List<Medicamento> lista = conexion.createQuery("from Medicamento", Medicamento.class).getResultList();
        return lista;
    }

    @Override
    public void actualizar(Medicamento objeto) {
        Medicamento medicamentobd = conexion.load(Medicamento.class, objeto.getMedicamento_ID());
        medicamentobd.setNombre(objeto.getNombre());
        medicamentobd.setDescripcion(objeto.getDescripcion());
        conexion.update(medicamentobd);
    }

    @Override
    public void eliminar(int id) {
        Medicamento medicamento = conexion.load(Medicamento.class, id);
        conexion.delete(medicamento);
    }
}
