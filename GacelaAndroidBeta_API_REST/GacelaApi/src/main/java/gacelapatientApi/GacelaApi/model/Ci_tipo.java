package gacelapatientApi.GacelaApi.model;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class Ci_tipo implements Serializable {

    private int ci_tipo_ID;
    private String nombre;
    private String descripcion;
    private int optLock;
    private List<Ci_medica> ci_medicas;
    public Ci_tipo(){

    }
}
