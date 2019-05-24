package com.example.balalar.data;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.balalar.model.Userfront;

@Repository
public interface UserRepository extends JpaRepository<Userfront, Long> {
    Optional<Userfront> findByUsername(String username);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
}