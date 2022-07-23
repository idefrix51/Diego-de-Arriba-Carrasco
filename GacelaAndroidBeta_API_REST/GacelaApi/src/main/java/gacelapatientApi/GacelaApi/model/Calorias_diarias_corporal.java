package gacelapatientApi.GacelaApi.model;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

@Data
public class Calorias_diarias_corporal implements Serializable {
    private int calorias_diarias_corporales_ID;
    private int id_registro_var_fisica;
    private int calorias_diarias_totales ;
    private Timestamp fecha ;
    private int optLock;
    private Registro_var_fisica registro_var_fisica;

    private List<Registro_GoogleFit> registro_googleFits;
    public Calorias_diarias_corporal(){

    }
}
