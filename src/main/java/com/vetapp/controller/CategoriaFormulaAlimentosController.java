package com.vetapp.controller;

import com.vetapp.dto.FormulaDTO;
import com.vetapp.dto.CategoriaFormulaAlimentosDTO;
import com.vetapp.service.CategoriaFormulaAlimentosService;
import com.vetapp.service.FormulaService;
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
@RequestMapping("/catForAlimentos")
@CrossOrigin
@Tag(name = "categoriaFormulaAlimentos")
public class CategoriaFormulaAlimentosController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CategoriaFormulaAlimentosService categoriaFormulaAlimentosService;

    @Autowired
    private FormulaService formulaService;

    @PostMapping("")
    @Operation(summary = "Create CategoriaFormulaAlimentos", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "201", content = @Content(mediaType = "application/json", schema = @Schema(implementation = CategoriaFormulaAlimentosDTO.class)))})
    public ResponseEntity<?> guardarCategoriaFormulaAlimentos(@RequestBody CategoriaFormulaAlimentosDTO repartoDTO) {
        try {
            CategoriaFormulaAlimentosDTO obj = categoriaFormulaAlimentosService.guardarCategoriaFormulaAlimentos(repartoDTO);
            return new ResponseEntity(obj, HttpStatus.CREATED);
        } catch (Exception e) {
            logger.error(e.getLocalizedMessage());
            return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("")
    @Operation(summary = "Read CategoriaFormulaAlimentoss", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = CategoriaFormulaAlimentosDTO.class)))})
    public ResponseEntity<?> obtenerCategoriaFormulaAlimentoss() {
        try {
            List<CategoriaFormulaAlimentosDTO> obj = categoriaFormulaAlimentosService.obtenerCategoriaFormulaAlimentos();
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
    @Operation(summary = "Read CategoriaFormulaAlimentos", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = CategoriaFormulaAlimentosDTO.class)))})
    public ResponseEntity<?> obtenerCategoriaFormulaAlimentosPorId(@PathVariable("id") Long id) {
        try {
            CategoriaFormulaAlimentosDTO obj = categoriaFormulaAlimentosService.obtenerCategoriaFormulaAlimentosPorId(id);
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
    @Operation(summary = "Update CategoriaFormulaAlimentos", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = CategoriaFormulaAlimentosDTO.class)))})
    public ResponseEntity<?> actualizarCategoriaFormulaAlimentos(@RequestBody CategoriaFormulaAlimentosDTO repartoDTO, @PathVariable("id") Long id) {
        try {
            CategoriaFormulaAlimentosDTO obj = categoriaFormulaAlimentosService.actualizarCategoriaFormulaAlimentos(repartoDTO, id);
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
    @Operation(summary = "Delete CategoriaFormulaAlimentos", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = CategoriaFormulaAlimentosDTO.class)))})
    public ResponseEntity<CategoriaFormulaAlimentosDTO> eliminarCategoriaFormulaAlimentos(@PathVariable("id") Long id) {
        try {
            Boolean obj = categoriaFormulaAlimentosService.eliminarCategoriaFormulaAlimentos(id);
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

    @GetMapping("/formula/{formulaId}")
    @Operation(summary = "Read CategoriaFormulaAlimentoss", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = CategoriaFormulaAlimentosDTO.class)))})
    public ResponseEntity<?> obtenerCategoriaFormulaAlimentosPorCategoriaFormulaId(@PathVariable("formulaId") Long formulaId) {
        try {
            List<CategoriaFormulaAlimentosDTO> obj = categoriaFormulaAlimentosService.obtenerCategoriaFormulaAlimentosPorCategoriaFormulaId(formulaId);
            if (obj.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity(obj, HttpStatus.OK);
        } catch (Exception e) {
            logger.error(e.getLocalizedMessage());
            return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/formula/{formulaId}")
    @Operation(summary = "Create CategoriaFormulaAlimentos", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "201", content = @Content(mediaType = "application/json", schema = @Schema(implementation = CategoriaFormulaAlimentosDTO.class)))})
    public ResponseEntity<?> guardarCategoriaFormulaAlimentos(@PathVariable("formulaId") Long formulaId, @RequestBody CategoriaFormulaAlimentosDTO repartoDTO) {
        try {
            FormulaDTO objFormula = formulaService.obtenerFormulaPorId(formulaId);
            if (objFormula == null) {
                return new ResponseEntity(HttpStatus.NOT_FOUND);
            }
            CategoriaFormulaAlimentosDTO obj = categoriaFormulaAlimentosService.guardarCategoriaFormulaAlimentos(formulaId, repartoDTO);
            return new ResponseEntity(obj, HttpStatus.CREATED);
        } catch (Exception e) {
            logger.error(e.getLocalizedMessage());
            return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{repartoId}/formula/{formulaId}")
    @Operation(summary = "Update CategoriaFormulaAlimentos", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = CategoriaFormulaAlimentosDTO.class)))})
    public ResponseEntity<?> actualizarCategoriaFormulaAlimentos(@PathVariable("formulaId") Long formulaId, @PathVariable("repartoId") Long repartoId, @RequestBody CategoriaFormulaAlimentosDTO repartoDTO) {
        try {
            FormulaDTO objFormula = formulaService.obtenerFormulaPorId(formulaId);
            if (objFormula == null) {
                return new ResponseEntity(HttpStatus.NOT_FOUND);
            }
            CategoriaFormulaAlimentosDTO obj = categoriaFormulaAlimentosService.actualizarCategoriaFormulaAlimentos(formulaId, repartoId, repartoDTO);
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

    @DeleteMapping("/{repartoId}/formula/{formulaId}")
    @Operation(summary = "Delete CategoriaFormulaAlimentos", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = CategoriaFormulaAlimentosDTO.class)))})
    public ResponseEntity<CategoriaFormulaAlimentosDTO> eliminarCategoriaFormulaAlimentos(@PathVariable("formulaId") Long formulaId, @PathVariable("repartoId") Long repartoId) {
        try {
            Boolean obj = categoriaFormulaAlimentosService.eliminarCategoriaFormulaAlimentos(formulaId, repartoId);
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
