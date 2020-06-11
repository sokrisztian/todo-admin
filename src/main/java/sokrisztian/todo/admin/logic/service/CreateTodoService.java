package sokrisztian.todo.admin.logic.service;

import org.springframework.stereotype.Service;
import sokrisztian.todo.admin.persistance.domain.TodoEntity;
import sokrisztian.todo.admin.persistance.repository.TodoBasicRepository;

@Service
public class CreateTodoService {

    private static final String DEFAULT_DESCRIPTION = "What will be your next interesting TODO?";

    private final TodoBasicRepository repository;

    public CreateTodoService(TodoBasicRepository repository) {
        this.repository = repository;
    }

    public void createBlank(int userId) {
        repository.save(createBlankTodo(userId));
    }

    private TodoEntity createBlankTodo(int userId) {
        TodoEntity blank = new TodoEntity();
        blank.setUserId(userId);
        blank.setDescription(DEFAULT_DESCRIPTION);
        return blank;
    }

}
