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
import com.vetapp.dto.GrupoDTO;
import com.vetapp.dto.GrupoInventarioDTO;
import com.vetapp.model.GrupoInventario;
import com.vetapp.service.GrupoInventarioSemenService;
import com.vetapp.util.List2TreeUtil;

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
	   
    @PostMapping("")
    @Operation(summary = "Create GrupoAnimal", responses = {
    @ApiResponse(description = "Successful Response", responseCode = "201", content = @Content(mediaType = "application/json", schema = @Schema(implementation = GrupoInventarioDTO.class)))})
    public ResponseEntity<?> guardarGrupo(@RequestBody GrupoInventarioDTO grupoDto) {
        try {
        	
        		GrupoInventarioDTO obj = grupoInventarioSemenService.guardarGrupoInventario(grupoDto);
                return new ResponseEntity(obj, HttpStatus.CREATED);
        	
            
        } catch (Exception e) {
            logger.error(e.getLocalizedMessage());
            return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
	 
	 
	    @GetMapping("")
	    @Operation(summary = "Read GrupoInventarioSemen", responses = {
	    @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = GrupoInventario.class)))})
	    public ResponseEntity<?> obtenerInventarioSemens() {
	        try {
	        	Gson gson = new Gson();
	            List<GrupoInventario> obj = grupoInventarioSemenService.obtenerGrupoInventarioSemen();
	            
	           //System.out.println(gson.toJson(List2TreeUtil.getDtoTreeList(obj)));
	            if (obj.isEmpty()) {
	                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	            }
	            return new ResponseEntity(gson.toJson(List2TreeUtil.getDtoTreeListInventario(obj)), HttpStatus.OK);
	        } catch (Exception e) {
	            logger.error(e.getLocalizedMessage());
	            return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }
	    
	    
	    @GetMapping("sinhijo")
	    @Operation(summary = "Read GrupoInventario", responses = {
	            @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = GrupoInventarioDTO.class)))})
	    public ResponseEntity<?> obtenerGrupoInventario() {
	        try {
	        	
	            List<GrupoInventarioDTO> obj = grupoInventarioSemenService.obtenerGrupoInventarioSinHijos();
	            
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
	            @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = GrupoInventarioDTO.class)))})
	    public ResponseEntity<?> obtenerGrupoInventarioPorId(@PathVariable("id") Long id) {
	        try {
	            GrupoInventarioDTO obj = grupoInventarioSemenService.obtenerGrupoInventarioPorId(id);
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
	    @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = GrupoInventarioDTO.class)))})
	    public ResponseEntity<?> existenciaInventario(@PathVariable("idgrupo") Long idgrupo) {
	        try {
	        	boolean respuesta;
	        	
	        		if(grupoInventarioSemenService.existenciaInventario(idgrupo))
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
	    @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = GrupoInventarioDTO.class)))})
	    public ResponseEntity<?> actualizarGrupo(@RequestBody GrupoInventarioDTO grupoDto, @PathVariable("id") Long id) {
	        try {
	        	
	            GrupoInventarioDTO obj = grupoInventarioSemenService.actualizarGrupoInventario(grupoDto, id);
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
	    @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = GrupoInventarioDTO.class)))})
	    public ResponseEntity<GrupoInventarioDTO> eliminarGrupo(@PathVariable("id") Long id) {
	        try {
	            Boolean obj = grupoInventarioSemenService.eliminarGrupoInventario(id);
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
