package com.vetapp.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
public class BaseModel implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Column(name = "is_active")
    private boolean isActive = true;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "user_creation")
    private Integer userCreation;

    @Column(name = "modified_at")
    private Date modifiedAt;

    @Column(name = "user_updated")
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
