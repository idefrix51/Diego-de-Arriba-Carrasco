package com.example.demo6.dto.assembler;


import com.example.demo6.dto.Ci_tipoDTO;
import gacelapatientApi.GacelaApi.model.Ci_tipo;

public class Ci_tipoAssembler {
    public static Ci_tipoDTO pasearADTO(Ci_tipo obj) {

        Ci_tipoDTO dto = new Ci_tipoDTO();

        dto.setCi_tipo_ID(obj.getCi_tipo_ID());
        dto.setNombre(obj.getNombre());
        dto.setDescripcion(obj.getDescripcion());
        return dto;
    }

    public static Ci_tipo pasearDesdeDTO(Ci_tipoDTO dto) {

        Ci_tipo obj = new Ci_tipo();

        obj.setCi_tipo_ID(dto.getCi_tipo_ID());
        obj.setNombre(dto.getNombre());
        obj.setDescripcion(dto.getDescripcion());
        return obj;
    }
}
