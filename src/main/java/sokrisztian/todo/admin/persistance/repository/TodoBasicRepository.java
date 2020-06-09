package sokrisztian.todo.admin.persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sokrisztian.todo.admin.persistance.domain.TodoEntity;

public interface TodoBasicRepository extends JpaRepository<TodoEntity, Long> {
}
