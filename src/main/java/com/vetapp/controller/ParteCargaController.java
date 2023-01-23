package com.vetapp.controller;

import com.vetapp.dto.FormulaDTO;
import com.vetapp.dto.ParteCargaDTO;
import com.vetapp.service.FormulaService;
import com.vetapp.service.ParteCargaService;
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
@RequestMapping("/parteCarga")
@CrossOrigin
@Tag(name = "parteCarga")
public class ParteCargaController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private FormulaService formulaService;

    @Autowired
    private ParteCargaService parteCargaService;

    @PostMapping("")
    @Operation(summary = "Create ParteCarga", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "201", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ParteCargaDTO.class)))})
    public ResponseEntity<?> guardarParteCarga(@RequestBody ParteCargaDTO parteCargaDTO) {
        try {
            ParteCargaDTO obj = parteCargaService.guardarParteCarga(parteCargaDTO);
            return new ResponseEntity(obj, HttpStatus.CREATED);
        } catch (Exception e) {
            logger.error(e.getLocalizedMessage());
            return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("")
    @Operation(summary = "Read ParteCargas", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ParteCargaDTO.class)))})
    public ResponseEntity<?> obtenerParteCargas() {
        try {
            List<ParteCargaDTO> obj = parteCargaService.obtenerParteCargas();
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
    @Operation(summary = "Read ParteCarga", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ParteCargaDTO.class)))})
    public ResponseEntity<?> obtenerParteCargaPorId(@PathVariable("id") Long id) {
        try {
            ParteCargaDTO obj = parteCargaService.obtenerParteCargaPorId(id);
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
    @Operation(summary = "Update ParteCarga", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ParteCargaDTO.class)))})
    public ResponseEntity<?> actualizarParteCarga(@RequestBody ParteCargaDTO parteCargaDTO, @PathVariable("id") Long id) {
        try {
            ParteCargaDTO obj = parteCargaService.actualizarParteCarga(parteCargaDTO, id);
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
    @Operation(summary = "Delete ParteCarga", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ParteCargaDTO.class)))})
    public ResponseEntity<ParteCargaDTO> eliminarParteCarga(@PathVariable("id") Long id) {
        try {
            Boolean obj = parteCargaService.eliminarParteCarga(id);
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
    @Operation(summary = "Read ParteCargas", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ParteCargaDTO.class)))})
    public ResponseEntity<?> obtenerParteCargaPorFormulaId(@PathVariable("formulaId") Long formulaId) {
        try {
            List<ParteCargaDTO> obj = parteCargaService.obtenerParteCargaPorFormulaId(formulaId);
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
    @Operation(summary = "Create ParteCarga", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "201", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ParteCargaDTO.class)))})
    public ResponseEntity<?> guardarParteCarga(@PathVariable("formulaId") Long formulaId, @RequestBody ParteCargaDTO parteCargaDTO) {
        try {
            FormulaDTO objFormula = formulaService.obtenerFormulaPorId(formulaId);
            if (objFormula == null) {
                return new ResponseEntity(HttpStatus.NOT_FOUND);
            }
            ParteCargaDTO obj = parteCargaService.guardarParteCarga(formulaId, parteCargaDTO);
            return new ResponseEntity(obj, HttpStatus.CREATED);
        } catch (Exception e) {
            logger.error(e.getLocalizedMessage());
            return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{parteCargaId}/formula/{formulaId}")
    @Operation(summary = "Update ParteCarga", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ParteCargaDTO.class)))})
    public ResponseEntity<?> actualizarParteCarga(@PathVariable("formulaId") Long formulaId, @PathVariable("parteCargaId") Long parteCargaId, @RequestBody ParteCargaDTO parteCargaDTO) {
        try {
            FormulaDTO objFormula = formulaService.obtenerFormulaPorId(formulaId);
            if (objFormula == null) {
                return new ResponseEntity(HttpStatus.NOT_FOUND);
            }
            ParteCargaDTO obj = parteCargaService.actualizarParteCarga(formulaId, parteCargaId, parteCargaDTO);
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

    @DeleteMapping("/{parteCargaId}/formula/{formulaId}")
    @Operation(summary = "Delete ParteCarga", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ParteCargaDTO.class)))})
    public ResponseEntity<ParteCargaDTO> eliminarParteCarga(@PathVariable("formulaId") Long formulaId, @PathVariable("parteCargaId") Long parteCargaId) {
        try {
            Boolean obj = parteCargaService.eliminarParteCarga(formulaId, parteCargaId);
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
