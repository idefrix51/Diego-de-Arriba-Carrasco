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
public class Historico_clinicoDTO implements Serializable {

    private int histo_clinicos_ID;
    private int id_paciente;
    private int id_variable;
    private Timestamp fecha_registro;
    private int valor_int;
    private String valor_varchar;
}
