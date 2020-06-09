package sokrisztian.todo.admin.logic.service;

import org.springframework.stereotype.Service;
import sokrisztian.todo.admin.api.model.TodoView;
import sokrisztian.todo.admin.logic.converter.TodoEntityToTodoViewConverter;
import sokrisztian.todo.admin.persistance.repository.TodoBasicRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FindTodosByUserIdService {

    private final TodoBasicRepository repository;
    private final TodoEntityToTodoViewConverter converter;

    public FindTodosByUserIdService(TodoBasicRepository repository, TodoEntityToTodoViewConverter converter) {
        this.repository = repository;
        this.converter = converter;
    }

    public List<TodoView> findByUserId(int userId) {
        return repository.findByUserId(userId).stream()
                .map(converter::convert)
                .collect(Collectors.toList());
    }

}
