package com.example.demo6.dto.assembler;


import com.example.demo6.dto.Registro_GoogleFitDTO;
import gacelapatientApi.GacelaApi.model.Registro_GoogleFit;

public class Registro_GoogleFitAssembler {
    public static Registro_GoogleFitDTO pasearADTO(Registro_GoogleFit obj) {

        Registro_GoogleFitDTO dto = new Registro_GoogleFitDTO();

        dto.setId_registro_var_fisica(obj.getId_registro_var_fisica());
        dto.setId_calorias_diarias_corporales(obj.getId_calorias_diarias_corporales());
        dto.setCalorias_consumidas(obj.getCalorias_consumidas());
        dto.setDistancia_recorrida(obj.getDistancia_recorrida());
        dto.setPasos(obj.getPasos());
        dto.setFecha(obj.getFecha());
        return dto;
    }

    public static Registro_GoogleFit pasearDesdeDTO(Registro_GoogleFitDTO dto) {

        Registro_GoogleFit obj = new Registro_GoogleFit();

        obj.setId_registro_var_fisica(dto.getId_registro_var_fisica());
        obj.setId_calorias_diarias_corporales(dto.getId_calorias_diarias_corporales());
        obj.setCalorias_consumidas(dto.getCalorias_consumidas());
        obj.setDistancia_recorrida(dto.getDistancia_recorrida());
        obj.setPasos(dto.getPasos());
        obj.setFecha(dto.getFecha());
        return obj;
    }
}
