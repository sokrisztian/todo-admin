package sokrisztian.todo.admin.api.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import sokrisztian.todo.admin.api.model.CreateUserForm;
import sokrisztian.todo.admin.logic.service.CreateUserService;

import javax.validation.Valid;

@Controller
public class CreateUserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CreateUserController.class);

    private final CreateUserService service;

    public CreateUserController(CreateUserService service) {
        this.service = service;
    }

    @GetMapping("/users/create")
    public String showCreatePage() {
        return "createUser";
    }

    @PostMapping("/users/create")
    public String create(@Valid @ModelAttribute CreateUserForm userForm) {
        LOGGER.info("Create user request arrived: {}", userForm);
        service.create(userForm);
        LOGGER.info("Create user request served: {}", userForm);
        return "redirect:/users";
    }

}
