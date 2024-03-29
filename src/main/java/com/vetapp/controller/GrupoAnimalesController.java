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

import com.google.gson.Gson;
import com.vetapp.dto.AnimalDTO;
import com.vetapp.dto.GrupoDTO;
import com.vetapp.dto.InventarioSemenDTO;
import com.vetapp.dto.ListaGrupoDTO;
import com.vetapp.model.Grupo;
import com.vetapp.service.GrupoAnimalesService;
import com.vetapp.service.InventarioSemenService;
import com.vetapp.util.List2TreeUtil;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/grupoanimal")
@CrossOrigin
@Tag(name = "grupoanimal")
public class GrupoAnimalesController {
	

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private GrupoAnimalesService grupoAnimalesService;
	
    @PostMapping("")
    @Operation(summary = "Create GrupoAnimal", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "201", content = @Content(mediaType = "application/json", schema = @Schema(implementation = GrupoDTO.class)))})
    public ResponseEntity<?> guardarGrupo(@RequestBody GrupoDTO grupoDto) {
        try {
        	
        		GrupoDTO obj = grupoAnimalesService.guardarGrupoAnimles(grupoDto);
                return new ResponseEntity(obj, HttpStatus.CREATED);
        	
            
        } catch (Exception e) {
            logger.error(e.getLocalizedMessage());
            return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
	 
	 
	    @GetMapping("")
	    @Operation(summary = "Read GrupoAnimales", responses = {
	            @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Grupo.class)))})
	    public ResponseEntity<?> obtenerInventarioSemens() {
	        try {
	        	Gson gson = new Gson();
	            List<Grupo> obj = grupoAnimalesService.obtenerGrupoAnimales();
	            
	           //System.out.println(gson.toJson(List2TreeUtil.getDtoTreeList(obj)));
	            if (obj.isEmpty()) {
	                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	            }
	            return new ResponseEntity(gson.toJson(List2TreeUtil.getDtoTreeList(obj)), HttpStatus.OK);
	        } catch (Exception e) {
	            logger.error(e.getLocalizedMessage());
	            return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }
	   
	    
	    @GetMapping("sinhijo")
	    @Operation(summary = "Read GrupoAnimales", responses = {
	            @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = GrupoDTO.class)))})
	    public ResponseEntity<?> obtenerGrupoAnimal() {
	        try {
	        	
	            List<GrupoDTO> obj = grupoAnimalesService.obtenerGrupoAnimalesSinHijos();
	            
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
	    
	    
	    @GetMapping("/{id}")
	    @Operation(summary = "Read Grupo Animal", responses = {
	            @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = GrupoDTO.class)))})
	    public ResponseEntity<?> obtenerGrupoAnimalPorId(@PathVariable("id") Long id) {
	        try {
	            GrupoDTO obj = grupoAnimalesService.obtenerGrupoAnimalesPorId(id);
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
	    
	    
	    @GetMapping("existe/{idgrupo}")
	    @Operation(summary = "existencia Animals", responses = {
	    @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = GrupoDTO.class)))})
	    public ResponseEntity<?> existenciaAnimalArete(@PathVariable("idgrupo") Long idgrupo) {
	        try {
	        	boolean respuesta;
	        	
	        		if(grupoAnimalesService.existenciaAnimales(idgrupo))
	        		{
	        			respuesta=true;
	        		}
	        		else {
	        			respuesta = false;
	        		}
	        	
	            
	            return new ResponseEntity(respuesta, HttpStatus.OK);
	        } catch (Exception e) {
	            logger.error(e.getLocalizedMessage());
	            return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }
	    
	    
	    @PutMapping("/{id}")
	    @Operation(summary = "Update Grupo", responses = {
	            @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = GrupoDTO.class)))})
	    public ResponseEntity<?> actualizarGrupo(@RequestBody GrupoDTO grupoDto, @PathVariable("id") Long id) {
	        try {
	        	
	            GrupoDTO obj = grupoAnimalesService.actualizarGrupoAnimales(grupoDto, id);
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
	    @Operation(summary = "Delete GrupoAnimal", responses = {
	    @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = GrupoDTO.class)))})
	    public ResponseEntity<GrupoDTO> eliminarGrupo(@PathVariable("id") Long id) {
	        try {
	            Boolean obj = grupoAnimalesService.eliminarGrupo(id);
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
