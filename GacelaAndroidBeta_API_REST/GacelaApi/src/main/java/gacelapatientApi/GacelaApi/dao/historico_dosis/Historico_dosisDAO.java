package gacelapatientApi.GacelaApi.dao.historico_dosis;



import gacelapatientApi.GacelaApi.BaseDAO;
import gacelapatientApi.GacelaApi.model.Historico_dosis;

import java.util.List;

public interface Historico_dosisDAO extends BaseDAO {

    public int insertar(Historico_dosis objeto) throws Exception;

    public Historico_dosis consultar(int id);

    public List<Historico_dosis> listar();

    public void actualizar(Historico_dosis objeto);

    public void eliminar(int id);
}
