package sokrisztian.todo.admin.logic.service;

import org.springframework.stereotype.Service;
import sokrisztian.todo.admin.api.model.UserView;
import sokrisztian.todo.admin.logic.converter.UserEntityToUserViewConverter;
import sokrisztian.todo.admin.persistance.repository.UserBasicRepository;

@Service
public class FindUserByIdService {

    private final UserBasicRepository repository;
    private final UserEntityToUserViewConverter converter;

    public FindUserByIdService(UserBasicRepository repository, UserEntityToUserViewConverter converter) {
        this.repository = repository;
        this.converter = converter;
    }

    public UserView findById(int id) {
        return converter.convert(repository.findById(id).get());
    }

}
