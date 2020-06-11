package sokrisztian.todo.admin.api.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import sokrisztian.todo.admin.logic.service.CreateTodoService;

@Controller
public class CreateTodoController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CreateTodoController.class);

    private final CreateTodoService service;

    public CreateTodoController(CreateTodoService service) {
        this.service = service;
    }

    @PostMapping("/todos/create-blank")
    public String create(@RequestParam int userId, @RequestHeader String referer) {
        LOGGER.info("Create blank TODO request arrived");
        service.createBlank(userId);
        LOGGER.info("Create blank TODO request served");
        return "redirect:" + referer;
    }

}
