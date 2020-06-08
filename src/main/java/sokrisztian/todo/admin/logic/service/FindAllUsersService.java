package sokrisztian.todo.admin.logic.service;

import org.springframework.stereotype.Service;
import sokrisztian.todo.admin.api.model.UserView;
import sokrisztian.todo.admin.logic.converter.UserEntityToUserViewConverter;
import sokrisztian.todo.admin.persistance.repository.UserBasicRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FindAllUsersService {

    private final UserBasicRepository repository;
    private final UserEntityToUserViewConverter converter;

    public FindAllUsersService(UserBasicRepository repository, UserEntityToUserViewConverter converter) {
        this.repository = repository;
        this.converter = converter;
    }

    public List<UserView> findAll() {
        return repository.findAll().stream()
                .map(converter::convert)
                .collect(Collectors.toList());
    }

}
