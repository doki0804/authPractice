package com.noriand.api.repository.users;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.noriand.api.entity.users.Users;

public interface UsersRepository extends JpaRepository<Users,Long> {

	Optional<Users> findByUserId(String userId);

	boolean existsByUserId(String userId);

}
