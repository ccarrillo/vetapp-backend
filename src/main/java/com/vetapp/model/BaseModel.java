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
    private boolean is_active = true;

    @Column(name = "created_at")
    private Date created_at;

    @Column(name = "user_creation")
    private Integer user_creation;

    @Column(name = "modified_at")
    private Date modified_at;

    @Column(name = "user_updated")
    private Integer user_updated;

    public boolean isIs_active() {
        return is_active;
    }

    public void setIs_active(boolean is_active) {
        this.is_active = is_active;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Integer getUser_creation() {
        return user_creation;
    }

    public void setUser_creation(Integer user_creation) {
        this.user_creation = user_creation;
    }

    public Date getModified_at() {
        return modified_at;
    }

    public void setModified_at(Date modified_at) {
        this.modified_at = modified_at;
    }

    public Integer getUser_updated() {
        return user_updated;
    }

    public void setUser_updated(Integer user_updated) {
        this.user_updated = user_updated;
    }
}
