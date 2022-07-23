package gacelapatientApi.GacelaApi;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class BaseDAOORM implements BaseDAO{
	protected Session conexion;
	protected Transaction tx;
	
	public Session abrirConexion() {
		conexion = ConexionORM.obtenerConexion().openSession();	
		tx = conexion.beginTransaction();
		return conexion;
		}
	public void cerrarConexion() {
		tx.commit();
		conexion.close();
	}
}
