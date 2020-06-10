package sokrisztian.todo.admin.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import sokrisztian.todo.admin.api.model.UserView;
import sokrisztian.todo.admin.logic.service.FindAllUsersService;

import java.util.List;

@Controller
public class FindAllUsersController {

    private final FindAllUsersService service;

    public FindAllUsersController(FindAllUsersService service) {
        this.service = service;
    }

    @ModelAttribute("users")
    public List<UserView> addUsers() {
        return service.findAll();
    }

    @GetMapping("/users")
    public void showUsers() {
    }

}
