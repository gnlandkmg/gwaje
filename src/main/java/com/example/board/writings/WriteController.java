package com.example.board.writings;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/title")
@RequiredArgsConstructor


public class WriteController {
    private final WriteService writeService;

    @PostMapping()
    public String createWritings(@RequestBody CreateWritingsRequest request) {
        writeService.createWritings(request);
        return writeService.createWritings(request);
    }

    @PatchMapping()
    public String delete(@RequestBody DeleteRequest request) {
        return writeService.delete(request);
    }


    @GetMapping()
    public WritingsResponse findWritingsByTitle(@RequestParam String title) {
        return writeService.findWritingsByTitle(title);
    }

    @DeleteMapping()
    public void deleteWritings(@RequestParam String title) {

        writeService.deleteWritings(title);
    }
    @PatchMapping("/post")
    public WritingsResponse updateWritings(@RequestBody UpdateWritings request) {
        return writeService.updateWritings(request);
    }
}
