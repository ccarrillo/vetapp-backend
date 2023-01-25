package com.vetapp.model;

import javax.persistence.*;
import java.util.Date;

@Table(name = "employee", schema = "vet")
@Entity
public class Employee extends BaseModel {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name="vet.employee_id_seq",sequenceName="vet.employee_id_seq",allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="vet.employee_id_seq")
    @Column(name = "id")
    private Long id;

    @Column(name = "first_name", length = 70)
    private String firstName;

    @Column(name = "last_name", length = 70)
    private String lastName;

    @Column(name = "date_birth")
    private Date dateBirth;

    @Column(name = "gender_id")
    private Long genderId;

    @Column(name = "nationality")
    private Long nationality;

    @Column(name = "document_type")
    private Long documentType;

    @Column(name = "document_number", length = 30)
    private String documentNumber;

    @Column(name = "mobile")
    private Integer mobile;

    @Column(name = "email", length = 150)
    private String email;

    @Column(name = "address", length = 150)
    private String address;

    @Column(name = "enterprise_id")
    private Long enterpriseId;

    @Column(name = "subsidiary_id")
    private Long subsidiaryId;

    @Column(name = "position_id")
    private Long positionId;

    @Column(name = "type_contract_id")
    private Long typeContractId;

    @Column(name = "salary")
    private Float salary;

    @Column(name = "schedule_id")
    private Long scheduleId;

    @Column(name = "star_activities")
    private Date starActivities;

    @Column(name = "end_activities")
    private Date endActivities;

    @Column(name = "bank_id")
    private Long bankId;

    @Column(name = "bank_cci")
    private Long bankCci;

    @Column(name = "afp_id")
    private Long afpId;

    @Column(name = "afp_code", length = 70)
    private String afp_code;

    @Column(name = "note", length = 300)
    private String note;
    
    @Column(name = "tipo_empleado")
    private Integer tipoEmpleado;

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

    public String getAfp_code() {
        return afp_code;
    }

    public void setAfp_code(String afp_code) {
        this.afp_code = afp_code;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

	public int getTipoEmpleado() {
		return tipoEmpleado;
	}

	public void setTipoEmpleado(int tipoEmpleado) {
		this.tipoEmpleado = tipoEmpleado;
	}
    
    
}
