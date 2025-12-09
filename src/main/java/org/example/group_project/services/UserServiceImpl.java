package org.example.group_project.services;

import lombok.AllArgsConstructor;
import org.example.group_project.dtos.NewUserDTO;
import org.example.group_project.dtos.UserDTO;
import org.example.group_project.dtos.UserMappers;
import org.example.group_project.entities.MyUser;
import org.example.group_project.exceptions.DatabaseException;
import org.example.group_project.exceptions.DuplicateResourceException;
import org.example.group_project.exceptions.NotFoundException;
import org.example.group_project.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDTO save(NewUserDTO newUserDTO) {
        MyUser myUser = new MyUser();
        myUser.setUserId(0);
        myUser.setUserName(newUserDTO.userName());
        myUser.setPassword(passwordEncoder.encode(newUserDTO.password()));
        myUser.setRole(newUserDTO.role());
        if (userRepository.existsByUserName(myUser.getUserName())) {
            throw new DuplicateResourceException(
                    "User with username " + myUser.getUserName() + " already exists"
            );
        }
        return  Optional.of(UserMappers.mapUserToUserDTO(userRepository.save(myUser)))
                .orElseThrow(() -> new DatabaseException("Failed to save user"));
    }

    @Override
    public UserDTO findById(int id) {
        MyUser myUser = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("User not found with id " + id));
        return UserMappers.mapUserToUserDTO(myUser);
    }
}
