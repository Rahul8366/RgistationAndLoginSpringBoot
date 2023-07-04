package com.LoginAndRegistation.service;

import org.springframework.stereotype.Service;


import com.LoginAndRegistation.dto.Login;
import com.LoginAndRegistation.dto.RegisterPage;
import com.LoginAndRegistation.responce.LoginResponce;


public interface RegisterService {

	
	String addRegisterPage(RegisterPage registerPage);

	LoginResponce LoginEmail(Login login);
    
}
