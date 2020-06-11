package sokrisztian.todo.admin.api.model;

import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

public class UserView {

    private int id;
    private String username;
    private String avatar;
    private List<TodoView> todos;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserView userView = (UserView) o;
        return id == userView.id &&
                username.equals(userView.username) &&
                Objects.equals(avatar, userView.avatar);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", UserView.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("username='" + username + "'")
                .add("avatar='" + avatar + "'")
                .toString();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public List<TodoView> getTodos() {
        return todos;
    }

    public void setTodos(List<TodoView> todos) {
        this.todos = todos;
    }

}
