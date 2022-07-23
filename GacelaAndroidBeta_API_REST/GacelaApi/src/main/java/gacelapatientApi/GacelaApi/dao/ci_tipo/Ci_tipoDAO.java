package gacelapatientApi.GacelaApi.dao.ci_tipo;

import gacelapatientApi.GacelaApi.BaseDAO;
import gacelapatientApi.GacelaApi.model.Ci_tipo;


import java.util.List;

public interface Ci_tipoDAO extends BaseDAO {

    public int insertar(Ci_tipo objeto) throws Exception;

    public Ci_tipo consultar(int id);

    public List<Ci_tipo> listar();

    public void actualizar(Ci_tipo objeto);

    public void eliminar(int id);
}
