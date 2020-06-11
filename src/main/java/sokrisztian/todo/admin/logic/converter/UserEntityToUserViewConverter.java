package sokrisztian.todo.admin.logic.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import sokrisztian.todo.admin.api.model.UserView;
import sokrisztian.todo.admin.persistance.domain.UserEntity;

@Component
public class UserEntityToUserViewConverter implements Converter<UserEntity, UserView> {

    @Override
    public UserView convert(UserEntity userEntity) {
        UserView userView = new UserView();
        userView.setId(userEntity.getId());
        userView.setUsername(userEntity.getUsername());
        userView.setEmail(userEntity.getEmail());
        userView.setAvatar(userEntity.getAvatar());
        return userView;
    }

}
