package sokrisztian.todo.admin.api.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import sokrisztian.todo.admin.logic.service.UploadAvatarService;

@RestController
@RequestMapping("/users")
public class UploadAvatarController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UploadAvatarController.class);

    private final UploadAvatarService service;

    public UploadAvatarController(UploadAvatarService service) {
        this.service = service;
    }

    @PostMapping("/{id}")
    public void upload(@PathVariable int id, @RequestBody MultipartFile avatarImage) {
        LOGGER.info("Upload avatar request with {} user ID arrived", id);
        service.upload(id, avatarImage);
        LOGGER.info("Upload avatar request with {} user ID served", id);
    }

}
