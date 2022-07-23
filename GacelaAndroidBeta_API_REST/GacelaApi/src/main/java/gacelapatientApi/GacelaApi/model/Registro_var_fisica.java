package gacelapatientApi.GacelaApi.model;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

@Data
public class Registro_var_fisica implements Serializable {

    private int registro_var_fisica_ID;
    private int id_paciente;
    private Timestamp fecha;
    private int peso;
    private int c_diarias;
    private int altura;
    private int peso_ideal;
    private int optLock;
    private Paciente paciente;

    private List<Registro_GoogleFit> registros_GoogleFit;
    private List<Calorias_diarias_corporal> calorias_diarias_corporales;
    public Registro_var_fisica(){

    }

}
