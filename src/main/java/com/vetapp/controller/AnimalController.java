package com.vetapp.controller;

import com.vetapp.dto.AnimalDTO;
import com.vetapp.service.AnimalService;
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
@RequestMapping("/animal")
@CrossOrigin
@Tag(name = "animal")
public class AnimalController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AnimalService animalService;

    @PostMapping("")
    @Operation(summary = "Create Animal", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "201", content = @Content(mediaType = "application/json", schema = @Schema(implementation = AnimalDTO.class)))})
    public ResponseEntity<?> guardarAnimal(@RequestBody AnimalDTO animalDto) {
        try {
            AnimalDTO obj = animalService.guardarAnimal(animalDto);
            return new ResponseEntity(obj, HttpStatus.CREATED);
        } catch (Exception e) {
            logger.error(e.getLocalizedMessage());
            return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("")
    @Operation(summary = "Read Animals", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = AnimalDTO.class)))})
    public ResponseEntity<?> obtenerAnimals() {
        try {
            List<AnimalDTO> obj = animalService.obtenerAnimals();
            if (obj.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity(obj, HttpStatus.OK);
        } catch (Exception e) {
            logger.error(e.getLocalizedMessage());
            return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @GetMapping("sexo/{sexo}")
    @Operation(summary = "Read Animals Sexes", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = AnimalDTO.class)))})
    public ResponseEntity<?> obtenerAnimalsBySex(@PathVariable("sexo") String sexo) {
        try {
            List<AnimalDTO> obj = animalService.obtenerAnimalBySexes(sexo);
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
    @Operation(summary = "Read Animal", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = AnimalDTO.class)))})
    public ResponseEntity<?> obtenerAnimalPorId(@PathVariable("id") Long id) {
        try {
            AnimalDTO obj = animalService.obtenerAnimalPorId(id);
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
    @Operation(summary = "Update Animal", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = AnimalDTO.class)))})
    public ResponseEntity<?> actualizarAnimal(@RequestBody AnimalDTO animalDto, @PathVariable("id") Long id) {
        try {
            AnimalDTO obj = animalService.actualizarAnimal(animalDto, id);
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
    @Operation(summary = "Delete Animal", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = AnimalDTO.class)))})
    public ResponseEntity<AnimalDTO> eliminarAnimal(@PathVariable("id") Long id) {
        try {
            Boolean obj = animalService.eliminarAnimal(id);
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
