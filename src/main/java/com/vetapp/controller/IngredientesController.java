package com.vetapp.controller;

import com.vetapp.dto.FormulaDTO;
import com.vetapp.dto.IngredientesDTO;
import com.vetapp.service.FormulaService;
import com.vetapp.service.IngredientesService;
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
@RequestMapping("/ingredientes")
@CrossOrigin
@Tag(name = "ingredientes")
public class IngredientesController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private FormulaService formulaService;

    @Autowired
    private IngredientesService ingredientesService;

    @PostMapping("")
    @Operation(summary = "Create Ingredientes", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "201", content = @Content(mediaType = "application/json", schema = @Schema(implementation = IngredientesDTO.class)))})
    public ResponseEntity<?> guardarIngredientes(@RequestBody IngredientesDTO ingredientesDTO) {
        try {
            IngredientesDTO obj = ingredientesService.guardarIngredientes(ingredientesDTO);
            return new ResponseEntity(obj, HttpStatus.CREATED);
        } catch (Exception e) {
            logger.error(e.getLocalizedMessage());
            return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("")
    @Operation(summary = "Read Ingredientess", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = IngredientesDTO.class)))})
    public ResponseEntity<?> obtenerIngredientess() {
        try {
            List<IngredientesDTO> obj = ingredientesService.obtenerIngredientess();
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
    @Operation(summary = "Read Ingredientes", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = IngredientesDTO.class)))})
    public ResponseEntity<?> obtenerIngredientesPorId(@PathVariable("id") Long id) {
        try {
            IngredientesDTO obj = ingredientesService.obtenerIngredientesPorId(id);
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
    @Operation(summary = "Update Ingredientes", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = IngredientesDTO.class)))})
    public ResponseEntity<?> actualizarIngredientes(@RequestBody IngredientesDTO ingredientesDTO, @PathVariable("id") Long id) {
        try {
            IngredientesDTO obj = ingredientesService.actualizarIngredientes(ingredientesDTO, id);
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
    @Operation(summary = "Delete Ingredientes", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = IngredientesDTO.class)))})
    public ResponseEntity<IngredientesDTO> eliminarIngredientes(@PathVariable("id") Long id) {
        try {
            Boolean obj = ingredientesService.eliminarIngredientes(id);
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
    @Operation(summary = "Read Ingredientess", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = IngredientesDTO.class)))})
    public ResponseEntity<?> obtenerIngredientesPorFormulaId(@PathVariable("formulaId") Long formulaId) {
        try {
            List<IngredientesDTO> obj = ingredientesService.obtenerIngredientesPorFormulaId(formulaId);
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
    @Operation(summary = "Create Ingredientes", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "201", content = @Content(mediaType = "application/json", schema = @Schema(implementation = IngredientesDTO.class)))})
    public ResponseEntity<?> guardarIngredientes(@PathVariable("formulaId") Long formulaId, @RequestBody IngredientesDTO ingredientesDTO) {
        try {
            FormulaDTO objFormula = formulaService.obtenerFormulaPorId(formulaId);
            if (objFormula == null) {
                return new ResponseEntity(HttpStatus.NOT_FOUND);
            }
            IngredientesDTO obj = ingredientesService.guardarIngredientes(formulaId, ingredientesDTO);
            return new ResponseEntity(obj, HttpStatus.CREATED);
        } catch (Exception e) {
            logger.error(e.getLocalizedMessage());
            return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{ingredientesId}/formula/{formulaId}")
    @Operation(summary = "Update Ingredientes", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = IngredientesDTO.class)))})
    public ResponseEntity<?> actualizarIngredientes(@PathVariable("formulaId") Long formulaId, @PathVariable("ingredientesId") Long ingredientesId, @RequestBody IngredientesDTO ingredientesDTO) {
        try {
            FormulaDTO objFormula = formulaService.obtenerFormulaPorId(formulaId);
            if (objFormula == null) {
                return new ResponseEntity(HttpStatus.NOT_FOUND);
            }
            IngredientesDTO obj = ingredientesService.actualizarIngredientes(formulaId, ingredientesId, ingredientesDTO);
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

    @DeleteMapping("/{ingredientesId}/formula/{formulaId}")
    @Operation(summary = "Delete Ingredientes", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = IngredientesDTO.class)))})
    public ResponseEntity<IngredientesDTO> eliminarIngredientes(@PathVariable("formulaId") Long formulaId, @PathVariable("ingredientesId") Long ingredientesId) {
        try {
            Boolean obj = ingredientesService.eliminarIngredientes(formulaId, ingredientesId);
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

    @GetMapping("/masivo/formula/{formulaId}/categoriaFormula/{categoriaFormulaId}")
    @Operation(summary = "Create and List Ingredientes", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = IngredientesDTO.class)))})
    public ResponseEntity<?> obtenerGuardarIngredientesMasivo(@PathVariable("formulaId") Long formulaId, @PathVariable("categoriaFormulaId") Long categoriaFormulaId) {
        try {
            FormulaDTO objFormula = formulaService.obtenerFormulaPorId(formulaId);
            if (objFormula == null) {
                return new ResponseEntity(HttpStatus.NOT_FOUND);
            }
            //Guardamos el listado en base a categoriaFormulaId
            Integer estado = ingredientesService.guardarIngredientesMasivo(formulaId, categoriaFormulaId);
            //Obtenemos el listado por formulaId
            List<IngredientesDTO> obj = ingredientesService.obtenerIngredientesPorFormulaId(formulaId);
            if (obj.isEmpty() && estado.equals(0)) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity(obj, HttpStatus.CREATED);
        } catch (Exception e) {
            logger.error(e.getLocalizedMessage());
            return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
