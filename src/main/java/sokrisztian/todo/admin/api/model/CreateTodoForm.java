package sokrisztian.todo.admin.api.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.StringJoiner;

public class CreateTodoForm {

    @NotNull
    private Integer userId;

    @NotBlank
    @Size(max = 150)
    private String description;

    private LocalDateTime deadline;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreateTodoForm that = (CreateTodoForm) o;
        return userId.equals(that.userId) &&
                description.equals(that.description) &&
                Objects.equals(deadline, that.deadline);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", CreateTodoForm.class.getSimpleName() + "[", "]")
                .add("userId=" + userId)
                .add("description='" + description + "'")
                .add("deadline=" + deadline)
                .toString();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDateTime deadline) {
        this.deadline = deadline;
    }

}
