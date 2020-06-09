package sokrisztian.todo.admin.logic.service;

import org.springframework.stereotype.Service;
import sokrisztian.todo.admin.api.model.ModifyTodoForm;
import sokrisztian.todo.admin.persistance.domain.TodoEntity;
import sokrisztian.todo.admin.persistance.repository.TodoBasicRepository;

@Service
public class ModifyTodoService {

    private final TodoBasicRepository repository;

    public ModifyTodoService(TodoBasicRepository repository) {
        this.repository = repository;
    }

    public void modify(ModifyTodoForm todoForm) {
        TodoEntity currentTodo = repository.findById(todoForm.getId()).get();
        repository.save(applyChanges(currentTodo, todoForm));
    }

    private TodoEntity applyChanges(TodoEntity currentTodo, ModifyTodoForm todoForm) {
        currentTodo.setDescription(todoForm.getDescription());
        currentTodo.setDeadline(todoForm.getDeadline());
        return currentTodo;
    }

}
