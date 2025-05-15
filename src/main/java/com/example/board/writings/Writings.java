package com.example.board.writings;

import jakarta.persistence.*;
import lombok.*;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@SuperBuilder
@NoArgsConstructor
@Table(name = "posts")
public class Writings {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)

//    @Column(nullable = false)
//    private String title;
    @Setter
    private String title;
    @Setter
    private String content;
}

