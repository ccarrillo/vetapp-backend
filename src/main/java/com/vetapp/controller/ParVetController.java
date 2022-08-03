package com.vetapp.controller;

import java.util.List;

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

import com.vetapp.dto.ParListValueDto;
import com.vetapp.dto.ParVetDto;
import com.vetapp.dto.ParVetValueDto;
import com.vetapp.service.ParListValueService;
import com.vetapp.service.ParVetValueService;
import com.vetapp.service.PartVetService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/parvet")
@CrossOrigin
@Tag(name = "parvet")
public class ParVetController {
	
	  @Autowired
	    private PartVetService parVetService;

	    @PostMapping("")
	    @Operation(summary = "Create ParListValue", responses = {
	            @ApiResponse(description = "Successful Response", responseCode = "201", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ParVetDto.class)))})
	    public ResponseEntity<?> guardarParVet(@RequestBody ParVetDto parVetDto) {
	        try {
	            ParVetDto obj = parVetService.guardarParVet(parVetDto);
	            return new ResponseEntity(obj, HttpStatus.CREATED);
	        } catch (Exception e) {
	            return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }

	    @GetMapping("")
	    @Operation(summary = "Read ParListValues", responses = {
	    @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ParVetDto.class)))})
	    public ResponseEntity<?> obtenerParVet() {
	        try {
	            List<ParVetDto> obj = parVetService.obtenerParVet();
	            if (obj.isEmpty()) {
	                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	            }
	            return new ResponseEntity(obj, HttpStatus.OK);
	        } catch (Exception e) {
	            return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }

	    @GetMapping("/{id}")
	    @Operation(summary = "Read ParListValue", responses = {
	    @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ParVetDto.class)))})
	    public ResponseEntity<?> obtenerParVetPorId(@PathVariable("id") Long id) {
	        try {
	            ParVetDto obj = parVetService.obtenerParVetPorId(id);
	            if (obj != null) {
	                return new ResponseEntity(obj, HttpStatus.OK);
	            } else {
	                return new ResponseEntity(HttpStatus.NOT_FOUND);
	            }
	        } catch (Exception e) {
	            return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }
	    
	 

	    @PutMapping("/{id}")
	    @Operation(summary = "Update ParListValue", responses = {
	    @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ParVetDto.class)))})
	    public ResponseEntity<?> actualizarParVet(@RequestBody ParVetDto parVetDto, @PathVariable("id") Long id) {
	        try {
	            ParVetDto obj = parVetService.actualizarParVet(parVetDto, id);
	            if (obj != null) {
	                return new ResponseEntity(obj, HttpStatus.OK);
	            } else {
	                return new ResponseEntity(HttpStatus.NOT_FOUND);
	            }
	        } catch (Exception e) {
	            return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }

	    @DeleteMapping("/{id}")
	    @Operation(summary = "Delete ParListValue", responses = {
	    @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ParVetDto.class)))})
	    public ResponseEntity<ParVetDto> eliminarParVet(@PathVariable("id") Long id) {
	        try {
	            Boolean obj = parVetService.eliminarParVet(id);
	            if (obj) {
	                return new ResponseEntity(obj, HttpStatus.OK);
	            } else {
	                return new ResponseEntity(HttpStatus.NOT_FOUND);
	            }
	        } catch (Exception e) {
	            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }


}
