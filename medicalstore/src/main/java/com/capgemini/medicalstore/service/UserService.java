package com.capgemini.medicalstore.service;

import com.capgemini.medicalstore.beans.LoginBean;

public interface UserService {
	public boolean register(LoginBean loginBean);

	public boolean updatePassword(LoginBean loginBean);

}
