package gacelapatientApi.GacelaApi.dao.variable;

import gacelapatientApi.GacelaApi.BaseDAO;
import gacelapatientApi.GacelaApi.model.Variable;


import java.util.List;

public interface VariableDAO extends BaseDAO {

    public int insertar(Variable objeto) throws Exception;

    public Variable consultar(int id);

    public List<Variable> listar();

    public void actualizar(Variable objeto);

    public void eliminar(int id);
}
