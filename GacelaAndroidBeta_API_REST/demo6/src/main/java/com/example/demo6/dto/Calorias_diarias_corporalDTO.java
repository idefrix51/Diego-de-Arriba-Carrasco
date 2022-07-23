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
public class Calorias_diarias_corporalDTO implements Serializable {
    private int calorias_diarias_corporales_ID;
    private int id_registro_var_fisica;
    private int calorias_diarias_totales ;
    private Timestamp fecha ;
}
