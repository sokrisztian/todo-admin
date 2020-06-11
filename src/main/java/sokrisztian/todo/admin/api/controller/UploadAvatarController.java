package sokrisztian.todo.admin.api.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import sokrisztian.todo.admin.logic.service.UploadAvatarService;

@Controller
public class UploadAvatarController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UploadAvatarController.class);

    private final UploadAvatarService service;

    public UploadAvatarController(UploadAvatarService service) {
        this.service = service;
    }

    @ModelAttribute("userId")
    public int addUserId(@PathVariable int id) {
        return id;
    }

    @GetMapping("/users/{id}/upload-avatar")
    public String upload() {
        return "uploadAvatar";
    }

    @PostMapping("/users/{id}/upload-avatar")
    public String upload(@PathVariable int id, @ModelAttribute MultipartFile avatarImage) {
        LOGGER.info("Upload avatar request with {} user ID arrived", id);
        service.upload(id, avatarImage);
        LOGGER.info("Upload avatar request with {} user ID served", id);
        return "redirect:/users";
    }

}
