package org.example.group_project.dtos;

import org.example.group_project.entities.MyUser;

public class UserMappers {

    public static UserDTO mapUserToUserDTO(MyUser u) {
        return new UserDTO(
                u.getUserId(),
                u.getUserName(),
                u.getPassword(),
                u.getRole()
        );
    }

}
