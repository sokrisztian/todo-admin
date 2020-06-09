package sokrisztian.todo.admin.api.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sokrisztian.todo.admin.persistance.repository.TodoBasicRepository;

@RestController
@RequestMapping("/todos")
public class DeleteTodoController {

    private final TodoBasicRepository repository;

    public DeleteTodoController(TodoBasicRepository repository) {
        this.repository = repository;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        repository.deleteById(id);
    }

}
