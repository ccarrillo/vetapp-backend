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
    private Long userCreation;

    @Column(name = "modified_at")
    private Date modifiedAt;

    @Column(name = "user_updated")
    private Long userUpdated;

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

    public Long getUserCreation() {
        return userCreation;
    }

    public void setUserCreation(Long userCreation) {
        this.userCreation = userCreation;
    }

    public Date getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(Date modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    public Long getUserUpdated() {
        return userUpdated;
    }

    public void setUserUpdated(Long userUpdated) {
        this.userUpdated = userUpdated;
    }
}
