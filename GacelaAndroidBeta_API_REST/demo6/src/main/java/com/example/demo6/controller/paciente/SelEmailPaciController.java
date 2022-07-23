package com.example.demo6.controller.paciente;

import com.example.demo6.dto.LoginDTO;
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
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class SelEmailPaciController {
    private DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.ORM);
    private PacienteDAO pacienteDAO = factory.getPacienteDAO();

    @Operation(summary = "Endpoint para seleccionar pacientes en base a su email y password")
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
    @PostMapping(value = "/loginEmailPassword", produces = {MediaType.APPLICATION_JSON_VALUE})
    public PacienteDTO consultarPacienteEmail(@RequestBody LoginDTO dto) {



        Paciente paciente = new Paciente();
        pacienteDAO.abrirConexion();

        if(dto.getNif()==null){
         paciente = pacienteDAO.consultarEmailpasword(dto.getEmail(), dto.getPassword());
        }
        if(dto.getEmail()==null){
         paciente = pacienteDAO.consultarNIFpasword(dto.getNif(), dto.getPassword());
        }
        if(dto.getNif()!=null & dto.getEmail() != null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "solo puedes insertar o email o nif, no los dos a la vez");
        }

        pacienteDAO.cerrarConexion();

        if (paciente != null) {

            if (!dto.getPassword().equals(paciente.getPassword())) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Datos no válidos");
            }

            PacienteDTO pacienteDTO = PacienteAssembler.pasearADTO(paciente);
            return pacienteDTO;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Datos no válidos");
        }
    }

}
