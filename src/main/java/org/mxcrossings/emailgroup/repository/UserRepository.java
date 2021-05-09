package org.mxcrossings.emailgroup.repository;

import org.mxcrossings.emailgroup.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository< UserEntity, Long > {
    UserEntity findByEmail(String email);
    UserEntity findByFirstName(String firstName);
}