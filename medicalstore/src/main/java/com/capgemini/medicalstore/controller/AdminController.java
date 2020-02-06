package com.capgemini.medicalstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.medicalstore.beans.LoginBean;
import com.capgemini.medicalstore.beans.MedicalResponse;
import com.capgemini.medicalstore.beans.ProductBean;
import com.capgemini.medicalstore.service.AdminService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "true")

public class AdminController {
	@Autowired
	private AdminService adminservice;

	@GetMapping(path = "/login"/* , produces = { MediaType.APPLICATION_JSON_VALUE } */)
	// @ResponseBody
	public MedicalResponse authenticate(String email, String password, String role) {
		LoginBean login = adminservice.authenticate(email, password, role);
		MedicalResponse response = new MedicalResponse();
		if (login != null) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("Logged in successfullly...");
			response.setLoginBean(login);
		} else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("Login failed");
		}
		return response;
	}// End of login()

	@GetMapping("/getallproduct")
	public MedicalResponse getAllProducts() {
		List<ProductBean> productList = adminservice.getAllProducts();
		MedicalResponse responce = new MedicalResponse();

		if (productList != null && !productList.isEmpty()) {
			responce.setStatusCode(201);
			responce.setMessage("success");
			responce.setDescription("Product record found....");
			responce.setProductList(productList);
		} else {
			responce.setStatusCode(401);
			responce.setMessage("failed");
			responce.setDescription("Unable to found record!!!");
		}
		return responce;
	}// End of getAllProduct()

	@GetMapping("/getalluser")
	public MedicalResponse getAllUsers() {
		List<LoginBean> userList = adminservice.getAllUsers();
		MedicalResponse responce = new MedicalResponse();

		if (userList != null && !userList.isEmpty()) {
			responce.setStatusCode(201);
			responce.setMessage("success");
			responce.setDescription("user record found....");
			responce.setUserList(userList);
		} else {
			responce.setStatusCode(401);
			responce.setMessage("failed");
			responce.setDescription("Unable to found record!!!");
		}
		return responce;
	}// End of getAllProduct()

	@DeleteMapping(path = "/deleteuser", produces = { MediaType.APPLICATION_JSON_VALUE})
	public MedicalResponse deleteUser(int Id) {
		boolean isDeleted = adminservice.deleteUser(Id);

		MedicalResponse responce = new MedicalResponse();

		if (isDeleted) {
			responce.setStatusCode(201);
			responce.setMessage("success");
			responce.setDescription("User deleted successfully...");
		} else {
			responce.setStatusCode(401);
			responce.setMessage("failed");
			responce.setDescription("Unable to delete User...");
		}
		return responce;
	}// End of deleteEmployee()

	@PostMapping(path = "/addproduct", consumes = { MediaType.APPLICATION_JSON_VALUE}, produces = { MediaType.APPLICATION_JSON_VALUE })
	public MedicalResponse addProduct(@RequestBody ProductBean productBean) {
		boolean isAdded = adminservice.addProduct(productBean);

		MedicalResponse responce = new MedicalResponse();

		if (isAdded) {
			responce.setStatusCode(201);
			responce.setMessage("success");
			responce.setDescription("Product added successfully...");
		} else {
			responce.setStatusCode(401);
			responce.setMessage("failed");
			responce.setDescription("Unable to add Product...");
		}
		return responce;
	}// End of addEmployee()

	@PostMapping(path = "/updateproduct", produces = { MediaType.APPLICATION_JSON_VALUE})
	public MedicalResponse updateProduct(@RequestBody ProductBean productBean) {
		boolean isUpdated = adminservice.updateProduct(productBean);
		MedicalResponse responce = new MedicalResponse();

		if (isUpdated) {
			responce.setStatusCode(201);
			responce.setMessage("success");
			responce.setDescription("Product updated successfully...");
		} else {
			responce.setStatusCode(401);
			responce.setMessage("failed");
			responce.setDescription("Unable to update Product...");
		}
		return responce;

	}// End of updateProduct()

	@DeleteMapping(path = "/deleteproduct", produces = { MediaType.APPLICATION_JSON_VALUE })
	public MedicalResponse deleteProduct(int productid) {
		boolean isDeleted = adminservice.deleteProduct(productid);

		MedicalResponse responce = new MedicalResponse();

		if (isDeleted) {
			responce.setStatusCode(201);
			responce.setMessage("success");
			responce.setDescription("Product deleted successfully...");
		} else {
			responce.setStatusCode(401);
			responce.setMessage("failed");
			responce.setDescription("Unable to delete Product...");
		}
		return responce;
	}// End of deleteEmployee()

}// End of class
