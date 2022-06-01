package com.vetapp.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import com.vetapp.dao.UserAuthRepository;
import com.vetapp.dto.RoleDto;
import com.vetapp.dto.UserRoleDto;
import com.vetapp.service.RoleService;
import com.vetapp.service.UserRoleService;
import com.vetapp.util.UserRoleResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vetapp.config.JWTTokenHelper;
import com.vetapp.model.UserAuth;
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

    @Autowired
    UserAuthRepository userAuthRepository;

    @Autowired
    private UserRoleService userRoleService;

    @Autowired
    private RoleService roleService;

    @PostMapping("/token")
    @Operation(summary = "Login For Access Token", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = LoginResponse.class)))})
    public ResponseEntity<?> login(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {

            //final Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));

            Authentication authentication = this.authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

            SecurityContextHolder.getContext().setAuthentication(authentication);

            User user = (User) authentication.getPrincipal();
            String jwtToken = jWTTokenHelper.generateToken(user.getUsername());//El username es el Email a nivel de login

            LoginResponse response = new LoginResponse();
            response.setToken(jwtToken);
            response.setToken_type("Bearer");

            UserAuth userAuth = userAuthRepository.findByEmail(user.getUsername());
            List<UserRoleDto> userRoleDtos = userRoleService.obtenerUserRolePorUserId(userAuth.getId());
            List<UserRoleResponse> listRolTmp = new ArrayList<>();
            for (UserRoleDto ur: userRoleDtos) {
                UserRoleResponse urrTemp = new UserRoleResponse();
                RoleDto roleDto = roleService.obtenerRolePorId(ur.getRoleId());
                urrTemp.setId(roleDto.getId());
                urrTemp.setName(roleDto.getName());
                listRolTmp.add(urrTemp);
            }
            response.setRoles(listRolTmp);

            return new ResponseEntity(response, HttpStatus.OK);

    }

    @GetMapping("/auth/userinfo")
    @Operation(summary = "Read User Info", responses = {
            @ApiResponse(description = "Successful Response", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = UserInfo.class)))})
    public ResponseEntity<?> getUserInfo(Principal user) {
        UserAuth userObj = (UserAuth) userDetailsService.loadUserByUsername(user.getName());

        UserInfo userInfo = new UserInfo();
        userInfo.setFirstName(userObj.getUsername());
        userInfo.setLastName(userObj.getUsername());
        //userInfo.setRoles(userObj.getAuthorities().toArray());

        return new ResponseEntity(userInfo, HttpStatus.OK);
    }

    private Authentication authenticate(String username, String password) throws Exception {
        try {
            return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("Usuario Desactivado");
        } catch (BadCredentialsException e) {
            throw new Exception("Credenciales Invalidas");
        }
    }
}
