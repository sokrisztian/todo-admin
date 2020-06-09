package sokrisztian.todo.admin.persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sokrisztian.todo.admin.persistance.domain.TodoEntity;

import java.util.List;

public interface TodoBasicRepository extends JpaRepository<TodoEntity, Integer> {

    List<TodoEntity> findByUserId(int userId);

}
