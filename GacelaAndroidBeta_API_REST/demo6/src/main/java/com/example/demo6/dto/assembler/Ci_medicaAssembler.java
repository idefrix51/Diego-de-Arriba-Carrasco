package com.example.demo6.dto.assembler;


import com.example.demo6.dto.Ci_medicaDTO;
import gacelapatientApi.GacelaApi.model.Ci_medica;

public class Ci_medicaAssembler {
    public static Ci_medicaDTO pasearADTO(Ci_medica obj) {

        Ci_medicaDTO dto = new Ci_medicaDTO();

        dto.setId_paciente(obj.getId_paciente());
        dto.setId_ci_tipo(obj.getId_ci_tipo());
        dto.setFecha(obj.getFecha());
        dto.setAnotacion(obj.getAnotacion());
        return dto;
    }

    public static Ci_medica pasearDesdeDTO(Ci_medicaDTO dto) {

        Ci_medica obj = new Ci_medica();

        obj.setId_paciente(dto.getId_paciente());
        obj.setId_ci_tipo(dto.getId_ci_tipo());
        obj.setFecha(dto.getFecha());
        obj.setAnotacion(dto.getAnotacion());
        return obj;
    }
}
