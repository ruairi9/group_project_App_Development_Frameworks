package org.example.group_project.controllers;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.example.group_project.dtos.NewUserDTO;
import org.example.group_project.dtos.UserDTO;
import org.example.group_project.services.UserService;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;

@Controller
@AllArgsConstructor
public class GraphQLUsersController {

    private final UserService usersService;

    @MutationMapping
    public UserDTO createUser(@Valid @Argument("newUser") NewUserDTO newUserDTO) {
        return usersService.save(newUserDTO);
    }
    @QueryMapping
    public UserDTO getUserById(@Argument int id) {
        return usersService.findById(id);
    }


}
