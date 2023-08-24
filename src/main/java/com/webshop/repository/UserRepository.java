package com.webshop.repository;

import com.webshop.model.entity.UserEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    /**
     * Find specific user by providing their email
     * @param email - String (user's email)
     * @return UserEntity, if any
     */
    Optional<UserEntity> findByUsername(String email);
}
