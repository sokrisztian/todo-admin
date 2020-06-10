package sokrisztian.todo.admin.logic.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import sokrisztian.todo.admin.persistance.domain.UserEntity;
import sokrisztian.todo.admin.persistance.repository.UserBasicRepository;

import java.io.File;

@Service
public class DeleteUserAvatarService {

    private final UserBasicRepository repository;

    public DeleteUserAvatarService(UserBasicRepository repository) {
        this.repository = repository;
    }

    @Value("${app.avatars.base-path}")
    private String avatarsBasePath;

    public UserEntity deleteAvatar(UserEntity user) {
        String avatar = user.getAvatar();
        if (avatar != null) {
            deleteAvatarImage(avatar);
            user = updateUserAvatar(user);
        }
        return user;
    }

    private void deleteAvatarImage(String fileName) {
        File avatarImage = new File(avatarsBasePath + fileName);
        if (!avatarImage.delete()) {
            throw new RuntimeException(String.format("Failed to delete '%s' avatar.", fileName));
        }
    }

    private UserEntity updateUserAvatar(UserEntity user) {
        user.setAvatar(null);
        return repository.save(user);
    }

}
