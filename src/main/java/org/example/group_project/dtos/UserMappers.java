package org.example.group_project.dtos;

import org.example.group_project.entities.User;

public class UserMappers {

    public static UserDTO mapUserToUserDTO(User u) {
        return new UserDTO(
                u.getUserId(),
                u.getUserName(),
                u.getPassword(),
                u.getRole()
        );
    }

}
