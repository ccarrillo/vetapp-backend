package com.vetapp.controller;


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

import com.vetapp.dto.EventoAnimalDTO;
import com.vetapp.service.EventoAnimalService;

import java.util.List;

@RestController
@RequestMapping("/evento")
@CrossOrigin
@Tag(name = "evento")
public class EventoController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private EventoAnimalService eventoService;

    @PostMapping("")
    @Operation(summary = "Create Evento", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "201", content = @Content(mediaType = "application/json", schema = @Schema(implementation = EventoAnimalDTO.class)))})
    public ResponseEntity<?> guardarEvento(@RequestBody EventoAnimalDTO eventoDto) {
        try {
            EventoAnimalDTO obj = eventoService.guardarEvento(eventoDto);
            return new ResponseEntity(obj, HttpStatus.CREATED);
        } catch (Exception e) {
            logger.error(e.getLocalizedMessage());
            return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("")
    @Operation(summary = "Read Eventos", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = EventoAnimalDTO.class)))})
    public ResponseEntity<?> obtenerEventos() {
        try {
            List<EventoAnimalDTO> obj = eventoService.obtenerEventos();
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
    @Operation(summary = "Read Evento", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = EventoAnimalDTO.class)))})
    public ResponseEntity<?> obtenerEventoPorId(@PathVariable("id") Long id) {
        try {
            EventoAnimalDTO obj = eventoService.obtenerEventoPorId(id);
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
    @Operation(summary = "Update Evento", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = EventoAnimalDTO.class)))})
    public ResponseEntity<?> actualizarEvento(@RequestBody EventoAnimalDTO eventoDto, @PathVariable("id") Long id) {
        try {
            EventoAnimalDTO obj = eventoService.actualizarEvento(eventoDto, id);
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
    @Operation(summary = "Delete Evento", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = EventoAnimalDTO.class)))})
    public ResponseEntity<EventoAnimalDTO> eliminarEvento(@PathVariable("id") Long id) {
        try {
            Boolean obj = eventoService.eliminarEvento(id);
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
