package com.example.todo.repository;

import com.example.todo.entity.ToDo;

import java.util.List;
import java.util.Optional;

public interface ToDoRepository {
    // 저장
    ToDo save(ToDo todo);
    // 조회
    List<ToDo> findAll();
    ToDo findById(Long id);
    // 삭제
    boolean deleteById(ToDo todo);
}
