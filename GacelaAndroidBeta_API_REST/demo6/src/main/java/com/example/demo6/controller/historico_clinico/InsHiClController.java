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
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class InsHiClController {
    private DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.ORM);
    private Historico_clinicoDAO pacienteDAO = factory.getHistorico_clinicoDAO();

    @Operation(summary = "Endpoint para insertar historicos clinicos")
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
    @PostMapping("/historicosClinicos")
    public ResponseEntity<Historico_clinicoDTO> insertarHistoricosClinicos(@RequestBody Historico_clinicoDTO dto) throws Exception {

        Historico_clinico paciente = Historico_clinicoAssembler.pasearDesdeDTO(dto);

        pacienteDAO.abrirConexion();
        pacienteDAO.insertar(paciente);
        pacienteDAO.cerrarConexion();

        return new ResponseEntity<>(Historico_clinicoAssembler.pasearADTO(paciente), HttpStatus.CREATED);
    }
}
