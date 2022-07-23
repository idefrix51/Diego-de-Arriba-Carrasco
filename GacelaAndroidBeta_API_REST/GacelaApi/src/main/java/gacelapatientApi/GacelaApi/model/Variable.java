package gacelapatientApi.GacelaApi.model;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class Variable implements Serializable {

    private int variable_ID;
    private String nombre;
    private int numerico;
    private String descripcion;
    private int optLock;
    private List<Historico_clinico> historicos_clinicos;

    public Variable(){

    }

}
