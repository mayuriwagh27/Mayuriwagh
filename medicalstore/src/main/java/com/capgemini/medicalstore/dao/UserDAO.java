package com.capgemini.medicalstore.dao;

import com.capgemini.medicalstore.beans.LoginBean;

public interface UserDAO {
	public boolean register(LoginBean loginBean);

	public boolean updatePassword(LoginBean loginBean);

}// End of interface
