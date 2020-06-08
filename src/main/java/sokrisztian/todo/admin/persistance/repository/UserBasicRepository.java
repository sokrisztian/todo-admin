package sokrisztian.todo.admin.persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sokrisztian.todo.admin.persistance.domain.UserEntity;

public interface UserBasicRepository extends JpaRepository<UserEntity, Long> {
}
