package com.vetapp.controller;

import com.vetapp.dto.ParVetDTO;
import com.vetapp.service.PartVetService;
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
@RequestMapping("/parvet")
@CrossOrigin
@Tag(name = "parvet")
public class ParVetController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private PartVetService parVetService;

    @PostMapping("")
    @Operation(summary = "Create ParListValue", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "201", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ParVetDTO.class)))})
    public ResponseEntity<?> guardarParVet(@RequestBody ParVetDTO parVetDto) {
        try {
            ParVetDTO obj = parVetService.guardarParVet(parVetDto);
            return new ResponseEntity(obj, HttpStatus.CREATED);
        } catch (Exception e) {
			logger.error(e.getLocalizedMessage());
            return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("")
    @Operation(summary = "Read ParListValues", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ParVetDTO.class)))})
    public ResponseEntity<?> obtenerParVet() {
        try {
            List<ParVetDTO> obj = parVetService.obtenerParVet();
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
    @Operation(summary = "Read ParListValue", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ParVetDTO.class)))})
    public ResponseEntity<?> obtenerParVetPorId(@PathVariable("id") Long id) {
        try {
            ParVetDTO obj = parVetService.obtenerParVetPorId(id);
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
    @Operation(summary = "Update ParListValue", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ParVetDTO.class)))})
    public ResponseEntity<?> actualizarParVet(@RequestBody ParVetDTO parVetDto, @PathVariable("id") Long id) {
        try {
            ParVetDTO obj = parVetService.actualizarParVet(parVetDto, id);
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
    @Operation(summary = "Delete ParListValue", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ParVetDTO.class)))})
    public ResponseEntity<ParVetDTO> eliminarParVet(@PathVariable("id") Long id) {
        try {
            Boolean obj = parVetService.eliminarParVet(id);
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
