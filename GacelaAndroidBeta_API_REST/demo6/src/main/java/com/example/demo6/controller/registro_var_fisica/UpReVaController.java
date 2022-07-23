package com.example.demo6.controller.registro_var_fisica;

import com.example.demo6.dto.Registro_var_fisicaDTO;
import com.example.demo6.dto.assembler.Registro_var_fisicaAssembler;
import gacelapatientApi.GacelaApi.dao.registro_var_fisica.Registro_var_fisicaDAO;
import gacelapatientApi.GacelaApi.factory.DAOFactory;

import gacelapatientApi.GacelaApi.model.Registro_var_fisica;
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
public class UpReVaController {
    private DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.ORM);
    private Registro_var_fisicaDAO registro_var_fisicaDAO = factory.getRegistro_var_fisicaDAO();

    @Operation(summary = "Endpoint para actualizar registros de variables fisicas")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "La solicitud ha tenido éxito.",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Registro_var_fisica.class)) }),
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
    @PutMapping("/registroVaFisicas/{id}")
    public Registro_var_fisicaDTO actualizarRegistrosVariablesFisicas(@PathVariable int id, @RequestBody Registro_var_fisicaDTO dto) {

        if (dto.getRegistro_var_fisica_ID() != id) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El identificador no coincide");
        }

        registro_var_fisicaDAO.abrirConexion();
        Registro_var_fisica pacienteBD = registro_var_fisicaDAO.consultar(dto.getRegistro_var_fisica_ID());
        registro_var_fisicaDAO.cerrarConexion();

        if (pacienteBD == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se ha encontrado el recurso solicitado");
        } else {
            Registro_var_fisica paciente = Registro_var_fisicaAssembler.pasearDesdeDTO(dto);

            registro_var_fisicaDAO.abrirConexion();
            registro_var_fisicaDAO.actualizar(paciente);
            registro_var_fisicaDAO.cerrarConexion();

            return Registro_var_fisicaAssembler.pasearADTO(paciente);
        }
    }
}
