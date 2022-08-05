package com.vetapp.controller;

import com.vetapp.dto.EmployeeDTO;
import com.vetapp.dto.UserAuthDTO;
import com.vetapp.service.UserAuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin
@Tag(name = "users")
public class UserAuthController {

    @Autowired
    UserAuthService userAuthService;

    @PostMapping("")
    @PreAuthorize("hasAuthority('SUPERUSUARIO')")
    @Operation(summary = "Create UserAuth", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "201", content = @Content(mediaType = "application/json", schema = @Schema(implementation = UserAuthDTO.class)))})
    public ResponseEntity<?> guardarUserAuth(@RequestBody UserAuthDTO userAuthDto) {
        try {
            UserAuthDTO obj = userAuthService.guardarUserAuth(userAuthDto);
            return new ResponseEntity(obj, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("")
    @PreAuthorize("hasAuthority('SUPERUSUARIO')")
    @Operation(summary = "Read UserAuths", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = UserAuthDTO.class)))})
    public ResponseEntity<?> obtenerUserAuths() {
        try {
            List<UserAuthDTO> obj = userAuthService.obtenerUserAuths();
            if (obj.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity(obj, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('SUPERUSUARIO')")
    @Operation(summary = "Read UserAuth", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = UserAuthDTO.class)))})
    public ResponseEntity<?> obtenerUserAuthPorId(@PathVariable("id") Long id) {
        try {
            UserAuthDTO obj = userAuthService.obtenerUserAuthPorId(id);
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
    @PreAuthorize("hasAuthority('SUPERUSUARIO')")
    @Operation(summary = "Update UserAuth", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = UserAuthDTO.class)))})
    public ResponseEntity<?> actualizarUserAuth(@RequestBody UserAuthDTO userAuthDto, @PathVariable("id") Long id) {
        try {
            UserAuthDTO obj = userAuthService.actualizarUserAuth(userAuthDto, id);
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
    @PreAuthorize("hasAuthority('SUPERUSUARIO')")
    @Operation(summary = "Delete UserAuth", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = UserAuthDTO.class)))})
    public ResponseEntity<EmployeeDTO> eliminarUserAuth(@PathVariable("id") Long id) {
        try {
            Boolean obj = userAuthService.eliminarUserAuth(id);
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
