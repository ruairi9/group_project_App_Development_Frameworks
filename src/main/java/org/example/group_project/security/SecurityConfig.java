package org.example.group_project.security;

import org.example.group_project.dtos.UserDTO;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.server.SecurityWebFilterChain;


@Configuration
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(auth -> auth
                .requestMatchers("/v3/api-doc/**", "/swagger-ui/**", "/swagger-ui.html", "/graphql/**").permitAll()
                .requestMatchers(PathRequest.toH2Console()).permitAll()
                .requestMatchers(HttpMethod.GET).permitAll()
                .requestMatchers(HttpMethod.PATCH).hasAnyRole("STAFF", "ADMIN")
                .requestMatchers(HttpMethod.POST).hasAnyRole("STAFF", "ADMIN")
                .requestMatchers(HttpMethod.DELETE).hasAnyRole("STAFF", "ADMIN")
                .anyRequest().authenticated()
        );
        http.headers(header ->
                header.frameOptions(HeadersConfigurer.FrameOptionsConfig::sameOrigin));
        http.cors(Customizer.withDefaults());
        http.sessionManagement(s->s.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        http.csrf(AbstractHttpConfigurer::disable);
        http.formLogin(Customizer.withDefaults());
        http.httpBasic(Customizer.withDefaults());
        return http.build();

    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    UserDetailsService userDetailsService(){
        UserDetails admin = User.withUsername("admin").password(passwordEncoder().encode("admin")).roles("ADMIN").build();
        UserDetails student = User.withUsername("student").password(passwordEncoder().encode("student")).roles("STUDENT").build();
        UserDetails staff = User.withUsername("staff").password(passwordEncoder().encode("staff")).roles("STAFF").build();
        return new InMemoryUserDetailsManager(admin,student,staff);
    }
}
