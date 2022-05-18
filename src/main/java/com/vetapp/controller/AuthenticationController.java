package com.vetapp.controller;

import java.security.NoSuchAlgorithmException;
import java.security.Principal;
import java.security.spec.InvalidKeySpecException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vetapp.config.JWTTokenHelper;
import com.vetapp.model.User;
import com.vetapp.util.AuthenticationRequest;
import com.vetapp.util.LoginResponse;
import com.vetapp.util.UserInfo;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/login")
@CrossOrigin
@Tag(name = "login")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    JWTTokenHelper jWTTokenHelper;

    @Autowired
    private UserDetailsService userDetailsService;

    @PostMapping("/token")
    @Operation(summary = "Login For Access Token", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = LoginResponse.class)))})
    public ResponseEntity<?> login(@RequestBody AuthenticationRequest authenticationRequest)
            throws InvalidKeySpecException, NoSuchAlgorithmException {

        final Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(),
                        authenticationRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        User user = (User) authentication.getPrincipal();
        String jwtToken = jWTTokenHelper.generateToken(user.getUsername());

        LoginResponse response = new LoginResponse();
        response.setAccess_token(jwtToken);
        response.setToken_type("Bearer");

        return ResponseEntity.ok(response);
    }

    @GetMapping("/auth/userinfo")
    @Operation(summary = "Read User Info", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = UserInfo.class)))})
    public ResponseEntity<?> getUserInfo(Principal user) {
        User userObj = (User) userDetailsService.loadUserByUsername(user.getName());

        UserInfo userInfo = new UserInfo();
        userInfo.setFirstName(userObj.getUserName());
        userInfo.setLastName(userObj.getUserName());
        userInfo.setRoles(userObj.getAuthorities().toArray());

        return ResponseEntity.ok(userInfo);
    }
}
