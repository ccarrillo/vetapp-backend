package com.vetapp.model;

import javax.persistence.*;

@Table(name = "parvetvalue", schema = "vet")
@Entity
public class ParVetValue extends BaseModel {


    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name="vet.parvetvalue_id_seq",sequenceName="vet.parvetvalue_id_seq",allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="vet.parvetvalue_id_seq")
    @Column(name = "id")
    private Long id;

    @Column(name = "name", length = 70)
    private String name;

    @Column(name = "parvet_id")
    private Long parvetId;

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

    public Long getParvetId() {
        return parvetId;
    }

    public void setParvetId(Long parvetId) {
        this.parvetId = parvetId;
    }
}
