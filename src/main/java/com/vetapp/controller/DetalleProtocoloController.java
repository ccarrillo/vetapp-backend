package com.vetapp.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vetapp.dto.AnimalDTO;
import com.vetapp.dto.DetalleProtocoloDTO;
import com.vetapp.service.DetalleProtocoloService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/detalleprotocolo")
@CrossOrigin
@Tag(name = "detalleprotocolo")
public class DetalleProtocoloController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private DetalleProtocoloService detalleService;

    @PostMapping("")
    @Operation(summary = "Create DetalleProtocolo", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "201", content = @Content(mediaType = "application/json", schema = @Schema(implementation = DetalleProtocoloDTO.class)))})
    public ResponseEntity<?> guardarDetalleProtocolo(@RequestBody DetalleProtocoloDTO DetalleProtocoloDto) {
        try {
            DetalleProtocoloDTO obj = detalleService.guardarDetalleProtocolo(DetalleProtocoloDto);
            return new ResponseEntity(obj, HttpStatus.CREATED);
        } catch (Exception e) {
            logger.error(e.getLocalizedMessage());
            return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("")
    @Operation(summary = "Read DetalleProtocolo", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = DetalleProtocoloDTO.class)))})
    public ResponseEntity<?> obtenerDetalleProtocolo() {
        try {
            List<DetalleProtocoloDTO> obj = detalleService.obtenerDetalleProtocolo();
            if (obj.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity(obj, HttpStatus.OK);
        } catch (Exception e) {
            logger.error(e.getLocalizedMessage());
            return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    
    @GetMapping("/buscar/{id}")
    @Operation(summary = "Read DetalleProtocolo", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = DetalleProtocoloDTO.class)))})
    public ResponseEntity<?> obtenerDetalleProtocoloPorIdAnimal(@PathVariable("id") Long id) {
        try {
            List<DetalleProtocoloDTO> obj = detalleService.buscarDetalleProtocoloPorAnimal(id);
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
    @Operation(summary = "Read DetalleProtocolo", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = DetalleProtocoloDTO.class)))})
    public ResponseEntity<?> obtenerDetalleProtocoloPorId(@PathVariable("id") Long id) {
        try {
            DetalleProtocoloDTO obj = detalleService.obtenerDetalleProtocoloPorId(id);
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
    @Operation(summary = "Update DetalleProtocolo", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = DetalleProtocoloDTO.class)))})
    public ResponseEntity<?> actualizarDetalleProtocolo(@RequestBody DetalleProtocoloDTO DetalleProtocoloDto, @PathVariable("id") Long id) {
        try {
            DetalleProtocoloDTO obj = detalleService.actualizarDetalleProtocolo(DetalleProtocoloDto, id);
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
    @Operation(summary = "Delete DetalleProtocolo", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = DetalleProtocoloDTO.class)))})
    public ResponseEntity<AnimalDTO> eliminarDetalleProtocolo(@PathVariable("id") Long id) {
        try {
            Boolean obj = detalleService.eliminarDetalleProtocolo(id);
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
    
    
    //------
    


}
