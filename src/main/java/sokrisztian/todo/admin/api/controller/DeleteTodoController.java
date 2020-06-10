package sokrisztian.todo.admin.api.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sokrisztian.todo.admin.logic.service.DeleteTodoService;

@RestController
@RequestMapping("/todos")
public class DeleteTodoController {

    private static final Logger LOGGER = LoggerFactory.getLogger(DeleteTodoController.class);

    private final DeleteTodoService service;

    public DeleteTodoController(DeleteTodoService service) {
        this.service = service;
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id) {
        LOGGER.info("Delete TODO request with {} TODO ID arrived", id);
        service.deleteById(id);
        LOGGER.info("Delete TODO request with {} TODO ID served", id);
    }

}
