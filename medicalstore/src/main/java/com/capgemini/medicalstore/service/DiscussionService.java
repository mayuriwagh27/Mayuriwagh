package com.capgemini.medicalstore.service;

import java.util.List;

import com.capgemini.medicalstore.beans.DiscussionBean;

public interface DiscussionService {
	public boolean question(DiscussionBean discussionBean);

	public boolean answer(int messageid, String answer);

	public List<DiscussionBean> questionAnswer();

	public List<DiscussionBean> getQuestion();

}
