package ru.yandex.practicum.tasktracker.manager;

import ru.yandex.practicum.tasktracker.model.Epic;
import ru.yandex.practicum.tasktracker.model.Subtask;
import ru.yandex.practicum.tasktracker.model.Task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TaskManager {
    private final HashMap<Integer, Task> tasks = new HashMap<>();
    private final HashMap<Integer, Epic> epics = new HashMap<>();
    private final HashMap<Integer, Subtask> subtasks = new HashMap<>();

    public void addTask(Task task) {
        tasks.put(task.getId(), task);
    }

    public void addSubtask(Subtask task) {
        subtasks.put(task.getId(), task);
    }

    public void addEpic(Epic task) {
        epics.put(task.getId(), task);
    }

    public ArrayList<Task> getTasks() {
        return new ArrayList<>(tasks.values());
    }

    public ArrayList<Epic> getEpics() {
        return new ArrayList<>(epics.values());
    }

    public ArrayList<Subtask> getSubtasks() {
        return new ArrayList<>(subtasks.values());
    }

    public void removeTasks() {
        tasks.clear();
    }

    public void removeEpics() {
        epics.clear();
        removeSubtasks();
    }

    public void removeSubtasks() {
        subtasks.clear();
        for (Epic epic : getEpics()) {
            epic.getSubtasks().clear();
            updateEpic(epic);
        }
    }

    public void removeTaskById(Integer id) {
        tasks.remove(id);
    }

    public void removeEpicById(Integer id) {
        Epic epicRemove = getEpic(id);
        ArrayList<Subtask> temp = epicRemove.getSubtasks();
        for (int i = 0; i < temp.size(); i++) {
            subtasks.remove(epicRemove.getSubtasks().get(i).getId());
        }
        epics.remove(id);
    }

    public void removeSubtask(Integer id) {
        Subtask subtaskRemove = getSubtask(id);
        Epic epic = subtaskRemove.getEpic();
        epic.getSubtasks().remove(subtaskRemove);
        epic.setStatus(epic.getStatus(epic));
        subtasks.remove(id);
    }

    public Task getTask(Integer id) {
        return tasks.get(id);
    }

    public Epic getEpic(Integer id) {
        return epics.get(id);
    }

    public Subtask getSubtask(Integer id) {
        return subtasks.get(id);
    }

    public void updateSubtask(Subtask subtask) {
        subtasks.put(subtask.getId(), subtask);
        Epic epic = getEpic(subtask.getEpic().getId());
        for (int i = 0; i < epic.getSubtasks().size(); i++) {
            if (epic.getSubtasks().get(i).getId() == subtask.getId()) {
                epic.getSubtasks().set(i, subtask);
            }
        }
        updateEpic(epic);
    }

    public void updateTask(Task task) {
        tasks.put(task.getId(), task);
    }

    public void updateEpic(Epic epic) {
        epics.put(epic.getId(), epic);
        epic.setStatus(epic.getStatus(epic));
    }

    public List<Subtask> getSubtaskByEpic(Epic epic) {
        Epic epic1 = (Epic) tasks.get(epic.getId());
        return epic1.getSubtasks();
    }
}