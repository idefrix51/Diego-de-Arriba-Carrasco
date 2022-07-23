package com.example.demo6.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
@Getter
@Setter
@NoArgsConstructor
@ToString
public class MedicamentoDTO implements Serializable {

    private int medicamento_ID;
    private String nombre;
    private String descripcion;
}
