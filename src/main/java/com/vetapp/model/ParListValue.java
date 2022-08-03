package com.vetapp.model;

import javax.persistence.*;

@Entity
@Table(name = "parlistvalue", schema = "vet")
public class ParListValue extends BaseModel {


    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name="vet.parlistvalue_id_seq",sequenceName="vet.parlistvalue_id_seq",allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="vet.parlistvalue_id_seq")
    @Column(name = "id")
    private Long id;

    @Column(name = "name", length = 70)
    private String name;

    @Column(name = "parlist_id")
    private Long parlistId;

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

    public Long getParlistId() {
        return parlistId;
    }

    public void setParlistId(Long parlistId) {
        this.parlistId = parlistId;
    }
}
