package org.example.repository;

import org.example.model.UserApp;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


/**
 * @author Anatoliy Shikin
 */
public interface UserRepository extends JpaRepository<UserApp, Long> {
    Optional<UserApp> findUserByLastNameIgnoreCase(String lastName);
}
