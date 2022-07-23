package com.example.demo6.controller.mediPaciente;


import com.example.demo6.dto.MediPacienteDTO;
import com.example.demo6.dto.assembler.MediPacienteAssembler;
import gacelapatientApi.GacelaApi.dao.mediPaciente.MediPacienteDAO;
import gacelapatientApi.GacelaApi.factory.DAOFactory;


import gacelapatientApi.GacelaApi.model.MediPaciente;
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
public class InsMePaController {
    private DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.ORM);
    private MediPacienteDAO pacienteDAO = factory.getMediPacienteDAO();

    @Operation(summary = "Endpoint para insertar relaciones entre pacientes y medicamentos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "La solicitud ha tenido éxito.",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = MediPaciente.class)) }),
            @ApiResponse(responseCode = "400", description = "No se pudo interpretar la solicitud debido a una sintaxis inválida.",
                    content = @Content),
            @ApiResponse(responseCode = "401", description = "Petición no autorizada, es necesario autenticar para obtener la respuesta solicitada.",
                    content = @Content),
            @ApiResponse(responseCode = "403", description = "No se poseen los permisos necesarios para la solicitud, por lo que se rechaza la misma.",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "El servidor no puede encontrar el contenido solicitado.",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Error inesperado del sistema",
                    content = @Content)})/*mediPacientes MediPacientes*/
    @PostMapping("/mediPacientes")
    public ResponseEntity<MediPacienteDTO> insertarMediPacientes(@RequestBody MediPacienteDTO dto) throws Exception {

        MediPaciente paciente = MediPacienteAssembler.pasearDesdeDTO(dto);

        pacienteDAO.abrirConexion();
        pacienteDAO.insertar(paciente);
        pacienteDAO.cerrarConexion();

        return new ResponseEntity<>(MediPacienteAssembler.pasearADTO(paciente), HttpStatus.CREATED);
    }
}
