package sokrisztian.todo.admin.logic.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import sokrisztian.todo.admin.api.model.TodoView;
import sokrisztian.todo.admin.persistance.domain.TodoEntity;

@Component
public class TodoEntityToTodoViewConverter implements Converter<TodoEntity, TodoView> {

    @Override
    public TodoView convert(TodoEntity todoEntity) {
        TodoView todoView = new TodoView();
        todoView.setId(todoEntity.getId());
        todoView.setUserId(todoEntity.getUserId());
        todoView.setDescription(todoEntity.getDescription());
        todoView.setDeadline(todoEntity.getDeadline());
        return todoView;
    }

}
