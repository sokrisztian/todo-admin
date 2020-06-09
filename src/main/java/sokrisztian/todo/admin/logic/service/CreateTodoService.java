package sokrisztian.todo.admin.logic.service;

import org.springframework.stereotype.Service;
import sokrisztian.todo.admin.api.model.CreateTodoForm;
import sokrisztian.todo.admin.logic.converter.CreateTodoFormToTodoEntityConverter;
import sokrisztian.todo.admin.persistance.repository.TodoBasicRepository;

@Service
public class CreateTodoService {

    private final TodoBasicRepository repository;
    private final CreateTodoFormToTodoEntityConverter converter;

    public CreateTodoService(TodoBasicRepository repository, CreateTodoFormToTodoEntityConverter converter) {
        this.repository = repository;
        this.converter = converter;
    }

    public void create(CreateTodoForm todoForm) {
        repository.save(converter.convert(todoForm));
    }

}
