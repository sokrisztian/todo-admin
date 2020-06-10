package sokrisztian.todo.admin.logic.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sokrisztian.todo.admin.persistance.domain.UserEntity;
import sokrisztian.todo.admin.persistance.repository.TodoBasicRepository;
import sokrisztian.todo.admin.persistance.repository.UserBasicRepository;

import java.io.File;

@Service
public class DeleteUserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DeleteUserService.class);

    private final UserBasicRepository userRepository;
    private final TodoBasicRepository todoRepository;

    @Value("${app.avatars.base-path}")
    private String avatarsBasePath;

    public DeleteUserService(UserBasicRepository userRepository, TodoBasicRepository todoRepository) {
        this.userRepository = userRepository;
        this.todoRepository = todoRepository;
    }

    @Transactional
    public void deleteById(int id) {
        UserEntity user = findUser(id);

        deleteRelatedTodos(id);
        deleteUser(user);
        deleteAvatarImage(user.getAvatar());
    }

    private UserEntity findUser(int id) {
        return userRepository.findById(id).get();
    }

    private void deleteRelatedTodos(int id) {
        todoRepository.deleteAll(todoRepository.findByUserId(id));
    }

    private void deleteUser(UserEntity user) {
        userRepository.delete(user);
    }

    private void deleteAvatarImage(String fileName) {
        if (fileName != null) {
            File avatarImage = new File(avatarsBasePath + fileName);
            if (!avatarImage.delete()) {
                LOGGER.error(String.format("Failed to delete '%s' avatar.", fileName));
            }
        }
    }

}
