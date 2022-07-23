package com.example.demo6.dto.assembler;


import com.example.demo6.dto.MedicamentoDTO;
import gacelapatientApi.GacelaApi.model.Medicamento;

public class MedicamentoAssembler {
    public static MedicamentoDTO pasearADTO(Medicamento obj) {

        MedicamentoDTO dto = new MedicamentoDTO();

        dto.setNombre(obj.getNombre());
        dto.setDescripcion(obj.getDescripcion());
        return dto;
    }

    public static Medicamento pasearDesdeDTO(MedicamentoDTO dto) {

        Medicamento obj = new Medicamento();

        obj.setNombre(dto.getNombre());
        obj.setDescripcion(dto.getDescripcion());
        return obj;
    }
}
