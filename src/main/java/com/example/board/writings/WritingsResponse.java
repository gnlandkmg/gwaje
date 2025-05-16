package com.example.board.writings;

public record WritingsResponse(
        Long id,
        String title,
        String content
) {
    public static WritingsResponse of (Writings writings) {
        return new WritingsResponse(
                writings.getId(),
                writings.getTitle(),
                writings.getContent()
        );
    }
}
