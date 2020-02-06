package com.capgemini.medicalstore;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.medicalstore.beans.DiscussionBean;
import com.capgemini.medicalstore.beans.LoginBean;
import com.capgemini.medicalstore.beans.ProductBean;
import com.capgemini.medicalstore.dao.AdminDAO;
import com.capgemini.medicalstore.dao.DiscussionDAO;
import com.capgemini.medicalstore.dao.UserDAO;

import junit.framework.TestCase;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminDAOTest {
	@Autowired
	private AdminDAO admindao;
	@Autowired
	private DiscussionDAO discussionDao;
	@Autowired
	private UserDAO userDao;
	ProductBean productBean = new ProductBean();
	DiscussionBean discusionBean = new DiscussionBean();
	LoginBean login = new LoginBean();

	@Test
	public void testAddProduct() {
		// productBean.setProductid(12);
		productBean.setCategory("Ayurvedic care");
		productBean.setName("Patanjali hadjyot");
		productBean.setPrice(200);
		productBean.setQuantity(50);
		productBean.setAvailability("Available");
		TestCase.assertEquals(true, admindao.addProduct(productBean));

	}// End of testAddProduct()

	@Test
	public void testUpdateProduct() {
		// productBean.setProductid(8);
		productBean.setCategory("Baby care");
		productBean.setName("Huggies food");
		productBean.setPrice(300);
		productBean.setQuantity(250);
		productBean.setAvailability("Available");
		TestCase.assertEquals(false, admindao.updateProduct(productBean));

	}// End of testUpdateProduct()

	@Test
	public void testQuestion() {
		// discusionBean.setMessageid(12);
		discusionBean.setUserid(5);
		discusionBean.setQuestion("Hii");
		discusionBean.setStatus(0);
		TestCase.assertEquals(true, discussionDao.question(discusionBean));
	}// End of testQuestion()

	@Test
	public void testRegister() {
		// login.setId(9);
		login.setName("Qwerty asdf");
		login.setEmail("qwerty@gmail.com");
		login.setPassword("Qwerty123");
		login.setRole("User");
		TestCase.assertEquals(true, userDao.register(login));

	}// End of testRegister()

	@Test
	public void testLogin() {
		TestCase.assertNotNull(admindao.authenticate("mayuri@gmail.com", "Mayuri123", "user"));
	}// End of testLogin()

}// End of class
