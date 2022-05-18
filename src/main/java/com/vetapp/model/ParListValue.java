package com.vetapp.model;

import javax.persistence.*;

@Entity
@Table(name = "parlistvalue")
public class ParListValue extends BaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 70)
    private String name;

    @Column(name = "parlist_id")
    private Long parlist_id;

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

    public Long getParlist_id() {
        return parlist_id;
    }

    public void setParlist_id(Long parlist_id) {
        this.parlist_id = parlist_id;
    }
}
