package sokrisztian.todo.admin.logic.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sokrisztian.todo.admin.persistance.domain.UserEntity;
import sokrisztian.todo.admin.persistance.repository.TodoBasicRepository;
import sokrisztian.todo.admin.persistance.repository.UserBasicRepository;

@Service
public class DeleteUserService {

    private final UserBasicRepository userRepository;
    private final TodoBasicRepository todoRepository;
    private final DeleteAvatarService deleteAvatarService;

    public DeleteUserService(UserBasicRepository userRepository, TodoBasicRepository todoRepository, DeleteAvatarService deleteAvatarService) {
        this.userRepository = userRepository;
        this.todoRepository = todoRepository;
        this.deleteAvatarService = deleteAvatarService;
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
        return deleteAvatarService.deleteAvatar(user);
    }

    private void deleteUser(UserEntity user) {
        userRepository.delete(user);
    }

}
