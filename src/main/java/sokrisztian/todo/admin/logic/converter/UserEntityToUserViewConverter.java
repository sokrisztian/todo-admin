package sokrisztian.todo.admin.logic.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import sokrisztian.todo.admin.api.model.TodoView;
import sokrisztian.todo.admin.api.model.UserView;
import sokrisztian.todo.admin.persistance.domain.TodoEntity;
import sokrisztian.todo.admin.persistance.domain.UserEntity;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserEntityToUserViewConverter implements Converter<UserEntity, UserView> {

    private final TodoEntityToTodoViewConverter todoConverter;

    public UserEntityToUserViewConverter(TodoEntityToTodoViewConverter todoConverter) {
        this.todoConverter = todoConverter;
    }

    @Override
    public UserView convert(UserEntity userEntity) {
        UserView userView = new UserView();
        userView.setId(userEntity.getId());
        userView.setUsername(userEntity.getUsername());
        userView.setAvatar(userEntity.getAvatar());
        userView.setTodos(convertTodos(userEntity.getTodos()));
        return userView;
    }

    private List<TodoView> convertTodos(List<TodoEntity> todos) {
        return todos.stream()
                .map(todoConverter::convert)
                .collect(Collectors.toList());
    }

}
