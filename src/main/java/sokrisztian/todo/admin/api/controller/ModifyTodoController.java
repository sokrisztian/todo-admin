package sokrisztian.todo.admin.api.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger LOGGER = LoggerFactory.getLogger(ModifyTodoController.class);

    private final ModifyTodoService service;

    public ModifyTodoController(ModifyTodoService service) {
        this.service = service;
    }

    @PutMapping
    public void modify(@Valid @RequestBody ModifyTodoForm todoForm) {
        LOGGER.info("Modify TODO request arrived: {}", todoForm);
        service.modify(todoForm);
        LOGGER.info("Modify TODO request served: {}", todoForm);
    }

}
