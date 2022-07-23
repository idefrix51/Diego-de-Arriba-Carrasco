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
public class VariableDTO implements Serializable {

    private int variable_ID;
    private String nombre;
    private int numerico;
    private String descripcion;
}
