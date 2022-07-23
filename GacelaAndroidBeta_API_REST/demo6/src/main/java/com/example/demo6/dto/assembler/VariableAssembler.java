package com.example.demo6.dto.assembler;


import com.example.demo6.dto.VariableDTO;
import gacelapatientApi.GacelaApi.model.Variable;

public class VariableAssembler {
    public static VariableDTO pasearADTO(Variable obj) {

        VariableDTO dto = new VariableDTO();

        dto.setNombre(obj.getNombre());
        dto.setNumerico(obj.getNumerico());
        dto.setDescripcion(obj.getDescripcion());
        return dto;
    }

    public static Variable pasearDesdeDTO(VariableDTO dto) {

        Variable obj = new Variable();

        obj.setNombre(dto.getNombre());
        obj.setNumerico(dto.getNumerico());
        obj.setDescripcion(dto.getDescripcion());
        return obj;
    }
}
