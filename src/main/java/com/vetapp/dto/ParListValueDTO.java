package com.vetapp.dto;

public class ParListValueDTO extends BaseModelDTO {

    private Long id;

    private String name;

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
