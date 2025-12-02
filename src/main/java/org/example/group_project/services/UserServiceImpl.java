package org.example.group_project.services;

import lombok.AllArgsConstructor;
import org.example.group_project.dtos.NewUserDTO;
import org.example.group_project.dtos.UserDTO;
import org.example.group_project.dtos.UserMappers;
import org.example.group_project.entities.User;
import org.example.group_project.exceptions.NotFoundException;
import org.example.group_project.repositories.UserRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    public UserDTO save(NewUserDTO newUserDTO) {
        User user = new User();
        user.setUserId(0);
        user.setUserName(newUserDTO.userName());
        user.setPassword(newUserDTO.password());
        user.setRole(newUserDTO.role());
        if (userRepository.existsByUserName(user.getUserName())) {
            throw new NotFoundException(user.getUserName() + " in "
                    + " already exists");
        }

        return UserMappers.mapUserToUserDTO(userRepository.save(user));
    }
}
