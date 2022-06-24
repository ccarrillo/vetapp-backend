package com.vetapp.controller;

import com.vetapp.dto.EnterpriseDto;
import com.vetapp.service.EnterpriseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enterprise")
@CrossOrigin
@Tag(name = "enterprise")
public class EnterpriseController {

    @Autowired
    private EnterpriseService enterpriseService;

    @PostMapping("")
    @Operation(summary = "Create Enterprise", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "201", content = @Content(mediaType = "application/json", schema = @Schema(implementation = EnterpriseDto.class)))})
    public ResponseEntity<?> guardarEmpresa(@RequestBody EnterpriseDto enterpriseDto) {
        try {
            EnterpriseDto obj = enterpriseService.guardarEmpresa(enterpriseDto);
            return new ResponseEntity(obj, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("")
    @Operation(summary = "Read Enterprises", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = EnterpriseDto.class)))})
    public ResponseEntity<?> obtenerEmpresas() {
        try {
            List<EnterpriseDto> obj = enterpriseService.obtenerEmpresas();
            if (obj.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity(obj, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    @Operation(summary = "Read Enterprise", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = EnterpriseDto.class)))})
    public ResponseEntity<?> obtenerEmpresaPorId(@PathVariable("id") Long id) {
        try {
            EnterpriseDto obj = enterpriseService.obtenerEmpresaPorId(id);
            if (obj != null) {
                return new ResponseEntity(obj, HttpStatus.OK);
            } else {
                return new ResponseEntity(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update Enterprise", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = EnterpriseDto.class)))})
    public ResponseEntity<?> actualizarEmpresa(@RequestBody EnterpriseDto enterpriseDto, @PathVariable("id") Long id) {
        try {
            EnterpriseDto obj = enterpriseService.actualizarEmpresa(enterpriseDto, id);
            if (obj != null) {
                return new ResponseEntity(obj, HttpStatus.OK);
            } else {
                return new ResponseEntity(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete Enterprise", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = EnterpriseDto.class)))})
    public ResponseEntity<EnterpriseDto> eliminarEmpresa(@PathVariable("id") Long id) {
        try {
            Boolean obj = enterpriseService.eliminarEmpresa(id);
            if (obj) {
                return new ResponseEntity(obj, HttpStatus.OK);
            } else {
                return new ResponseEntity(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
