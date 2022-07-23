package gacelapatientApi.GacelaApi.model;



import lombok.Data;
import lombok.Getter;
import lombok.Setter;


import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

@Data
public class Paciente implements Serializable {

    private int id;
    private String nombre;
    private String apellidos;
    private Timestamp fechaNacimento;
    private String genero;
    private String cipAutonomico;
    private String cipNacional;
    private String nif;
    private String domicilio;
    private String mobilePhone;
    private String email;
    private String tutorLegal;
    private byte[] foto;
    private String password;

    private int optLock;

    private List<Ci_medica> ci_medicas;

    private List<Historico_clinico> historicos_clinicos;

    private List<MediPaciente> mediPacientes;

    private List<Registro_var_fisica> registro_var_fisicas;
    public Paciente(){

    }


}
