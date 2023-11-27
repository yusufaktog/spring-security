package com.aktog.yusuf.controller;


import com.aktog.yusuf.dto.AuthRequest;
import com.aktog.yusuf.dto.CreateUserRequest;
import com.aktog.yusuf.model.User;
import com.aktog.yusuf.service.JwtTokenGenerator;
import com.aktog.yusuf.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final JwtTokenGenerator jwtTokenGenerator;
    private final UserService userService;

    public AuthController(JwtTokenGenerator jwtTokenGenerator, UserService userService) {
        this.jwtTokenGenerator = jwtTokenGenerator;
        this.userService = userService;
    }

    @PostMapping("/generate")
    public String generateJwtToken(@RequestBody AuthRequest request){
        return jwtTokenGenerator.generateJwtToken(request);
    }
    @PostMapping("/create-user")
    public ResponseEntity<User> createUser(@RequestBody CreateUserRequest request){
        return ResponseEntity.ok(userService.createUser(request));
    }

    @DeleteMapping("/delete-user/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable  Long id){
        return ResponseEntity.ok(userService.deleteUserById(id));
    }

}
