package com.capgemini.medicalstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.medicalstore.beans.LoginBean;
import com.capgemini.medicalstore.dao.UserDAO;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDAO userdao;

	@Override
	public boolean register(LoginBean loginBean) {
		return userdao.register(loginBean);
	}

	@Override
	public boolean updatePassword(LoginBean loginBean) {
		return userdao.updatePassword(loginBean);
	}

}// End of class
