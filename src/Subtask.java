public class Subtask extends Task{
    private  Epic epic;

    public Epic getEpic() {
        return epic;
    }

    public void setEpic(Epic epic) {
        this.epic = epic;
    }

    public Subtask(String taskMame, String description, TaskStatus status, Epic epic) {
        super(taskMame, description, status);
        this.epic = epic;
    }

    public Subtask(String taskName, String description, int id, TaskStatus status, Epic epic) {
        super(taskName, description, id, status);
        this.epic = epic;
    }

    @Override
    public String toString() {
        return "Subtask{" +
                "taskName='" + getTaskName() + '\'' +
                ", description='" + getDescription() + '\'' +
                ", id=" + getId() +
                ", status=" + getStatus() +
                ", epic=" + epic.getId() +
                '}';
    }
}
