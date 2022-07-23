package com.example.demo6.dto.assembler;


import com.example.demo6.dto.Registro_var_fisicaDTO;
import gacelapatientApi.GacelaApi.model.Registro_var_fisica;

public class Registro_var_fisicaAssembler {
    public static Registro_var_fisicaDTO pasearADTO(Registro_var_fisica obj) {

        Registro_var_fisicaDTO dto = new Registro_var_fisicaDTO();

        dto.setId_paciente(obj.getId_paciente());
        dto.setFecha(obj.getFecha());
        dto.setPeso(obj.getPeso());
        dto.setC_diarias(obj.getC_diarias());
        dto.setAltura(obj.getAltura());
        dto.setPeso_ideal(obj.getPeso_ideal());
        return dto;
    }

    public static Registro_var_fisica pasearDesdeDTO(Registro_var_fisicaDTO dto) {

        Registro_var_fisica obj = new Registro_var_fisica();

        obj.setId_paciente(dto.getId_paciente());
        obj.setFecha(dto.getFecha());
        obj.setPeso(dto.getPeso());
        obj.setC_diarias(dto.getC_diarias());
        obj.setAltura(dto.getAltura());
        obj.setPeso_ideal(dto.getPeso_ideal());
        return obj;
    }

}
