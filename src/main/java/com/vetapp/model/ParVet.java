package com.vetapp.model;

import javax.persistence.*;

@Table(name = "parvet", schema = "vet")
@Entity
public class ParVet extends BaseModel {


    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name="vet.parvet_id_seq",sequenceName="vet.parvet_id_seq",allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="vet.parvet_id_seq")
    @Column(name = "id")
    private Long id;

    @Column(name = "name", length = 100)
    private String name;

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
}
