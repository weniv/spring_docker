package com.example.dockercomposedemo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "todos")
@Getter
@Setter
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    private boolean completed;

    private LocalDateTime createdAt;

    // 기본 생성자
    public Todo() {
        this.createdAt = LocalDateTime.now();
    }

}