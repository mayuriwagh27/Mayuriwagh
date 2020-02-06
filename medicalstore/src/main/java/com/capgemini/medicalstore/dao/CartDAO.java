package com.capgemini.medicalstore.dao;

import java.util.List;

import com.capgemini.medicalstore.beans.CartBean;
import com.capgemini.medicalstore.beans.OrderHistoryBean;

public interface CartDAO {
	public boolean addToCart(int Id, int productid, int quantity);

	public List<CartBean> displayCart(int userid);

	public double doPayment(int userid);

	// public boolean deleteCart(int userid);
	public boolean deleteCart(int cart);

	public List<OrderHistoryBean> historyTable(int userid);
}// End of interface
