package com.ems.employee_management_system.controller;

import com.ems.employee_management_system.dto.RegisterRequest;
import com.ems.employee_management_system.entity.Role;
import com.ems.employee_management_system.entity.User;
import com.ems.employee_management_system.repository.RoleRepository;
import com.ems.employee_management_system.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserRepository userRepository;
    private final PasswordEncoder encoder;
    private final RoleRepository roleRepository;

    public AuthController(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.encoder = encoder;
    }

    @PostMapping("/register")
    public String register(@RequestBody RegisterRequest request) {

        Role role = roleRepository.findByName(request.getRole())
                .orElseThrow(() -> new RuntimeException("Invalid Role"));

        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(encoder.encode(request.getPassword()));
        user.setEnabled(true);
        user.setRoles(List.of(role));

        userRepository.save(user);

        return "User registered successfully";
    }
}
