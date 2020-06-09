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

    public void modify(ModifyUserForm todoForm) {
        UserEntity presentUser = repository.findById(todoForm.getId()).get();
        repository.save(applyChanges(presentUser, todoForm));
    }

    private UserEntity applyChanges(UserEntity presentUser, ModifyUserForm todoForm) {
        presentUser.setUsername(todoForm.getUsername());
        presentUser.setPassword(digestUtils.digestAsHex(todoForm.getPassword()));
        presentUser.setEmail(todoForm.getEmail());
        return presentUser;
    }

}
