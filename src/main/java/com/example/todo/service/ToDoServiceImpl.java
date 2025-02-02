package com.example.todo.service;

import com.example.todo.dto.CreateDto;
import com.example.todo.dto.ToDoDto;
import com.example.todo.entity.ToDo;
import com.example.todo.repository.ToDoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ToDoServiceImpl implements ToDoService {
    private final ToDoRepository toDoRepository;

    public ToDoServiceImpl(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    // 생성
    public ToDo create(CreateDto todoDto) {
        ToDo todo = new ToDo(todoDto.getTitle(), todoDto.getContent(), todoDto.getDeadLine());
        return toDoRepository.save(todo);
    }

    // 조회
    public List<ToDo> getAll() {
        return toDoRepository.findAll();
    }
    public ToDo getById(Long id) {
        return toDoRepository.findById(id);
    }

    // 수정
    public ToDo update(Long id, ToDoDto todoDto) {
        ToDo todo = toDoRepository.findById(id);
        todo.setTitle(todoDto.getTitle());
        todo.setContent(todoDto.getContent());
        todo.setDeadLine(todoDto.getDeadLine());
        todo.setCompleted(todoDto.isCompleted());
        System.out.println(todo.isCompleted());
        return toDoRepository.save(todo);
    }

    // 삭제
    public boolean delete(Long id) {
        return toDoRepository.deleteById(toDoRepository.findById(id));
    }
}
