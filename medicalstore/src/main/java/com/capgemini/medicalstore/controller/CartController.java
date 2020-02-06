package com.capgemini.medicalstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.medicalstore.beans.CartBean;
import com.capgemini.medicalstore.beans.DiscussionBean;
import com.capgemini.medicalstore.beans.MedicalResponse;
import com.capgemini.medicalstore.beans.OrderHistoryBean;
import com.capgemini.medicalstore.service.CartService;
import com.capgemini.medicalstore.service.DiscussionService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "true")

public class CartController {
	@Autowired
	private CartService cartservice;
	@Autowired
	private DiscussionService discussionservice;

	@PostMapping(path = "/addtocart", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public MedicalResponse addToCart(@RequestParam int Id, int productid, int quantity) {
		boolean isAdded = cartservice.addToCart(Id, productid, quantity);

		MedicalResponse responce = new MedicalResponse();

		if (isAdded) {
			responce.setStatusCode(201);
			responce.setMessage("success");
			responce.setDescription("Product successfully added to cart...");
		} else {
			responce.setStatusCode(401);
			responce.setMessage("failed");
			responce.setDescription("Unable to add Product...");
		}
		return responce;
	}// End of addEmployee()

	@GetMapping(path = "/cart")
	public MedicalResponse getfromcart(@RequestParam int userid) {
		List<CartBean> carList = cartservice.displayCart(userid);
		MedicalResponse responce = new MedicalResponse();

		if (carList != null) {
			responce.setStatusCode(201);
			responce.setMessage("success");
			responce.setDescription("Product record found....");
			responce.setCartList(carList);
		} else {
			responce.setStatusCode(401);
			responce.setMessage("failed");
			responce.setDescription("Unable to found record!!!");
		}
		return responce;
	}// End of getAllProduct()

	@GetMapping(path = "/payment")
	public MedicalResponse payment(@RequestParam int userid) {
		double price = cartservice.doPayment(userid);
		MedicalResponse responce = new MedicalResponse();

		if (price > 0) {
			responce.setStatusCode(201);
			responce.setMessage("success");
			responce.setDescription("Payment successfull....");
		} else {
			responce.setStatusCode(401);
			responce.setMessage("failed");
			responce.setDescription("Payment failed!!!");
		}
		return responce;
	}// End of getAllProduct()

	@DeleteMapping(path = "/deletecart", produces = { MediaType.APPLICATION_JSON_VALUE })
	public MedicalResponse deleteCart(@RequestParam int cartid) {
		boolean isDeleted = cartservice.deleteCart(cartid);

		MedicalResponse responce = new MedicalResponse();

		if (isDeleted) {
			responce.setStatusCode(201);
			responce.setMessage("success");
			responce.setDescription("product successfully deleted from cart...");
		} else {
			responce.setStatusCode(401);
			responce.setMessage("failed");
			responce.setDescription("Unable to delete product...");
		}
		return responce;
	}// End of deleteEmployee()

	@PostMapping(path = "/question")
	public MedicalResponse question(DiscussionBean discussionBean) {
		boolean question = discussionservice.question(discussionBean);
		MedicalResponse discussionResponse = new MedicalResponse();
		if (question) {
			discussionResponse.setStatusCode(201);
			discussionResponse.setMessage("Success");
			discussionResponse.setDescription("Your Question added successfully");
		} else {
			discussionResponse.setStatusCode(401);
			discussionResponse.setMessage("Failed");
			discussionResponse.setDescription("Unable To add Question");
		}
		return discussionResponse;
	}// end of question()

	@PostMapping(path = "/answer")
	public MedicalResponse answer(int messageid, String answer) {
		boolean insertAnswer = discussionservice.answer(messageid, answer);
		MedicalResponse medicalResponse = new MedicalResponse();
		if (insertAnswer) {
			medicalResponse.setStatusCode(201);
			medicalResponse.setMessage("Success");
			medicalResponse.setDescription("Your Response recorded successfully");
		} else {
			medicalResponse.setStatusCode(401);
			medicalResponse.setMessage("Failed");
			medicalResponse.setDescription("Unable To record response");
		}
		return medicalResponse;
	}// end of answer

	@GetMapping(path = "/discussionTable")
	public MedicalResponse discussion() {
		List<DiscussionBean> discussion = discussionservice.questionAnswer();
		MedicalResponse response = new MedicalResponse();
		if (discussion != null) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Discussion Table");
			response.setDiscussionList(discussion);
		} else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("Unable Fetch Table");
		}
		return response;
	}// end of discussion

	@GetMapping(path = "/historyTable")
	public MedicalResponse historyTable(@RequestParam int userid) {
		List<OrderHistoryBean> history = cartservice.historyTable(userid);
		MedicalResponse cartResponse = new MedicalResponse();
		if (history != null && !history.isEmpty()) {
			cartResponse.setStatusCode(201);
			cartResponse.setMessage("Success");
			cartResponse.setDescription("History Table");
			cartResponse.setHistorylist(history);
		} else {
			cartResponse.setStatusCode(401);
			cartResponse.setMessage("Failed");
			cartResponse.setDescription("Unable to Fetch Data");
		}
		return cartResponse;
	}// end of historyTable()

	@GetMapping(path = "/adminquestion")
	public MedicalResponse getquestion() {
		List<DiscussionBean> question = discussionservice.getQuestion();
		MedicalResponse discussionResponse = new MedicalResponse();
		if (question != null) {
			discussionResponse.setStatusCode(201);
			discussionResponse.setMessage("Success");
			discussionResponse.setDescription("Record found");
			discussionResponse.setDiscussionList(question);
		} else {
			discussionResponse.setStatusCode(401);
			discussionResponse.setMessage("Failed");
			discussionResponse.setDescription("Unable To find record ");
		}
		return discussionResponse;
	}// end of question()
}// End of class
