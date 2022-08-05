package com.vetapp.controller;

import com.vetapp.dto.RecordatorioEventoDto;
import com.vetapp.service.RecordatorioEventoServiceImpl;
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
@RequestMapping("/recordatorioevento")
@CrossOrigin
@Tag(name = "recordatorioevento")
public class RecordatorioEventoController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RecordatorioEventoServiceImpl recordatorioEventoService;

    @PostMapping("")
    @Operation(summary = "Create RecordatorioEvento", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "201", content = @Content(mediaType = "application/json", schema = @Schema(implementation = RecordatorioEventoDto.class)))})
    public ResponseEntity<?> guardarRecordatorioEvento(@RequestBody RecordatorioEventoDto recordatorioEventoDto) {
        try {
            RecordatorioEventoDto obj = recordatorioEventoService.guardarRecordatorioEvento(recordatorioEventoDto);
            return new ResponseEntity(obj, HttpStatus.CREATED);
        } catch (Exception e) {
            logger.error(e.getLocalizedMessage());
            return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("")
    @Operation(summary = "Read RecordatorioEventos", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = RecordatorioEventoDto.class)))})
    public ResponseEntity<?> obtenerRecordatorioEventos() {
        try {
            List<RecordatorioEventoDto> obj = recordatorioEventoService.obtenerRecordatorioEventos();
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
    @Operation(summary = "Read RecordatorioEvento", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = RecordatorioEventoDto.class)))})
    public ResponseEntity<?> obtenerRecordatorioEventoPorId(@PathVariable("id") Long id) {
        try {
            RecordatorioEventoDto obj = recordatorioEventoService.obtenerRecordatorioEventoPorId(id);
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
    @Operation(summary = "Update RecordatorioEvento", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = RecordatorioEventoDto.class)))})
    public ResponseEntity<?> actualizarRecordatorioEvento(@RequestBody RecordatorioEventoDto recordatorioEventoDto, @PathVariable("id") Long id) {
        try {
            RecordatorioEventoDto obj = recordatorioEventoService.actualizarRecordatorioEvento(recordatorioEventoDto, id);
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
    @Operation(summary = "Delete RecordatorioEvento", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = RecordatorioEventoDto.class)))})
    public ResponseEntity<RecordatorioEventoDto> eliminarRecordatorioEvento(@PathVariable("id") Long id) {
        try {
            Boolean obj = recordatorioEventoService.eliminarRecordatorioEvento(id);
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
