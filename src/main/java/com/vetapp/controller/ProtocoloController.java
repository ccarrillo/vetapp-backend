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
import com.vetapp.dto.AnimalDTO;
import com.vetapp.dto.DetalleProtocoloDTO;
import com.vetapp.dto.ProtocoloDTO;
import com.vetapp.service.DetalleProtocoloService;
import com.vetapp.service.ProtocoloService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/protocolo")
@CrossOrigin
@Tag(name = "protocolo")
public class ProtocoloController {
	
	

	private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ProtocoloService protocoloService;
    
    @Autowired
    private DetalleProtocoloService detalleProtocoloService;

    @PostMapping("")
    @Operation(summary = "Create Protocolo", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "201", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProtocoloDTO.class)))})
    public ResponseEntity<?> guardarProtocolo(@RequestBody ProtocoloDTO protocoloDto) {
        try {
            ProtocoloDTO obj = protocoloService.guardarProtocolo(protocoloDto);
            if(protocoloDto.getListaDetallleProtocoloDTO().size()>0) {
        		for(DetalleProtocoloDTO detalle:protocoloDto.getListaDetallleProtocoloDTO()) 
        		{
        			/*if(detalle.getId() != null ) {
        				System.out.println("ingreso aqui actualizacion detalle ");
        			}
        			else {*/
        				 detalle.setProtocolo(obj);
        				 detalleProtocoloService.guardarDetalleProtocolo(detalle);
        			//}
        			  
        		}
        	}
            return new ResponseEntity(obj, HttpStatus.CREATED);
        } catch (Exception e) {
            logger.error(e.getLocalizedMessage());
            return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("")
    @Operation(summary = "Read Protocolo", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProtocoloDTO.class)))})
    public ResponseEntity<?> obtenerProtocolo() {
        try {
            List<ProtocoloDTO> obj = protocoloService.obtenerProtocolo();
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
    @Operation(summary = "Read Protocolo", responses = {
    @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProtocoloDTO.class)))})
    public ResponseEntity<?> obtenerProtocoloPorIdAnimal(@PathVariable("id") Long id) {
        try {
            List<ProtocoloDTO> obj = protocoloService.buscarProtocoloPorAnimal(id);
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
    @Operation(summary = "Read Protocolo", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProtocoloDTO.class)))})
    public ResponseEntity<?> obtenerProtocoloPorId(@PathVariable("id") Long id) {
        try {
            ProtocoloDTO obj = protocoloService.obtenerProtocoloPorId(id);
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
    
    @GetMapping("porid/{id}")
    @Operation(summary = "Read Protocolo", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProtocoloDTO.class)))})
    public ResponseEntity<?> obtenerDetalleProtocoloPorIdProtocolo(@PathVariable("id") Long id) {
        try {
            ProtocoloDTO obj = protocoloService.obtenerDetalleProtocoloPorIdProtocolo(id);
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
    @Operation(summary = "Update Protocolo", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProtocoloDTO.class)))})
    public ResponseEntity<?> actualizarProtocolo(@RequestBody ProtocoloDTO protocoloDto, @PathVariable("id") Long id) {
        try {
            ProtocoloDTO obj = protocoloService.actualizarProtocolo(protocoloDto, id);
            if (obj != null) {
            	if(protocoloDto.getListaDetallleProtocoloDTO().size()>0) {
            		for(DetalleProtocoloDTO detalle:protocoloDto.getListaDetallleProtocoloDTO()) 
            		{    
            			if(detalle.getId() != null ) {
            				 if(detalle.isEliminado())
            				 {
            					detalleProtocoloService.eliminarDetalleProtocolo(detalle.getId()) ;
            				 }
            				 else{
            					// detalle.setIdprotocolo(obj.getId()); cambiado
            					 detalleProtocoloService.actualizarDetalleProtocolo(obj,detalle, detalle.getId());
            				 }
            				
            			}
            			else {
            				// detalle.setIdprotocolo(obj.getId()); cambiado
            				 detalleProtocoloService.guardarDetalleProtocolo(obj,detalle);
            			}
            			  
            		}
            	}
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
    @Operation(summary = "Delete Protocolo", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProtocoloDTO.class)))})
    public ResponseEntity<AnimalDTO> eliminarProtocolo(@PathVariable("id") Long id) {
        try {
            Boolean obj = protocoloService.eliminarProtocolo(id);
               // detalleProtocoloService.eliminarDetalleProtocoloPorIdProtocolo(id);
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
    
    @GetMapping("grupos")
    @Operation(summary = "Read TipoEventos Personalizado", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProtocoloDTO.class)))})
    public ResponseEntity<?> obtenerProtocoloGrupos() {
        try {
            List<ProtocoloDTO> obj = protocoloService.obtenerProtocoloGrupos();
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
