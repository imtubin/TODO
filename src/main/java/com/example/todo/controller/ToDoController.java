package com.example.todo.controller;

import com.example.todo.dto.CreateDto;
import com.example.todo.dto.ToDoDto;
import com.example.todo.entity.ToDo;
import com.example.todo.service.ToDoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/todos")
public class ToDoController {
    private final ToDoService toDoService;

    public ToDoController(ToDoService toDoService) {
        this.toDoService = toDoService;
    }

    // TODO 생성
    @PostMapping
    public ResponseEntity<ToDo> createTodo(@RequestBody CreateDto todoDto) {
        try {
            ToDo createdTodo = toDoService.create(todoDto);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(createdTodo);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    // 전체 조회
    @GetMapping
    public ResponseEntity<List<ToDo>> getAllTodos() {
        return ResponseEntity.ok(toDoService.getAll());
    }

    // 단일 조회
    @GetMapping("/{id}")
    public ResponseEntity<ToDo> getTodo(@PathVariable Long id) {
        try {
            ToDo todo = toDoService.getById(id);
            if (todo == null) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(todo);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    // TODO 수정
    @PutMapping("/{id}")
    public ResponseEntity<ToDo> updateTodo(@PathVariable Long id, @RequestBody ToDoDto todoDto) {
        try {
            if (todoDto == null || todoDto.getTitle().isEmpty()) {
                return ResponseEntity.badRequest().build();
            }
            ToDo updatedTodo = toDoService.update(id, todoDto);
            if (updatedTodo == null) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.status(HttpStatus.CREATED)
                    .header("Location", "/todos/" + updatedTodo.getId())
                    .body(updatedTodo);
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    // TODO 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable Long id) {
        try {
            if (toDoService.delete(id)) {
                return ResponseEntity.ok().build();
            }
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

}
