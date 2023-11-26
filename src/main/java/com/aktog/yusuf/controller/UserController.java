package com.aktog.yusuf.controller;


import com.aktog.yusuf.dto.CreateUserRequest;
import com.aktog.yusuf.model.User;
import com.aktog.yusuf.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody CreateUserRequest request){
        return ResponseEntity.ok(userService.createUser(request));
    }

    @DeleteMapping
    public ResponseEntity<String> deleteUser(Long id){
        return ResponseEntity.ok(userService.deleteUserById(id));
    }

}
