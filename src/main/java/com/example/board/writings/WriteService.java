package com.example.board.writings;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class WriteService {
    private final WritingsRepository WritingsRepository;

    public String createWritings(CreateWritingsRequest request) {
        Writings e =WritingsRepository.findByTitle("제목1").orElse(null);

        if (e != null) {
            throw new RuntimeException("이 글은 이미 있습니다.");
        }


        Writings writings = Writings.builder()
                .title(request.title())
                .content(request.content())
                .build();

        WritingsRepository.save(writings);
        return "글이 성공적으로 작성되었습니다.";
    }
    public String delete(DeleteRequest request) {
        Writings writings = WritingsRepository.findByTitle(request.title()).orElse(null);

        if (writings == null) {
            throw new IllegalArgumentException(request.title() + "는 없는 글입니다.");
        }
        WritingsRepository.delete(writings);
        return "글이 삭제되었습니다.";
    }
    public WritingsResponse findWritingsByTitle(String title) {
        Writings e = WritingsRepository.findByTitle(title).orElse(null);
        if (e == null) {
            throw new IllegalArgumentException(title +"는 없는 글입니다.");
        }

        return WritingsResponse.of(e);
    }
    public void deleteWritings(String title) {
        Writings e = WritingsRepository.findByTitle(title).orElse(null);
        if (e == null) {
            throw new IllegalArgumentException(title +"는 없는 글입니다.");
        }
        WritingsRepository.delete(e);
    }
    public WritingsResponse updateWritings(UpdateWritings request) {
        Writings e = WritingsRepository.findByTitle(request.title()).orElse(null);
        if (e == null) {
            throw new IllegalArgumentException(request.title() +"는 없는 글입니다.");
        }
        e.setTitle(request.title());
        e.setContent(request.content());

        WritingsRepository.save(e);

        return WritingsResponse.of(e);
    }
}
