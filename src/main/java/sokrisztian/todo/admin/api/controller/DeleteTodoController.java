package sokrisztian.todo.admin.api.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sokrisztian.todo.admin.logic.service.DeleteTodoService;

@RestController
@RequestMapping("/todos")
public class DeleteTodoController {

    private final DeleteTodoService service;

    public DeleteTodoController(DeleteTodoService service) {
        this.service = service;
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id) {
        service.deleteById(id);
    }

}
