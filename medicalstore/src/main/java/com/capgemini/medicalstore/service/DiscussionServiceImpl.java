package com.capgemini.medicalstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.medicalstore.beans.DiscussionBean;
import com.capgemini.medicalstore.dao.DiscussionDAO;

@Service
public class DiscussionServiceImpl implements DiscussionService {
	@Autowired
	private DiscussionDAO dao;

	@Override
	public boolean question(DiscussionBean discussionBean) {
		return dao.question(discussionBean);
	}

	@Override
	public boolean answer(int messageid, String answer) {
		return dao.answer(messageid, answer);
	}

	@Override
	public List<DiscussionBean> questionAnswer() {
		return dao.questionAnswer();
	}

	@Override
	public List<DiscussionBean> getQuestion() {
		return dao.getQuestion();
	}

}
