package com.sdelamer.midas.MidasChallenge.Dto;

import java.util.Date;

import org.springframework.lang.NonNull;

import com.sdelamer.midas.MidasChallenge.Model.Role;


public class UserDto {

	private Date creationDate;
	private Date deletedAt;
	private boolean isDeleted = false;
	@NonNull
	private String email;
	@NonNull
	private String name;
	private String lastName;
	private Date lastUpdate;
	private Role role;
	
	public UserDto() {
		
	}
	public UserDto(Date creationDate, Date deletedAt, boolean isDeleted, String email, String name, String lastName,
			Date lastUpdate,Role role) {
		super();
		this.creationDate = creationDate;
		this.deletedAt = deletedAt;
		this.isDeleted = isDeleted;
		this.email = email;
		this.name = name;
		this.lastName = lastName;
		this.lastUpdate = lastUpdate;
		this.role = role;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public void setDeletedAt(Date deletedAt) {
		this.deletedAt = deletedAt;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public Date getDeletedAt() {
		return deletedAt;
	}
	public boolean isDeleted() {
		return isDeleted;
	}
	public String getEmail() {
		return email;
	}
	public String getName() {
		return name;
	}
	public String getLastName() {
		return lastName;
	}
	public Date getLastUpdate() {
		return lastUpdate;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	
	
	
	

}
