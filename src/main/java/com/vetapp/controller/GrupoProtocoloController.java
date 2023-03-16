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
import com.vetapp.dto.GrupoEventoDTO;
import com.vetapp.dto.GrupoProtocoloDTO;
import com.vetapp.model.GrupoEvento;
import com.vetapp.model.GrupoProtocolo;
import com.vetapp.service.GrupoProtocoloService;
import com.vetapp.util.List2TreeUtil;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/grupoprotocolo")
@CrossOrigin
@Tag(name = "grupoprotocolo")//obtenerGrupoEventoSinHijos
public class GrupoProtocoloController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private GrupoProtocoloService grupoProtocoloService;
    
    
    @PostMapping("")
    @Operation(summary = "Create GrupoProtocolo", responses = {
    @ApiResponse(description = "Successful Response", responseCode = "201", content = @Content(mediaType = "application/json", schema = @Schema(implementation = GrupoProtocoloDTO.class)))})
    public ResponseEntity<?> guardarGrupoProtocolo(@RequestBody GrupoProtocoloDTO grupoDto) {
        try {
        	
        		GrupoProtocoloDTO obj = grupoProtocoloService.guardarGrupoProtocolo(grupoDto);
                return new ResponseEntity(obj, HttpStatus.CREATED);
        	
            
        } catch (Exception e) {
            logger.error(e.getLocalizedMessage());
            return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    
    @GetMapping("")
    @Operation(summary = "Read GrupoProtocolo", responses = {
    @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = GrupoProtocolo.class)))})
    public ResponseEntity<?> obtenerEventoAnimal() {
        try {
        	Gson gson = new Gson();
            List<GrupoProtocolo> obj = grupoProtocoloService.obtenerGrupoProtocolo();
            
           //System.out.println(gson.toJson(List2TreeUtil.getDtoTreeList(obj)));
            if (obj.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity(gson.toJson(List2TreeUtil.getDtoTreeListProtocolo(obj)), HttpStatus.OK);
        } catch (Exception e) {
            logger.error(e.getLocalizedMessage());
            return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    
    @GetMapping("sinhijo")
    @Operation(summary = "Read GrupoProtocolo", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = GrupoProtocoloDTO.class)))})
    public ResponseEntity<?> obtenerGrupoProtocolo() {
        try {
        	
            List<GrupoProtocoloDTO> obj = grupoProtocoloService.obtenerGrupoProtocoloSinHijos();

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
    @Operation(summary = "Read Grupo Protocolo", responses = {
    @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = GrupoProtocoloDTO.class)))})
    public ResponseEntity<?> obtenerGrupoProtocoloPorId(@PathVariable("id") Long id) {
        try {
            GrupoProtocoloDTO obj = grupoProtocoloService.obtenerGrupoProtocoloPorId(id);
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
    @Operation(summary = "existencia protocolo", responses = {
    @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = GrupoProtocoloDTO.class)))})
    public ResponseEntity<?> existenciaProtocolo(@PathVariable("idgrupo") Long idgrupo) {
        try {
        	boolean respuesta;
        	
        		if(grupoProtocoloService.existenciaProtocolo(idgrupo))
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
    @Operation(summary = "Update GrupoProtocolo", responses = {
    @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = GrupoProtocoloDTO.class)))})
    public ResponseEntity<?> actualizarGrupoProtocolo(@RequestBody GrupoProtocoloDTO grupoDto, @PathVariable("id") Long id) {
        try {
        	
            GrupoProtocoloDTO obj = grupoProtocoloService.actualizarGrupoProtocolo(grupoDto, id);
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
    @Operation(summary = "Delete GrupoProtocolo", responses = {
    @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = GrupoProtocoloDTO.class)))})
    public ResponseEntity<GrupoEventoDTO> eliminarGrupoEvento(@PathVariable("id") Long id) {
        try {
            Boolean obj = grupoProtocoloService.eliminarGrupoProtocolo(id);
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
