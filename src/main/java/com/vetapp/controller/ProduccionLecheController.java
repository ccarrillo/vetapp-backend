package com.vetapp.controller;

import com.vetapp.dto.ProduccionLecheDTO;
import com.vetapp.service.ProduccionLecheService;
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
@RequestMapping("/produccionleche")
@CrossOrigin
@Tag(name = "produccionleche")
public class ProduccionLecheController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ProduccionLecheService produccionLecheService;

    @PostMapping("")
    @Operation(summary = "Create ProduccionLeche", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "201", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProduccionLecheDTO.class)))})
    public ResponseEntity<?> guardarProduccionLeche(@RequestBody ProduccionLecheDTO produccionLecheDto) {
        try {
            ProduccionLecheDTO obj = produccionLecheService.guardarProduccionLeche(produccionLecheDto);
            return new ResponseEntity(obj, HttpStatus.CREATED);
        } catch (Exception e) {
            logger.error(e.getLocalizedMessage());
            return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("")
    @Operation(summary = "Read ProduccionLeches", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProduccionLecheDTO.class)))})
    public ResponseEntity<?> obtenerProduccionLeches() {
        try {
            List<ProduccionLecheDTO> obj = produccionLecheService.obtenerProduccionLeches();
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
    @Operation(summary = "Read ProduccionLeche", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProduccionLecheDTO.class)))})
    public ResponseEntity<?> obtenerProduccionLechePorId(@PathVariable("id") Long id) {
        try {
            ProduccionLecheDTO obj = produccionLecheService.obtenerProduccionLechePorId(id);
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
    @Operation(summary = "Update ProduccionLeche", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProduccionLecheDTO.class)))})
    public ResponseEntity<?> actualizarProduccionLeche(@RequestBody ProduccionLecheDTO produccionLecheDto, @PathVariable("id") Long id) {
        try {
            ProduccionLecheDTO obj = produccionLecheService.actualizarProduccionLeche(produccionLecheDto, id);
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
    @Operation(summary = "Delete ProduccionLeche", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProduccionLecheDTO.class)))})
    public ResponseEntity<ProduccionLecheDTO> eliminarProduccionLeche(@PathVariable("id") Long id) {
        try {
            Boolean obj = produccionLecheService.eliminarProduccionLeche(id);
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
