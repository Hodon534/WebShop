package com.webshop.repository;

import com.webshop.model.entity.UserEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repository interface for managing User entities in the database.
 */
@Repository
@Transactional
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    /**
     * Find a specific user by providing their email address.
     *
     * @param email The email address of the user.
     * @return An optional containing a UserEntity if a user with the given email exists, or empty if not found.
     */
    Optional<UserEntity> findByUsername(String email);
}
