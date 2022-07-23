package gacelapatientApi.GacelaApi.factory;

import gacelapatientApi.GacelaApi.dao.calorias_diarias_corporal.Calorias_diarias_corporalDAO;
import gacelapatientApi.GacelaApi.dao.calorias_diarias_corporal.Calorias_diarias_corporalDAOORM;
import gacelapatientApi.GacelaApi.dao.ci_medica.Ci_medicaDAO;
import gacelapatientApi.GacelaApi.dao.ci_medica.Ci_medicaDAOORM;
import gacelapatientApi.GacelaApi.dao.ci_tipo.Ci_tipoDAO;
import gacelapatientApi.GacelaApi.dao.ci_tipo.Ci_tipoDAOORM;
import gacelapatientApi.GacelaApi.dao.historico_clinico.Historico_clinicoDAO;
import gacelapatientApi.GacelaApi.dao.historico_clinico.Historico_clinicoDAOORM;
import gacelapatientApi.GacelaApi.dao.historico_dosis.Historico_dosisDAO;
import gacelapatientApi.GacelaApi.dao.historico_dosis.Historico_dosisDAOORM;
import gacelapatientApi.GacelaApi.dao.mediPaciente.MediPacienteDAO;
import gacelapatientApi.GacelaApi.dao.mediPaciente.MediPacienteDAOORM;
import gacelapatientApi.GacelaApi.dao.medicamento.MedicamentoDAO;
import gacelapatientApi.GacelaApi.dao.medicamento.MedicamentoDAOORM;
import gacelapatientApi.GacelaApi.dao.paciente.PacienteDAO;
import gacelapatientApi.GacelaApi.dao.paciente.PacienteDAOORM;
import gacelapatientApi.GacelaApi.dao.registro_GoogleFit.Registro_GoogleFitDAO;
import gacelapatientApi.GacelaApi.dao.registro_GoogleFit.Registro_GoogleFitDAOORM;
import gacelapatientApi.GacelaApi.dao.registro_var_fisica.Registro_var_fisicaDAO;
import gacelapatientApi.GacelaApi.dao.registro_var_fisica.Registro_var_fisicaDAOORM;
import gacelapatientApi.GacelaApi.dao.variable.VariableDAO;
import gacelapatientApi.GacelaApi.dao.variable.VariableDAOORM;

public class DAOFactoryORM extends DAOFactory{
    @Override
    public PacienteDAO getPacienteDAO() {
        return new PacienteDAOORM();
    }

    @Override
    public Registro_GoogleFitDAO getRegistro_GoogleFitDAO() {
        return new Registro_GoogleFitDAOORM();
    }

    @Override
    public Registro_var_fisicaDAO getRegistro_var_fisicaDAO() {
        return new Registro_var_fisicaDAOORM();
    }

    @Override
    public VariableDAO getVariableDAO() {
        return new VariableDAOORM();
    }

    @Override
    public Calorias_diarias_corporalDAO getCalorias_diarias_corporalDAO() {
        return new Calorias_diarias_corporalDAOORM();
    }

    @Override
    public Ci_medicaDAO getCi_medicaDAO() {
        return new Ci_medicaDAOORM();
    }

    @Override
    public Ci_tipoDAO getCi_tipoDAO() {
        return new Ci_tipoDAOORM();
}

    @Override
    public Historico_clinicoDAO getHistorico_clinicoDAO() {
        return new Historico_clinicoDAOORM();
    }

    @Override
    public Historico_dosisDAO getHistorico_dosisDAO() {
        return new Historico_dosisDAOORM();
    }

    @Override
    public MedicamentoDAO getMedicamentoDAO() {
        return new MedicamentoDAOORM();
    }

    @Override
    public MediPacienteDAO getMediPacienteDAO() {
        return new MediPacienteDAOORM();
    }
}

