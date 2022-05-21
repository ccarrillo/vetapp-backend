package com.vetapp.dto;

import java.util.Date;

public class BaseModelDto {

    private boolean isActive = true;
    private Date createdAt;
    private Integer userCreation;
    private Date modifiedAt;
    private Integer userUpdated;

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getUserCreation() {
        return userCreation;
    }

    public void setUserCreation(Integer userCreation) {
        this.userCreation = userCreation;
    }

    public Date getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(Date modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    public Integer getUserUpdated() {
        return userUpdated;
    }

    public void setUserUpdated(Integer userUpdated) {
        this.userUpdated = userUpdated;
    }
}
