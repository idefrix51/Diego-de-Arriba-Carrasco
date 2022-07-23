package gacelapatientApi.GacelaApi.dao.calorias_diarias_corporal;

import gacelapatientApi.GacelaApi.BaseDAO;
import gacelapatientApi.GacelaApi.model.Calorias_diarias_corporal;


import java.util.List;

public interface Calorias_diarias_corporalDAO extends BaseDAO {

    public int insertar(Calorias_diarias_corporal objeto) throws Exception;

    public Calorias_diarias_corporal consultar(int id);

    public List<Calorias_diarias_corporal> listar();

    public void actualizar(Calorias_diarias_corporal objeto);

    public void eliminar(int id);
}
