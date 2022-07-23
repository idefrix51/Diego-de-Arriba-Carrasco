package gacelapatientApi.GacelaApi.dao.paciente;

import gacelapatientApi.GacelaApi.BaseDAO;
import gacelapatientApi.GacelaApi.model.Paciente;

import java.util.List;

public interface PacienteDAO extends BaseDAO {

    public int insertar(Paciente objeto) throws Exception;

    public Paciente consultar(int id);

    public List<Paciente> listar();

    public void actualizar(Paciente objeto);

    public void eliminar(int id);
    public Paciente consultarEmailpasword(String email, String password);
    public Paciente consultarNIFpasword(String nif, String password);

}
