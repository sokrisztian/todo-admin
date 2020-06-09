package sokrisztian.todo.admin.logic.converter;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import sokrisztian.todo.admin.api.model.CreateUserForm;
import sokrisztian.todo.admin.persistance.domain.UserEntity;

@Component
public class CreateUserFormToUserEntityConverter implements Converter<CreateUserForm, UserEntity> {

    private final DigestUtils digestUtils;

    public CreateUserFormToUserEntityConverter(DigestUtils digestUtils) {
        this.digestUtils = digestUtils;
    }

    @Override
    public UserEntity convert(CreateUserForm userForm) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(userForm.getUsername());
        userEntity.setPassword(digestUtils.digestAsHex(userForm.getPassword()));
        userEntity.setEmail(userForm.getEmail());
        return userEntity;
    }

}
