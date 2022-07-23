package gacelapatientApi.GacelaApi.model;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;
@Data
public class Registro_GoogleFit implements Serializable {

    private int registro_google_fit_ID;
    private int id_registro_var_fisica ;
    private int id_calorias_diarias_corporales ;
    private int calorias_consumidas ;
    private int distancia_recorrida ;
    private int pasos ;
    private Timestamp fecha ;
    private int optLock;
    private Registro_var_fisica registro_var_fisica;

    private Calorias_diarias_corporal calorias_diarias_corporal;
    public Registro_GoogleFit(){

    }

}
