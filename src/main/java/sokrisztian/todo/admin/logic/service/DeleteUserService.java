package sokrisztian.todo.admin.logic.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sokrisztian.todo.admin.persistance.repository.TodoBasicRepository;
import sokrisztian.todo.admin.persistance.repository.UserBasicRepository;

@Service
public class DeleteUserService {

    private final UserBasicRepository userRepository;
    private final TodoBasicRepository todoRepository;

    public DeleteUserService(UserBasicRepository userRepository, TodoBasicRepository todoRepository) {
        this.userRepository = userRepository;
        this.todoRepository = todoRepository;
    }

    @Transactional
    public void deleteById(int id) {
        todoRepository.deleteAll(todoRepository.findByUserId(id));
        userRepository.deleteById(id);
    }

}
