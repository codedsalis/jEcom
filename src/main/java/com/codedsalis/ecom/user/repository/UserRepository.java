package com.codedsalis.ecom.user.repository;

import com.codedsalis.ecom.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    User findByEmail(String email);
    boolean existsByEmail(String email);
}
