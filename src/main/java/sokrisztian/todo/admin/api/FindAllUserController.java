package sokrisztian.todo.admin.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sokrisztian.todo.admin.persistance.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class FindAllUserController {

    private final UserRepository userRepository;
    private final UserResponseConverter converter;

    public FindAllUserController(UserRepository userRepository, UserResponseConverter converter) {
        this.userRepository = userRepository;
        this.converter = converter;
    }

    @GetMapping
    public List<UserResponse> findAll() {
        return userRepository.findAll().stream()
                .map(converter::convert)
                .collect(Collectors.toList());
    }

}
