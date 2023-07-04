package com.LoginAndRegistation.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.LoginAndRegistation.dto.RegisterPage;
import com.LoginAndRegistation.repo.RegisterRepo;

@Repository
public class Registerdao {

//	@Autowired
//	private RegisterRepo registerRepo;
// 
//	public RegisterPage saveRegister(RegisterPage registerPage) {
//		return registerRepo.save(registerPage);
//	}
//	
//	public RegisterPage getById(int id) {
//		Optional<RegisterPage> optional= registerRepo.findById(id);
//		if(optional.isEmpty()) {
//			return null;
//		}
//		else {
//			return optional.get();
//			
//		}
//	}
}
