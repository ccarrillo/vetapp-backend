package com.vetapp.dto;

import java.util.Date;

public class EmployeeDto extends BaseModelDto {

    private Long id;

    private String firstName;

    private String lastName;

    private Date dateBirth;

    private Long genderId;

    private Long nationality;

    private Long documentType;

    private String documentNumber;

    private Integer mobile;

    private String email;

    private String address;

    private Long enterpriseId;

    private Long subsidiaryId;

    private Long positionId;

    private Long typeContractId;

    private Float salary;

    private Long scheduleId;

    private Date starActivities;

    private Date endActivities;

    private Long bankId;

    private Long bankCci;

    private Long afpId;

    private String afpCode;

    private String note;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(Date dateBirth) {
        this.dateBirth = dateBirth;
    }

    public Long getGenderId() {
        return genderId;
    }

    public void setGenderId(Long genderId) {
        this.genderId = genderId;
    }

    public Long getNationality() {
        return nationality;
    }

    public void setNationality(Long nationality) {
        this.nationality = nationality;
    }

    public Long getDocumentType() {
        return documentType;
    }

    public void setDocumentType(Long documentType) {
        this.documentType = documentType;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public Integer getMobile() {
        return mobile;
    }

    public void setMobile(Integer mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(Long enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public Long getSubsidiaryId() {
        return subsidiaryId;
    }

    public void setSubsidiaryId(Long subsidiaryId) {
        this.subsidiaryId = subsidiaryId;
    }

    public Long getPositionId() {
        return positionId;
    }

    public void setPositionId(Long positionId) {
        this.positionId = positionId;
    }

    public Long getTypeContractId() {
        return typeContractId;
    }

    public void setTypeContractId(Long typeContractId) {
        this.typeContractId = typeContractId;
    }

    public Float getSalary() {
        return salary;
    }

    public void setSalary(Float salary) {
        this.salary = salary;
    }

    public Long getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(Long scheduleId) {
        this.scheduleId = scheduleId;
    }

    public Date getStarActivities() {
        return starActivities;
    }

    public void setStarActivities(Date starActivities) {
        this.starActivities = starActivities;
    }

    public Date getEndActivities() {
        return endActivities;
    }

    public void setEndActivities(Date endActivities) {
        this.endActivities = endActivities;
    }

    public Long getBankId() {
        return bankId;
    }

    public void setBankId(Long bankId) {
        this.bankId = bankId;
    }

    public Long getBankCci() {
        return bankCci;
    }

    public void setBankCci(Long bankCci) {
        this.bankCci = bankCci;
    }

    public Long getAfpId() {
        return afpId;
    }

    public void setAfpId(Long afpId) {
        this.afpId = afpId;
    }

    public String getAfpCode() {
        return afpCode;
    }

    public void setAfpCode(String afp_code) {
        this.afpCode = afpCode;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
