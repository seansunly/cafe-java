package com.example.caffeeshop.features.user;

import com.example.caffeeshop.doman.User;
import com.example.caffeeshop.features.user.dtoUser.UserCreate;
import com.example.caffeeshop.features.user.dtoUser.UserResponse;
import com.example.caffeeshop.features.user.dtoUser.UserUpdate;
import com.example.caffeeshop.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    @Override
    public UserResponse createProfile(UserCreate userCreate) {
        if(userRepository.existsByCodeUser(userCreate.codeUser())){
            throw new ResponseStatusException(HttpStatus.CONFLICT, "User already exists");
        }


        User user =userMapper.createProfile(userCreate);
        user.setCodeUser(UUID.randomUUID().toString());
        user= userRepository.save(user);

        return userMapper.entityToUser(user);
    }

    @Override
    public UserResponse updateProfile(String codeUser, UserUpdate userUpdate) {
        User user =userRepository.findByCodeUser(codeUser)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));

        userMapper.updateUser(user,userUpdate);
        user= userRepository.save(user);
        return userMapper.entityToUser(user);
    }

    @Override
    public void deleteProfile(String codeUser) {
        User user =userRepository.findByCodeUser(codeUser)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
        userRepository.delete(user);
    }

    @Override
    public UserResponse getProfile(String codeUser) {
        User user =userRepository.findByCodeUser(codeUser)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
        user = userRepository.save(user);
        return userMapper.entityToUser(user);
    }

    @Override
    public List<UserResponse> getAllUsers() {
        List<User> users = userRepository.findAll();
        return userMapper.userListToUserResponseList(users);
    }
}
