package ru.yandex.practicum.tasktracker.model;

public class Subtask extends Task{
    private  Epic epic;

    public Subtask(String taskName, String description, int id, TaskStatus status, Epic epic) {
        super(taskName, description, id, status);
        this.epic = epic;
    }

    public Epic getEpic() {
        return epic;
    }

    public void setEpic(Epic epic) {
        this.epic = epic;
    }

    @Override
    public String toString() {
        return "Subtask{" +
                "taskName='" + getName() + '\'' +
                ", description='" + getDescription() + '\'' +
                ", id=" + getId() +
                ", status=" + getStatus() +
                ", epic=" + epic.getId() +
                '}';
    }
}