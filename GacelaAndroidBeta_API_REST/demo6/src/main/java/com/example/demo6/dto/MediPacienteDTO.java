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
public class MediPacienteDTO implements Serializable {


    private int medipaciente_ID;
    private int id_paciente;
    private int id_medicamento;
    private int cantidad;
}
