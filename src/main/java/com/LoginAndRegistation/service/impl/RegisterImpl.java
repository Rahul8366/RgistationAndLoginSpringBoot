package com.LoginAndRegistation.service.impl;

import java.util.Optional;

import org.apache.logging.log4j.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.LoginAndRegistation.Entity.Register;
import com.LoginAndRegistation.dto.Login;
import com.LoginAndRegistation.dto.RegisterPage;
import com.LoginAndRegistation.repo.RegisterRepo;
import com.LoginAndRegistation.responce.LoginResponce;
import com.LoginAndRegistation.service.RegisterService;

import ch.qos.logback.core.status.Status;

@Service
public class RegisterImpl implements RegisterService{

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private RegisterRepo registerRepo;
	
	@Override
	public String addRegisterPage(RegisterPage registerPage) {
		
		Register register=new Register(	 
	 registerPage.getId(),
	 registerPage.getFirstName(),
	 registerPage.getLastName(),
	 registerPage.getEmail(),
	 this.passwordEncoder.encode(registerPage.getPassword()));
	 
	registerRepo.save(register);
	return register.getFirstName();
	}

	@Override
	public LoginResponce LoginEmail(Login login) {
		
		String msg="";
		Register register=registerRepo.findByEmail(login.getEmail());
		if(register!=null) {
			String Password=login.getPassword();
			String encodedPassword =register.getPassword();
			Boolean ispwdRight = passwordEncoder.matches(Password,encodedPassword);
			if(ispwdRight) {
				Optional<Register> optional=registerRepo.findOneByEmailAndPassword(login.getEmail(), encodedPassword);
				if(optional.isPresent()) {
					return new LoginResponce("login success",true);
				}
				else {
					return new LoginResponce("login failed",false);
				}
			}else {
				return new LoginResponce("password not match",false);
			}
		}
		
		return new LoginResponce("email not exist",false);
	}

	

}
