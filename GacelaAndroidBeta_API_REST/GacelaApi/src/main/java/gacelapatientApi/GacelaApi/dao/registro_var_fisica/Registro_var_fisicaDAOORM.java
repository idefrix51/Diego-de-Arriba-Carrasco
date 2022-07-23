package gacelapatientApi.GacelaApi.dao.registro_var_fisica;

import gacelapatientApi.GacelaApi.BaseDAOORM;
import gacelapatientApi.GacelaApi.dao.calorias_diarias_corporal.Calorias_diarias_corporalDAO;
import gacelapatientApi.GacelaApi.model.Registro_var_fisica;

import java.sql.Timestamp;
import java.util.List;

public class Registro_var_fisicaDAOORM extends BaseDAOORM implements Registro_var_fisicaDAO {
    @Override
    public int insertar(Registro_var_fisica objeto) throws Exception {
        conexion.save(objeto);
        return objeto.getRegistro_var_fisica_ID();
    }

    @Override
    public Registro_var_fisica consultar(int id) {
        Registro_var_fisica registro_var_fisica = conexion.get(Registro_var_fisica.class, id);
        return registro_var_fisica;
    }

    @Override
    public List<Registro_var_fisica> listar() {
        List<Registro_var_fisica> lista = conexion.createQuery("from Registro_var_fisica", Registro_var_fisica.class).getResultList();
        return lista;
    }

    @Override
    public void actualizar(Registro_var_fisica objeto) {
        Registro_var_fisica registro_var_fisicabd = conexion.load(Registro_var_fisica.class, objeto.getRegistro_var_fisica_ID());
        registro_var_fisicabd.setId_paciente(objeto.getId_paciente());
        registro_var_fisicabd.setFecha(objeto.getFecha());
        registro_var_fisicabd.setPeso(objeto.getPeso());
        registro_var_fisicabd.setC_diarias(objeto.getC_diarias());
        registro_var_fisicabd.setAltura(objeto.getAltura());
        registro_var_fisicabd.setPeso_ideal(objeto.getPeso_ideal());
        conexion.update(registro_var_fisicabd);
    }

    @Override
    public void eliminar(int id) {
        Registro_var_fisica registro_var_fisica = conexion.load(Registro_var_fisica.class, id);
        conexion.delete(registro_var_fisica);
    }
}
