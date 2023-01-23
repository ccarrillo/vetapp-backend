package com.vetapp.controller;

import com.vetapp.dto.CategoriaFormulaInsumoDTO;
import com.vetapp.service.CategoriaFormulaInsumoService;
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
@RequestMapping("/categoriaFormulaInsumo")
@CrossOrigin
@Tag(name = "categoriaFormulaInsumo")
public class CategoriaFormulaInsumoController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CategoriaFormulaInsumoService categoriaFormulaInsumoService;

    @PostMapping("")
    @Operation(summary = "Create CategoriaFormulaInsumo", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "201", content = @Content(mediaType = "application/json", schema = @Schema(implementation = CategoriaFormulaInsumoDTO.class)))})
    public ResponseEntity<?> guardarCategoriaFormulaInsumo(@RequestBody CategoriaFormulaInsumoDTO categoriaFormulaInsumoDTO) {
        try {
            CategoriaFormulaInsumoDTO obj = categoriaFormulaInsumoService.guardarCategoriaFormulaInsumo(categoriaFormulaInsumoDTO);
            return new ResponseEntity(obj, HttpStatus.CREATED);
        } catch (Exception e) {
            logger.error(e.getLocalizedMessage());
            return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("")
    @Operation(summary = "Read CategoriaFormulaInsumo", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = CategoriaFormulaInsumoDTO.class)))})
    public ResponseEntity<?> obtenerCategoriaFormulaInsumos() {
        try {
            List<CategoriaFormulaInsumoDTO> obj = categoriaFormulaInsumoService.obtenerCategoriaFormulaInsumos();
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
    @Operation(summary = "Read CategoriaFormulaInsumo", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = CategoriaFormulaInsumoDTO.class)))})
    public ResponseEntity<?> obtenerCategoriaFormulaPorId(@PathVariable("id") Long id) {
        try {
            CategoriaFormulaInsumoDTO obj = categoriaFormulaInsumoService.obtenerCategoriaFormulaInsumoPorId(id);
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
    @Operation(summary = "Update CategoriaFormulaInsumo", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = CategoriaFormulaInsumoDTO.class)))})
    public ResponseEntity<?> actualizarCategoriaFormulaInsumo(@RequestBody CategoriaFormulaInsumoDTO categoriaFormulaInsumoDTO, @PathVariable("id") Long id) {
        try {
            CategoriaFormulaInsumoDTO obj = categoriaFormulaInsumoService.actualizarCategoriaFormulaInsumo(categoriaFormulaInsumoDTO, id);
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
    @Operation(summary = "Delete CategoriaFormulaInsumo", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = CategoriaFormulaInsumoDTO.class)))})
    public ResponseEntity<CategoriaFormulaInsumoDTO> eliminarCategoriaFormulaInsumo(@PathVariable("id") Long id) {
        try {
            Boolean obj = categoriaFormulaInsumoService.eliminarCategoriaFormulaInsumo(id);
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
    @Operation(summary = "Read CategoriaFormulaInsumos", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = CategoriaFormulaInsumoDTO.class)))})
    public ResponseEntity<?> obtenerCategoriaFormulaInsumoPorCategoriaFormulaId(@PathVariable("categoriaFormulaId") Long categoriaFormulaId) {
        try {
            List<CategoriaFormulaInsumoDTO> obj = categoriaFormulaInsumoService.obtenerCategoriaFormulaInsumoPorCategoriaFormulaId(categoriaFormulaId);
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
