package com.example.samdi3.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private final UserRepository userRepository;

    public String printHelloWorld() {
        User user = User.builder()
                .username("gnlandkmg")
                .password("Qwer1234!")
                .build();

        userRepository.save(user);

        return "Hello World!";
    }

    public void signup(CreateUserRequest request) {
        User user = User.builder()
                .username(request.username())
                .password(request.password())
                .build();

        userRepository.save(user);
    }


    public List<User> findAllUsers() {
        return userRepository.findAll();
    }
}
