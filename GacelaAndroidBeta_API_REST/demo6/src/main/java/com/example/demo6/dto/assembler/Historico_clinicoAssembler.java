package com.example.demo6.dto.assembler;


import com.example.demo6.dto.Historico_clinicoDTO;
import gacelapatientApi.GacelaApi.model.Historico_clinico;

public class Historico_clinicoAssembler {
    public static Historico_clinicoDTO pasearADTO(Historico_clinico obj) {

        Historico_clinicoDTO dto = new Historico_clinicoDTO();

        dto.setId_paciente(obj.getId_paciente());
        dto.setId_variable(obj.getId_variable());
        dto.setFecha_registro(obj.getFecha_registro());
        dto.setValor_int(obj.getValor_int());
        dto.setValor_varchar(obj.getValor_varchar());
        return dto;
    }

    public static Historico_clinico pasearDesdeDTO(Historico_clinicoDTO dto) {

        Historico_clinico obj = new Historico_clinico();

        obj.setId_paciente(dto.getId_paciente());
        obj.setId_variable(dto.getId_variable());
        obj.setFecha_registro(dto.getFecha_registro());
        obj.setValor_int(dto.getValor_int());
        obj.setValor_varchar(dto.getValor_varchar());
        return obj;
    }
}
