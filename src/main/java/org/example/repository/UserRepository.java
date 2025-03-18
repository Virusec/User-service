package org.example.repository;

import org.example.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


/**
 * @author Anatoliy Shikin
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findUserByLastNameIgnoreCase(String lastName);
}
