package org.example.group_project.repositories;

import org.example.group_project.entities.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<MyUser, Integer> {

    boolean existsByUserName(String userName);
    Optional<MyUser> findByUserName(String userName);
}
