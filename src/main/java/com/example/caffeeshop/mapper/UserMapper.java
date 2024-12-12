package com.example.caffeeshop.mapper;

import com.example.caffeeshop.doman.User;
import com.example.caffeeshop.features.user.dtoUser.UserCreate;
import com.example.caffeeshop.features.user.dtoUser.UserResponse;
import com.example.caffeeshop.features.user.dtoUser.UserUpdate;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User createProfile(UserCreate userCreate);

    UserResponse entityToUser(User user);


    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateUser(@MappingTarget User user, UserUpdate userUpdate);

    List<UserResponse> userListToUserResponseList(List<User> userList);
}
