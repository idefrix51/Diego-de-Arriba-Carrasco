package com.example.demo6.dto.assembler;


import com.example.demo6.dto.Calorias_diarias_corporalDTO;


import gacelapatientApi.GacelaApi.dao.calorias_diarias_corporal.Calorias_diarias_corporalDAO;
import gacelapatientApi.GacelaApi.model.Calorias_diarias_corporal;


public class Calorias_diarias_corporalAssembler {

    public static Calorias_diarias_corporalDTO pasearADTO(Calorias_diarias_corporal obj) {

        Calorias_diarias_corporalDTO dto = new Calorias_diarias_corporalDTO();
        dto.setCalorias_diarias_corporales_ID(obj.getCalorias_diarias_corporales_ID());
        dto.setId_registro_var_fisica(obj.getId_registro_var_fisica());
        dto.setFecha(obj.getFecha());
        dto.setCalorias_diarias_totales(obj.getCalorias_diarias_totales());
        return dto;
    }
    public static Calorias_diarias_corporal pasearDesdeDTO(Calorias_diarias_corporalDTO dto) {

        Calorias_diarias_corporal obj = new Calorias_diarias_corporal();

        obj.setCalorias_diarias_corporales_ID(dto.getCalorias_diarias_corporales_ID());
        obj.setId_registro_var_fisica(dto.getId_registro_var_fisica());
        obj.setFecha(dto.getFecha());
        obj.setCalorias_diarias_totales(dto.getCalorias_diarias_totales());
        return obj;
    }

}
