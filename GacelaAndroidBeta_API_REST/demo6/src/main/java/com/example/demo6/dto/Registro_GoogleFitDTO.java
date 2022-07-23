package com.example.demo6.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.sql.Timestamp;
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Registro_GoogleFitDTO implements Serializable {

    private int registro_google_fit_ID;
    private int id_registro_var_fisica ;
    private int id_calorias_diarias_corporales ;
    private int calorias_consumidas ;
    private int distancia_recorrida ;
    private int pasos ;
    private Timestamp fecha ;
}
