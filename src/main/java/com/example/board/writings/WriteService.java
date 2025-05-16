package com.example.board.writings;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class WriteService {
    private final WritingsRepository WritingsRepository;

    public void createWritings(CreateWritingsRequest request) {
        Writings writings = Writings.builder()
                .title(request.title())
                .content(request.content())
                .build();

        WritingsRepository.save(writings);
    }
    public String delete(DeleteRequest request) {
        Writings writings = WritingsRepository.findById(request.id()).orElse(null);

        if (writings == null) {
            throw new IllegalArgumentException(request.id() + "는 없는 글입니다.");
        }
        WritingsRepository.delete(writings);
        return "글이 삭제되었습니다.";
    }
    public WritingsResponse findWritingsById(Long id) {
        Writings e = WritingsRepository.findById(id).orElse(null);
        if (e == null) {
            throw new IllegalArgumentException(id +"는 없는 글입니다.");
        }

        return WritingsResponse.of(e);
    }
    public void deleteWritings(Long id) {
        Writings e = WritingsRepository.findById(id).orElse(null);
        if (e == null) {
            throw new IllegalArgumentException(id +"는 없는 글입니다.");
        }
        WritingsRepository.delete(e);
    }
    public WritingsResponse updateWritings(UpdateWritings request) {
        Writings e = WritingsRepository.findById(request.id()).orElse(null);
        if (e == null) {
            throw new IllegalArgumentException(request.id() +"는 없는 글입니다.");
        }
        e.setContent(request.content());

        WritingsRepository.save(e);

        return WritingsResponse.of(e);
    }

    public List<WritingsResponse> findAll() {
        return WritingsRepository.findAll().stream().map(WritingsResponse::of).collect(Collectors.toList());
    }
}
