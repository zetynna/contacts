package com.uex.contats.repository;

import com.uex.contats.domain.PasswordResetToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecoveryPasswordRepository extends JpaRepository<PasswordResetToken,Long> {
}
