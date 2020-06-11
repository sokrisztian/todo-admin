package sokrisztian.todo.admin.api.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import sokrisztian.todo.admin.api.model.ModifyUserForm;
import sokrisztian.todo.admin.api.model.UserView;
import sokrisztian.todo.admin.logic.service.FindUserByIdService;
import sokrisztian.todo.admin.logic.service.ModifyUserService;

import javax.validation.Valid;

@Controller
public class ModifyUserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ModifyUserController.class);

    private final FindUserByIdService findUserByIdService;
    private final ModifyUserService modifyUserService;

    public ModifyUserController(FindUserByIdService findUserByIdService, ModifyUserService modifyUserService) {
        this.findUserByIdService = findUserByIdService;
        this.modifyUserService = modifyUserService;
    }

    @ModelAttribute("user")
    public UserView addUser(@PathVariable int id) {
        return findUserByIdService.findById(id);
    }

    @GetMapping("/users/{id}/modify")
    public String showModifyPage() {
        return "modifyUser";
    }

    @PostMapping("/users/{id}/modify")
    public String modify(@PathVariable int id, @Valid @ModelAttribute ModifyUserForm userForm) {
        LOGGER.info("Modify user request with {} user ID arrived: {}", id, userForm);
        modifyUserService.modify(id, userForm);
        LOGGER.info("Modify user request with {} user ID served: {}", id, userForm);
        return "redirect:/users";
    }

}
