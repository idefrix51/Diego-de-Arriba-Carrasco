package gacelapatientApi.GacelaApi.dao.historico_clinico;

import gacelapatientApi.GacelaApi.BaseDAO;
import gacelapatientApi.GacelaApi.model.Historico_clinico;


import java.util.List;

public interface Historico_clinicoDAO extends BaseDAO {

    public int insertar(Historico_clinico objeto) throws Exception;

    public Historico_clinico consultar(int id);

    public List<Historico_clinico> listar();

    public void actualizar(Historico_clinico objeto);

    public void eliminar(int id);
}
