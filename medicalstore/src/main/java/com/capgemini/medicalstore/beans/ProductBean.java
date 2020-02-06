package com.capgemini.medicalstore.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonPropertyOrder({ "productid", "name", "category" })
@JsonRootName("medicalstore")
@XmlRootElement(name = "products")
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name = "products")

public class ProductBean {
	// @JsonProperty("product Id")
	// @XmlElement(name = "Product Id")
	@Id
	@Column
	private int productid;
	@JsonProperty("Ceategory")
	@XmlElement(name = "Category")
	@Column
	private String category;
	@Column
	private double price;
	@Column
	private int quantity;
	@Column
	private String name;
	@Column
	private String availability;

	// Getters & setters
	
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	
	public int getProductid() {
		return productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAvailability() {
		return availability;
	}

	public void setAvailability(String availability) {
		this.availability = availability;
	}

}// End of class
