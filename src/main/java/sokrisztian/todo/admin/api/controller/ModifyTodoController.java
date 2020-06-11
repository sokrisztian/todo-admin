package sokrisztian.todo.admin.api.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import sokrisztian.todo.admin.api.model.ModifyTodoForm;
import sokrisztian.todo.admin.logic.service.ModifyTodoService;

import javax.validation.Valid;

@Controller
public class ModifyTodoController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ModifyTodoController.class);

    private final ModifyTodoService service;

    public ModifyTodoController(ModifyTodoService service) {
        this.service = service;
    }

    @PostMapping("/todos/{id}/modify")
    public String modify(@PathVariable int id, @Valid @ModelAttribute ModifyTodoForm todoForm, @RequestHeader String referer) {
        LOGGER.info("Modify TODO request with {} TODO ID arrived: {}", id, todoForm);
        service.modify(id, todoForm);
        LOGGER.info("Modify TODO request with {} TODO ID served: {}", id, todoForm);
        return "redirect:" + referer;
    }

}
