package sokrisztian.todo.admin.logic.service;

import org.springframework.stereotype.Service;
import sokrisztian.todo.admin.api.model.CreateUserForm;
import sokrisztian.todo.admin.logic.converter.CreateUserFormToUserEntityConverter;
import sokrisztian.todo.admin.persistance.repository.UserBasicRepository;

@Service
public class CreateUserService {

    private final UserBasicRepository repository;
    private final CreateUserFormToUserEntityConverter converter;

    public CreateUserService(UserBasicRepository repository, CreateUserFormToUserEntityConverter converter) {
        this.repository = repository;
        this.converter = converter;
    }

    public void create(CreateUserForm todoForm) {
        repository.save(converter.convert(todoForm));
    }

}
