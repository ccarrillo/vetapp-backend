package com.vetapp.util;

import com.vetapp.dto.RolDto;

import java.util.List;

public class LoginResponse {

    private String access_token;
    private String token_type;
    private List<RolDto> roles ;

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getToken_type() {
        return token_type;
    }

    public void setToken_type(String token_type) {
        this.token_type = token_type;
    }

    public List<RolDto> getRoles() {
        return roles;
    }

    public void setRoles(List<RolDto> roles) {
        this.roles = roles;
    }
}
