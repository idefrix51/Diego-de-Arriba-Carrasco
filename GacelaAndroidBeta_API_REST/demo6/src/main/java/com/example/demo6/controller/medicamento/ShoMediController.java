package com.example.demo6.controller.medicamento;


import com.example.demo6.dto.MedicamentoDTO;
import com.example.demo6.dto.assembler.MedicamentoAssembler;
import gacelapatientApi.GacelaApi.dao.medicamento.MedicamentoDAO;
import gacelapatientApi.GacelaApi.factory.DAOFactory;
import gacelapatientApi.GacelaApi.model.Medicamento;

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
public class ShoMediController {
    private DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.ORM);
    private MedicamentoDAO pacienteDAO = factory.getMedicamentoDAO();

    @Operation(summary = "Endpoint para listar los medicamentos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "La solicitud ha tenido éxito.",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Medicamento.class)) }),
            @ApiResponse(responseCode = "400", description = "No se pudo interpretar la solicitud debido a una sintaxis inválida.",
                    content = @Content),
            @ApiResponse(responseCode = "401", description = "Petición no autorizada, es necesario autenticar para obtener la respuesta solicitada.",
                    content = @Content),
            @ApiResponse(responseCode = "403", description = "No se poseen los permisos necesarios para la solicitud, por lo que se rechaza la misma.",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "El servidor no puede encontrar el contenido solicitado.",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Error inesperado del sistema",
                    content = @Content)})/*medicamentos Medicamentos*/
    @GetMapping(value = "/medicamentos", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<MedicamentoDTO> listarMedicamentos() {

        pacienteDAO.abrirConexion();
        List<Medicamento> lista = pacienteDAO.listar();
        pacienteDAO.cerrarConexion();

        List<MedicamentoDTO> listaDTO = new ArrayList<>();
        for (Medicamento paciente : lista) {
            MedicamentoDTO pacienteDTO = MedicamentoAssembler.pasearADTO(paciente);
            listaDTO.add(pacienteDTO);
        }

        return listaDTO;
    }
}
