package com.example.caffeeshop.features.user;

import com.example.caffeeshop.features.user.dtoUser.UserCreate;
import com.example.caffeeshop.features.user.dtoUser.UserResponse;
import com.example.caffeeshop.features.user.dtoUser.UserUpdate;

import java.util.List;

public interface UserService {
    UserResponse createProfile(UserCreate userCreate);
    UserResponse updateProfile(String codeUser,UserUpdate userUpdate);
    void deleteProfile(String codeUser);
    UserResponse getProfile(String codeUser);
    List<UserResponse> getAllUsers();

}
