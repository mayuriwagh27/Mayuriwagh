package com.capgemini.medicalstore.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.DeleteMapping;

import com.capgemini.medicalstore.beans.CartBean;
import com.capgemini.medicalstore.beans.LoginBean;
import com.capgemini.medicalstore.beans.MedicalResponse;
import com.capgemini.medicalstore.beans.OrderHistoryBean;
import com.capgemini.medicalstore.beans.ProductBean;

@Repository

public class CartDAOImpl implements CartDAO {
	@PersistenceUnit
	private EntityManagerFactory em;

	@Override
	public boolean addToCart(int Id, int productid, int quantity) {
		boolean inserted = false;
		EntityManager entityManager = em.createEntityManager();
		EntityTransaction tx = entityManager.getTransaction();
		String jpql = "from LoginBean where Id=:id";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("id", Id);
		LoginBean login = (LoginBean) query.getSingleResult();

		String jpql1 = "from ProductBean where productid =: productid";
		query = entityManager.createQuery(jpql1);
		query.setParameter("productid", productid);
		ProductBean product = (ProductBean) query.getSingleResult();

		CartBean cart = new CartBean();
		cart.setProductid(productid);
		cart.setProductname(product.getName());
		cart.setQuantity(quantity);
		cart.setUserid(Id);
		cart.setPrice(product.getPrice());
		cart.setUsername(login.getName());

		try {
			tx.begin();
			entityManager.persist(cart);
			tx.commit();
			inserted = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		String jpql3 = "update ProductBean set quantity =:newQuantity where productid =: productId";
		query = entityManager.createQuery(jpql3);
		query.setParameter("newQuantity", product.getQuantity() - quantity);
		query.setParameter("productId", productid);
		tx.begin();
		int res = query.executeUpdate();
		tx.commit();
		return inserted;
	}

	@Override
	public List<CartBean> displayCart(int userid) {
		EntityManager entityManager = em.createEntityManager();
		String jpql = "from CartBean where userid =: userId";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("userId", userid);
		List<CartBean> cartList = new ArrayList<CartBean>();
		try {
			cartList = query.getResultList();
		} catch (Exception e) {
			System.out.println("User id not fount");
		}
		return cartList;

	}

	@Override
	public double doPayment(int userid) {
//		EntityTransaction tx = entityManager.getTransaction();
		EntityManager entityManager = em.createEntityManager();
//		List<OrderHistoryBean> orderList = new ArrayList<OrderHistoryBean>();
		List<CartBean> cartList = displayCart(userid);
		String jpql = "select sum(price) from CartBean where userid =: userId";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("userId", userid);
		double price = (double) query.getSingleResult();
		entityManager.close();

		for (CartBean c : cartList) {
			OrderHistoryBean orderBean = new OrderHistoryBean();
			orderBean.setPrice(c.getPrice());
			orderBean.setProductid(c.getProductid());
			orderBean.setProductname(c.getProductname());
			orderBean.setQuantity(c.getQuantity());
			orderBean.setUserid(c.getUserid());
			orderBean.setUsername(c.getUsername());

			EntityManager entityManager2 = em.createEntityManager();
			EntityTransaction tx = entityManager2.getTransaction();
			tx.begin();
			entityManager2.persist(orderBean);
			tx.commit();
			entityManager2.close();
		}
		deleteCart(userid);
		return price;
	}

	@Override
	public boolean deleteCart(int cartid) {
		boolean delete = false;
		EntityManager entityManager = em.createEntityManager();
		EntityTransaction tx = entityManager.getTransaction();
		String jpql = "delete from CartBean where cartid =: cart";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("cart", cartid);
		try {
			tx.begin();
			int result = query.executeUpdate();
			tx.commit();
			delete = true;
		} catch (Exception e) {
			System.out.println("No products in cart");
		}
		return delete;
	}// End of deleteCart()

	@Override
	public List<OrderHistoryBean> historyTable(int userid) {
		EntityManager entityManager = em.createEntityManager();
		EntityTransaction tx = entityManager.getTransaction();
		List<OrderHistoryBean> bean = null;
		String jpql = "from OrderHistoryBean where userid =: userid";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("userid", userid);
		try {
			bean = query.getResultList();
		} catch (Exception e) {
			System.out.println("No Order Found");
			e.printStackTrace();
		}
		return bean;
	}// end of historyBean()

}// End of class
