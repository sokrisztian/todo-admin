package sokrisztian.todo.admin.api.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Objects;
import java.util.StringJoiner;

public class ModifyTodoForm {

    @NotBlank
    @Size(max = 150)
    private String description;

    private String deadline;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ModifyTodoForm that = (ModifyTodoForm) o;
        return description.equals(that.description) &&
                Objects.equals(deadline, that.deadline);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", ModifyTodoForm.class.getSimpleName() + "[", "]")
                .add("description='" + description + "'")
                .add("deadline=" + deadline)
                .toString();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

}
