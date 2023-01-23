package com.vetapp.controller;

import com.vetapp.dto.FormulaDTO;
import com.vetapp.dto.RepartoProgramacionDTO;
import com.vetapp.service.FormulaService;
import com.vetapp.service.RepartoProgramacionService;
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
@RequestMapping("/repartoProgramacion")
@CrossOrigin
@Tag(name = "repartoProgramacion")
public class RepartoProgramacionController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private FormulaService formulaService;

    @Autowired
    private RepartoProgramacionService repartoProgramacionService;

    @PostMapping("")
    @Operation(summary = "Create RepartoProgramacion", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "201", content = @Content(mediaType = "application/json", schema = @Schema(implementation = RepartoProgramacionDTO.class)))})
    public ResponseEntity<?> guardarRepartoProgramacion(@RequestBody RepartoProgramacionDTO repartoProgramacionDto) {
        try {
            RepartoProgramacionDTO obj = repartoProgramacionService.guardarRepartoProgramacion(repartoProgramacionDto);
            return new ResponseEntity(obj, HttpStatus.CREATED);
        } catch (Exception e) {
            logger.error(e.getLocalizedMessage());
            return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("")
    @Operation(summary = "Read RepartoProgramacions", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = RepartoProgramacionDTO.class)))})
    public ResponseEntity<?> obtenerRepartoProgramacions() {
        try {
            List<RepartoProgramacionDTO> obj = repartoProgramacionService.obtenerRepartoProgramacions();
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
    @Operation(summary = "Read RepartoProgramacion", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = RepartoProgramacionDTO.class)))})
    public ResponseEntity<?> obtenerRepartoProgramacionPorId(@PathVariable("id") Long id) {
        try {
            RepartoProgramacionDTO obj = repartoProgramacionService.obtenerRepartoProgramacionPorId(id);
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
    @Operation(summary = "Update RepartoProgramacion", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = RepartoProgramacionDTO.class)))})
    public ResponseEntity<?> actualizarRepartoProgramacion(@RequestBody RepartoProgramacionDTO repartoProgramacionDto, @PathVariable("id") Long id) {
        try {
            RepartoProgramacionDTO obj = repartoProgramacionService.actualizarRepartoProgramacion(repartoProgramacionDto, id);
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
    @Operation(summary = "Delete RepartoProgramacion", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = RepartoProgramacionDTO.class)))})
    public ResponseEntity<RepartoProgramacionDTO> eliminarRepartoProgramacion(@PathVariable("id") Long id) {
        try {
            Boolean obj = repartoProgramacionService.eliminarRepartoProgramacion(id);
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
    @Operation(summary = "Read RepartoProgramacions", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = RepartoProgramacionDTO.class)))})
    public ResponseEntity<?> obtenerRepartoProgramacionPorFormulaId(@PathVariable("formulaId") Long formulaId) {
        try {
            List<RepartoProgramacionDTO> obj = repartoProgramacionService.obtenerRepartoProgramacionPorFormulaId(formulaId);
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
    @Operation(summary = "Create RepartoProgramacion", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "201", content = @Content(mediaType = "application/json", schema = @Schema(implementation = RepartoProgramacionDTO.class)))})
    public ResponseEntity<?> guardarRepartoProgramacion(@PathVariable("formulaId") Long formulaId, @RequestBody RepartoProgramacionDTO repartoProgramacionDTO) {
        try {
            FormulaDTO objFormula = formulaService.obtenerFormulaPorId(formulaId);
            if (objFormula == null) {
                return new ResponseEntity(HttpStatus.NOT_FOUND);
            }
            repartoProgramacionDTO.setFormula(objFormula);
            RepartoProgramacionDTO obj = repartoProgramacionService.guardarRepartoProgramacion(formulaId, repartoProgramacionDTO);
            return new ResponseEntity(obj, HttpStatus.CREATED);
        } catch (Exception e) {
            logger.error(e.getLocalizedMessage());
            return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{repartoProgramacionId}/formula/{formulaId}")
    @Operation(summary = "Update RepartoProgramacion", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = RepartoProgramacionDTO.class)))})
    public ResponseEntity<?> actualizarRepartoProgramacion(@PathVariable("formulaId") Long formulaId, @PathVariable("repartoProgramacionId") Long repartoProgramacionId, @RequestBody RepartoProgramacionDTO repartoProgramacionDTO) {
        try {
            FormulaDTO objFormula = formulaService.obtenerFormulaPorId(formulaId);
            if (objFormula == null) {
                return new ResponseEntity(HttpStatus.NOT_FOUND);
            }
            RepartoProgramacionDTO obj = repartoProgramacionService.actualizarRepartoProgramacion(formulaId, repartoProgramacionId, repartoProgramacionDTO);
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

    @DeleteMapping("/{repartoProgramacionId}/formula/{formulaId}")
    @Operation(summary = "Delete RepartoProgramacion", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = RepartoProgramacionDTO.class)))})
    public ResponseEntity<RepartoProgramacionDTO> eliminarRepartoProgramacion(@PathVariable("formulaId") Long formulaId, @PathVariable("repartoProgramacionId") Long repartoProgramacionId) {
        try {
            Boolean obj = repartoProgramacionService.eliminarRepartoProgramacion(formulaId, repartoProgramacionId);
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
