package sokrisztian.todo.admin.api.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sokrisztian.todo.admin.api.model.CreateTodoForm;
import sokrisztian.todo.admin.logic.service.CreateTodoService;

import javax.validation.Valid;

@RestController
@RequestMapping("/todos")
public class CreateTodoController {

    private final CreateTodoService service;

    public CreateTodoController(CreateTodoService service) {
        this.service = service;
    }

    @PostMapping
    public void create(@Valid @RequestBody CreateTodoForm todoForm) {
        service.create(todoForm);
    }

}
