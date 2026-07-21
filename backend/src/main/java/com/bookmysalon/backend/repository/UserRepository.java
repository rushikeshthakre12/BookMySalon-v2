package com.bookmysalon.backend.repository;

import com.bookmysalon.backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // Spring Data JPA will automatically write the SQL query for this method!
    Optional<User> findByEmail(String email);

}