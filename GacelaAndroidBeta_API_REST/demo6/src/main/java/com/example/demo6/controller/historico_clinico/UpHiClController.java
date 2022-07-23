package com.example.demo6.controller.historico_clinico;

import com.example.demo6.dto.Historico_clinicoDTO;
import com.example.demo6.dto.assembler.Historico_clinicoAssembler;
import gacelapatientApi.GacelaApi.dao.historico_clinico.Historico_clinicoDAO;
import gacelapatientApi.GacelaApi.factory.DAOFactory;
import gacelapatientApi.GacelaApi.model.Historico_clinico;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class UpHiClController {
    private DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.ORM);
    private Historico_clinicoDAO pacienteDAO = factory.getHistorico_clinicoDAO();

    @Operation(summary = "Endpoint para actualizar los historicos clinicos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "La solicitud ha tenido éxito.",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Historico_clinico.class)) }),
            @ApiResponse(responseCode = "400", description = "No se pudo interpretar la solicitud debido a una sintaxis inválida.",
                    content = @Content),
            @ApiResponse(responseCode = "401", description = "Petición no autorizada, es necesario autenticar para obtener la respuesta solicitada.",
                    content = @Content),
            @ApiResponse(responseCode = "403", description = "No se poseen los permisos necesarios para la solicitud, por lo que se rechaza la misma.",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "El servidor no puede encontrar el contenido solicitado.",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Error inesperado del sistema",
                    content = @Content)})/*historicosClinicos HistoricosClinicos*/
    @PutMapping("/historicosClinicos/{id}")
    public Historico_clinicoDTO actualizarHistoricosClinicos(@PathVariable int id, @RequestBody Historico_clinicoDTO dto) {

        if (dto.getHisto_clinicos_ID() != id) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El identificador no coincide");
        }

        pacienteDAO.abrirConexion();
        Historico_clinico pacienteBD = pacienteDAO.consultar(dto.getHisto_clinicos_ID());
        pacienteDAO.cerrarConexion();

        if (pacienteBD == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se ha encontrado el recurso solicitado");
        } else {
            Historico_clinico paciente = Historico_clinicoAssembler.pasearDesdeDTO(dto);

            pacienteDAO.abrirConexion();
            pacienteDAO.actualizar(paciente);
            pacienteDAO.cerrarConexion();

            return Historico_clinicoAssembler.pasearADTO(paciente);
        }
    }
}
