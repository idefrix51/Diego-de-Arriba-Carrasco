package gacelapatientApi.GacelaApi.model;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class Medicamento implements Serializable {

    private int medicamento_ID;
    private String nombre;
    private String descripcion;
    private int optLock;
    private List<MediPaciente> mediPacientes;

    public Medicamento(){

    }
}
