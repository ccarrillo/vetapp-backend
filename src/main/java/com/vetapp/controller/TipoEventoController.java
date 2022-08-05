package com.vetapp.controller;

import com.vetapp.dto.TipoEventoDto;
import com.vetapp.service.TipoEventoServiceImpl;
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
@RequestMapping("/tipoevento")
@CrossOrigin
@Tag(name = "tipoevento")
public class TipoEventoController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TipoEventoServiceImpl tipoEventoService;

    @PostMapping("")
    @Operation(summary = "Create TipoEvento", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "201", content = @Content(mediaType = "application/json", schema = @Schema(implementation = TipoEventoDto.class)))})
    public ResponseEntity<?> guardarTipoEvento(@RequestBody TipoEventoDto tipoEventoDto) {
        try {
            TipoEventoDto obj = tipoEventoService.guardarTipoEvento(tipoEventoDto);
            return new ResponseEntity(obj, HttpStatus.CREATED);
        } catch (Exception e) {
            logger.error(e.getLocalizedMessage());
            return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("")
    @Operation(summary = "Read TipoEventos", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = TipoEventoDto.class)))})
    public ResponseEntity<?> obtenerTipoEventos() {
        try {
            List<TipoEventoDto> obj = tipoEventoService.obtenerTipoEventos();
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
    @Operation(summary = "Read TipoEvento", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = TipoEventoDto.class)))})
    public ResponseEntity<?> obtenerTipoEventoPorId(@PathVariable("id") Long id) {
        try {
            TipoEventoDto obj = tipoEventoService.obtenerTipoEventoPorId(id);
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
    @Operation(summary = "Update TipoEvento", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = TipoEventoDto.class)))})
    public ResponseEntity<?> actualizarTipoEvento(@RequestBody TipoEventoDto tipoEventoDto, @PathVariable("id") Long id) {
        try {
            TipoEventoDto obj = tipoEventoService.actualizarTipoEvento(tipoEventoDto, id);
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
    @Operation(summary = "Delete TipoEvento", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = TipoEventoDto.class)))})
    public ResponseEntity<TipoEventoDto> eliminarTipoEvento(@PathVariable("id") Long id) {
        try {
            Boolean obj = tipoEventoService.eliminarTipoEvento(id);
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
