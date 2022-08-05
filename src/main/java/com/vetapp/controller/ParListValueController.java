package com.vetapp.controller;

import com.vetapp.dto.ParListValueDTO;
import com.vetapp.service.ParListValueService;
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
@RequestMapping("/parlistvalue")
@CrossOrigin
@Tag(name = "parlistvalue")
public class ParListValueController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ParListValueService parListValueService;

    @PostMapping("")
    @Operation(summary = "Create ParListValue", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "201", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ParListValueDTO.class)))})
    public ResponseEntity<?> guardarParListValue(@RequestBody ParListValueDTO parListValueDto) {
        try {
            ParListValueDTO obj = parListValueService.guardarParListValue(parListValueDto);
            return new ResponseEntity(obj, HttpStatus.CREATED);
        } catch (Exception e) {
            logger.error(e.getLocalizedMessage());
            return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("")
    @Operation(summary = "Read ParListValues", responses = {
    @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ParListValueDTO.class)))})
    public ResponseEntity<?> obtenerParListValues() {
        try {
            List<ParListValueDTO> obj = parListValueService.obtenerParListValues();
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
    @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ParListValueDTO.class)))})
    public ResponseEntity<?> obtenerParListValuePorId(@PathVariable("id") Long id) {
        try {
            ParListValueDTO obj = parListValueService.obtenerParListValuePorId(id);
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
    @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ParListValueDTO.class)))})
    public ResponseEntity<?> actualizarParListValue(@RequestBody ParListValueDTO parListValueDto, @PathVariable("id") Long id) {
        try {
            ParListValueDTO obj = parListValueService.actualizarParListValue(parListValueDto, id);
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
    @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ParListValueDTO.class)))})
    public ResponseEntity<ParListValueDTO> eliminarParListValue(@PathVariable("id") Long id) {
        try {
            Boolean obj = parListValueService.eliminarParListValue(id);
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
