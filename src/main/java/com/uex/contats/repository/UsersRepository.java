package com.uex.contats.repository;

import com.uex.contats.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users,Long> {
    Users findByEmail(String email);
}
