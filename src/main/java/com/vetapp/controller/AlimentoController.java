package com.vetapp.controller;

import com.vetapp.dto.AlimentoDto;
import com.vetapp.service.AlimentoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
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

    @Autowired
    private AlimentoService alimentoService;

    @PostMapping("")
    @Operation(summary = "Create Alimento", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "201", content = @Content(mediaType = "application/json", schema = @Schema(implementation = AlimentoDto.class)))})
    public ResponseEntity<?> guardarAlimento(@RequestBody AlimentoDto alimentoDto) {
        try {
            AlimentoDto obj = alimentoService.guardarAlimento(alimentoDto);
            return new ResponseEntity(obj, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("")
    @Operation(summary = "Read Alimentos", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = AlimentoDto.class)))})
    public ResponseEntity<?> obtenerAlimentos() {
        try {
            List<AlimentoDto> obj = alimentoService.obtenerAlimentos();
            if (obj.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity(obj, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    @Operation(summary = "Read Alimento", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = AlimentoDto.class)))})
    public ResponseEntity<?> obtenerAlimentoPorId(@PathVariable("id") Long id) {
        try {
            AlimentoDto obj = alimentoService.obtenerAlimentoPorId(id);
            if (obj != null) {
                return new ResponseEntity(obj, HttpStatus.OK);
            } else {
                return new ResponseEntity(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update Alimento", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = AlimentoDto.class)))})
    public ResponseEntity<?> actualizarAlimento(@RequestBody AlimentoDto alimentoDto, @PathVariable("id") Long id) {
        try {
            AlimentoDto obj = alimentoService.actualizarAlimento(alimentoDto, id);
            if (obj != null) {
                return new ResponseEntity(obj, HttpStatus.OK);
            } else {
                return new ResponseEntity(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete Alimento", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = AlimentoDto.class)))})
    public ResponseEntity<AlimentoDto> eliminarAlimento(@PathVariable("id") Long id) {
        try {
            Boolean obj = alimentoService.eliminarAlimento(id);
            if (obj) {
                return new ResponseEntity(obj, HttpStatus.OK);
            } else {
                return new ResponseEntity(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
