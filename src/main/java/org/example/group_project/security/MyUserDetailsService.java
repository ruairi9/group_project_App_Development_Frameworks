package org.example.group_project.security;

import lombok.AllArgsConstructor;
import org.example.group_project.entities.MyUser;
import org.example.group_project.repositories.UserRepository;
import org.example.group_project.services.UserService;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@AllArgsConstructor
public class MyUserDetailsService implements UserDetailsService {

    private UserRepository userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MyUser myUser = userService.findByUserName(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(myUser.getRole());
        return new User(
                myUser.getUserName(),
                myUser.getPassword(),
                myUser.isEnabled(),
                true,
                true,
                true,
                Collections.singletonList(authority)
        );
    }
}
