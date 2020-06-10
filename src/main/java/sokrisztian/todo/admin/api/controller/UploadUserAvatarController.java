package sokrisztian.todo.admin.api.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import sokrisztian.todo.admin.logic.service.UploadUserAvatarService;

@RestController
@RequestMapping("/users")
public class UploadUserAvatarController {

    private final UploadUserAvatarService service;

    public UploadUserAvatarController(UploadUserAvatarService service) {
        this.service = service;
    }

    @PostMapping("/{id}")
    public void upload(@PathVariable int id, @RequestBody MultipartFile avatarImage) {
        service.upload(id, avatarImage);
    }

}
