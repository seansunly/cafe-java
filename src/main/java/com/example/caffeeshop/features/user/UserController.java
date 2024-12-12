package com.example.caffeeshop.features.user;

import com.example.caffeeshop.features.user.dtoUser.UserCreate;
import com.example.caffeeshop.features.user.dtoUser.UserResponse;
import com.example.caffeeshop.features.user.dtoUser.UserUpdate;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/user")
public class UserController {
    private final UserService userService;

    @GetMapping("/{codeUser}")
    public UserResponse getUser(@PathVariable String codeUser) {
        return userService.getProfile(codeUser);
    }

    @PostMapping
    public UserResponse createUser(@Valid @RequestBody UserCreate userCreate) {
        return userService.createProfile(userCreate);
    }

    @GetMapping
    public List<UserResponse> getAllUsers() {
        return userService.getAllUsers();
    }

    @DeleteMapping("/{codeUser}")
    public void deleteUser(@PathVariable String codeUser) {
        userService.deleteProfile(codeUser);
    }

    @PatchMapping("/{codeUser}")
    public UserResponse updateUser(@PathVariable String codeUser, @Valid @RequestBody UserUpdate userUpdate) {
        return userService.updateProfile(codeUser, userUpdate);
    }


}
