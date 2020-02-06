package com.capgemini.medicalstore.beans;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)

public class MedicalResponse {

	private int statusCode;
	private String message;
	private String description;
	private ProductBean productBean;
	private LoginBean loginBean;
	private List<ProductBean> productList;
	private List<LoginBean> userList;
	private List<CartBean> cartList;
	private List<DiscussionBean> discussionList;
	private List<OrderHistoryBean> historylist;
	

//Getters & setters
	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ProductBean getProductBean() {
		return productBean;
	}

	public void setProductBean(ProductBean productBean) {
		this.productBean = productBean;
	}

	public LoginBean getLoginBean() {
		return loginBean;
	}

	public void setLoginBean(LoginBean loginBean) {
		this.loginBean = loginBean;
	}

	public List<ProductBean> getProductList() {
		return productList;
	}

	public void setProductList(List<ProductBean> productList) {
		this.productList = productList;
	}

	public List<LoginBean> getUserList() {
		return userList;
	}

	public void setUserList(List<LoginBean> userList) {
		this.userList = userList;
	}

	public List<CartBean> getCartList() {
		return cartList;
	}

	public void setCartList(List<CartBean> cartList) {
		this.cartList = cartList;
	}

	public List<DiscussionBean> getDiscussionList() {
		return discussionList;
	}

	public void setDiscussionList(List<DiscussionBean> discussionList) {
		this.discussionList = discussionList;
	}

	public List<OrderHistoryBean> getHistorylist() {
		return historylist;
	}

	public void setHistorylist(List<OrderHistoryBean> historylist) {
		this.historylist = historylist;
	}

}// End of class
