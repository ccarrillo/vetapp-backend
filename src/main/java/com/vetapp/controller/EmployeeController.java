package com.vetapp.controller;

import com.vetapp.dto.EmployeeDto;
import com.vetapp.service.EmployeeService;
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
@RequestMapping("/employees")
@CrossOrigin
@Tag(name = "employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("")
    @Operation(summary = "Create Employee", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "201", content = @Content(mediaType = "application/json", schema = @Schema(implementation = EmployeeDto.class)))})
    public ResponseEntity<?> guardarEmpleado(@RequestBody EmployeeDto employeeDto) {
        try {
            EmployeeDto obj = employeeService.guardarEmpleado(employeeDto);
            return new ResponseEntity(obj, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("")
    @Operation(summary = "Read Employees", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = EmployeeDto.class)))})
    public ResponseEntity<?> obtenerEmpleados() {
        try {
            List<EmployeeDto> obj = employeeService.obtenerEmpleados();
            if (obj.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity(obj, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    @Operation(summary = "Read Employee", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = EmployeeDto.class)))})
    public ResponseEntity<?> obtenerEmpleadoPorId(@PathVariable("id") Long id) {
        try {
            EmployeeDto obj = employeeService.obtenerEmpleadoPorId(id);
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
    @Operation(summary = "Update Employee", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = EmployeeDto.class)))})
    public ResponseEntity<?> actualizarEmpleado(@RequestBody EmployeeDto employeeDto, @PathVariable("id") Long id) {
        try {
            EmployeeDto obj = employeeService.actualizarEmpleado(employeeDto, id);
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
    @Operation(summary = "Delete Employee", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = EmployeeDto.class)))})
    public ResponseEntity<EmployeeDto> eliminarEmpleado(@PathVariable("id") Long id) {
        try {
            Boolean obj = employeeService.eliminarEmpleado(id);
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
