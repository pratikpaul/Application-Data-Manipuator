package com.self.appData.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="ACCESS_INFO")
public class AccessInfo implements Serializable{
	
	@Id
	@GenericGenerator(name = "custominc", strategy = "increment")
	@GeneratedValue(generator = "custominc")
	private int id;
	private int role_id;
	private String role;
	private String access;
	private String created_by;
	private Date creation_date;
	private String modified_by;
	private Date modification_date;
	private int mark_delete;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRole_id() {
		return role_id;
	}

	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getAccess() {
		return access;
	}

	public void setAccess(String access) {
		this.access = access;
	}

	public String getCreated_by() {
		return created_by;
	}

	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}

	public Date getCreation_date() {
		return creation_date;
	}

	public void setCreation_date(Date creation_date) {
		this.creation_date = creation_date;
	}

	public String getModified_by() {
		return modified_by;
	}

	public void setModified_by(String modified_by) {
		this.modified_by = modified_by;
	}

	public Date getModification_date() {
		return modification_date;
	}

	public void setModification_date(Date modification_date) {
		this.modification_date = modification_date;
	}

	public int getMark_delete() {
		return mark_delete;
	}

	public void setMark_delete(int mark_delete) {
		this.mark_delete = mark_delete;
	}
}
