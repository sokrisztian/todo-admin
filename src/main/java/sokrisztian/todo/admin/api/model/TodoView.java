package sokrisztian.todo.admin.api.model;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.StringJoiner;

public class TodoView {

    private int id;
    private int userId;
    private String description;
    private LocalDateTime deadline;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TodoView todoView = (TodoView) o;
        return id == todoView.id &&
                userId == todoView.userId &&
                description.equals(todoView.description) &&
                Objects.equals(deadline, todoView.deadline);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", TodoView.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("userId=" + userId)
                .add("description='" + description + "'")
                .add("deadline=" + deadline)
                .toString();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
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
