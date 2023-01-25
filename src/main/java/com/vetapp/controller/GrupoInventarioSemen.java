package com.vetapp.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vetapp.dto.GrupoInventarioDTO;

import com.vetapp.service.GrupoInventarioSemenService;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;


@RestController
@RequestMapping("/grupoinventariosemen")
@CrossOrigin
@Tag(name = "grupoinventariosemen")
public class GrupoInventarioSemen {
	

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private GrupoInventarioSemenService grupoInventarioSemenService;
	
	 
	 
	    @GetMapping("")
	    @Operation(summary = "Read GrupoInventarioSemen", responses = {
	    @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = GrupoInventarioDTO.class)))})
	    public ResponseEntity<?> obtenerInventarioSemens() {
	        try {
	            List<GrupoInventarioDTO> obj = grupoInventarioSemenService.obtenerGrupoInventarioSemen();
	            
	           //System.out.println(gson.toJson(List2TreeUtil.getDtoTreeList(obj)));
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
