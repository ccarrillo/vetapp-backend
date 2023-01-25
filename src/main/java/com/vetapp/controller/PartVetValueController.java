package com.vetapp.controller;
import com.vetapp.dto.ParVetValueDTO;
import com.vetapp.service.ParVetValueService;
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
@RequestMapping("/parvetvalue")
@CrossOrigin
@Tag(name = "parvetvalue")
public class PartVetValueController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ParVetValueService partVetValueService;
	   
   
	 @PostMapping("")
	 @Operation(summary = "Create ParVetValue", responses = {
	            @ApiResponse(description = "Successful Response", responseCode = "201", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ParVetValueDTO.class)))})
	public ResponseEntity<?> guardarParVetValue(@RequestBody ParVetValueDTO parVetValueDto) {
	        try {
	            ParVetValueDTO obj = partVetValueService.guardarParVetValue(parVetValueDto);
	            return new ResponseEntity(obj, HttpStatus.CREATED);
	        } catch (Exception e) {
				logger.error(e.getLocalizedMessage());
	            return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	 }
	 
	 @GetMapping("")
	    @Operation(summary = "Read ParVetValue", responses = {
	            @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ParVetValueDTO.class)))})
	    public ResponseEntity<?> obtenerParVet() {
	        try {
	            List<ParVetValueDTO> obj = partVetValueService.obtenerParVetValuesTodos();
	            if (obj.isEmpty()) {
	                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	            }
	            return new ResponseEntity(obj, HttpStatus.OK);
	        } catch (Exception e) {
				logger.error(e.getLocalizedMessage());
	            return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }

	@GetMapping("/{idParVet}")
	@Operation(summary = "Read ParVetValues", responses = {
	@ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ParVetValueDTO.class)))})
	public ResponseEntity<?> obtenerParVetValuesPorId(@PathVariable("idParVet") Long idParVet) {
		try {
	    	List<ParVetValueDTO> obj = partVetValueService.obtenerParVetValues(idParVet);
	        if (obj.isEmpty()) {
	        	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
	        return new ResponseEntity(obj, HttpStatus.OK);
	    } catch (Exception e) {
			logger.error(e.getLocalizedMessage());
	    	return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
	
	@PutMapping("/{id}")
	    @Operation(summary = "Update ParVetValue", responses = {
	            @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ParVetValueDTO.class)))})
	    public ResponseEntity<?> actualizarParVetValue(@RequestBody ParVetValueDTO parVetDto, @PathVariable("id") Long id) {
	        try {
	            ParVetValueDTO obj = partVetValueService.actualizarParVetValue(parVetDto, id);
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

}
