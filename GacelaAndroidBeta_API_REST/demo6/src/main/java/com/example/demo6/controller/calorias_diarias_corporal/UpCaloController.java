package com.example.demo6.controller.calorias_diarias_corporal;


import com.example.demo6.dto.Calorias_diarias_corporalDTO;
import com.example.demo6.dto.assembler.Calorias_diarias_corporalAssembler;
import gacelapatientApi.GacelaApi.dao.calorias_diarias_corporal.Calorias_diarias_corporalDAO;
import gacelapatientApi.GacelaApi.factory.DAOFactory;
import gacelapatientApi.GacelaApi.model.Calorias_diarias_corporal;

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
public class UpCaloController {
    private DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.ORM);
    private Calorias_diarias_corporalDAO calorias_diarias_corporalDAO = factory.getCalorias_diarias_corporalDAO();

    @Operation(summary = "Endpoint para actualizar registros de Calorias Diarias")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "La solicitud ha tenido éxito.",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Calorias_diarias_corporal.class)) }),
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
    @PutMapping("/caloriasdiarias/{id}")
    public Calorias_diarias_corporalDTO actualizarCaloriasDiarias(@PathVariable int id, @RequestBody Calorias_diarias_corporalDTO dto) {

        if (dto.getCalorias_diarias_corporales_ID() != id) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El identificador no coincide");
        }

        calorias_diarias_corporalDAO.abrirConexion();
        Calorias_diarias_corporal calorias_diarias_corporalBD = calorias_diarias_corporalDAO.consultar(dto.getCalorias_diarias_corporales_ID());
        calorias_diarias_corporalDAO.cerrarConexion();

        if (calorias_diarias_corporalBD == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se ha encontrado el recurso solicitado");
        } else {
            Calorias_diarias_corporal calorias_diarias_corporal = Calorias_diarias_corporalAssembler.pasearDesdeDTO(dto);

            calorias_diarias_corporalDAO.abrirConexion();
            calorias_diarias_corporalDAO.actualizar(calorias_diarias_corporal);
            calorias_diarias_corporalDAO.cerrarConexion();

            return Calorias_diarias_corporalAssembler.pasearADTO(calorias_diarias_corporal);
        }
    }
}
