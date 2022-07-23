package gacelapatientApi.GacelaApi.model;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;
@Data
public class Ci_medica implements Serializable {

    private int ci_medica_ID;
    private int id_paciente;
    private int id_ci_tipo;
    private Timestamp fecha;
    private String anotacion;
    private int optLock;
    private Paciente paciente;
    private Ci_tipo ci_tipo;

    public Ci_medica(){

    }

}
