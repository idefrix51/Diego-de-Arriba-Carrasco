package gacelapatientApi.GacelaApi.dao.registro_GoogleFit;

import gacelapatientApi.GacelaApi.BaseDAO;
import gacelapatientApi.GacelaApi.model.Registro_GoogleFit;


import java.util.List;

public interface Registro_GoogleFitDAO extends BaseDAO {

    public int insertar(Registro_GoogleFit objeto) throws Exception;

    public Registro_GoogleFit consultar(int id);

    public List<Registro_GoogleFit> listar();

    public void actualizar(Registro_GoogleFit objeto);

    public void eliminar(int id);
}
