package sokrisztian.todo.admin.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import sokrisztian.todo.admin.api.model.TodoView;
import sokrisztian.todo.admin.logic.service.FindTodosByUserIdService;

import java.util.List;

@Controller
public class FindTodosByUserIdController {

    private final FindTodosByUserIdService service;

    public FindTodosByUserIdController(FindTodosByUserIdService service) {
        this.service = service;
    }

    @ModelAttribute("todos")
    public List<TodoView> addTodos(@RequestParam int userId) {
        return service.findByUserId(userId);
    }

    @GetMapping("/todos")
    public void showTodos() {
    }

}
