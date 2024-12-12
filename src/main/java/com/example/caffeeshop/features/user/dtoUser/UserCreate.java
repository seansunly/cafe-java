package com.example.caffeeshop.features.user.dtoUser;

public record UserCreate(
         String codeUser,
         String firstName,
         String middleName,
         String lastName,
         String gender,
         String profilePicture
) {
}
