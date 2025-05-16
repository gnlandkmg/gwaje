package com.example.board.writings;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class WriteController {
    private final WriteService writeService;

    @PostMapping()
    public void createWritings(@RequestBody CreateWritingsRequest request) {
        writeService.createWritings(request);
    }


    @GetMapping("/{id}")
    public WritingsResponse findWritingsById(@PathVariable Long id) {
        return writeService.findWritingsById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteWritings(@PathVariable Long id) {

        writeService.deleteWritings(id);
    }
    @PatchMapping()
    public WritingsResponse updateWritings(@RequestBody UpdateWritings request) {
        return writeService.updateWritings(request);
    }

    @GetMapping()
    public List<WritingsResponse> findAll() {
        return writeService.findAll();
    }
}
