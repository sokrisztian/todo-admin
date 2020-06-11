package sokrisztian.todo.admin.logic.service;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;
import sokrisztian.todo.admin.api.model.ModifyUserForm;
import sokrisztian.todo.admin.persistance.domain.UserEntity;
import sokrisztian.todo.admin.persistance.repository.UserBasicRepository;

@Service
public class ModifyUserService {

    private final UserBasicRepository repository;
    private final DigestUtils digestUtils;

    public ModifyUserService(UserBasicRepository repository, DigestUtils digestUtils) {
        this.repository = repository;
        this.digestUtils = digestUtils;
    }

    public void modify(int userId, ModifyUserForm userForm) {
        UserEntity presentUser = repository.findById(userId).get();
        repository.save(applyChanges(presentUser, userForm));
    }

    private UserEntity applyChanges(UserEntity presentUser, ModifyUserForm userForm) {
        presentUser.setUsername(userForm.getUsername());
        presentUser.setPassword(digestUtils.digestAsHex(userForm.getPassword()));
        presentUser.setEmail(userForm.getEmail());
        return presentUser;
    }

}
