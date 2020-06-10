package sokrisztian.todo.admin.logic.service;

import org.apache.commons.io.FilenameUtils;
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
public class UploadUserAvatarService {

    private final UserBasicRepository userRepository;
    private final DeleteUserAvatarService deleteUserAvatarService;

    @Value("${app.avatars.base-path}")
    private String avatarsBasePath;

    public UploadUserAvatarService(UserBasicRepository userRepository, DeleteUserAvatarService deleteUserAvatarService) {
        this.userRepository = userRepository;
        this.deleteUserAvatarService = deleteUserAvatarService;
    }

    @Transactional
    public void upload(int id, MultipartFile avatarImage) {
        UserEntity user = deleteAvatar(findUser(id));
        saveImage(avatarImage, user.getEmail());
        updateUserAvatar(user, avatarImage);
    }

    private UserEntity findUser(int id) {
        return userRepository.findById(id).get();
    }

    private UserEntity deleteAvatar(UserEntity user) {
        return deleteUserAvatarService.deleteAvatar(user);
    }

    private void saveImage(MultipartFile avatarImage, String userEmail) {
        try {
            Path avatarPath = Paths.get(avatarsBasePath + createFilename(userEmail, avatarImage.getOriginalFilename()));
            avatarImage.transferTo(avatarPath);
        } catch (IOException e) {
            throw new RuntimeException(String.format("Failed to save '%s' avatar image: %s", avatarImage, e.getMessage()));
        }
    }

    private void updateUserAvatar(UserEntity user, MultipartFile avatarImage) {
        user.setAvatar(createFilename(user.getEmail(), avatarImage.getOriginalFilename()));
        userRepository.save(user);
    }

    private String createFilename(String userEmail, String originalFilename) {
        return userEmail + '.' + FilenameUtils.getExtension(originalFilename);
    }

}
