package com.capgemini.medicalstore.service;

import java.util.List;

import com.capgemini.medicalstore.beans.CartBean;
import com.capgemini.medicalstore.beans.OrderHistoryBean;

public interface CartService {
	public boolean addToCart(int Id, int productid, int quantity);

	public List<CartBean> displayCart(int userid);

	public double doPayment(int userid);

	public boolean deleteCart(int userid);

	public List<OrderHistoryBean> historyTable(int userid);

}
