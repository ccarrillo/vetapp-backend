package com.vetapp.controller;

import com.vetapp.dto.IngredientesDTO;
import com.vetapp.dto.InsumoDTO;
import com.vetapp.service.InsumoService;
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
@RequestMapping("/insumo")
@CrossOrigin
@Tag(name = "insumo")
public class InsumoController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private InsumoService insumoService;

    @PostMapping("")
    @Operation(summary = "Create Insumo", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "201", content = @Content(mediaType = "application/json", schema = @Schema(implementation = InsumoDTO.class)))})
    public ResponseEntity<?> guardarInsumo(@RequestBody InsumoDTO insumoDTO) {
        try {
            InsumoDTO obj = insumoService.guardarInsumo(insumoDTO);
            return new ResponseEntity(obj, HttpStatus.CREATED);
        } catch (Exception e) {
            logger.error(e.getLocalizedMessage());
            return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("")
    @Operation(summary = "Read Insumos", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = InsumoDTO.class)))})
    public ResponseEntity<?> obtenerInsumos() {
        try {
            List<InsumoDTO> obj = insumoService.obtenerInsumos();
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
    @Operation(summary = "Read Insumo", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = InsumoDTO.class)))})
    public ResponseEntity<?> obtenerInsumoPorId(@PathVariable("id") Long id) {
        try {
            InsumoDTO obj = insumoService.obtenerInsumoPorId(id);
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
    @Operation(summary = "Update Insumo", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = InsumoDTO.class)))})
    public ResponseEntity<?> actualizarInsumo(@RequestBody InsumoDTO insumoDTO, @PathVariable("id") Long id) {
        try {
            InsumoDTO obj = insumoService.actualizarInsumo(insumoDTO, id);
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
    @Operation(summary = "Delete Insumo", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = InsumoDTO.class)))})
    public ResponseEntity<InsumoDTO> eliminarInsumo(@PathVariable("id") Long id) {
        try {
            Boolean obj = insumoService.eliminarInsumo(id);
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

    @GetMapping("/categoriaFormula/{categoriaFormulaId}")
    @Operation(summary = "Read Insumo", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = InsumoDTO.class)))})
    public ResponseEntity<?> obtenerInsumoPorCategoriaFormulaId(@PathVariable("categoriaFormulaId") Long categoriaFormulaId) {
        try {
            List<InsumoDTO> obj = insumoService.obtenerInsumoPorCategoriaFormulaId(categoriaFormulaId);
            if (obj.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity(obj, HttpStatus.OK);
        } catch (Exception e) {
            logger.error(e.getLocalizedMessage());
            return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
