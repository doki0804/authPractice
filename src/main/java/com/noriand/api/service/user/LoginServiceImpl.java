package com.noriand.api.service.user;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.noriand.api.dto.common.Response;
import com.noriand.api.dto.users.UserRequestDto;
import com.noriand.api.dto.users.UserResponseDto;
import com.noriand.api.dto.users.UserRequestDto.Login;
import com.noriand.api.dto.users.UserResponseDto.TokenInfo;
import com.noriand.api.entity.users.Users;
import com.noriand.api.enums.Role;
import com.noriand.api.repository.auth.RefreshTokenRedisRepository;
import com.noriand.api.repository.users.UsersRepository;
import com.noriand.api.security.JwtTokenProvider;
import com.noriand.api.security.RefreshToken;
import com.noriand.api.util.Helper;
import com.noriand.api.util.SecurityUtil;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService{
	
    private final UsersRepository userRepository;
    private final RefreshTokenRedisRepository refreshTokenRedisRepository;
    private final Response response;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final RedisTemplate redisTemplate;

    public ResponseEntity<?> signUp(UserRequestDto.SignUp signUp) {
        if (userRepository.existsByUserId(signUp.getUserId())) {
            return response.fail("이미 회원가입된 아이디입니다.", HttpStatus.BAD_REQUEST);
        }

        Users user = Users.builder()
                .userId(signUp.getUserId())
                .password(passwordEncoder.encode(signUp.getPassword()))
                .roles(Collections.singletonList(Role.USER.getValue()))
                .build();
        userRepository.save(user);

        return response.success("회원가입에 성공했습니다.");
    }

    
	public ResponseEntity<?> login(HttpServletRequest request, UserRequestDto.Login login) {
		
		if (userRepository.findByUserId(login.getUserId()).orElse(null) == null) {
			return response.fail("해당하는 유저가 존재하지 않습니다.", HttpStatus.BAD_REQUEST);
		}

		// 1. Login ID/PW 를 기반으로 Authentication 객체 생성
		// 이때 authentication 는 인증 여부를 확인하는 authenticated 값이 false
		UsernamePasswordAuthenticationToken authenticationToken = login.toAuthentication();

		// 2. 실제 검증 (사용자 비밀번호 체크)이 이루어지는 부분
		// authenticate 매서드가 실행될 때 CustomUserDetailsService 에서 만든 loadUserByUsername
		// 메서드가 실행
		Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);

		// 3. 인증 정보를 기반으로 JWT 토큰 생성
		UserResponseDto.TokenInfo tokenInfo = jwtTokenProvider.generateToken(authentication);

		// 4. RefreshToken Redis 저장 (expirationTime 설정을 통해 자동 삭제 처리)
        refreshTokenRedisRepository.save(RefreshToken.builder()
                .id(authentication.getName())
                .ip(Helper.getClientIp(request))
                .authorities(authentication.getAuthorities())
                .refreshToken(tokenInfo.getRefreshToken())
                .build());
    
		return response.success(tokenInfo);
	}

    public ResponseEntity<?> reissue(HttpServletRequest request) {
		// TODO:: 1, 2 는 JwtAuthenticationFilter 동작과 중복되는 부분, 때문에 jwt filter 에서 다른 key
		// 값으로 refresh token 값을
		// 넘겨주고 여기서 받아서 처리하는 방법도 적용해 볼 수 있을 듯

		// 1. Request Header 에서 JWT Token 추출
		String token = jwtTokenProvider.resolveToken(request);

		// 2. validateToken 메서드로 토큰 유효성 검사
		if (token != null && jwtTokenProvider.validateToken(token)) {
			// 3. refresh token 인지 확인
			if (jwtTokenProvider.isRefreshToken(token)) {
				// refresh token
				RefreshToken refreshToken = refreshTokenRedisRepository.findByRefreshToken(token);
				if (refreshToken != null) {
					// 4. 최초 로그인한 ip 와 같은지 확인 (처리 방식에 따라 재발급을 하지 않거나 메일 등의 알림을 주는 방법이 있음)
					String currentIpAddress = Helper.getClientIp(request);
					if (refreshToken.getIp().equals(currentIpAddress)) {
						// 5. Redis 에 저장된 RefreshToken 정보를 기반으로 JWT Token 생성
						UserResponseDto.TokenInfo tokenInfo = jwtTokenProvider.generateToken(refreshToken.getId(),
								refreshToken.getAuthorities());
						
						// 4. Redis RefreshToken update
						refreshTokenRedisRepository.save(RefreshToken.builder().id(refreshToken.getId())
								.ip(currentIpAddress).authorities(refreshToken.getAuthorities())
								.refreshToken(tokenInfo.getRefreshToken()).build());

						return response.success(tokenInfo);
					}
				}
			}
		}

		return response.fail("토큰 갱신에 실패했습니다.");
    	
    	
//        // 1. Refresh Token 검증
//        if (!jwtTokenProvider.validateToken(reissue.getRefreshToken())) {
//            return response.fail("Refresh Token 정보가 유효하지 않습니다.", HttpStatus.BAD_REQUEST);
//        }
//
//        // 2. Access Token 에서 UserId를 가져옵니다.
//        Authentication authentication = jwtTokenProvider.getAuthentication(reissue.getAccessToken());
//        System.out.println("-----loginService-----authentication.getPrincipal()"+authentication.getPrincipal());
//        System.out.println("-----loginService-----authentication.getName()"+authentication.getName());
//
//        // 3. Redis 에서 User email 을 기반으로 저장된 Refresh Token 값을 가져옵니다.
//        String refreshToken = (String)redisTemplate.opsForValue().get("refresh:" + authentication.getName()+" refreshToken");
//        HashOperations<String, Object, Object> hashOperations = redisTemplate.opsForHash();
//        String key = "refresh:test3";
//        String value = "id";
//        hashOperations.get(key, value);
//        Map<Object,Object> refreshToken2 = redisTemplate.opsForHash().entries(key);
//        System.out.println("+++++++++++"+refreshToken2.get(value));
//        String hashValue = (String) hashOperations.get(key, "id");
//        System.out.println("+++++++++++"+hashValue);
//        
//        // (추가) 로그아웃되어 Redis 에 RefreshToken 이 존재하지 않는 경우 처리
//        System.out.println("-----loginService-----"+refreshToken);
//        if(ObjectUtils.isEmpty(refreshToken)) {
//            return response.fail("잘못된 요청입니다.", HttpStatus.BAD_REQUEST);
//        }
//        if(!refreshToken.equals(reissue.getRefreshToken())) {
//            return response.fail("Refresh Token 정보가 일치하지 않습니다.", HttpStatus.BAD_REQUEST);
//        }
//
//        // 4. 새로운 토큰 생성
//        UserResponseDto.TokenInfo tokenInfo = jwtTokenProvider.generateToken(authentication);
//
//        // 5. RefreshToken Redis 업데이트
//        redisTemplate.opsForValue()
//                .set("RT:" + authentication.getName(), tokenInfo.getRefreshToken(), tokenInfo.getRefreshTokenExpirationTime(), TimeUnit.MILLISECONDS);
//
//        return response.success(tokenInfo, "Token 정보가 갱신되었습니다.", HttpStatus.OK);
    }

    public ResponseEntity<?> logout(HttpServletRequest request) {
        // 1. Access Token 검증
    	String token = jwtTokenProvider.resolveToken(request);
        if (!jwtTokenProvider.validateToken(token)) {
            return response.fail("잘못된 요청입니다.", HttpStatus.BAD_REQUEST);
        }

        // 2. Access Token 에서 User email 을 가져옵니다.
        Authentication authentication = jwtTokenProvider.getAuthentication(token);
        
        // 3. Redis 에서 해당 User email 로 저장된 Refresh Token 이 있는지 여부를 확인 후 있을 경우 삭제합니다.
        if (refreshTokenRedisRepository.findById(authentication.getName()) != null) {
            // Refresh Token 삭제
        	refreshTokenRedisRepository.deleteById(authentication.getName());
            System.out.println("------------------삭제성공-----------------");
        } 
        
        // 4. 해당 Access Token 유효시간 가지고 와서 BlackList 로 저장하기
        Long expiration = jwtTokenProvider.getExpiration(token);
        redisTemplate.opsForValue()
                .set(token, "logout", expiration, TimeUnit.MILLISECONDS);

        return response.success("로그아웃 되었습니다.");
    }

    public ResponseEntity<?> authority() {
        // SecurityContext에 담겨 있는 authentication userEamil 정보
        String userId = SecurityUtil.getCurrentUserId();

        Users user = userRepository.findByUserId(userId)
                .orElseThrow(() -> new UsernameNotFoundException("No authentication information."));

        // add ROLE_ADMIN
        user.getRoles().add(Role.MANAGER.getValue());
        userRepository.save(user);

        return response.success();
    }

}
