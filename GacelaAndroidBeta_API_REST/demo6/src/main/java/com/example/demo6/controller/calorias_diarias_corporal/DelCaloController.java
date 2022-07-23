package com.example.demo6.controller.calorias_diarias_corporal;


import gacelapatientApi.GacelaApi.dao.calorias_diarias_corporal.Calorias_diarias_corporalDAO;
import gacelapatientApi.GacelaApi.factory.DAOFactory;

import gacelapatientApi.GacelaApi.model.Calorias_diarias_corporal;
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
public class DelCaloController {
    private DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.ORM);
    private Calorias_diarias_corporalDAO calorias_diarias_corporalDAO = factory.getCalorias_diarias_corporalDAO();

    @Operation(summary = "Endpoint para eliminar registros de Calorias Diarias")
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
    @DeleteMapping(value = "/caloriasdiarias/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public void eliminarCaloriasDiarias(@PathVariable int id) {

        calorias_diarias_corporalDAO.abrirConexion();
        Calorias_diarias_corporal calorias_diarias_corporal = calorias_diarias_corporalDAO.consultar(id);
        calorias_diarias_corporalDAO.cerrarConexion();

        if (calorias_diarias_corporal == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se ha encontrado el recurso solicitado");
        } else {
            calorias_diarias_corporalDAO.abrirConexion();
            calorias_diarias_corporalDAO.eliminar(id);
            calorias_diarias_corporalDAO.cerrarConexion();
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }

    }
}
