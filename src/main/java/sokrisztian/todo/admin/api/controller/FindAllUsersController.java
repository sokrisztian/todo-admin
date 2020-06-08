package sokrisztian.todo.admin.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sokrisztian.todo.admin.api.model.UserView;
import sokrisztian.todo.admin.logic.service.FindAllUsersService;

import java.util.List;

@RestController
@RequestMapping("/users")
public class FindAllUsersController {

    private final FindAllUsersService service;

    public FindAllUsersController(FindAllUsersService service) {
        this.service = service;
    }

    @GetMapping
    public List<UserView> findAll() {
        return service.findAll();
    }

}
