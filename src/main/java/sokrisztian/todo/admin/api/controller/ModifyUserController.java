package sokrisztian.todo.admin.api.controller;

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

    private final ModifyUserService service;

    public ModifyUserController(ModifyUserService service) {
        this.service = service;
    }

    @PutMapping
    public void create(@Valid @RequestBody ModifyUserForm todoForm) {
        service.modify(todoForm);
    }

}
