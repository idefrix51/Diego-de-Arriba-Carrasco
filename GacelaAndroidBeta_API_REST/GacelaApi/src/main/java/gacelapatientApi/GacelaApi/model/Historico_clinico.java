package gacelapatientApi.GacelaApi.model;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;
@Data
public class Historico_clinico implements Serializable {

    private int histo_clinicos_ID;
    private int id_paciente;
    private int id_variable;
    private Timestamp fecha_registro;
    private int valor_int;
    private String valor_varchar;
    private int optLock;
    private Paciente paciente;

    private Variable variable;

    public Historico_clinico(){

    }
}
