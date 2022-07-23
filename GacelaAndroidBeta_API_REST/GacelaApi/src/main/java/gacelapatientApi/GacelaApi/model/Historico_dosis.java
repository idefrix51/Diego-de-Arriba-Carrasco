package gacelapatientApi.GacelaApi.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Timestamp;
@Data
public class Historico_dosis implements Serializable {

    private int historico_dosis_ID;
    private int id_medipaciente;
    private boolean dosis;
    private Timestamp fecha;
    private int optLock;
    private MediPaciente mediPaciente;
    public Historico_dosis(){

    }
}
