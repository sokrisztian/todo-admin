package sokrisztian.todo.admin.logic.service;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import sokrisztian.todo.admin.persistance.domain.UserEntity;
import sokrisztian.todo.admin.persistance.repository.UserBasicRepository;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class UploadAvatarService {

    private final UserBasicRepository userRepository;
    private final DeleteAvatarService deleteAvatarService;

    @Value("${app.avatars.base-path}")
    private String avatarsBasePath;

    public UploadAvatarService(UserBasicRepository userRepository, DeleteAvatarService deleteAvatarService) {
        this.userRepository = userRepository;
        this.deleteAvatarService = deleteAvatarService;
    }

    @Transactional
    public void upload(int userId, MultipartFile avatarImage) {
        UserEntity user = deleteAvatar(findUser(userId));
        String newAvatarFilename = createFilename(avatarImage.getOriginalFilename());

        saveImage(avatarImage, newAvatarFilename);
        updateUserAvatar(user, newAvatarFilename);
    }

    private UserEntity findUser(int id) {
        return userRepository.findById(id).get();
    }

    private UserEntity deleteAvatar(UserEntity user) {
        return deleteAvatarService.deleteAvatar(user);
    }

    private String createFilename(String originalFilename) {
        String name = RandomStringUtils.random(15, true, true);
        String ext = FilenameUtils.getExtension(originalFilename);
        return name + '.' + ext;
    }

    private void saveImage(MultipartFile avatarImage, String newAvatarFilename) {
        try {
            Path avatarPath = Paths.get(avatarsBasePath + newAvatarFilename);
            avatarImage.transferTo(avatarPath);
        } catch (IOException e) {
            throw new RuntimeException(String.format("Failed to save '%s' avatar image: %s", avatarImage, e.getMessage()));
        }
    }

    private void updateUserAvatar(UserEntity user, String newAvatarFilename) {
        user.setAvatar(newAvatarFilename);
        userRepository.save(user);
    }

}
