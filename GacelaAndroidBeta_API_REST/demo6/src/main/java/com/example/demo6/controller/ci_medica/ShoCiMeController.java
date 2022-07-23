package com.example.demo6.controller.ci_medica;

import com.example.demo6.dto.Ci_medicaDTO;
import com.example.demo6.dto.assembler.Ci_medicaAssembler;
import gacelapatientApi.GacelaApi.dao.ci_medica.Ci_medicaDAO;
import gacelapatientApi.GacelaApi.factory.DAOFactory;
import gacelapatientApi.GacelaApi.model.Ci_medica;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class ShoCiMeController {
    private DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.ORM);
    private Ci_medicaDAO pacienteDAO = factory.getCi_medicaDAO();

    @Operation(summary = "Endpoint para listar las citas medicas")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "La solicitud ha tenido éxito.",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Ci_medica.class)) }),
            @ApiResponse(responseCode = "400", description = "No se pudo interpretar la solicitud debido a una sintaxis inválida.",
                    content = @Content),
            @ApiResponse(responseCode = "401", description = "Petición no autorizada, es necesario autenticar para obtener la respuesta solicitada.",
                    content = @Content),
            @ApiResponse(responseCode = "403", description = "No se poseen los permisos necesarios para la solicitud, por lo que se rechaza la misma.",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "El servidor no puede encontrar el contenido solicitado.",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Error inesperado del sistema",
                    content = @Content)})/*citasMedicas  CitasMedicas*/
    @GetMapping(value = "/citasMedicas", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Ci_medicaDTO> listarCitasMedicas() {

        pacienteDAO.abrirConexion();
        List<Ci_medica> lista = pacienteDAO.listar();
        pacienteDAO.cerrarConexion();

        List<Ci_medicaDTO> listaDTO = new ArrayList<>();
        for (Ci_medica paciente : lista) {
            Ci_medicaDTO pacienteDTO = Ci_medicaAssembler.pasearADTO(paciente);
            listaDTO.add(pacienteDTO);
        }

        return listaDTO;
    }
}
