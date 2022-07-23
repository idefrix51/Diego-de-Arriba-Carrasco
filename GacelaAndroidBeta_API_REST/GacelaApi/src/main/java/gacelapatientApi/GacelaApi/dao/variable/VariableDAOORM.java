package gacelapatientApi.GacelaApi.dao.variable;

import gacelapatientApi.GacelaApi.BaseDAOORM;
import gacelapatientApi.GacelaApi.dao.calorias_diarias_corporal.Calorias_diarias_corporalDAO;
import gacelapatientApi.GacelaApi.model.Variable;

import java.util.List;

public class VariableDAOORM extends BaseDAOORM implements VariableDAO {
    @Override
    public int insertar(Variable objeto) throws Exception {
        conexion.save(objeto);
        return objeto.getVariable_ID();
    }

    @Override
    public Variable consultar(int id) {
        Variable variable = conexion.get(Variable.class, id);
        return variable;
    }

    @Override
    public List<Variable> listar() {
        List<Variable> lista = conexion.createQuery("from Variable", Variable.class).getResultList();
        return lista;
    }

    @Override
    public void actualizar(Variable objeto) {
        Variable variablebd = conexion.load(Variable.class, objeto.getVariable_ID());
        variablebd.setNombre(objeto.getNombre());
        variablebd.setNumerico(objeto.getNumerico());
        variablebd.setDescripcion(objeto.getDescripcion());
        conexion.update(variablebd);
    }

    @Override
    public void eliminar(int id) {
        Variable variable = conexion.load(Variable.class, id);
        conexion.delete(variable);
    }
}
