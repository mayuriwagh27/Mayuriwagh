package com.capgemini.medicalstore.dao;

import java.util.List;

import com.capgemini.medicalstore.beans.DiscussionBean;

public interface DiscussionDAO {
	public boolean question(DiscussionBean discussionBean);

	public boolean answer(int messageid, String answer);

	public List<DiscussionBean> questionAnswer();

	public List<DiscussionBean> getQuestion();
}
