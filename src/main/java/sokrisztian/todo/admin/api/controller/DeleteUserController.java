package sokrisztian.todo.admin.api.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sokrisztian.todo.admin.logic.service.DeleteUserService;

@RestController
@RequestMapping("/users")
public class DeleteUserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(DeleteUserController.class);

    private final DeleteUserService service;

    public DeleteUserController(DeleteUserService service) {
        this.service = service;
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id) {
        LOGGER.info("Delete user request with {} user ID arrived", id);
        service.deleteById(id);
        LOGGER.info("Delete user request with {} user ID served", id);
    }

}
