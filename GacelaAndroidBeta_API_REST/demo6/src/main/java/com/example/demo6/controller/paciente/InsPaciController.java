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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class InsPaciController {
    private DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.ORM);
    private PacienteDAO pacienteDAO = factory.getPacienteDAO();

    @Operation(summary = "Endpoint para insertar pacientes")
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
    @PostMapping("/pacientes")
    public ResponseEntity<PacienteDTO> insertarPaciente(@RequestBody PacienteDTO dto) throws Exception {

        Paciente paciente = PacienteAssembler.pasearDesdeDTO(dto);

        pacienteDAO.abrirConexion();
        pacienteDAO.insertar(paciente);
        pacienteDAO.cerrarConexion();

        return new ResponseEntity<>(PacienteAssembler.pasearADTO(paciente), HttpStatus.CREATED);
    }
}
