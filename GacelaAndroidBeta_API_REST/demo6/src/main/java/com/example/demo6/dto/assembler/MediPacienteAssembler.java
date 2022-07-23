package com.example.demo6.dto.assembler;


import com.example.demo6.dto.MediPacienteDTO;
import gacelapatientApi.GacelaApi.model.MediPaciente;

public class MediPacienteAssembler {
    public static MediPacienteDTO pasearADTO(MediPaciente obj) {

        MediPacienteDTO dto = new MediPacienteDTO();

        dto.setId_paciente(obj.getId_paciente());
        dto.setId_medicamento(obj.getId_medicamento());
        dto.setCantidad(obj.getCantidad());
        return dto;
    }

    public static MediPaciente pasearDesdeDTO(MediPacienteDTO dto) {

        MediPaciente obj = new MediPaciente();

        obj.setId_paciente(dto.getId_paciente());
        obj.setId_medicamento(dto.getId_medicamento());
        obj.setCantidad(dto.getCantidad());
        return obj;
    }
}
