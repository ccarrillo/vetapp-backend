package com.vetapp.controller;

import com.vetapp.dto.DetalleTipoEventoAnimalDto;
import com.vetapp.service.DetalleTipoEventoAnimalServiceImpl;
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
@RequestMapping("/detalletipoeventoanimal")
@CrossOrigin
@Tag(name = "detalletipoeventoanimal")
public class DetalleTipoEventoAnimalController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private DetalleTipoEventoAnimalServiceImpl detalleTipoEventoAnimalService;

    @PostMapping("")
    @Operation(summary = "Create DetalleTipoEventoAnimal", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "201", content = @Content(mediaType = "application/json", schema = @Schema(implementation = DetalleTipoEventoAnimalDto.class)))})
    public ResponseEntity<?> guardarDetalleTipoEventoAnimal(@RequestBody DetalleTipoEventoAnimalDto detalleTipoEventoAnimalDto) {
        try {
            DetalleTipoEventoAnimalDto obj = detalleTipoEventoAnimalService.guardarDetalleTipoEventoAnimal(detalleTipoEventoAnimalDto);
            return new ResponseEntity(obj, HttpStatus.CREATED);
        } catch (Exception e) {
            logger.error(e.getLocalizedMessage());
            return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("")
    @Operation(summary = "Read DetalleTipoEventoAnimals", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = DetalleTipoEventoAnimalDto.class)))})
    public ResponseEntity<?> obtenerDetalleTipoEventoAnimals() {
        try {
            List<DetalleTipoEventoAnimalDto> obj = detalleTipoEventoAnimalService.obtenerDetalleTipoEventoAnimals();
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
    @Operation(summary = "Read DetalleTipoEventoAnimal", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = DetalleTipoEventoAnimalDto.class)))})
    public ResponseEntity<?> obtenerDetalleTipoEventoAnimalPorId(@PathVariable("id") Long id) {
        try {
            DetalleTipoEventoAnimalDto obj = detalleTipoEventoAnimalService.obtenerDetalleTipoEventoAnimalPorId(id);
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
    @Operation(summary = "Update DetalleTipoEventoAnimal", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = DetalleTipoEventoAnimalDto.class)))})
    public ResponseEntity<?> actualizarDetalleTipoEventoAnimal(@RequestBody DetalleTipoEventoAnimalDto detalleTipoEventoAnimalDto, @PathVariable("id") Long id) {
        try {
            DetalleTipoEventoAnimalDto obj = detalleTipoEventoAnimalService.actualizarDetalleTipoEventoAnimal(detalleTipoEventoAnimalDto, id);
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
    @Operation(summary = "Delete DetalleTipoEventoAnimal", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = DetalleTipoEventoAnimalDto.class)))})
    public ResponseEntity<DetalleTipoEventoAnimalDto> eliminarDetalleTipoEventoAnimal(@PathVariable("id") Long id) {
        try {
            Boolean obj = detalleTipoEventoAnimalService.eliminarDetalleTipoEventoAnimal(id);
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
