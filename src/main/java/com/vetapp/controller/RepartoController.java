package com.vetapp.controller;

import com.vetapp.dto.FormulaDTO;
import com.vetapp.dto.RepartoDTO;
import com.vetapp.service.FormulaService;
import com.vetapp.service.RepartoService;
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
@RequestMapping("/reparto")
@CrossOrigin
@Tag(name = "reparto")
public class RepartoController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private FormulaService formulaService;

    @Autowired
    private RepartoService repartoService;

    @PostMapping("")
    @Operation(summary = "Create Reparto", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "201", content = @Content(mediaType = "application/json", schema = @Schema(implementation = RepartoDTO.class)))})
    public ResponseEntity<?> guardarReparto(@RequestBody RepartoDTO repartoDTO) {
        try {
            RepartoDTO obj = repartoService.guardarReparto(repartoDTO);
            return new ResponseEntity(obj, HttpStatus.CREATED);
        } catch (Exception e) {
            logger.error(e.getLocalizedMessage());
            return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("")
    @Operation(summary = "Read Repartos", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = RepartoDTO.class)))})
    public ResponseEntity<?> obtenerRepartos() {
        try {
            List<RepartoDTO> obj = repartoService.obtenerRepartos();
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
    @Operation(summary = "Read Reparto", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = RepartoDTO.class)))})
    public ResponseEntity<?> obtenerRepartoPorId(@PathVariable("id") Long id) {
        try {
            RepartoDTO obj = repartoService.obtenerRepartoPorId(id);
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
    @Operation(summary = "Update Reparto", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = RepartoDTO.class)))})
    public ResponseEntity<?> actualizarReparto(@RequestBody RepartoDTO repartoDTO, @PathVariable("id") Long id) {
        try {
            RepartoDTO obj = repartoService.actualizarReparto(repartoDTO, id);
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
    @Operation(summary = "Delete Reparto", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = RepartoDTO.class)))})
    public ResponseEntity<RepartoDTO> eliminarReparto(@PathVariable("id") Long id) {
        try {
            Boolean obj = repartoService.eliminarReparto(id);
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
    @Operation(summary = "Read Repartos", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = RepartoDTO.class)))})
    public ResponseEntity<?> obtenerRepartoPorFormulaId(@PathVariable("formulaId") Long formulaId) {
        try {
            List<RepartoDTO> obj = repartoService.obtenerRepartoPorFormulaId(formulaId);
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
    @Operation(summary = "Create Reparto", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "201", content = @Content(mediaType = "application/json", schema = @Schema(implementation = RepartoDTO.class)))})
    public ResponseEntity<?> guardarReparto(@PathVariable("formulaId") Long formulaId, @RequestBody RepartoDTO repartoDTO) {
        try {
            FormulaDTO objFormula = formulaService.obtenerFormulaPorId(formulaId);
            if (objFormula == null) {
                return new ResponseEntity(HttpStatus.NOT_FOUND);
            }
            RepartoDTO obj = repartoService.guardarReparto(formulaId, repartoDTO);
            return new ResponseEntity(obj, HttpStatus.CREATED);
        } catch (Exception e) {
            logger.error(e.getLocalizedMessage());
            return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{repartoId}/formula/{formulaId}")
    @Operation(summary = "Update Reparto", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = RepartoDTO.class)))})
    public ResponseEntity<?> actualizarReparto(@PathVariable("formulaId") Long formulaId, @PathVariable("repartoId") Long repartoId, @RequestBody RepartoDTO repartoDTO) {
        try {
            FormulaDTO objFormula = formulaService.obtenerFormulaPorId(formulaId);
            if (objFormula == null) {
                return new ResponseEntity(HttpStatus.NOT_FOUND);
            }
            RepartoDTO obj = repartoService.actualizarReparto(formulaId, repartoId, repartoDTO);
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
    @Operation(summary = "Delete Reparto", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = RepartoDTO.class)))})
    public ResponseEntity<RepartoDTO> eliminarReparto(@PathVariable("formulaId") Long formulaId, @PathVariable("repartoId") Long repartoId) {
        try {
            Boolean obj = repartoService.eliminarReparto(formulaId, repartoId);
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
