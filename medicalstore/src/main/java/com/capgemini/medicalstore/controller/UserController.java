package com.capgemini.medicalstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.medicalstore.beans.LoginBean;
import com.capgemini.medicalstore.beans.MedicalResponse;
import com.capgemini.medicalstore.beans.ProductBean;
import com.capgemini.medicalstore.service.UserService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "true")
public class UserController {
	@Autowired
	private UserService userservice;

	@PutMapping(path = "/register", produces = { MediaType.APPLICATION_JSON_VALUE })
	//
	public MedicalResponse register(@RequestBody LoginBean loginBean) {
		boolean register = userservice.register(loginBean);
		MedicalResponse response = new MedicalResponse();
		if (register) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("Registered successfullly...");

		} else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("Registration failed");
		}
		return response;
	}// End of login()

	@PostMapping(path = "/updatepassword", produces = { MediaType.APPLICATION_JSON_VALUE })
	public MedicalResponse updatePassword(@RequestBody LoginBean loginBean) {
		boolean isUpdated = userservice.updatePassword(loginBean);
		MedicalResponse responce = new MedicalResponse();

		if (isUpdated) {
			responce.setStatusCode(201);
			responce.setMessage("success");
			responce.setDescription("Password updated successfully...");
		} else {
			responce.setStatusCode(401);
			responce.setMessage("failed");
			responce.setDescription("Unable to update Password...");
		}
		return responce;

	}// End of updateProduct()
}// End of class
