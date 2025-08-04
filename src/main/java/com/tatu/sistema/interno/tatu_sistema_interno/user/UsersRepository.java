package com.tatu.sistema.interno.tatu_sistema_interno.user;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.security.core.userdetails.UserDetails;

public interface UsersRepository extends JpaRepository<Users, String>{
    UserDetails findByLogin(String login);
    Optional<Users> findByPhone(String phone);
    boolean existsByPhone (String phone);
    Optional<Users>findByRole(UserRole role);
    List<Users>findListByRole(UserRole role);
}
