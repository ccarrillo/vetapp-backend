package com.vetapp.controller;

import com.vetapp.dto.CategoriaFormulaDTO;
import com.vetapp.service.CategoriaFormulaService;
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
@RequestMapping("/categoriaFormula")
@CrossOrigin
@Tag(name = "categoriaFormula")
public class CategoriaFormulaController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CategoriaFormulaService categoriaFormulaService;

    @PostMapping("")
    @Operation(summary = "Create CategoriaFormula", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "201", content = @Content(mediaType = "application/json", schema = @Schema(implementation = CategoriaFormulaDTO.class)))})
    public ResponseEntity<?> guardarCategoriaFormula(@RequestBody CategoriaFormulaDTO categoriaFormulaDTO) {
        try {
            CategoriaFormulaDTO obj = categoriaFormulaService.guardarCategoriaFormula(categoriaFormulaDTO);
            return new ResponseEntity(obj, HttpStatus.CREATED);
        } catch (Exception e) {
            logger.error(e.getLocalizedMessage());
            return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("")
    @Operation(summary = "Read CategoriaFormula", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = CategoriaFormulaDTO.class)))})
    public ResponseEntity<?> obtenerCategoriaFormulas() {
        try {
            List<CategoriaFormulaDTO> obj = categoriaFormulaService.obtenerCategoriaFormulas();
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
    @Operation(summary = "Read CategoriaFormula", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = CategoriaFormulaDTO.class)))})
    public ResponseEntity<?> obtenerCategoriaFormulaPorId(@PathVariable("id") Long id) {
        try {
            CategoriaFormulaDTO obj = categoriaFormulaService.obtenerCategoriaFormulaPorId(id);
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
    @Operation(summary = "Update CategoriaFormula", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = CategoriaFormulaDTO.class)))})
    public ResponseEntity<?> actualizarCategoriaFormula(@RequestBody CategoriaFormulaDTO categoriaFormulaDTO, @PathVariable("id") Long id) {
        try {
            CategoriaFormulaDTO obj = categoriaFormulaService.actualizarCategoriaFormula(categoriaFormulaDTO, id);
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
    @Operation(summary = "Delete CategoriaFormula", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = CategoriaFormulaDTO.class)))})
    public ResponseEntity<CategoriaFormulaDTO> eliminarCategoriaFormula(@PathVariable("id") Long id) {
        try {
            Boolean obj = categoriaFormulaService.eliminarCategoriaFormula(id);
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
