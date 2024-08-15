package com.taskManaager.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.taskManaager.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

	User findByUserId(Long userId);
}
