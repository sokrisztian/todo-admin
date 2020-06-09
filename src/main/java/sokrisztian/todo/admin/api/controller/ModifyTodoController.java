package sokrisztian.todo.admin.api.controller;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sokrisztian.todo.admin.api.model.ModifyTodoForm;
import sokrisztian.todo.admin.logic.service.ModifyTodoService;

import javax.validation.Valid;

@RestController
@RequestMapping("/todos")
public class ModifyTodoController {

    private final ModifyTodoService service;

    public ModifyTodoController(ModifyTodoService service) {
        this.service = service;
    }

    @PutMapping
    public void create(@Valid @RequestBody ModifyTodoForm todoForm) {
        service.modify(todoForm);
    }

}
