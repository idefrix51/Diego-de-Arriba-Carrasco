package com.example.demo6.controller.paciente;

import com.example.demo6.dto.PacienteDTO;
import com.example.demo6.dto.assembler.PacienteAssembler;

import gacelapatientApi.GacelaApi.dao.paciente.PacienteDAO;
import gacelapatientApi.GacelaApi.factory.DAOFactory;
import gacelapatientApi.GacelaApi.model.Paciente;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class ShoPaciController {

    private DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.ORM);
    private PacienteDAO pacienteDAO = factory.getPacienteDAO();

    @Operation(summary = "Endpoint para listar todos los pacientes")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "La solicitud ha tenido éxito.",
                content = { @Content(mediaType = "application/json",
                        schema = @Schema(implementation = Paciente.class)) }),
            @ApiResponse(responseCode = "400", description = "No se pudo interpretar la solicitud debido a una sintaxis inválida.",
            content = @Content),
            @ApiResponse(responseCode = "401", description = "Petición no autorizada, es necesario autenticar para obtener la respuesta solicitada.",
                    content = @Content),
            @ApiResponse(responseCode = "403", description = "No se poseen los permisos necesarios para la solicitud, por lo que se rechaza la misma.",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "El servidor no puede encontrar el contenido solicitado.",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Error inesperado del sistema",
                    content = @Content)})
    @GetMapping(value = "/pacientes", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<PacienteDTO> listarPacientes() {

        pacienteDAO.abrirConexion();
        List<Paciente> lista = pacienteDAO.listar();
        pacienteDAO.cerrarConexion();

        List<PacienteDTO> listaDTO = new ArrayList<>();
        for (Paciente paciente : lista) {
            PacienteDTO pacienteDTO = PacienteAssembler.pasearADTO(paciente);
            listaDTO.add(pacienteDTO);
        }

        return listaDTO;
    }
}