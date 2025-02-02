package com.example.todo.repository;

import com.example.todo.entity.ToDo;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class ToDoRepositoryImpl implements ToDoRepository {
    private final Map<Long, ToDo> todoData = new HashMap<>();
    private Long sequenceId = 1L;

    // 저장
    public ToDo save(ToDo todo) {
        if (todo.getId() == null) {
            todo.setId(sequenceId++);
        }
        todoData.put(todo.getId(), todo);
        return todo;
    }

    // 조회
    public List<ToDo> findAll() {
        return new ArrayList<>(todoData.values());
    }
    public ToDo findById(Long id) {
        return Optional.ofNullable(todoData.get(id))
                .orElse(null);
    }

    // 삭제
    public boolean deleteById(ToDo todo) {
        if(todoData.remove(todo.getId(), todo)) {
            return true;
        }
        return false;
    }
}
