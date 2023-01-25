package com.vetapp.controller;

import com.vetapp.dto.InventarioSemenDTO;
import com.vetapp.service.InventarioSemenService;
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
@RequestMapping("/inventariosemen")
@CrossOrigin
@Tag(name = "inventariosemen")
public class InventarioSemenController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private InventarioSemenService inventarioSemenService;

    @PostMapping("")
    @Operation(summary = "Create InventarioSemen", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "201", content = @Content(mediaType = "application/json", schema = @Schema(implementation = InventarioSemenDTO.class)))})
    public ResponseEntity<?> guardarInventarioSemen(@RequestBody InventarioSemenDTO inventarioSemenDto) {
        try {
            InventarioSemenDTO obj = inventarioSemenService.guardarInventarioSemen(inventarioSemenDto);
            return new ResponseEntity(obj, HttpStatus.CREATED);
        } catch (Exception e) {
            logger.error(e.getLocalizedMessage());
            return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("")
    @Operation(summary = "Read InventarioSemens", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = InventarioSemenDTO.class)))})
    public ResponseEntity<?> obtenerInventarioSemens() {
        try {
            List<InventarioSemenDTO> obj = inventarioSemenService.obtenerInventarioSemenGrupos();
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
    @Operation(summary = "Read InventarioSemen", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = InventarioSemenDTO.class)))})
    public ResponseEntity<?> obtenerInventarioSemenPorId(@PathVariable("id") Long id) {
        try {
            InventarioSemenDTO obj = inventarioSemenService.obtenerInventarioSemenPorId(id);
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
    @Operation(summary = "Update InventarioSemen", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = InventarioSemenDTO.class)))})
    public ResponseEntity<?> actualizarInventarioSemen(@RequestBody InventarioSemenDTO inventarioSemenDto, @PathVariable("id") Long id) {
        try {
            InventarioSemenDTO obj = inventarioSemenService.actualizarInventarioSemen(inventarioSemenDto, id);
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
    @Operation(summary = "Delete InventarioSemen", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = InventarioSemenDTO.class)))})
    public ResponseEntity<InventarioSemenDTO> eliminarInventarioSemen(@PathVariable("id") Long id) {
        try {
            Boolean obj = inventarioSemenService.eliminarInventarioSemen(id);
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
