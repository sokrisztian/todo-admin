package sokrisztian.todo.admin.logic.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sokrisztian.todo.admin.persistance.domain.UserEntity;
import sokrisztian.todo.admin.persistance.repository.TodoBasicRepository;
import sokrisztian.todo.admin.persistance.repository.UserBasicRepository;

@Service
public class DeleteUserService {

    private final UserBasicRepository userRepository;
    private final TodoBasicRepository todoRepository;
    private final DeleteUserAvatarService deleteUserAvatarService;

    @Value("${app.avatars.base-path}")
    private String avatarsBasePath;

    public DeleteUserService(UserBasicRepository userRepository, TodoBasicRepository todoRepository, DeleteUserAvatarService deleteUserAvatarService) {
        this.userRepository = userRepository;
        this.todoRepository = todoRepository;
        this.deleteUserAvatarService = deleteUserAvatarService;
    }

    @Transactional
    public void deleteById(int id) {
        deleteRelatedTodos(id);
        deleteUser(deleteAvatar(findUser(id)));
    }

    private void deleteRelatedTodos(int id) {
        todoRepository.deleteAll(todoRepository.findByUserId(id));
    }

    private UserEntity findUser(int id) {
        return userRepository.findById(id).get();
    }

    private UserEntity deleteAvatar(UserEntity user) {
        return deleteUserAvatarService.deleteAvatar(user);
    }

    private void deleteUser(UserEntity user) {
        userRepository.delete(user);
    }

}
