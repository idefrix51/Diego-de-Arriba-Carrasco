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
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class InsCaloController {
    private DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.ORM);
    private Calorias_diarias_corporalDAO calorias_diarias_corporalDAO = factory.getCalorias_diarias_corporalDAO();

    @Operation(summary = "Endpoint para insertar registros de Calorias Diarias")
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
    @PostMapping("/caloriasdiarias")
    public ResponseEntity<Calorias_diarias_corporalDTO> insertarCaloriasDiarias(@RequestBody Calorias_diarias_corporalDTO dto) throws Exception {

        Calorias_diarias_corporal calorias_diarias_corporal = Calorias_diarias_corporalAssembler.pasearDesdeDTO(dto);

        calorias_diarias_corporalDAO.abrirConexion();
        calorias_diarias_corporalDAO.insertar(calorias_diarias_corporal);
        calorias_diarias_corporalDAO.cerrarConexion();

        return new ResponseEntity<>(Calorias_diarias_corporalAssembler.pasearADTO(calorias_diarias_corporal), HttpStatus.CREATED);
    }
}
