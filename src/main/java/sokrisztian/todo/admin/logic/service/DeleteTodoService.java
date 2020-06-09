package sokrisztian.todo.admin.logic.service;

import org.springframework.stereotype.Service;
import sokrisztian.todo.admin.persistance.repository.TodoBasicRepository;

@Service
public class DeleteTodoService {

    private final TodoBasicRepository repository;

    public DeleteTodoService(TodoBasicRepository repository) {
        this.repository = repository;
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }

}
