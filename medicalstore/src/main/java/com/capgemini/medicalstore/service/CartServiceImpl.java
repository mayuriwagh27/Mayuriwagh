package com.capgemini.medicalstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.medicalstore.beans.CartBean;
import com.capgemini.medicalstore.beans.OrderHistoryBean;
import com.capgemini.medicalstore.dao.CartDAO;

@Service
public class CartServiceImpl implements CartService {
	@Autowired
	private CartDAO dao;

	@Override
	public boolean addToCart(int Id, int productid, int quantity) {
		return dao.addToCart(Id, productid, quantity);
	}

	@Override
	public List<CartBean> displayCart(int userid) {
		return dao.displayCart(userid);
	}

	@Override
	public double doPayment(int userid) {
		return dao.doPayment(userid);
	}

	@Override
	public boolean deleteCart(int userid) {
		return dao.deleteCart(userid);
	}

	@Override
	public List<OrderHistoryBean> historyTable(int userid) {
		return dao.historyTable(userid);
	}
}// End of class
