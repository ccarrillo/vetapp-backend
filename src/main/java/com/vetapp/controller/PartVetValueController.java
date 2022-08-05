package com.vetapp.controller;

import com.vetapp.dto.ParVetValueDto;
import com.vetapp.service.ParVetValueServiceImpl;
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
@Tag(name = "value")
public class PartVetValueController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ParVetValueServiceImpl partVetValueService;
	   

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
			logger.error(e.getLocalizedMessage());
	    	return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}

}
