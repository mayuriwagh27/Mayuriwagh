package com.capgemini.medicalstore.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.capgemini.medicalstore.beans.LoginBean;
import com.capgemini.medicalstore.beans.ProductBean;

@Repository
public class AdminDAOImpl implements AdminDAO {
	@PersistenceUnit
	private EntityManagerFactory em;

	@Override
	public LoginBean authenticate(String email, String password, String role) {
		EntityManager manager = em.createEntityManager();
		String jpql = "from LoginBean where email = :email and password = :pwd and role = : role ";
		Query query = manager.createQuery(jpql);
		query.setParameter("email", email);
		query.setParameter("pwd", password);
		query.setParameter("role", role);

		LoginBean loginBean = null;
		try {
			loginBean = (LoginBean) query.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return loginBean;
	}// end of authenticate

	@Override
	public List<ProductBean> getAllProducts() {
		EntityManager manager = em.createEntityManager();
		String jpql = "from ProductBean";
		Query query = manager.createQuery(jpql);

		List<ProductBean> productlist = null;
		try {
			productlist = query.getResultList();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return productlist;

	}// End of getAllProducts()

	@Override
	public List<LoginBean> getAllUsers() {
		EntityManager manager = em.createEntityManager();
		String jpql = "from LoginBean where role='user'";
		Query query = manager.createQuery(jpql);

		List<LoginBean> userList = null;
		try {
			userList = query.getResultList();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return userList;

	}// End of getAllUsers()

	@Override
	public boolean deleteUser(int Id) {
		EntityManager entityManager = em.createEntityManager();
		boolean isDeleted = false;

		try {
			EntityTransaction tx = entityManager.getTransaction();
			tx.begin();
			LoginBean loginBean = entityManager.find(LoginBean.class, Id);
			entityManager.remove(loginBean);
			tx.commit();
			isDeleted = true;

		} catch (Exception e) {
			e.printStackTrace();
		}

		entityManager.close();
		return isDeleted;
	}// End of deleteEmployee()

	@Override
	public boolean addProduct(ProductBean productBean) {
		EntityManager manager = em.createEntityManager();
		EntityTransaction tx = manager.getTransaction();
		boolean isAdded = false;
		try {
			tx.begin();
			manager.persist(productBean);
			tx.commit();
			isAdded = true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		manager.close();

		return isAdded;
	}// End of add employee

	@Override
	public boolean updateProduct(ProductBean productBean) {
		EntityManager manager = em.createEntityManager();
		ProductBean existingProductInfo = manager.find(ProductBean.class, productBean.getProductid());
		boolean isUpdated = false;

		if (existingProductInfo != null) {
			String name = productBean.getName();
			if (name != null) {
				existingProductInfo.setName(name);
			}

			int id = productBean.getProductid();
			if (id > 0) {
				existingProductInfo.setProductid(id);
			}
			int quantity = productBean.getQuantity();
			if (quantity > 0) {
				existingProductInfo.setQuantity(quantity);
			}

			double price = productBean.getPrice();
			if (price > 0) {
				existingProductInfo.setPrice(price);
			}

			String category = productBean.getCategory();
			if (category != null) {
				existingProductInfo.setCategory(category);
			}

			String availability = productBean.getAvailability();
			if (availability != null) {
				existingProductInfo.setAvailability(availability);
			}
			try {
				EntityTransaction tx = manager.getTransaction();
				tx.begin();
				manager.persist(existingProductInfo);
				tx.commit();
				isUpdated = true;
			} catch (Exception e) {
				e.printStackTrace();
			}

			manager.close();

		}
		return isUpdated;

	}// end of update employee

	@Override
	public boolean deleteProduct(int productid) {
		EntityManager entityManager = em.createEntityManager();
		boolean isDeleted = false;

		try {
			EntityTransaction tx = entityManager.getTransaction();
			tx.begin();
			ProductBean productBean = entityManager.find(ProductBean.class, productid);
			entityManager.remove(productBean);
			tx.commit();
			isDeleted = true;

		} catch (Exception e) {
			e.printStackTrace();
		}

		entityManager.close();
		return isDeleted;
	}// End of deleteEmployee()

}// End of class
