package com.noriand.api.repository.auth;

import org.springframework.data.repository.CrudRepository;

import com.noriand.api.security.RefreshToken;

public interface RefreshTokenRedisRepository extends CrudRepository<RefreshToken, String>{
	
	RefreshToken findByRefreshToken(String refreshToken);
	
	boolean existsByRefreshToken(String refreshToken);

}
