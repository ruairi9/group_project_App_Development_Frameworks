//package org.example.group_project.controllers;
//
//import jakarta.validation.Valid;
//import lombok.AllArgsConstructor;
//import org.example.group_project.dtos.NewUserDTO;
//import org.example.group_project.dtos.UserDTO;
//import org.example.group_project.services.UserService;
//import org.springframework.graphql.data.method.annotation.Argument;
//import org.springframework.graphql.data.method.annotation.MutationMapping;
//import org.springframework.stereotype.Controller;
//
//@Controller
//@AllArgsConstructor
//public class RestUserService {
//    private final UserService usersService;
//
//    @MutationMapping
//    public UserDTO createUser(@Valid @Argument("newUser") NewUserDTO newUserDTO) {
//        return usersService.save(newUserDTO);
//    }
//}
