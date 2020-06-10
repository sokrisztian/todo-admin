package sokrisztian.todo.admin.api.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sokrisztian.todo.admin.api.model.CreateUserForm;
import sokrisztian.todo.admin.logic.service.CreateUserService;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
public class CreateUserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CreateUserController.class);

    private final CreateUserService service;

    public CreateUserController(CreateUserService service) {
        this.service = service;
    }

    @PostMapping
    public void create(@Valid @RequestBody CreateUserForm userForm) {
        LOGGER.info("Create user request arrived: {}", userForm);
        service.create(userForm);
        LOGGER.info("Create user request served: {}", userForm);
    }

}
