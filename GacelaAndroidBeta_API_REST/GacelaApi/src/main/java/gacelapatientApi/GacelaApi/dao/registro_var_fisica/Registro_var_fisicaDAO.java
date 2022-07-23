package gacelapatientApi.GacelaApi.dao.registro_var_fisica;

import gacelapatientApi.GacelaApi.BaseDAO;
import gacelapatientApi.GacelaApi.model.Registro_var_fisica;


import java.util.List;

public interface Registro_var_fisicaDAO extends BaseDAO {

    public int insertar(Registro_var_fisica objeto) throws Exception;

    public Registro_var_fisica consultar(int id);

    public List<Registro_var_fisica> listar();

    public void actualizar(Registro_var_fisica objeto);

    public void eliminar(int id);
}
