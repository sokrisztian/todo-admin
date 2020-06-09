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
        TodoEntity presentTodo = repository.findById(todoForm.getId()).get();
        repository.save(applyChanges(presentTodo, todoForm));
    }

    private TodoEntity applyChanges(TodoEntity presentTodo, ModifyTodoForm todoForm) {
        presentTodo.setDescription(todoForm.getDescription());
        presentTodo.setDeadline(todoForm.getDeadline());
        return presentTodo;
    }

}
