package com.example.demo6.controller.historico_dosis;


import com.example.demo6.dto.Historico_dosisDTO;
import com.example.demo6.dto.assembler.Historico_dosisAssembler;
import gacelapatientApi.GacelaApi.dao.historico_dosis.Historico_dosisDAO;
import gacelapatientApi.GacelaApi.factory.DAOFactory;
import gacelapatientApi.GacelaApi.model.Historico_dosis;

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
public class SelHiDoController {
    private DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.ORM);
    private Historico_dosisDAO pacienteDAO = factory.getHistorico_dosisDAO();

    @Operation(summary = "Endpoint para consultar historicos de dosis")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "La solicitud ha tenido éxito.",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Historico_dosis.class)) }),
            @ApiResponse(responseCode = "400", description = "No se pudo interpretar la solicitud debido a una sintaxis inválida.",
                    content = @Content),
            @ApiResponse(responseCode = "401", description = "Petición no autorizada, es necesario autenticar para obtener la respuesta solicitada.",
                    content = @Content),
            @ApiResponse(responseCode = "403", description = "No se poseen los permisos necesarios para la solicitud, por lo que se rechaza la misma.",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "El servidor no puede encontrar el contenido solicitado.",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Error inesperado del sistema",
                    content = @Content)})/*historicosDosis HistoricosDosis*/
    @GetMapping(value = "/historicosDosis/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public Historico_dosisDTO consultarHistoricosDosis(@PathVariable int id) {

        pacienteDAO.abrirConexion();
        Historico_dosis paciente = pacienteDAO.consultar(id);
        pacienteDAO.cerrarConexion();

        if (paciente != null) {
            Historico_dosisDTO pacienteDTO = Historico_dosisAssembler.pasearADTO(paciente);
            return pacienteDTO;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se ha encontrado el recuso solicitado");
        }
    }
}
