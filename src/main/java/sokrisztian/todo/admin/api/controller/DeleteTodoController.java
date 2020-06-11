package sokrisztian.todo.admin.api.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import sokrisztian.todo.admin.logic.service.DeleteTodoService;

@Controller
public class DeleteTodoController {

    private static final Logger LOGGER = LoggerFactory.getLogger(DeleteTodoController.class);

    private final DeleteTodoService service;

    public DeleteTodoController(DeleteTodoService service) {
        this.service = service;
    }

    @PostMapping("/todos/{id}/delete")
    public String deleteById(@PathVariable int id, @RequestHeader String referer) {
        LOGGER.info("Delete TODO request with {} TODO ID arrived", id);
        service.deleteById(id);
        LOGGER.info("Delete TODO request with {} TODO ID served", id);
        return "redirect:" + referer;
    }

}
