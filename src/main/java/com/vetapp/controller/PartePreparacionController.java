package com.vetapp.controller;

import com.vetapp.dto.FormulaDTO;
import com.vetapp.dto.PartePreparacionDTO;
import com.vetapp.service.FormulaService;
import com.vetapp.service.PartePreparacionService;
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
@RequestMapping("/repartoPreparacion")
@CrossOrigin
@Tag(name = "repartoPreparacion")
public class PartePreparacionController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private FormulaService formulaService;

    @Autowired
    private PartePreparacionService partePreparacionService;

    @PostMapping("")
    @Operation(summary = "Create PartePreparacion", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "201", content = @Content(mediaType = "application/json", schema = @Schema(implementation = PartePreparacionDTO.class)))})
    public ResponseEntity<?> guardarPartePreparacion(@RequestBody PartePreparacionDTO partePreparacionDto) {
        try {
            PartePreparacionDTO obj = partePreparacionService.guardarPartePreparacion(partePreparacionDto);
            return new ResponseEntity(obj, HttpStatus.CREATED);
        } catch (Exception e) {
            logger.error(e.getLocalizedMessage());
            return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("")
    @Operation(summary = "Read PartePreparacions", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = PartePreparacionDTO.class)))})
    public ResponseEntity<?> obtenerPartePreparacions() {
        try {
            List<PartePreparacionDTO> obj = partePreparacionService.obtenerPartePreparacions();
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
    @Operation(summary = "Read PartePreparacion", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = PartePreparacionDTO.class)))})
    public ResponseEntity<?> obtenerPartePreparacionPorId(@PathVariable("id") Long id) {
        try {
            PartePreparacionDTO obj = partePreparacionService.obtenerPartePreparacionPorId(id);
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
    @Operation(summary = "Update PartePreparacion", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = PartePreparacionDTO.class)))})
    public ResponseEntity<?> actualizarPartePreparacion(@RequestBody PartePreparacionDTO partePreparacionDto, @PathVariable("id") Long id) {
        try {
            PartePreparacionDTO obj = partePreparacionService.actualizarPartePreparacion(partePreparacionDto, id);
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
    @Operation(summary = "Delete PartePreparacion", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = PartePreparacionDTO.class)))})
    public ResponseEntity<PartePreparacionDTO> eliminarPartePreparacion(@PathVariable("id") Long id) {
        try {
            Boolean obj = partePreparacionService.eliminarPartePreparacion(id);
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
    @Operation(summary = "Read PartePreparacions", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = PartePreparacionDTO.class)))})
    public ResponseEntity<?> obtenerPartePreparacionPorFormulaId(@PathVariable("formulaId") Long formulaId) {
        try {
            List<PartePreparacionDTO> obj = partePreparacionService.obtenerPartePreparacionPorFormulaId(formulaId);
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
    @Operation(summary = "Create PartePreparacion", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "201", content = @Content(mediaType = "application/json", schema = @Schema(implementation = PartePreparacionDTO.class)))})
    public ResponseEntity<?> guardarPartePreparacion(@PathVariable("formulaId") Long formulaId, @RequestBody PartePreparacionDTO partePreparacionDTO) {
        try {
            FormulaDTO objFormula = formulaService.obtenerFormulaPorId(formulaId);
            if (objFormula == null) {
                return new ResponseEntity(HttpStatus.NOT_FOUND);
            }
            partePreparacionDTO.setFormulaDTO(objFormula);
            PartePreparacionDTO obj = partePreparacionService.guardarPartePreparacion(formulaId, partePreparacionDTO);
            return new ResponseEntity(obj, HttpStatus.CREATED);
        } catch (Exception e) {
            logger.error(e.getLocalizedMessage());
            return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{partePreparacionId}/formula/{formulaId}")
    @Operation(summary = "Update PartePreparacion", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = PartePreparacionDTO.class)))})
    public ResponseEntity<?> actualizarPartePreparacion(@PathVariable("formulaId") Long formulaId, @PathVariable("partePreparacionId") Long partePreparacionId, @RequestBody PartePreparacionDTO partePreparacionDTO) {
        try {
            FormulaDTO objFormula = formulaService.obtenerFormulaPorId(formulaId);
            if (objFormula == null) {
                return new ResponseEntity(HttpStatus.NOT_FOUND);
            }
            PartePreparacionDTO obj = partePreparacionService.actualizarPartePreparacion(formulaId, partePreparacionId, partePreparacionDTO);
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

    @DeleteMapping("/{partePreparacionId}/formula/{formulaId}")
    @Operation(summary = "Delete PartePreparacion", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = PartePreparacionDTO.class)))})
    public ResponseEntity<PartePreparacionDTO> eliminarPartePreparacion(@PathVariable("formulaId") Long formulaId, @PathVariable("partePreparacionId") Long partePreparacionId) {
        try {
            Boolean obj = partePreparacionService.eliminarPartePreparacion(formulaId, partePreparacionId);
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
