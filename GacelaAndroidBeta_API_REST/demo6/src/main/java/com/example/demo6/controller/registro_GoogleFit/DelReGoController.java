package com.example.demo6.controller.registro_GoogleFit;


import gacelapatientApi.GacelaApi.dao.registro_GoogleFit.Registro_GoogleFitDAO;
import gacelapatientApi.GacelaApi.factory.DAOFactory;

import gacelapatientApi.GacelaApi.model.Registro_GoogleFit;
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
public class DelReGoController {
    private DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.ORM);
    private Registro_GoogleFitDAO pacienteDAO = factory.getRegistro_GoogleFitDAO();

    @Operation(summary = "Endpoint para eliminar registros de GoogleFit")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "La solicitud ha tenido éxito.",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Registro_GoogleFit.class)) }),
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
    @DeleteMapping(value = "/registroGoogle/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public void eliminarRegistroGoogleFit(@PathVariable int id) {

        pacienteDAO.abrirConexion();
        Registro_GoogleFit paciente = pacienteDAO.consultar(id);
        pacienteDAO.cerrarConexion();

        if (paciente == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se ha encontrado el recurso solicitado");
        } else {
            pacienteDAO.abrirConexion();
            pacienteDAO.eliminar(id);
            pacienteDAO.cerrarConexion();
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }

    }
}
