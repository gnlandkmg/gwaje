package com.example.board.writings;

public record DeleteRequest(
        Long id,
        String content
) {
}
