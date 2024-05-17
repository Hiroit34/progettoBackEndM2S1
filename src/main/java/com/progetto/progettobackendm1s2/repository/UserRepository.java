package com.progetto.progettobackendm1s2.repository;

import com.progetto.progettobackendm1s2.data.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findById(Long id);
}
