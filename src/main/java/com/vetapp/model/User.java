package com.vetapp.model;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Table(name = "user")
@Entity
public class User implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "username", unique = true)
	private String userName;

	@Column(name = "email", unique = true)
	private String email;

	@Column(name = "hashed_password")
	private String password;

	@Column(name = "is_active")
	private boolean is_active = true;

	@Column(name = "is_superuser")
	private boolean is_superuser = false;

	@Column(name = "created_at")
	private Date created_at;

	@Column(name = "user_creation")
	private Integer user_creation;

	@Column(name = "modified_at")
	private Date modified_at;

	@Column(name = "user_updated")
	private Integer user_updated;

	@Column(name = "enterprise_id")
	private Long enterprise_id;


	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "userrole", joinColumns = @JoinColumn(referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(referencedColumnName = "id"))
	private List<Authority> authorities;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return authorities;
	}

	public void setAuthorities(List<Authority> authorities) {
		this.authorities = authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		return this.is_active;
	}

	@Override
	public boolean isAccountNonLocked() {
		return this.is_active;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return this.is_active;
	}

	@Override
	public boolean isEnabled() {
		return this.is_active;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isIs_active() {
		return is_active;
	}

	public void setIs_active(boolean is_active) {
		this.is_active = is_active;
	}

	public boolean isIs_superuser() {
		return is_superuser;
	}

	public void setIs_superuser(boolean is_superuser) {
		this.is_superuser = is_superuser;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	public Integer getUser_creation() {
		return user_creation;
	}

	public void setUser_creation(Integer user_creation) {
		this.user_creation = user_creation;
	}

	public Date getModified_at() {
		return modified_at;
	}

	public void setModified_at(Date modified_at) {
		this.modified_at = modified_at;
	}

	public Integer getUser_updated() {
		return user_updated;
	}

	public void setUser_updated(Integer user_updated) {
		this.user_updated = user_updated;
	}

	public Long getEnterprise_id() {
		return enterprise_id;
	}

	public void setEnterprise_id(Long enterprise_id) {
		this.enterprise_id = enterprise_id;
	}
}
