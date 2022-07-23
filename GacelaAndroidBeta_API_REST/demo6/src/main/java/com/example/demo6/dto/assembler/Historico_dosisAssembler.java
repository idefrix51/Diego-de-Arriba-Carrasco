package com.example.demo6.dto.assembler;


import com.example.demo6.dto.Historico_dosisDTO;
import gacelapatientApi.GacelaApi.model.Historico_dosis;

public class Historico_dosisAssembler {
    public static Historico_dosisDTO pasearADTO(Historico_dosis obj) {

        Historico_dosisDTO dto = new Historico_dosisDTO();

        dto.setId_medipaciente(obj.getId_medipaciente());
        dto.setDosis(obj.isDosis());
        dto.setFecha(obj.getFecha());
        return dto;
    }

    public static Historico_dosis pasearDesdeDTO(Historico_dosisDTO dto) {

        Historico_dosis obj = new Historico_dosis();

        obj.setId_medipaciente(dto.getId_medipaciente());
        obj.setDosis(dto.isDosis());
        obj.setFecha(dto.getFecha());
        return obj;
    }
}
