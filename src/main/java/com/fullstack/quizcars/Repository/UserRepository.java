package com.fullstack.quizcars.Repository;

import com.fullstack.quizcars.classes.User;
import com.fullstack.quizcars.classes.Version;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    @Query("SELECT u FROM User u WHERE u.id = ?1") // Use JPQL query to fetch user by id
    Optional<User> findById(Long id);
}
