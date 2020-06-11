package sokrisztian.todo.admin.api.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import sokrisztian.todo.admin.logic.service.DeleteUserService;

@Controller
public class DeleteUserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(DeleteUserController.class);

    private final DeleteUserService service;

    public DeleteUserController(DeleteUserService service) {
        this.service = service;
    }

    @PostMapping("/users/{id}/delete")
    public String deleteById(@PathVariable int id, @RequestHeader String referer) {
        LOGGER.info("Delete user request with {} user ID arrived", id);
        service.deleteById(id);
        LOGGER.info("Delete user request with {} user ID served", id);
        return "redirect:" + referer;
    }

}
