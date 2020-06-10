package sokrisztian.todo.admin.api.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sokrisztian.todo.admin.api.model.ModifyUserForm;
import sokrisztian.todo.admin.logic.service.ModifyUserService;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
public class ModifyUserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ModifyUserController.class);

    private final ModifyUserService service;

    public ModifyUserController(ModifyUserService service) {
        this.service = service;
    }

    @PutMapping
    public void modify(@Valid @RequestBody ModifyUserForm userForm) {
        LOGGER.info("Modify user request arrived: {}", userForm);
        service.modify(userForm);
        LOGGER.info("Modify user request served: {}", userForm);
    }

}
