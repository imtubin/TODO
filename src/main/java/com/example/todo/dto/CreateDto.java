package com.example.todo.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CreateDto {
    private String title;
    private String content;
    private LocalDateTime deadLine;
}
