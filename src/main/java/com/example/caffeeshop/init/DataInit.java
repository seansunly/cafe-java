package com.example.caffeeshop.init;

import com.example.caffeeshop.doman.User;
import com.example.caffeeshop.features.user.UserRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class DataInit {
    private final UserRepository userRepository;
    @PostConstruct
    public void init() {
        if(userRepository.count() == 0) {
            User user1 = new User();
            user1.setCodeUser(UUID.randomUUID().toString());
            user1.setEmail("user1@gmail.com");
            user1.setPassword("password1");
            user1.setFirstName("User1");
            user1.setLastName("User1");
            user1.setConfirmPassword("password1");
            user1.setMobilePhone("0987654321");
            user1.setProfilePicture("qwertyuiopasdfghjkl");


            User user2 = new User();
            user2.setCodeUser(UUID.randomUUID().toString());
            user2.setEmail("user2@gmail.com");
            user2.setPassword("password2");
            user2.setFirstName("User2");
            user2.setLastName("User2");
            user2.setConfirmPassword("password2");
            user2.setMobilePhone("0987654322");
            user2.setProfilePicture("qwertyuiopasdfghjkl");

            User user3 = new User();
            user3.setCodeUser(UUID.randomUUID().toString());
            user3.setEmail("user3@gmail.com");
            user3.setPassword("password3");
            user3.setFirstName("User3");
            user3.setLastName("User3");
            user3.setConfirmPassword("password3");
            user3.setMobilePhone("0987654323");
            user3.setProfilePicture("qwertyuiopasdfghjkl");

            User user4 = new User();
            user4.setCodeUser(UUID.randomUUID().toString());
            user4.setEmail("user4@gmail.com");
            user4.setPassword("password4");
            user4.setFirstName("User4");
            user4.setLastName("User4");
            user4.setConfirmPassword("password4");
            user4.setMobilePhone("0987654324");
            user4.setProfilePicture("qwertyuiopasdfghjkl");

            userRepository.saveAll(List.of(user1, user2, user3, user4));
        }
    }


}
