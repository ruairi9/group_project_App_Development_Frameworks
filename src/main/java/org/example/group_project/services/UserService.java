package org.example.group_project.services;

import org.example.group_project.dtos.NewUserDTO;
import org.example.group_project.dtos.UserDTO;

public interface UserService {
    UserDTO save(NewUserDTO user);
}
