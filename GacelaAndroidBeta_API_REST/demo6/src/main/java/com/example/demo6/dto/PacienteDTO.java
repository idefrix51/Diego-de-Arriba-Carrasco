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
public class PacienteDTO implements Serializable {
    private int id;
    private String nombre;
    private String apellidos;
    private Timestamp fechaNacimento;
    private String genero;
    private String cipAutonomico;
    private String cipNacional;
    private String nif;
    private String domicilio;
    private String mobilePhone;
    private String email;
    private String tutorLegal;
    private byte[] foto;
    private String password;
}
