package com.example.board.writings;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WritingsRepository extends JpaRepository<Writings, Long> {
    Optional<Writings> findById(Long id);
}

