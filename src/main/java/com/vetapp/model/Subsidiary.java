package com.vetapp.model;

import javax.persistence.*;

@Entity
@Table(name = "subsidiary")
public class Subsidiary extends BaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "address", length = 150)
    private String address;

    @Column(name = "phone")
    private Integer phone;

    @Column(name = "mobile")
    private Integer mobile;

    @Column(name = "enterprise_id")
    private Long enterprise_id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public Integer getMobile() {
        return mobile;
    }

    public void setMobile(Integer mobile) {
        this.mobile = mobile;
    }

    public Long getEnterprise_id() {
        return enterprise_id;
    }

    public void setEnterprise_id(Long enterprise_id) {
        this.enterprise_id = enterprise_id;
    }
}
