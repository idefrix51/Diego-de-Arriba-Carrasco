package gacelapatientApi.GacelaApi.dao.ci_tipo;

import gacelapatientApi.GacelaApi.BaseDAOORM;

import gacelapatientApi.GacelaApi.model.Ci_tipo;


import java.util.List;

public class Ci_tipoDAOORM  extends BaseDAOORM implements Ci_tipoDAO {
    @Override
    public int insertar(Ci_tipo objeto) throws Exception {
        conexion.save(objeto);

        return objeto.getCi_tipo_ID();
    }

    @Override
    public Ci_tipo consultar(int id) {
        Ci_tipo obj = conexion.get(Ci_tipo.class, id);

        return obj;
    }

    @Override
    public List<Ci_tipo> listar() {
        List<Ci_tipo> lista = conexion.createQuery("from Ci_tipo", Ci_tipo.class).getResultList();

        return lista;
    }

    @Override
    public void actualizar(Ci_tipo objeto) {
        Ci_tipo objBD = conexion.load(Ci_tipo.class, objeto.getCi_tipo_ID());
        objBD.setCi_tipo_ID(objeto.getCi_tipo_ID());
        objBD.setNombre(objeto.getNombre());
        objBD.setDescripcion(objeto.getDescripcion());
        conexion.update(objBD);
    }

    @Override
    public void eliminar(int id) {
        Ci_tipo obj = conexion.load(Ci_tipo.class, id);
        conexion.delete(obj);
    }
}
