package gacelapatientApi.GacelaApi;

import org.hibernate.Session;

public interface BaseDAO {
public Session abrirConexion();
    public void cerrarConexion();
}
