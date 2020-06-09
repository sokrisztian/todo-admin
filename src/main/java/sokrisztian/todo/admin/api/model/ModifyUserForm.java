package sokrisztian.todo.admin.api.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;
import java.util.StringJoiner;

public class ModifyUserForm {

    @NotNull
    private Integer id;

    @NotBlank
    @Size(max = 20)
    private String username;

    @NotBlank
    @Size(min = 8)
    private String password;

    @Email
    @NotBlank
    @Size(max = 50)
    private String email;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ModifyUserForm that = (ModifyUserForm) o;
        return id.equals(that.id) &&
                username.equals(that.username) &&
                password.equals(that.password) &&
                email.equals(that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", ModifyUserForm.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("username='" + username + "'")
                .add("email='" + email + "'")
                .toString();
    }

    public Integer getId() {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
