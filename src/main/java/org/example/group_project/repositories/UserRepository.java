package org.example.group_project.repositories;

import org.example.group_project.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    boolean existsByUserName(String userName);
}
