package com.vetapp.dto;

public class ParVetValueDto extends BaseModelDto {

    private Long id;

    private String name;

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
