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
public class Ci_medicaDTO implements Serializable {

    private int ci_medica_ID;
    private int id_paciente;
    private int id_ci_tipo;
    private Timestamp fecha;
    private String anotacion;
}
