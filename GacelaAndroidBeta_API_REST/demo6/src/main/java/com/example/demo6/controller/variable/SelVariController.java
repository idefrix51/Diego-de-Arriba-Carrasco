package com.example.demo6.controller.variable;

import com.example.demo6.dto.VariableDTO;
import com.example.demo6.dto.assembler.VariableAssembler;
import gacelapatientApi.GacelaApi.dao.variable.VariableDAO;
import gacelapatientApi.GacelaApi.factory.DAOFactory;

import gacelapatientApi.GacelaApi.model.Variable;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class SelVariController {
    private DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.ORM);
    private VariableDAO pacienteDAO = factory.getVariableDAO();

    @Operation(summary = "Endpoint para consultar variables")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "La solicitud ha tenido éxito.",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Variable.class)) }),
            @ApiResponse(responseCode = "400", description = "No se pudo interpretar la solicitud debido a una sintaxis inválida.",
                    content = @Content),
            @ApiResponse(responseCode = "401", description = "Petición no autorizada, es necesario autenticar para obtener la respuesta solicitada.",
                    content = @Content),
            @ApiResponse(responseCode = "403", description = "No se poseen los permisos necesarios para la solicitud, por lo que se rechaza la misma.",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "El servidor no puede encontrar el contenido solicitado.",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Error inesperado del sistema",
                    content = @Content)})/*variables Variables*/
    @GetMapping(value = "/variables/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public VariableDTO consultarVariables(@PathVariable int id) {

        pacienteDAO.abrirConexion();
        Variable paciente = pacienteDAO.consultar(id);
        pacienteDAO.cerrarConexion();

        if (paciente != null) {
            VariableDTO pacienteDTO = VariableAssembler.pasearADTO(paciente);
            return pacienteDTO;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se ha encontrado el recuso solicitado");
        }
    }
}
