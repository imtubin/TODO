package com.example.todo.entity;

import java.time.LocalDateTime;
import lombok.*;

@Getter
@Setter
public class ToDo {
    private Long id;
    private String title;
    private String content;
    private LocalDateTime createAt;
    private LocalDateTime deadLine;
    private boolean isCompleted;

    public ToDo(String title, String content, LocalDateTime deadLine) {
        this.title = title;
        this.content = content;
        this.createAt = LocalDateTime.now();
        this.deadLine = deadLine;
        this.isCompleted = false;
    }
}
