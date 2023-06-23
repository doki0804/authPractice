package com.noriand.api.service.user;


import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;

import com.noriand.api.dto.users.UserRequestDto;

public interface LoginService {
	
	ResponseEntity<?> signUp(UserRequestDto.SignUp login);
	
	ResponseEntity<?> login(HttpServletRequest request, UserRequestDto.Login login);

    ResponseEntity<?> reissue(HttpServletRequest request);
       
    ResponseEntity<?> logout(HttpServletRequest request);
    
    ResponseEntity<?> authority();
}
