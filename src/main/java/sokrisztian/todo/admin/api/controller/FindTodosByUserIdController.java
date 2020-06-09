package sokrisztian.todo.admin.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sokrisztian.todo.admin.api.model.TodoView;
import sokrisztian.todo.admin.logic.service.FindTodosByUserIdService;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class FindTodosByUserIdController {

    private final FindTodosByUserIdService service;

    public FindTodosByUserIdController(FindTodosByUserIdService service) {
        this.service = service;
    }

    @GetMapping
    public List<TodoView> findByUserId(@RequestParam int userId) {
        return service.findByUserId(userId);
    }

}
