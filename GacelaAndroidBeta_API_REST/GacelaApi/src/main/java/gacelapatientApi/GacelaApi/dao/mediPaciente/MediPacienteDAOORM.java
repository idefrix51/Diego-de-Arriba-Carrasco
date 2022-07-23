package gacelapatientApi.GacelaApi.dao.mediPaciente;

import gacelapatientApi.GacelaApi.BaseDAOORM;
import gacelapatientApi.GacelaApi.dao.calorias_diarias_corporal.Calorias_diarias_corporalDAO;
import gacelapatientApi.GacelaApi.model.MediPaciente;

import java.util.List;

public class MediPacienteDAOORM extends BaseDAOORM implements MediPacienteDAO {
    @Override
    public int insertar(MediPaciente objeto) throws Exception {
        conexion.save(objeto);
        return objeto.getMedipaciente_ID();
    }

    @Override
    public MediPaciente consultar(int id) {
        MediPaciente mediPaciente = conexion.get(MediPaciente.class, id);
        return mediPaciente;
    }

    @Override
    public List<MediPaciente> listar() {
        List<MediPaciente> lista = conexion.createQuery("from MediPaciente", MediPaciente.class).getResultList();
        return lista;
    }

    @Override
    public void actualizar(MediPaciente objeto) {
        MediPaciente mediPacientebd = conexion.load(MediPaciente.class, objeto.getMedipaciente_ID());
        mediPacientebd.setId_paciente(objeto.getId_paciente());
        mediPacientebd.setId_medicamento(objeto.getId_medicamento());
        mediPacientebd.setCantidad(objeto.getCantidad());
        conexion.update(mediPacientebd);
    }

    @Override
    public void eliminar(int id) {
        MediPaciente mediPaciente = conexion.load(MediPaciente.class, id);
        conexion.delete(mediPaciente);
    }
}
