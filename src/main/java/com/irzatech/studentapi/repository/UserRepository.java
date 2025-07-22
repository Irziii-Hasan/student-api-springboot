package com.irzatech.studentapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.irzatech.studentapi.model.AppUser;

public interface UserRepository extends JpaRepository<AppUser, Long> {

	Optional<AppUser>  findByUsername(String username);
}
