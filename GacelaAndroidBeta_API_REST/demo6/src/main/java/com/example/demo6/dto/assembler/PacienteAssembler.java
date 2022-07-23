package com.example.demo6.dto.assembler;

import com.example.demo6.dto.PacienteDTO;
import gacelapatientApi.GacelaApi.model.Paciente;

import java.sql.Timestamp;

public class PacienteAssembler {
    public static PacienteDTO pasearADTO(Paciente obj) {

        PacienteDTO dto = new PacienteDTO();

        dto.setId(obj.getId());
        dto.setNombre(obj.getNombre());
        dto.setApellidos(obj.getApellidos());
        dto.setFechaNacimento(obj.getFechaNacimento());
        dto.setGenero(obj.getGenero());
        dto.setCipAutonomico(obj.getCipAutonomico());
        dto.setCipNacional(obj.getCipNacional());
        dto.setNif(obj.getNif());
        dto.setDomicilio(obj.getDomicilio());
        dto.setMobilePhone(obj.getMobilePhone());
        dto.setEmail(obj.getEmail());
        dto.setTutorLegal(obj.getTutorLegal());
        dto.setFoto(obj.getFoto());
        dto.setPassword(obj.getPassword());
        return dto;
    }

    public static Paciente pasearDesdeDTO(PacienteDTO dto) {

        Paciente obj = new Paciente();

        obj.setId(dto.getId());
        obj.setNombre(dto.getNombre());
        obj.setApellidos(dto.getApellidos());
        obj.setFechaNacimento(dto.getFechaNacimento());
        obj.setGenero(dto.getGenero());
        obj.setCipAutonomico(dto.getCipAutonomico());
        obj.setCipNacional(dto.getCipNacional());
        obj.setNif(dto.getNif());
        obj.setDomicilio(dto.getDomicilio());
        obj.setMobilePhone(dto.getMobilePhone());
        obj.setEmail(dto.getEmail());
        obj.setTutorLegal(dto.getTutorLegal());
        obj.setFoto(dto.getFoto());
        obj.setPassword(dto.getPassword());
        return obj;
    }
}
