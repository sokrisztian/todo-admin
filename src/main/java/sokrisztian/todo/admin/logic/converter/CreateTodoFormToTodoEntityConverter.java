package sokrisztian.todo.admin.logic.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import sokrisztian.todo.admin.api.model.CreateTodoForm;
import sokrisztian.todo.admin.persistance.domain.TodoEntity;

@Component
public class CreateTodoFormToTodoEntityConverter implements Converter<CreateTodoForm, TodoEntity> {

    @Override
    public TodoEntity convert(CreateTodoForm todoForm) {
        TodoEntity todoEntity = new TodoEntity();
        todoEntity.setUserId(todoForm.getUserId());
        todoEntity.setDescription(todoForm.getDescription());
        todoEntity.setDeadline(todoForm.getDeadline());
        return todoEntity;
    }

}
