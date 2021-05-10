package org.mxcrossings.emailgroup.repository;

import org.mxcrossings.emailgroup.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository< UserEntity, Long > {
    Optional<UserEntity> findUserById(Long id);
    Optional<UserEntity> findUserByFirstName(String firstName);
    Optional<UserEntity> findUserByLastName(String lastName);
    Optional<UserEntity> findUserByEmail(String email);
}