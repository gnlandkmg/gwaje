package com.example.board.writings;

public record WritingsResponse(
        String title,
        String content
) {
    public static WritingsResponse of (Writings writings) {
        return new WritingsResponse(
                writings.getTitle(),
                writings.getContent()
        );
    }
}
