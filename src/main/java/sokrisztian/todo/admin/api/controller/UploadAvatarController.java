package sokrisztian.todo.admin.api.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import sokrisztian.todo.admin.logic.service.UploadAvatarService;

@RestController
@RequestMapping("/users")
public class UploadAvatarController {

    private final UploadAvatarService service;

    public UploadAvatarController(UploadAvatarService service) {
        this.service = service;
    }

    @PostMapping("/{id}")
    public void upload(@PathVariable int id, @RequestBody MultipartFile avatarImage) {
        service.upload(id, avatarImage);
    }

}
