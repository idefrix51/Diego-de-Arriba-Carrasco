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
public class Ci_tipoDTO implements Serializable {

    private int ci_tipo_ID;
    private String nombre;
    private String descripcion;
}
