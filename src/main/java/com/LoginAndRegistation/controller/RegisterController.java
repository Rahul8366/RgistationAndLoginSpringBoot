package com.LoginAndRegistation.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.LoginAndRegistation.dto.Login;
import com.LoginAndRegistation.dto.RegisterPage;
import com.LoginAndRegistation.responce.LoginResponce;
import com.LoginAndRegistation.service.RegisterService;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
@RequestMapping("/api")
public class RegisterController {


	
	@Autowired
	private RegisterService registerService;
	
	@PostMapping("/reg")
	public String saveRegisterPage(@RequestBody RegisterPage registerPage) {
		
		String id=registerService.addRegisterPage(registerPage);
		return id;
		
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody Login login ) {
		
	LoginResponce loginResponce =registerService.LoginEmail(login);
		return ResponseEntity.ok(loginResponce);
		
	}
}
