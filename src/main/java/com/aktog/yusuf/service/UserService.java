package com.aktog.yusuf.service;


import com.aktog.yusuf.dto.CreateUserRequest;
import com.aktog.yusuf.model.User;
import com.aktog.yusuf.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public Optional<User> findByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }

    public User createUser(CreateUserRequest request) {

        User user = User.builder()
                .name(request.name())
                .username(request.username())
                .password(bCryptPasswordEncoder.encode(request.password()))
                .roles(request.roles())
                .accountNonExpired(true)
                .accountNonLocked(true)
                .credentialsNonExpired(true)
                .enabled(true)
                .build();

        return userRepository.save(user);
    }

    public String deleteUserById(Long id) {
        User user = userRepository.findById(id).orElse(null);

        if (Objects.isNull(user)) {
            throw new EntityNotFoundException("Id: " + id + " not found!");
        }

        return user.getId() + " has been deleted...";
    }
}
