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
import com.vetapp.dto.GrupoEventoDTO;
import com.vetapp.dto.GrupoInventarioDTO;
import com.vetapp.model.GrupoEvento;
import com.vetapp.model.GrupoInventario;
import com.vetapp.service.GrupoEventoService;
import com.vetapp.util.List2TreeUtil;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/grupoevento")
@CrossOrigin
@Tag(name = "grupoevento")//obtenerGrupoEventoSinHijos
public class GrupoEventoController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private GrupoEventoService grupoEventoService;
    
    
    @PostMapping("")
    @Operation(summary = "Create GrupoAnimal", responses = {
    @ApiResponse(description = "Successful Response", responseCode = "201", content = @Content(mediaType = "application/json", schema = @Schema(implementation = GrupoEventoDTO.class)))})
    public ResponseEntity<?> guardarGrupo(@RequestBody GrupoEventoDTO grupoDto) {
        try {
        	
        		GrupoEventoDTO obj = grupoEventoService.guardarGrupoEvento(grupoDto);
                return new ResponseEntity(obj, HttpStatus.CREATED);
        	
            
        } catch (Exception e) {
            logger.error(e.getLocalizedMessage());
            return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    
    @GetMapping("")
    @Operation(summary = "Read GrupoInventarioSemen", responses = {
    @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = GrupoEvento.class)))})
    public ResponseEntity<?> obtenerEventoAnimal() {
        try {
        	Gson gson = new Gson();
            List<GrupoEvento> obj = grupoEventoService.obtenerGrupoEvento();
            
           //System.out.println(gson.toJson(List2TreeUtil.getDtoTreeList(obj)));
            if (obj.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity(gson.toJson(List2TreeUtil.getDtoTreeListEvento(obj)), HttpStatus.OK);
        } catch (Exception e) {
            logger.error(e.getLocalizedMessage());
            return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @GetMapping("sinhijo")
    @Operation(summary = "Read GrupoEvento", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = GrupoEventoDTO.class)))})
    public ResponseEntity<?> obtenerGrupoEvento() {
        try {
        	
            List<GrupoEventoDTO> obj = grupoEventoService.obtenerGrupoEventoSinHijos();
            
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
    @Operation(summary = "Read Grupo Evento", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = GrupoEventoDTO.class)))})
    public ResponseEntity<?> obtenerGrupoEventoPorId(@PathVariable("id") Long id) {
        try {
            GrupoEventoDTO obj = grupoEventoService.obtenerGrupoEventoPorId(id);
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
    @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = GrupoEventoDTO.class)))})
    public ResponseEntity<?> existenciaEvento(@PathVariable("idgrupo") Long idgrupo) {
        try {
        	boolean respuesta;
        	
        		if(grupoEventoService.existenciaEvento(idgrupo))
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
    @Operation(summary = "Update GrupoEvento", responses = {
    @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = GrupoEventoDTO.class)))})
    public ResponseEntity<?> actualizarGrupoEvento(@RequestBody GrupoEventoDTO grupoDto, @PathVariable("id") Long id) {
        try {
        	
            GrupoEventoDTO obj = grupoEventoService.actualizarGrupoEvento(grupoDto, id);
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
    @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = GrupoEventoDTO.class)))})
    public ResponseEntity<GrupoEventoDTO> eliminarGrupoEvento(@PathVariable("id") Long id) {
        try {
            Boolean obj = grupoEventoService.eliminarGrupoEvento(id);
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
