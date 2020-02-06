package com.capgemini.medicalstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.medicalstore.beans.LoginBean;
import com.capgemini.medicalstore.beans.ProductBean;
import com.capgemini.medicalstore.dao.AdminDAO;

@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	private AdminDAO dao;

	@Override
	public LoginBean authenticate(String email, String password, String role) {
		return dao.authenticate(email, password, role);
	}

	@Override
	public List<ProductBean> getAllProducts() {
		return dao.getAllProducts();
	}

	@Override
	public List<LoginBean> getAllUsers() {
		return dao.getAllUsers();
	}

	@Override
	public boolean deleteUser(int Id) {
		return dao.deleteUser(Id);
	}

	@Override
	public boolean addProduct(ProductBean productBean) {
		return dao.addProduct(productBean);
	}

	@Override
	public boolean updateProduct(ProductBean productBean) {
		return dao.updateProduct(productBean);
	}

	@Override
	public boolean deleteProduct(int productid) {
		return dao.deleteProduct(productid);
	}

}// End of class
