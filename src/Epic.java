import java.util.ArrayList;

public class Epic extends Task {
    private ArrayList<Subtask> subtasks;

    public Epic(String taskMame, String description, TaskStatus status, ArrayList<Subtask> subtasks) {
        super(taskMame, description, status);
        this.subtasks = subtasks;
    }

    public Epic(String taskName, String description, int id, TaskStatus status, ArrayList<Subtask> subtasks) {
        super(taskName, description, id, status);
        this.subtasks = subtasks;
    }

    public ArrayList<Subtask> getSubtasks() {
        return subtasks;
    }

    public void setSubtasks(ArrayList<Subtask> subtasks) {
        this.subtasks = subtasks;
    }
    @Override
    public String toString() {
        return "Epic{" +
                "taskName='" + getTaskName() + '\'' +
                ", description='" + getDescription() + '\'' +
                ", id=" + getId() +
                ", status=" + getStatus() +
                '}';
    }
}
