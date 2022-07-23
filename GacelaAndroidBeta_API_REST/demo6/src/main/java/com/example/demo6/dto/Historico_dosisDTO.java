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
public class Historico_dosisDTO implements Serializable {

    private int historico_dosis_ID;
    private int id_medipaciente;
    private boolean dosis;
    private Timestamp fecha;
}
