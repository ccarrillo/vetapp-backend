package com.vetapp.model;

import javax.persistence.*;

@Table(name = "user")
@Entity
public class UserAuth extends BaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", unique = true)
    private String username;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "hashed_password")
    private String password;

    @Column(name = "is_superuser")
    private boolean isSuperuser = false;

    @Column(name = "enterprise_id")
    private Long enterpriseId;

    //@OneToMany(mappedBy = "userAuth", fetch = FetchType.EAGER)
    //private Set<UserRole> userRole;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isSuperuser() {
        return isSuperuser;
    }

    public void setSuperuser(boolean superuser) {
        isSuperuser = superuser;
    }

    public Long getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(Long enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    /*public Set<UserRole> getUserRole() {
        return userRole;
    }

    public void setUserRole(Set<UserRole> userRole) {
        this.userRole = userRole;
    }*/
}
