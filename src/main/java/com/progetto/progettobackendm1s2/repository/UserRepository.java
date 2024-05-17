package com.progetto.progettobackendm1s2.repository;

import com.progetto.progettobackendm1s2.data.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserName(String username);
}
