package gacelapatientApi.GacelaApi.dao.mediPaciente;

import gacelapatientApi.GacelaApi.BaseDAO;
import gacelapatientApi.GacelaApi.model.MediPaciente;


import java.util.List;

public interface MediPacienteDAO extends BaseDAO {

    public int insertar(MediPaciente objeto) throws Exception;

    public MediPaciente consultar(int id);

    public List<MediPaciente> listar();

    public void actualizar(MediPaciente objeto);

    public void eliminar(int id);
}
