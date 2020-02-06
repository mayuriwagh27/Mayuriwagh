package com.capgemini.medicalstore.service;

import java.util.List;

import com.capgemini.medicalstore.beans.LoginBean;
import com.capgemini.medicalstore.beans.ProductBean;

public interface AdminService {
	public LoginBean authenticate(String email, String password, String role);

	public List<ProductBean> getAllProducts();

	public List<LoginBean> getAllUsers();

	public boolean deleteUser(int Id);

	public boolean addProduct(ProductBean productBean);

	public boolean updateProduct(ProductBean productBean);

	public boolean deleteProduct(int productid);

}// End of interface
