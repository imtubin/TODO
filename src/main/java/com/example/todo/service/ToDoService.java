package com.example.todo.service;

import com.example.todo.dto.CreateDto;
import com.example.todo.dto.ToDoDto;
import com.example.todo.entity.ToDo;

import java.util.*;


public interface ToDoService {
    // 생성
    ToDo create(CreateDto todoDto);
    // 조회
    List<ToDo> getAll();
    ToDo getById(Long id);
    // 수정
    ToDo update(Long id, ToDoDto todoDto);
    // 삭제
    boolean delete(Long id);
}
