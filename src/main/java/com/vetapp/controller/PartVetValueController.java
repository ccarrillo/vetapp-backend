package com.vetapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vetapp.dto.ParVetValueDto;
import com.vetapp.service.ParVetValueService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/parvetvalue")
@CrossOrigin
@Tag(name = "value")
public class PartVetValueController {
	
	   @Autowired
	   private ParVetValueService partVetValueService;
	   

	   @GetMapping("/{idParVet}")
	    @Operation(summary = "Read ParVetValues", responses = {
	            @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ParVetValueDto.class)))})
	    public ResponseEntity<?> obtenerParVetValuesPorId(@PathVariable("idParVet") Long idParVet) {
	        try {
	            List<ParVetValueDto> obj = partVetValueService.obtenerParVetValues(idParVet);
	            if (obj.isEmpty()) {
	                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	            }
	            return new ResponseEntity(obj, HttpStatus.OK);
	        } catch (Exception e) {
	            return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }

}
