package com.example.board.user;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/print")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @GetMapping()
    public String printHelloWorld() { return postService.printHelloWorld();}

    @PostMapping()
    public void singup(@RequestBody CreateUserRequest request) {
        postService.signup(request);
    }

    @GetMapping("/users")
    public List<Post> findAllUsers() {
        return postService.findAllUsers();
    }

}