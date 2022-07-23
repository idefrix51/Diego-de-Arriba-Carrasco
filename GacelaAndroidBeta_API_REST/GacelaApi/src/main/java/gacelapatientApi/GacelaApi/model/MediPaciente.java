package gacelapatientApi.GacelaApi.model;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class MediPaciente implements Serializable {


    private int medipaciente_ID;
    private int id_paciente;
    private int id_medicamento;
    private int cantidad;
    private int optLock;
    private Paciente paciente;

    private Medicamento medicamento;

    private List<Historico_dosis> historicos_dosis;
    public MediPaciente(){

    }

}
