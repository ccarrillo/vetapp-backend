package com.vetapp.controller;

import com.vetapp.dto.AlimentoDTO;
import com.vetapp.service.AlimentoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alimento")
@CrossOrigin
@Tag(name = "alimento")
public class AlimentoController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AlimentoService alimentoService;

    @PostMapping("")
    @Operation(summary = "Create Alimento", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "201", content = @Content(mediaType = "application/json", schema = @Schema(implementation = AlimentoDTO.class)))})
    public ResponseEntity<?> guardarAlimento(@RequestBody AlimentoDTO alimentoDto) {
        try {
            AlimentoDTO obj = alimentoService.guardarAlimento(alimentoDto);
            return new ResponseEntity(obj, HttpStatus.CREATED);
        } catch (Exception e) {
            logger.error(e.getLocalizedMessage());
            return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("")
    @Operation(summary = "Read Alimentos", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = AlimentoDTO.class)))})
    public ResponseEntity<?> obtenerAlimentos() {
        try {
            List<AlimentoDTO> obj = alimentoService.obtenerAlimentos();
            if (obj.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity(obj, HttpStatus.OK);
        } catch (Exception e) {
            logger.error(e.getLocalizedMessage());
            return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    @Operation(summary = "Read Alimento", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = AlimentoDTO.class)))})
    public ResponseEntity<?> obtenerAlimentoPorId(@PathVariable("id") Long id) {
        try {
            AlimentoDTO obj = alimentoService.obtenerAlimentoPorId(id);
            if (obj != null) {
                return new ResponseEntity(obj, HttpStatus.OK);
            } else {
                return new ResponseEntity(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            logger.error(e.getLocalizedMessage());
            return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update Alimento", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = AlimentoDTO.class)))})
    public ResponseEntity<?> actualizarAlimento(@RequestBody AlimentoDTO alimentoDto, @PathVariable("id") Long id) {
        try {
            AlimentoDTO obj = alimentoService.actualizarAlimento(alimentoDto, id);
            if (obj != null) {
                return new ResponseEntity(obj, HttpStatus.OK);
            } else {
                return new ResponseEntity(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            logger.error(e.getLocalizedMessage());
            return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete Alimento", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = AlimentoDTO.class)))})
    public ResponseEntity<AlimentoDTO> eliminarAlimento(@PathVariable("id") Long id) {
        try {
            Boolean obj = alimentoService.eliminarAlimento(id);
            if (obj) {
                return new ResponseEntity(obj, HttpStatus.OK);
            } else {
                return new ResponseEntity(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            logger.error(e.getLocalizedMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
