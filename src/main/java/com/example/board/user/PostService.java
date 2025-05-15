package com.example.board.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository PostRepository;

    public String printHelloWorld() {
        Post user = Post.builder()
                .username("gnlandkmg")
                .password("Qwer1234!")
                .build();

        PostRepository.save(user);

        return "Hello World!";
    }

    public void signup(CreateUserRequest request) {
        Post user = Post.builder()
                .username(request.username())
                .password(request.password())
                .build();

        PostRepository.save(user);
    }


    public List<Post> findAllUsers() {
        return PostRepository.findAll();
    }
}
