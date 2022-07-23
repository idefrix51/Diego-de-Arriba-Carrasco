package gacelapatientApi.GacelaApi.factory;

import gacelapatientApi.GacelaApi.dao.calorias_diarias_corporal.Calorias_diarias_corporalDAO;
import gacelapatientApi.GacelaApi.dao.ci_medica.Ci_medicaDAO;
import gacelapatientApi.GacelaApi.dao.ci_tipo.Ci_tipoDAO;
import gacelapatientApi.GacelaApi.dao.historico_clinico.Historico_clinicoDAO;
import gacelapatientApi.GacelaApi.dao.historico_dosis.Historico_dosisDAO;
import gacelapatientApi.GacelaApi.dao.mediPaciente.MediPacienteDAO;
import gacelapatientApi.GacelaApi.dao.medicamento.MedicamentoDAO;
import gacelapatientApi.GacelaApi.dao.paciente.PacienteDAO;
import gacelapatientApi.GacelaApi.dao.registro_GoogleFit.Registro_GoogleFitDAO;
import gacelapatientApi.GacelaApi.dao.registro_var_fisica.Registro_var_fisicaDAO;
import gacelapatientApi.GacelaApi.dao.variable.VariableDAO;
import gacelapatientApi.GacelaApi.model.Ci_medica;

public abstract class DAOFactory {

    public static final int ORM = 1;

    public abstract Calorias_diarias_corporalDAO getCalorias_diarias_corporalDAO();

    public abstract Ci_medicaDAO getCi_medicaDAO();

    public abstract Ci_tipoDAO getCi_tipoDAO();

    public abstract Historico_clinicoDAO getHistorico_clinicoDAO();

    public abstract Historico_dosisDAO getHistorico_dosisDAO();

    public abstract MedicamentoDAO getMedicamentoDAO();
    public abstract MediPacienteDAO getMediPacienteDAO();
    public abstract PacienteDAO getPacienteDAO();

    public abstract Registro_GoogleFitDAO getRegistro_GoogleFitDAO();

    public abstract Registro_var_fisicaDAO getRegistro_var_fisicaDAO();

    public abstract VariableDAO getVariableDAO();
    public static DAOFactory getDAOFactory(int bd) {
        switch (bd) {
            case ORM:
                return new DAOFactoryORM();
            default:
                throw new RuntimeException("Opcion no disponible");
        }
    }
}
