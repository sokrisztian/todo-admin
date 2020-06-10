package sokrisztian.todo.admin.api.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger LOGGER = LoggerFactory.getLogger(CreateTodoController.class);

    private final CreateTodoService service;

    public CreateTodoController(CreateTodoService service) {
        this.service = service;
    }

    @PostMapping
    public void create(@Valid @RequestBody CreateTodoForm todoForm) {
        LOGGER.info("Create TODO request arrived: {}", todoForm);
        service.create(todoForm);
        LOGGER.info("Create TODO request served: {}", todoForm);
    }

}
