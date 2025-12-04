package com.webdynamo.AuthSysOne.repository;

import com.webdynamo.AuthSysOne.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repository interface for User entity operations.
 *
 * @Repository: Indicates that this interface is a Spring Data repository.
 * It serves as a mechanism for encapsulating storage, retrieval, and search behavior which emulates a collection of objects.
 *
 * JpaRepository<Users, Long>: Extends JpaRepository to provide standard CRUD operations for the Users entity.
 * - Users: The entity type.
 * - Long: The type of the primary key.
 */
@Repository
public interface UserRepo extends JpaRepository<Users, Long> {
    
    /**
     * Custom query method to find a user by their username.
     * Spring Data JPA automatically implements this method based on the name.
     *
     * @param username The username to search for.
     * @return An Optional containing the User if found, or empty if not.
     */
    Optional<Users> findByUsername(String username);
}
