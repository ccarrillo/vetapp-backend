package com.vetapp.controller;

import com.vetapp.dto.DetalleTipoEventoDto;
import com.vetapp.service.DetalleTipoEventoServiceImpl;
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
@RequestMapping("/detalletipoevento")
@CrossOrigin
@Tag(name = "detalletipoevento")
public class DetalleTipoEventoController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private DetalleTipoEventoServiceImpl detalleTipoEventoService;

    @PostMapping("")
    @Operation(summary = "Create DetalleTipoEvento", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "201", content = @Content(mediaType = "application/json", schema = @Schema(implementation = DetalleTipoEventoDto.class)))})
    public ResponseEntity<?> guardarDetalleTipoEvento(@RequestBody DetalleTipoEventoDto detalleTipoEventoDto) {
        try {
            DetalleTipoEventoDto obj = detalleTipoEventoService.guardarDetalleTipoEvento(detalleTipoEventoDto);
            return new ResponseEntity(obj, HttpStatus.CREATED);
        } catch (Exception e) {
            logger.error(e.getLocalizedMessage());
            return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("")
    @Operation(summary = "Read DetalleTipoEventos", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = DetalleTipoEventoDto.class)))})
    public ResponseEntity<?> obtenerDetalleTipoEventos() {
        try {
            List<DetalleTipoEventoDto> obj = detalleTipoEventoService.obtenerDetalleTipoEventos();
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
    @Operation(summary = "Read DetalleTipoEvento", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = DetalleTipoEventoDto.class)))})
    public ResponseEntity<?> obtenerDetalleTipoEventoPorId(@PathVariable("id") Long id) {
        try {
            DetalleTipoEventoDto obj = detalleTipoEventoService.obtenerDetalleTipoEventoPorId(id);
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
    @Operation(summary = "Update DetalleTipoEvento", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = DetalleTipoEventoDto.class)))})
    public ResponseEntity<?> actualizarDetalleTipoEvento(@RequestBody DetalleTipoEventoDto detalleTipoEventoDto, @PathVariable("id") Long id) {
        try {
            DetalleTipoEventoDto obj = detalleTipoEventoService.actualizarDetalleTipoEvento(detalleTipoEventoDto, id);
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
    @Operation(summary = "Delete DetalleTipoEvento", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = DetalleTipoEventoDto.class)))})
    public ResponseEntity<DetalleTipoEventoDto> eliminarDetalleTipoEvento(@PathVariable("id") Long id) {
        try {
            Boolean obj = detalleTipoEventoService.eliminarDetalleTipoEvento(id);
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
