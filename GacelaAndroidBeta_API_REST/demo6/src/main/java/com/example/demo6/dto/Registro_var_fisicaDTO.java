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
public class Registro_var_fisicaDTO implements Serializable {

    private int registro_var_fisica_ID;
    private int id_paciente;
    private Timestamp fecha;
    private int peso;
    private int c_diarias;
    private int altura;
    private int peso_ideal;
}
