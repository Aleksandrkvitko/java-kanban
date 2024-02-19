package ru.yandex.practicum.tasktracker.realization;

import ru.yandex.practicum.tasktracker.typesoftasks.Epic;
import ru.yandex.practicum.tasktracker.typesoftasks.Subtask;
import ru.yandex.practicum.tasktracker.typesoftasks.Task;

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
      /*Пожалуйста, должны быть методы для каждого типа задач - getTasks, getEpics, getSubtasks
    При этом метода чтобы получить все задачи вообще быть не должно
            (Возможно, удобнее будет сделать хэшмапы для каждого типа задач)*/
    public void removeTasks() {
        tasks.clear();
    }
   /* То же, нужны методы для каждого типа задач (и для двух методов ниже)*/

    public void removeEpics() {
        epics.clear();
    }

    public void removeSubtasks() {
        subtasks.clear();
    }

    public void removeTaskById(Integer id) {
        tasks.remove(id);
    }

    public void removeEpicById(Integer id) {
        epics.remove(id);
    }

    public void removeSubtask(Integer id) {
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