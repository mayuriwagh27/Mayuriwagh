package com.capgemini.medicalstore.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.capgemini.medicalstore.beans.DiscussionBean;

@Repository
public class DiscussionDAOImpl implements DiscussionDAO {
	@PersistenceUnit
	private EntityManagerFactory em;

	@Override
	public boolean question(DiscussionBean discussionBean) {
		EntityManager entityManager = em.createEntityManager();
		EntityTransaction tx = entityManager.getTransaction();
		boolean question = false;
		try {
			tx.begin();
			entityManager.persist(discussionBean);
			tx.commit();
			question = true;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Unable to Add Question");
		}
		entityManager.close();
		return question;

	}// end of question()

	@Override
	public boolean answer(int messageid, String answer) {
		EntityManager entityManager = em.createEntityManager();
		EntityTransaction tx = entityManager.getTransaction();
		String jpql = "update DiscussionBean set status=1,answer = :answer where messageid= :messageId";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("messageId", messageid);
		query.setParameter("answer", answer);
		boolean insertAnswer = false;
		try {
			tx.begin();
			int result = query.executeUpdate();
			tx.commit();
			if (result > 0) {
				insertAnswer = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return insertAnswer;
	}// end of answer()

	@Override
	public List<DiscussionBean> questionAnswer() {
		EntityManager entityManager = em.createEntityManager();
		String jpql = "from DiscussionBean where status = 1";

		Query query = entityManager.createQuery(jpql);
		List<DiscussionBean> answerList = null;
		try {
			answerList = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return answerList;
	}// end of questionAnswer

	@Override
	public List<DiscussionBean> getQuestion() {
		EntityManager entityManager = em.createEntityManager();
		String jpql = "from DiscussionBean where status = 0";

		Query query = entityManager.createQuery(jpql);
		List<DiscussionBean> questionList = null;
		try {
			questionList = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return questionList;
	}// end of questionAnswer

}// end of class
