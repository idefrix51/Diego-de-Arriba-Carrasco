package gacelapatientApi.GacelaApi.dao.ci_medica;

import gacelapatientApi.GacelaApi.BaseDAO;
import gacelapatientApi.GacelaApi.model.Ci_medica;


import java.util.List;

public interface Ci_medicaDAO extends BaseDAO {

    public int insertar(Ci_medica objeto) throws Exception;

    public Ci_medica consultar(int id);

    public List<Ci_medica> listar();

    public void actualizar(Ci_medica objeto);

    public void eliminar(int id);
}
