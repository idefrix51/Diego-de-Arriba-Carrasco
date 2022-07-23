package gacelapatientApi.GacelaApi.dao.medicamento;

import gacelapatientApi.GacelaApi.BaseDAO;
import gacelapatientApi.GacelaApi.model.Medicamento;


import java.util.List;

public interface MedicamentoDAO extends BaseDAO {

    public int insertar(Medicamento objeto) throws Exception;

    public Medicamento consultar(int id);

    public List<Medicamento> listar();

    public void actualizar(Medicamento objeto);

    public void eliminar(int id);
}
