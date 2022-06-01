package com.vetapp.util;

import java.util.List;

public class LoginResponse {

    private String token;
    private String token_type;
    private List<UserRoleResponse> roles ;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getToken_type() {
        return token_type;
    }

    public void setToken_type(String token_type) {
        this.token_type = token_type;
    }

    public List<UserRoleResponse> getRoles() {
        return roles;
    }

    public void setRoles(List<UserRoleResponse> roles) {
        this.roles = roles;
    }
}
