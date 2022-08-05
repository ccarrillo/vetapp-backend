package com.vetapp.controller;

import com.vetapp.dto.SubsidiaryDTO;
import com.vetapp.service.SubsidiaryService;
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
@RequestMapping("/subsidiary")
@CrossOrigin
@Tag(name = "subsidiary")
public class SubsidiaryController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SubsidiaryService subsidiaryService;

    @PostMapping("")
    @Operation(summary = "Create Subsidiary", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "201", content = @Content(mediaType = "application/json", schema = @Schema(implementation = SubsidiaryDTO.class)))})
    public ResponseEntity<?> guardarSubsidiary(@RequestBody SubsidiaryDTO subsidiaryDto) {
        try {
            SubsidiaryDTO obj = subsidiaryService.guardarSubsidiary(subsidiaryDto);
            return new ResponseEntity(obj, HttpStatus.CREATED);
        } catch (Exception e) {
            logger.error(e.getLocalizedMessage());
            return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("")
    @Operation(summary = "Read Subsidiarys", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = SubsidiaryDTO.class)))})
    public ResponseEntity<?> obtenerSubsidiarys() {
        try {
            List<SubsidiaryDTO> obj = subsidiaryService.obtenerSubsidiarys();
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
    @Operation(summary = "Read Subsidiary", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = SubsidiaryDTO.class)))})
    public ResponseEntity<?> obtenerSubsidiaryPorId(@PathVariable("id") Long id) {
        try {
            SubsidiaryDTO obj = subsidiaryService.obtenerSubsidiaryPorId(id);
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
    @Operation(summary = "Update Subsidiary", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = SubsidiaryDTO.class)))})
    public ResponseEntity<?> actualizarSubsidiary(@RequestBody SubsidiaryDTO subsidiaryDto, @PathVariable("id") Long id) {
        try {
            SubsidiaryDTO obj = subsidiaryService.actualizarSubsidiary(subsidiaryDto, id);
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
    @Operation(summary = "Delete Subsidiary", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = SubsidiaryDTO.class)))})
    public ResponseEntity<SubsidiaryDTO> eliminarSubsidiary(@PathVariable("id") Long id) {
        try {
            Boolean obj = subsidiaryService.eliminarSubsidiary(id);
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
