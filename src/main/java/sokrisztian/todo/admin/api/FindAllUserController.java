package sokrisztian.todo.admin.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sokrisztian.todo.admin.persistance.User;
import sokrisztian.todo.admin.persistance.UserRepository;

import java.util.List;

@RestController
@RequestMapping("/users")
public class FindAllUserController {

    private final UserRepository userRepository;

    public FindAllUserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public List<User> findAll() {
        return userRepository.findAll();
    }

}
