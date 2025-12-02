package org.example.group_project.dtos;



public record UserDTO(
        int userId,
        String userName,
        String password,
        String role
) {}
