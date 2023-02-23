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
import com.vetapp.dto.DetalleTipoEventoAnimalDTO;
import com.vetapp.dto.EventoAnimalDTO;
import com.vetapp.dto.RecordatorioEventoAnimalDTO;
import com.vetapp.service.AnimalService;
import com.vetapp.service.DetalleTipoEventoAnimalService;
import com.vetapp.service.EventoAnimalService;
import com.vetapp.service.RecordatorioEventoAnimalService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/eventoanimal")
@CrossOrigin
@Tag(name = "eventoanimal")
public class EventoAnimalController {
	
	
	  private Logger logger = LoggerFactory.getLogger(this.getClass());

	    @Autowired
	    private EventoAnimalService eventoService;
	    
	    @Autowired
	    private AnimalService animalService;
	    
	    @Autowired
	    private DetalleTipoEventoAnimalService detalleTipoEventoAnimalService;
	    
	    @Autowired
	    private RecordatorioEventoAnimalService recordatorioEventoAnimalService;

	    @PostMapping("")
	    @Operation(summary = "Create Evento", responses = {
	            @ApiResponse(description = "Successful Response", responseCode = "201", content = @Content(mediaType = "application/json", schema = @Schema(implementation = EventoAnimalDTO.class)))})
	    public ResponseEntity<?> guardarEvento(@RequestBody EventoAnimalDTO eventoAnimalDto) {
	        try {
	            EventoAnimalDTO obj = eventoService.guardarEvento(eventoAnimalDto);
	            if(eventoAnimalDto.getListaDetallleTipoEventoAnimalDTO().size()>0) {
	        		for(DetalleTipoEventoAnimalDTO detalle:eventoAnimalDto.getListaDetallleTipoEventoAnimalDTO()) 
	        		{
	        			/*if(detalle.getId() != null ) {
	        				System.out.println("ingreso aqui actualizacion detalle ");
	        			}
	        			else {*/
	        				 detalle.setIdeventoanimal(obj);
	        				 detalleTipoEventoAnimalService.guardarDetalleTipoEventoAnimal(detalle);
	        			//}
	        			  
	        		}
	        	}
	        	if(eventoAnimalDto.getListaRecordatorioEventoAnimalDTO().size()>0) {
	        		for(RecordatorioEventoAnimalDTO recordatorio:eventoAnimalDto.getListaRecordatorioEventoAnimalDTO()) {
	        			/*if(recordatorio.getId() != null ) {
	        				System.out.println("ingreso aqui actualizacion recordatorio ");
	        			}
	        			else {*/
	        				//System.out.println("ingreso aqui crear recordatorio ");
	        				recordatorio.setIdeventoanimal(obj);
	        				recordatorioEventoAnimalService.guardarRecordatorioEvento(recordatorio);
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
	    @Operation(summary = "Read Eventos", responses = {
	            @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = EventoAnimalDTO.class)))})
	    public ResponseEntity<?> obtenerEventos() {
	        try {
	            List<EventoAnimalDTO> obj = eventoService.obtenerEventos();
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
	    @Operation(summary = "Read Evento", responses = {
	            @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = EventoAnimalDTO.class)))})
	    public ResponseEntity<?> obtenerEventoPorId(@PathVariable("id") Long id) {
	        try {
	            EventoAnimalDTO obj = eventoService.obtenerEventoPorId(id);
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
	    @Operation(summary = "Update Evento", responses = {
	            @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = EventoAnimalDTO.class)))})
	    public ResponseEntity<?> actualizarEvento(@RequestBody EventoAnimalDTO eventoDto, @PathVariable("id") Long id) {
	        try {
	            EventoAnimalDTO obj = eventoService.actualizarEvento(eventoDto, id);
	            if (obj != null) {
	            	if(eventoDto.getListaDetallleTipoEventoAnimalDTO().size()>0) {
	            		for(DetalleTipoEventoAnimalDTO detalle:eventoDto.getListaDetallleTipoEventoAnimalDTO()) {
	            			if(detalle.getId() != null   ) {
	            				detalleTipoEventoAnimalService.actualizarDetalleTipoEventoAnimal(obj,detalle, detalle.getId());
	            			}
	            			
	            				  
	            		}
	            	}
	            	if(eventoDto.getListaRecordatorioEventoAnimalDTO().size()>0) {
	            		for(RecordatorioEventoAnimalDTO recordatorio:eventoDto.getListaRecordatorioEventoAnimalDTO()) {
	            			if(recordatorio.getId() != null && !recordatorio.isEliminado() ) {
	            				recordatorioEventoAnimalService.actualizarRecordatorioEvento(obj,recordatorio, recordatorio.getId());
	            			}
	            			
	            			if(recordatorio.getId() != null && recordatorio.isEliminado() ) {
	            				recordatorioEventoAnimalService.eliminarRecordatorioEventoAnimal(recordatorio.getId());
	            			}
	            			
	            			if( recordatorio.getId() == null ) {
	            				//recordatorio.setIdtipoevento(obj.getId());
	            				recordatorioEventoAnimalService.guardarRecordatorioEvento(obj,recordatorio);
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
	    @Operation(summary = "Delete Evento", responses = {
	            @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = EventoAnimalDTO.class)))})
	    public ResponseEntity<EventoAnimalDTO> eliminarEvento(@PathVariable("id") Long id) {
	        try {
	            Boolean obj = eventoService.eliminarEvento(id);
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
	    
	    @GetMapping("animal/{id}")
	    @Operation(summary = "Read Evento", responses = {
	            @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = EventoAnimalDTO.class)))})
	    public ResponseEntity<?> obtenerEventosPorIdAnimal(@PathVariable("id") Long id) {
	        try {
	        	 List<EventoAnimalDTO> obj = eventoService.obtenerEventosPorIdAnimal(id);
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
	    
	    @PostMapping("/animal/{animalId}")
	    @Operation(summary = "Create Evento", responses = {
	    @ApiResponse(description = "Successful Response", responseCode = "201", content = @Content(mediaType = "application/json", schema = @Schema(implementation = EventoAnimalDTO.class)))})
	    public ResponseEntity<?> guardarEvento(@PathVariable("animalId") Long animalId, @RequestBody EventoAnimalDTO eventoAnimalDto) {
	    	 try { 
	    		 AnimalDTO objAnimal = animalService.obtenerAnimalPorId(animalId);
	    		 if (objAnimal == null) {
	                 return new ResponseEntity(HttpStatus.NOT_FOUND);
	             }
	    		     eventoAnimalDto.setIdAnimal(objAnimal);
		            EventoAnimalDTO obj = eventoService.guardarEvento(eventoAnimalDto);
		            if(eventoAnimalDto.getListaDetallleTipoEventoAnimalDTO().size()>0) {
		        		for(DetalleTipoEventoAnimalDTO detalle:eventoAnimalDto.getListaDetallleTipoEventoAnimalDTO()) 
		        		{
		        			/*if(detalle.getId() != null ) {
		        				System.out.println("ingreso aqui actualizacion detalle ");
		        			}
		        			else {*/
		        				 detalle.setIdeventoanimal(obj);
		        				 detalleTipoEventoAnimalService.guardarDetalleTipoEventoAnimal(detalle);
		        			//}
		        			  
		        		}
		        	}
		        	if(eventoAnimalDto.getListaRecordatorioEventoAnimalDTO().size()>0) {
		        		for(RecordatorioEventoAnimalDTO recordatorio:eventoAnimalDto.getListaRecordatorioEventoAnimalDTO()) {
		        			/*if(recordatorio.getId() != null ) {
		        				System.out.println("ingreso aqui actualizacion recordatorio ");
		        			}
		        			else {*/
		        				//System.out.println("ingreso aqui crear recordatorio ");
		        				recordatorio.setIdeventoanimal(obj);
		        				recordatorioEventoAnimalService.guardarRecordatorioEvento(recordatorio);
		        			//}
		        			  
		        		}
		        	}
		            return new ResponseEntity(obj, HttpStatus.CREATED);
		        } catch (Exception e) {
		            logger.error(e.getLocalizedMessage());
		            return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
		        }
	    }
	    
	    @PutMapping("/animal/{animalId}/evento/{id}")
	    @Operation(summary = "Update Evento", responses = {
	            @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = EventoAnimalDTO.class)))})
	    public ResponseEntity<?> actualizarEvento(@PathVariable("animalId") Long animalId,@RequestBody EventoAnimalDTO eventoAnimalDto, @PathVariable("id") Long id) {
	        try {
	        	 AnimalDTO objAnimal = animalService.obtenerAnimalPorId(animalId);
	    		 if (objAnimal == null) {
	                 return new ResponseEntity(HttpStatus.NOT_FOUND);
	             }
	    		   eventoAnimalDto.setIdAnimal(objAnimal);
	            EventoAnimalDTO obj = eventoService.actualizarEvento(eventoAnimalDto, id);
	            if (obj != null) {
	            	if(eventoAnimalDto.getListaDetallleTipoEventoAnimalDTO().size()>0) {
	            		for(DetalleTipoEventoAnimalDTO detalle:eventoAnimalDto.getListaDetallleTipoEventoAnimalDTO()) {
	            			if(detalle.getId() != null   ) {
	            				detalleTipoEventoAnimalService.actualizarDetalleTipoEventoAnimal(obj,detalle, detalle.getId());
	            			}
	            			
	            				  
	            		}
	            	}
	            	if(eventoAnimalDto.getListaRecordatorioEventoAnimalDTO().size()>0) {
	            		for(RecordatorioEventoAnimalDTO recordatorio:eventoAnimalDto.getListaRecordatorioEventoAnimalDTO()) {
	            			if(recordatorio.getId() != null && !recordatorio.isEliminado() ) {
	            				recordatorioEventoAnimalService.actualizarRecordatorioEvento(obj,recordatorio, recordatorio.getId());
	            			}
	            			
	            			if(recordatorio.getId() != null && recordatorio.isEliminado() ) {
	            				recordatorioEventoAnimalService.eliminarRecordatorioEventoAnimal(recordatorio.getId());
	            			}
	            			
	            			if( recordatorio.getId() == null ) {
	            				//recordatorio.setIdtipoevento(obj.getId());
	            				recordatorioEventoAnimalService.guardarRecordatorioEvento(obj,recordatorio);
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
	    

}
