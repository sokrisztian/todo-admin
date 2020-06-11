package sokrisztian.todo.admin.logic.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sokrisztian.todo.admin.persistance.domain.UserEntity;
import sokrisztian.todo.admin.persistance.repository.TodoBasicRepository;
import sokrisztian.todo.admin.persistance.repository.UserBasicRepository;

import java.util.ArrayList;

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
        deleteUser(deleteAvatar(deleteTodos(findUser(id))));
    }

    private UserEntity findUser(int id) {
        return userRepository.findById(id).get();
    }

    private UserEntity deleteTodos(UserEntity user) {
        todoRepository.deleteAll(user.getTodos());
        user.setTodos(new ArrayList<>());
        return user;
    }

    private UserEntity deleteAvatar(UserEntity user) {
        return deleteAvatarService.deleteAvatar(user);
    }

    private void deleteUser(UserEntity user) {
        userRepository.delete(user);
    }

}
