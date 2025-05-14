package com.example.board.user;

public record CreateUserRequest(
        String username,
        String password
) {
}
