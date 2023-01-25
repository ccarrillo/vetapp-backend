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

import com.vetapp.dto.AnimalBusquedaDTO;
import com.vetapp.dto.AnimalDTO;
import com.vetapp.dto.MedicionDTO;

import com.vetapp.service.MedicionService;
import com.vetapp.vo.AnimalVO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/medicion")
@CrossOrigin
@Tag(name = "medicion")
public class MedicionController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private MedicionService medicionService;

    @PostMapping("")
    @Operation(summary = "Create Medicion", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "201", content = @Content(mediaType = "application/json", schema = @Schema(implementation = MedicionDTO.class)))})
    public ResponseEntity<?> guardarMedicion(@RequestBody MedicionDTO medicionDto) {
        try {
            MedicionDTO obj = medicionService.guardarMedicion(medicionDto);
            return new ResponseEntity(obj, HttpStatus.CREATED);
        } catch (Exception e) {
            logger.error(e.getLocalizedMessage());
            return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("")
    @Operation(summary = "Read Mediciones", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = MedicionDTO.class)))})
    public ResponseEntity<?> obtenerMedicion() {
        try {
            List<MedicionDTO> obj = medicionService.obtenerMediciones();
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
    @Operation(summary = "Read Mediciones", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = MedicionDTO.class)))})
    public ResponseEntity<?> obtenerMedicionesPorIdAnimal(@PathVariable("id") Long id) {
        try {
            List<MedicionDTO> obj = medicionService.buscarMedicionesPorAnimal(id);
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
    @Operation(summary = "Read Medicion", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = MedicionDTO.class)))})
    public ResponseEntity<?> obtenerMedicionPorId(@PathVariable("id") Long id) {
        try {
            MedicionDTO obj = medicionService.obtenerMedicionPorId(id);
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
    @Operation(summary = "Update Medicion", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = MedicionDTO.class)))})
    public ResponseEntity<?> actualizarMedicion(@RequestBody MedicionDTO medicionDto, @PathVariable("id") Long id) {
        try {
            MedicionDTO obj = medicionService.actualizarMedicion(medicionDto, id);
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
    @Operation(summary = "Delete Medicion", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = MedicionDTO.class)))})
    public ResponseEntity<AnimalDTO> eliminarAnimal(@PathVariable("id") Long id) {
        try {
            Boolean obj = medicionService.eliminarMedicion(id);
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
