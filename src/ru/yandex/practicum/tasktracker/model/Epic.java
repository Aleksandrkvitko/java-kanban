package ru.yandex.practicum.tasktracker.model;

import java.util.ArrayList;
import java.util.List;

public class Epic extends Task {
    private ArrayList<Subtask> subtasks;

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

    public TaskStatus getStatus(Epic epic){
        List<Subtask> subtasks = epic.getSubtasks();
        if (subtasks.isEmpty()) {
            return TaskStatus.NEW;
        }
        int countNew = 0;
        int countDone = 0;
        for (int i = 0; i < subtasks.size(); i++) {
            if (TaskStatus.NEW == subtasks.get(i).getStatus()) {
                countNew++;
            } else if (TaskStatus.DONE == subtasks.get(i).getStatus()) {
                countDone++;
            }
        }
        if (countNew == subtasks.size()) {
            return TaskStatus.NEW;
        } else if (countDone == subtasks.size()) {
            return TaskStatus.DONE;
        } else {
            return TaskStatus.IN_PROGRESS;
        }
    }

    @Override
    public String toString() {
        return "Epic{" +
                "taskName='" + getName() + '\'' +
                ", description='" + getDescription() + '\'' +
                ", id=" + getId() +
                ", status=" + getStatus() +
                '}';
    }
}