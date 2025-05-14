package com.example.board.user;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/print")
@RequiredArgsConstructor
public class PostController {
    private final com.example.samdi3.user.PostService printService;

    @GetMapping()
    public String printHelloWorld() { return printService.printHelloWorld();}

    @PostMapping()
    public void singup(@RequestBody CreateUserRequest request) {
        printService.signup(request);
    }

    @GetMapping("/users")
    public List<Post> findAllUsers() {
        return printService.findAllUsers();
    }

}