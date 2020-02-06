package com.capgemini.medicalstore.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;

import org.springframework.stereotype.Repository;

import com.capgemini.medicalstore.beans.LoginBean;
import com.capgemini.medicalstore.beans.ProductBean;

@Repository
public class UserDAOImpl implements UserDAO {
	@PersistenceUnit
	private EntityManagerFactory em;

	@Override
	public boolean register(LoginBean loginBean) {
		EntityManager manager = em.createEntityManager();
		EntityTransaction tx = manager.getTransaction();
		boolean isAdded = false;
		try {
			tx.begin();
			manager.persist(loginBean);
			tx.commit();
			isAdded = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		manager.close();
		return isAdded;
	}// End of register

	@Override
	public boolean updatePassword(LoginBean loginBean) {
		EntityManager manager = em.createEntityManager();
		LoginBean existingUserInfo = manager.find(LoginBean.class, loginBean.getId());
		boolean isUpdated = false;
		if (existingUserInfo != null) {
			String password = loginBean.getPassword();
			if (password != null) {
				existingUserInfo.setPassword(password);
			}
			try {
				EntityTransaction tx = manager.getTransaction();
				tx.begin();
				manager.persist(existingUserInfo);
				tx.commit();
				isUpdated = true;
			} catch (Exception e) {
				e.printStackTrace();
			}

			manager.close();

		}
		return false;

	}// end of updatePassword

}// End of class
