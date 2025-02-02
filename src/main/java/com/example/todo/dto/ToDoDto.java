package com.example.todo.dto;

import java.time.LocalDateTime;
import lombok.*;

@Getter
@Setter
public class ToDoDto {
    private String title;
    private String content;
    private LocalDateTime deadLine;
    private boolean isCompleted;
}