package sokrisztian.todo.admin.logic.service;

import org.springframework.stereotype.Service;
import sokrisztian.todo.admin.api.model.ModifyTodoForm;
import sokrisztian.todo.admin.persistance.domain.TodoEntity;
import sokrisztian.todo.admin.persistance.repository.TodoBasicRepository;

import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;

@Service
public class ModifyTodoService {

    private final TodoBasicRepository repository;

    public ModifyTodoService(TodoBasicRepository repository) {
        this.repository = repository;
    }

    public void modify(int todoId, ModifyTodoForm todoForm) {
        TodoEntity presentTodo = repository.findById(todoId).get();
        repository.save(applyChanges(presentTodo, todoForm));
    }

    private TodoEntity applyChanges(TodoEntity presentTodo, ModifyTodoForm todoForm) {
        presentTodo.setDescription(todoForm.getDescription());
        presentTodo.setDeadline(parseSafely(todoForm.getDeadline()));
        return presentTodo;
    }

    private LocalDateTime parseSafely(String dateTime) {
        try {
            return LocalDateTime.parse(dateTime);
        } catch (DateTimeParseException e) {
            return null;
        }
    }

}
