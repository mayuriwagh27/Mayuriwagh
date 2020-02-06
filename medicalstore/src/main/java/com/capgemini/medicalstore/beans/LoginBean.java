package com.capgemini.medicalstore.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonPropertyOrder({ "id", "name", "role" })
@JsonRootName("Login")
@XmlRootElement(name = "Login")
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name = "login")
public class LoginBean {
	// @JsonProperty("login Id")
	// @XmlElement(name = "login Id")
	@Id
	@Column
	private int Id;
	@Column
	private String name;
	@Column
	private String email;
	//@JsonIgnore
	@Column
	private String password;
	@Column
	private String role;

//Getters & setters
	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}// End of class
