package com.vetapp.controller;

import com.vetapp.dto.PesadoLecheDto;
import com.vetapp.service.PesadoLecheServiceImpl;
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
@RequestMapping("/pesadoleche")
@CrossOrigin
@Tag(name = "pesadoleche")
public class PesadoLecheController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private PesadoLecheServiceImpl pesadoLecheService;

    @PostMapping("")
    @Operation(summary = "Create PesadoLeche", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "201", content = @Content(mediaType = "application/json", schema = @Schema(implementation = PesadoLecheDto.class)))})
    public ResponseEntity<?> guardarPesadoLeche(@RequestBody PesadoLecheDto pesadoLecheDto) {
        try {
            PesadoLecheDto obj = pesadoLecheService.guardarPesadoLeche(pesadoLecheDto);
            return new ResponseEntity(obj, HttpStatus.CREATED);
        } catch (Exception e) {
            logger.error(e.getLocalizedMessage());
            return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("")
    @Operation(summary = "Read PesadoLeches", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = PesadoLecheDto.class)))})
    public ResponseEntity<?> obtenerPesadoLeches() {
        try {
            List<PesadoLecheDto> obj = pesadoLecheService.obtenerPesadoLeches();
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
    @Operation(summary = "Read PesadoLeche", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = PesadoLecheDto.class)))})
    public ResponseEntity<?> obtenerPesadoLechePorId(@PathVariable("id") Long id) {
        try {
            PesadoLecheDto obj = pesadoLecheService.obtenerPesadoLechePorId(id);
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
    @Operation(summary = "Update PesadoLeche", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = PesadoLecheDto.class)))})
    public ResponseEntity<?> actualizarPesadoLeche(@RequestBody PesadoLecheDto pesadoLecheDto, @PathVariable("id") Long id) {
        try {
            PesadoLecheDto obj = pesadoLecheService.actualizarPesadoLeche(pesadoLecheDto, id);
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
    @Operation(summary = "Delete PesadoLeche", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = PesadoLecheDto.class)))})
    public ResponseEntity<PesadoLecheDto> eliminarPesadoLeche(@PathVariable("id") Long id) {
        try {
            Boolean obj = pesadoLecheService.eliminarPesadoLeche(id);
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
