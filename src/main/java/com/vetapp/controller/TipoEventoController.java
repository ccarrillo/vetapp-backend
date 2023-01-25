package com.vetapp.controller;

import com.vetapp.dto.DetalleTipoEventoDTO;
import com.vetapp.dto.RecordatorioEventoDTO;
import com.vetapp.dto.TipoEventoDTO;
import com.vetapp.service.DetalleTipoEventoService;
import com.vetapp.service.RecordatorioEventoService;
import com.vetapp.service.TipoEventoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.hibernate.hql.internal.ast.tree.IsNotNullLogicOperatorNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tipoevento")
@CrossOrigin
@Tag(name = "tipoevento")
public class TipoEventoController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TipoEventoService tipoEventoService;
    
    @Autowired
    private DetalleTipoEventoService detalleTipoEventoService;
    
    @Autowired
    private RecordatorioEventoService recordatorioEventoService;

    @PostMapping("")
    @Operation(summary = "Create TipoEvento", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "201", content = @Content(mediaType = "application/json", schema = @Schema(implementation = TipoEventoDTO.class)))})
    public ResponseEntity<?> guardarTipoEvento(@RequestBody TipoEventoDTO tipoEventoDto) {
        try {
            TipoEventoDTO obj = tipoEventoService.guardarTipoEvento(tipoEventoDto);
        	/*TipoEventoDTO obj = tipoEventoDto;
        	System.out.println("Tipo Evento"+obj);*/
        	if(tipoEventoDto.getListaDetallleTipoEventoDTO().size()>0) {
        		for(DetalleTipoEventoDTO detalle:tipoEventoDto.getListaDetallleTipoEventoDTO()) 
        		{
        			/*if(detalle.getId() != null ) {
        				System.out.println("ingreso aqui actualizacion detalle ");
        			}
        			else {*/
        				 detalle.setIdTipoEvento(obj.getId());
        				 detalleTipoEventoService.guardarDetalleTipoEvento(detalle);
        			//}
        			  
        		}
        	}
        	if(tipoEventoDto.getListaRecordatorioEventoDTO().size()>0) {
        		for(RecordatorioEventoDTO recordatorio:tipoEventoDto.getListaRecordatorioEventoDTO()) {
        			/*if(recordatorio.getId() != null ) {
        				System.out.println("ingreso aqui actualizacion recordatorio ");
        			}
        			else {*/
        				//System.out.println("ingreso aqui crear recordatorio ");
        				recordatorio.setIdtipoevento(obj.getId());
        				recordatorioEventoService.guardarRecordatorioEvento(recordatorio);
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
    @Operation(summary = "Read TipoEventos", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = TipoEventoDTO.class)))})
    public ResponseEntity<?> obtenerTipoEventos() {
        try {
            List<TipoEventoDTO> obj = tipoEventoService.obtenerTipoEventos();
            if (obj.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity(obj, HttpStatus.OK);
        } catch (Exception e) {
            logger.error(e.getLocalizedMessage());
            return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    
    @GetMapping("grupos")
    @Operation(summary = "Read TipoEventos Personalizado", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = TipoEventoDTO.class)))})
    public ResponseEntity<?> obtenerTipoEventosGrupos() {
        try {
            List<TipoEventoDTO> obj = tipoEventoService.obtenerTipoEventosGrupos();
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
    @Operation(summary = "Read TipoEvento", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = TipoEventoDTO.class)))})
    public ResponseEntity<?> obtenerTipoEventoPorId(@PathVariable("id") Long id) {
        try {
            TipoEventoDTO obj = tipoEventoService.obtenerTipoEventoPorId(id);
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
    @Operation(summary = "Update TipoEvento", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = TipoEventoDTO.class)))})
    public ResponseEntity<?> actualizarTipoEvento(@RequestBody TipoEventoDTO tipoEventoDto, @PathVariable("id") Long id) {
        try {
            TipoEventoDTO obj = tipoEventoService.actualizarTipoEvento(tipoEventoDto, id);
            if (obj != null) {
            	if(tipoEventoDto.getListaDetallleTipoEventoDTO().size()>0) {
            		for(DetalleTipoEventoDTO detalle:tipoEventoDto.getListaDetallleTipoEventoDTO()) {
            			if(detalle.getId() != null && detalle.isEditado() ) {
            				detalleTipoEventoService.actualizarDetalleTipoEvento(detalle, detalle.getId());
            			}
            			if( detalle.getId() == null ) {
            				  //System.out.println("ingreso a la prueba"+detalle.getNombre());
            				  detalle.setIdTipoEvento(obj.getId());
             				 detalleTipoEventoService.guardarDetalleTipoEvento(detalle);
            			}
            				  
            		}
            	}
            	if(tipoEventoDto.getListaRecordatorioEventoDTO().size()>0) {
            		for(RecordatorioEventoDTO recordatorio:tipoEventoDto.getListaRecordatorioEventoDTO()) {
            			if(recordatorio.getId() != null && recordatorio.isEditado() ) {
            				recordatorioEventoService.actualizarRecordatorioEvento(recordatorio, recordatorio.getId());
            			}
            			if( recordatorio.getId() == null ) {
            				recordatorio.setIdtipoevento(obj.getId());
            				recordatorioEventoService.guardarRecordatorioEvento(recordatorio);
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
    @Operation(summary = "Delete TipoEvento", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = TipoEventoDTO.class)))})
    public ResponseEntity<TipoEventoDTO> eliminarTipoEvento(@PathVariable("id") Long id) {
        try {
            Boolean obj = tipoEventoService.eliminarTipoEvento(id);
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
