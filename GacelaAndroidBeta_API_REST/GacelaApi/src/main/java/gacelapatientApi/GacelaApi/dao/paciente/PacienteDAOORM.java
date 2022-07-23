package gacelapatientApi.GacelaApi.dao.paciente;

import gacelapatientApi.GacelaApi.BaseDAOORM;
import gacelapatientApi.GacelaApi.model.Paciente;
import org.hibernate.query.Query;

import java.sql.Timestamp;
import java.util.List;

public class PacienteDAOORM extends BaseDAOORM implements PacienteDAO {
    @Override
    public int insertar(Paciente objeto) throws Exception {

        conexion.save(objeto);

        return objeto.getId();
    }

    @Override
    public Paciente consultar(int id) {
        Paciente obj = conexion.get(Paciente.class, id);

        return obj;
    }

    @Override
    public List<Paciente> listar() {
        List<Paciente> lista = conexion.createQuery("from Paciente", Paciente.class).getResultList();

        return lista;
    }

    @Override
    public void actualizar(Paciente objeto) {

        Paciente objBD = conexion.load(Paciente.class, objeto.getId());
        objBD.setId(objeto.getId());
        objBD.setNombre(objeto.getNombre());
        objBD.setApellidos(objeto.getApellidos());
        objBD.setFechaNacimento(new Timestamp(objeto.getFechaNacimento().getTime()));
        objBD.setGenero(objeto.getGenero());
        objBD.setCipAutonomico(objeto.getCipAutonomico());
        objBD.setCipNacional(objeto.getCipNacional());
        objBD.setNif(objeto.getNif());
        objBD.setDomicilio(objeto.getDomicilio());
        objBD.setMobilePhone(objeto.getMobilePhone());
        objBD.setEmail(objeto.getEmail());
        objBD.setTutorLegal(objeto.getTutorLegal());
        objBD.setFoto(objeto.getFoto());
        objBD.setPassword(objeto.getPassword());
        conexion.update(objBD);

    }

    @Override
    public void eliminar(int id) {

        Paciente obj = conexion.load(Paciente.class, id);
        conexion.delete(obj);

    }

    @Override
    public Paciente consultarEmailpasword(String email, String password) {

        Query query =
                conexion.createQuery(
                        "select p " +
                                "from Paciente p " +
                                "where p.email = :email" + " AND " +
                                "p.password = :password");
                        query.setParameter( "email", email );
                        query.setParameter( "password", password );
        Paciente resPaciente = (Paciente)query.uniqueResult();
        return resPaciente;
    }

    @Override
    public Paciente consultarNIFpasword(String nif, String password) {
        Query query =
                conexion.createQuery(
                        "select p " +
                                "from Paciente p " +
                                "where p.nif = :nif" + " AND " +
                                "p.password = :password");
        query.setParameter( "nif", nif );
        query.setParameter( "password", password );
        Paciente resPaciente = (Paciente)query.uniqueResult();
        return resPaciente;
    }

}
